package ua.hillellit.lms.exceptions;

public class ArrayDataException extends Exception{

  private final String message;

  public ArrayDataException(int i, int j) {
    message = "У вас невірні дані в " + i + " стрічці "+ j +" комірці";
  }

  @Override
  public String getMessage() {
    return message;
  }
}
