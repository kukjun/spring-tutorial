package spring;

public class DuplicateMemberException extends RuntimeException {

    public DuplicateMemberException() {

    }

    public DuplicateMemberException(String msg) {
        super(msg);
    }

}
