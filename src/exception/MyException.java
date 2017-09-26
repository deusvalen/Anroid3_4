package exception;

/**
 * Демонстрация создания класса исключений
 * Created by User on 12.09.2017.
 */

public class MyException extends Exception {
    private int number;
    public int getNumber(){return number;}
    public MyException(String message, int num){
        super(message);
        number=num;
    }
}
