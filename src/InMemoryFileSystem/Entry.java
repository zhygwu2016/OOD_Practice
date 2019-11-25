package InMemoryFileSystem;

abstract public class Entry {

    //Time related fields
    protected final long createTime;
    protected long lastUpdateTime;
    protected long lastAccessTime;

    //Parent has to be a Directory
    protected Directory parent;

    //Other fields
    protected String name;
    protected long size;


    //Constructor, only Directory can be a parent
    public Entry(final String name, final Directory parent){
        this.parent = parent;
        this.name = name;

        createTime = System.currentTimeMillis();
        lastAccessTime = createTime;
        lastUpdateTime = createTime;
    }

    //Delete the file
    public boolean delete(){
        if(parent == null){
            return false;
        } else {
            //When delete this file, it should also be removed from its parent
            parent.deleteEntry(this);
            parent = null;
            return true;
        }
    }

    //getSize method should be abstract and it needs to be implemented in its child class
    abstract long getSize();

    //Get path, int Linux, the command is "pwd"
    public String getPath(){
        //Use DFS to fetch the path
        if(parent == null){
            //if the entry's parent is null, this entry should be the root of the system
            return this.name;
        } else {
            //else fetch the path of its parent and append the name at the end
            return parent.getPath() + '/' + this.name;
        }
    }

    public String getName(){
        return name;
    }

    public long getCreateTime(){
        return createTime;
    }

    public long getLastUpdateTime(){
        return lastUpdateTime;
    }

    public long getLastAccessTime(){
        return lastAccessTime;
    }


}
