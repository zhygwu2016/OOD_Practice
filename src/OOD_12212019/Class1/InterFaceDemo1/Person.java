package Class1.InterFaceDemo1;

import com.sun.istack.internal.NotNull;

public class Person {

    private final String name;

    private final String id;

    public Person(@NotNull final String name, @NotNull final String id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String read(IReadable iReadable){
        return iReadable.getContent();
    }

}
