package chap04.spring;

public class DuplicateMemberException extends RuntimeException{
  public DuplicateMemberException() {
  }

  public DuplicateMemberException(String message) {
    super(message);
  }
}
