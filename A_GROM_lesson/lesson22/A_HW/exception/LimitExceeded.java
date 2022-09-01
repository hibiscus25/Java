package A_GROM_lesson.lesson22.A_HW.exception;

public class LimitExceeded extends BadRequestException {

    public LimitExceeded(String message) {
        super(message);
    }
}
