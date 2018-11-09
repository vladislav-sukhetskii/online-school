package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Wrong firstname"),
    TRAINEE_WRONG_LASTNAME("Wrong lastname"),
    TRAINEE_WRONG_RATING("Wrong rating");

    String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
