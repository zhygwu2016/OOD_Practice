package InterFaceDemo;

public class Book implements IReadable{

    @Override
    public String getContent(){
        return "This is a book";
    }

    public String getEdition(){
        return "ACD12345";
    }
}
