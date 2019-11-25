package InterfaceDemo;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class Book implements IReadable{

    @Override
    public String getContent(){
        return "This is a book";
    }
}
