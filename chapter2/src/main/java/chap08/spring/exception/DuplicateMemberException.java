package chap08.spring.exception;

public class DuplicateMemberException extends RuntimeException {

    public DuplicateMemberException(String msg) {
        super(msg);
    }

}
