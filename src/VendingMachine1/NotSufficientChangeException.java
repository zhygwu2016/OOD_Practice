package VendingMachine1;

/**
 * Created by FLK on 4/8/18.
 */
public class NotSufficientChangeException extends RuntimeException {
    private String message;

    public NotSufficientChangeException(String string)
    {
        this.message = string;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
