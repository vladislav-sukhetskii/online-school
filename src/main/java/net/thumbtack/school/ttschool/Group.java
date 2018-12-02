package net.thumbtack.school.ttschool;

import com.sun.istack.internal.NotNull;

import java.util.List;

public class Group {
    private String name;
    private String room;
    private List<Trainee> traineeList;

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (!name.isEmpty() || name != null) {
            this.name = name
        } else throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (!name.isEmpty() || name != null) {
            this.room = room;
        } else throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
    }

    public List<Trainee> getTrainee() {
        return traineeList;
    }

    public void setTrainee(List<Trainee> trainee) {
        traineeList = trainee;
    }

    public void addTrainee(Trainee trainee) {
        this.traineeList.add(trainee);
    }

    public Group(String name, String room) throws TrainingException {
        super();
        setName(name);
        setRoom(room);
        setTrainee(null);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (traineeList.contains(trainee)) {
            traineeList.remove(trainee)
        } else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTrainee(int index) throws TrainingException {
        if (traineeList.size() < index || index < 0) {
            traineeList.remove(index);
        } else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        Trainee result = null;
        for (Trainee elem : traineeList) {
            if (elem.getFirstName().equals(fullName)) {
                result = elem;
                break;
            } else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return result;
    }

    public void sortTraineeListByFirstNameAscendant() {

    }


}
