package InterfaceDemo;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class Person {

    public String read(IReadable iReadable){
        return iReadable.getContent();
    }
}
