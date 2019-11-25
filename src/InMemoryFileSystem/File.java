package InMemoryFileSystem;

public class File extends Entry {

    //Assume the content of the file is String
    private int size;
    private String content;

    public File(String name, Directory parent) {
        super(name, parent);
        size = 0;
        content = null;
    }

    public void setContent(String content){
        this.content = content;
        size = content.length();
        lastUpdateTime = System.currentTimeMillis();
    }


    public String getContent(){
        return content;
    }

    @Override
    long getSize() {
        return size;
    }
}
