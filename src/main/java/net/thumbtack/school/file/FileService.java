package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;
import net.thumbtack.school.windows.v4.base.WindowException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.util.StringJoiner;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))) {
            fileOutputStream.write(array);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(file.getPath(), array);
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        byte[] array = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            array = new byte[fileInputStream.available()];
            fileInputStream.read(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return readByteArrayFromBinaryFile(file.getPath());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] resultArray = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byteArrayOutputStream.write(array);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            resultArray = new byte[(array.length % 2 == 0) ? (array.length / 2) : (array.length / 2) + 1];
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] = (byte) byteArrayInputStream.read();
                byteArrayInputStream.skip(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bufferedOutputStream.write(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.getPath(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        byte[] resultArray = null;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            resultArray = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(resultArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultArray;
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        return readByteArrayFromBinaryFileBuffered(file.getPath());
    }

    public static void writeRectButtonToBinaryFile(File file, RectButton rectButton) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file.getPath())))) {
            dataOutputStream.writeInt(rectButton.getTopLeft().getX());
            dataOutputStream.writeInt(rectButton.getTopLeft().getY());
            dataOutputStream.writeInt(rectButton.getBottomRight().getX());
            dataOutputStream.writeInt(rectButton.getBottomRight().getY());
            dataOutputStream.writeUTF(rectButton.getState().toString());
            dataOutputStream.writeUTF(rectButton.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static RectButton readRectButtonFromBinaryFile(File file) throws WindowException, IOException {
        RectButton rectButton = null;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File(file.getPath())))) {
            int xTopLeft = dataInputStream.readInt();
            int yTopLeft = dataInputStream.readInt();
            int xBottomRight = dataInputStream.readInt();
            int yBottomRight = dataInputStream.readInt();
            String state = dataInputStream.readUTF();
            String text = dataInputStream.readUTF();
            rectButton = new RectButton(new Point(xTopLeft, yTopLeft), new Point(xBottomRight, yBottomRight), state, text);
        } catch (NullPointerException e) {
            throw new NullPointerException("The coordinates of the point is Null ");
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rectButton;
    }

    public static void writeRectButtonArrayToBinaryFile(File file, RectButton[] rects) throws WindowException, IOException {
        for (RectButton element : rects) {
            try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file.getPath()), true))) {
                dataOutputStream.writeInt(element.getTopLeft().getX());
                dataOutputStream.writeInt(element.getTopLeft().getY());
                dataOutputStream.writeInt(element.getBottomRight().getX());
                dataOutputStream.writeInt(element.getBottomRight().getY());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void modifyRectButtonArrayInBinaryFile(File file) throws IOException {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file.getPath()), "rw")) {
            for (int i = 0; i < randomAccessFile.length(); i += 8) {
                randomAccessFile.seek(i);
                int x = randomAccessFile.readInt();
                randomAccessFile.seek(i);
                randomAccessFile.writeInt(x + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RectButton[] readRectButtonArrayFromBinaryFile(File file) throws WindowException, IOException {
        RectButton[] rectButton = null;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File(file.getPath())))) {
            int dataAvailable = dataInputStream.available();
            rectButton = new RectButton[dataAvailable / 16];
            for (int i = 0; i < dataAvailable / 16; i++) {
                int xTopLeft = dataInputStream.readInt();
                int yTopLeft = dataInputStream.readInt();
                int xBottomRight = dataInputStream.readInt();
                int yBottomRight = dataInputStream.readInt();
                rectButton[i] = new RectButton(new Point(xTopLeft, yTopLeft), new Point(xBottomRight, yBottomRight), "ACTIVE", "OK");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rectButton;
    }

    public static void writeRectButtonToTextFileOneLine(File file, RectButton rectButton) throws IOException {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(file.getPath())))) {
            StringJoiner rectButtonString = new StringJoiner(" ");
            rectButtonString.add(Integer.toString(rectButton.getTopLeft().getX()));
            rectButtonString.add(Integer.toString(rectButton.getTopLeft().getY()));
            rectButtonString.add(Integer.toString(rectButton.getBottomRight().getX()));
            rectButtonString.add(Integer.toString(rectButton.getBottomRight().getY()));
            rectButtonString.add(rectButton.getState().toString());
            rectButtonString.add(rectButton.getText());
            outputStreamWriter.write(rectButtonString.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RectButton readRectButtonFromTextFileOneLine(File file) throws WindowException, IOException {
        RectButton result = null;
        int elem = 0;
        String buttonFromStr = null;
        StringBuilder value = new StringBuilder();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(file.getPath())))) {
            while ((elem = inputStreamReader.read()) != -1) {
                buttonFromStr = value.append(Character.toString(Character.toChars(elem)[0])).toString();
            }
            result = new RectButton(new Point(Integer.parseInt(buttonFromStr.split(" ")[0]), Integer.parseInt(buttonFromStr.split(" ")[1])), new Point(Integer.parseInt(buttonFromStr.split(" ")[2]), Integer.parseInt(buttonFromStr.split(" ")[3])), buttonFromStr.split(" ")[4], buttonFromStr.split(" ")[5]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeRectButtonToTextFileSixLines(File file, RectButton rectButton) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file.getPath()))))) {
            bufferedWriter.write(String.valueOf(rectButton.getTopLeft().getX()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rectButton.getTopLeft().getY()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rectButton.getBottomRight().getX()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rectButton.getBottomRight().getY()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rectButton.getState().toString()));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(rectButton.getText()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RectButton readRectButtonFromTextFileSixLines(File file) throws WindowException, IOException {
        RectButton result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file.getPath()))))) {
            result = new RectButton(new Point(Integer.parseInt(bufferedReader.readLine()), Integer.parseInt(bufferedReader.readLine())), new Point(Integer.parseInt(bufferedReader.readLine()), Integer.parseInt(bufferedReader.readLine())), bufferedReader.readLine(), bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file.getPath())), "UTF-8"))) {
            StringJoiner traineeString = new StringJoiner(" ");
            traineeString.add(trainee.getFirstName());
            traineeString.add(trainee.getLastName());
            traineeString.add(String.valueOf(trainee.getRating()));
            bufferedWriter.write(traineeString.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws TrainingException, IOException {
        Trainee result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file.getPath())), "UTF-8"))) {
            String traineeString = bufferedReader.readLine();
            result = new Trainee(traineeString.split(" ")[0], traineeString.split(" ")[1], Integer.parseInt(traineeString.split(" ")[2]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file.getPath())), "UTF-8"))) {
            bufferedWriter.write(trainee.getFirstName());
            bufferedWriter.newLine();
            bufferedWriter.write(trainee.getLastName());
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(trainee.getRating()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws TrainingException, IOException {
        Trainee result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file.getPath())), "UTF-8"))) {
            result = new Trainee(bufferedReader.readLine(), bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(file.getPath())))) {
            objectOutputStream.writeObject(trainee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException {
        Trainee result = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(file.getPath())))) {
            result = (Trainee) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        String result = gson.toJson(trainee);
        return result;
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        Trainee result = gson.fromJson(json, Trainee.class);
        return result;
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bufferedJson = new BufferedWriter(new FileWriter(new File(file.getPath())))) {
            gson.toJson(trainee, bufferedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Trainee result = null;
        Gson gson = new Gson();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file.getPath())))) {
            result = gson.fromJson(bufferedReader, Trainee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}

