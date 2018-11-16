package net.thumbtack.school.file;

import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;
import net.thumbtack.school.windows.v4.base.WindowException;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.*;

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

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) {
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

    public static void writeRectButtonToBinaryFile(File file, RectButton rectButton) {
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

    public static void writeRectButtonArrayToBinaryFile(File file, RectButton[] rects) throws WindowException {
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
            long t = randomAccessFile.length();
            for (int i = 0; i < randomAccessFile.length(); i += 8) {
                randomAccessFile.seek(i);
                int x = randomAccessFile.readInt();
                randomAccessFile.seek(i);
                randomAccessFile.writeInt(x+1);
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

    public static void  writeRectButtonToTextFileOneLine(File file, RectButton rectButton){

    }
}
