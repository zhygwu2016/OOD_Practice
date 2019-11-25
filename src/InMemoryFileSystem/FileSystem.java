package InMemoryFileSystem;

public class FileSystem {

    private Directory root;
    private String name;
    private final long createTime;

    //Overall, the file system is a tree with two kinds od Node: file and Directory
    public FileSystem(final String name){
        this.name = name;
        createTime = System.currentTimeMillis();
        //The root should be a Directory since it will contain other Directories and files
        root = new Directory("/",null);
    }

    public Directory getRoot(){
        return root;
    }

}
