package Exception;

public class InvalidInput extends RuntimeException {
    public InvalidInput (String msg){
        super(msg);
    }
}
