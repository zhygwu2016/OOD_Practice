package InterFaceDemo;

public class Person {

    public String read(IReadable iReadable){
        return iReadable.getContent();
    }

}
