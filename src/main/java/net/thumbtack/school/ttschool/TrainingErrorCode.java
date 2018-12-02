package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Wrong firstname"),
    TRAINEE_WRONG_LASTNAME("Wrong lastname"),
    TRAINEE_WRONG_RATING("Wrong rating"),
    GROUP_WRONG_NAME("Group wrong name"),
    GROUP_WRONG_ROOM("Wrong room number"),
    TRAINEE_NOT_FOUND("Trainee not found");

    String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
