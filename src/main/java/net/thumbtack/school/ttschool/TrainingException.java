package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {

    TrainingErrorCode ErrorCode;

    public TrainingException(TrainingErrorCode ErrorCode){
        this.ErrorCode = ErrorCode;

    };

    public TrainingErrorCode getErrorCode() {
        return ErrorCode;
    }
}
