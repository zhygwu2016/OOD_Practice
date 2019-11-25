package InMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;


public class Directory extends Entry{

    //A Directory contains a both file and Directory
    private final List<Entry> children;


    public Directory(String name, Directory parent) {
        super(name, parent);
        children = new ArrayList<Entry>();
    }

    //Delete --> "rm"
    public boolean deleteEntry(Entry entry) {
        return children.remove(entry);
    }

    //Use recursion to search the childrens
    public long getFileNum(){
        long fileNum = 0;

        //Traverse the child list
        for(Entry entry : children){
            /*
             * 1. "instanceof" is used to tell whether two objects have the same type or not
             * 2. If entry is a file, then number of file will increase 1, only the file has fileNumber as 1.
             * 3. If the entry is a directory, recursively call its getFileNumber()
             */
            if(entry instanceof File){
                fileNum++;
            } else if (entry instanceof Directory){
                // Cast the entry into Directory, since there is no "getFileNum()" method in entry
                fileNum += ((Directory) entry).getFileNum();
            }
        }

        return fileNum;
    }

    /* 1. getSize() uses the same idea with "getFileNum()", recursively call its children's getSize() method
     * 2. If the child is a file, they just return the size of that file. Only the file has a size, directory without any
     * file will have size 0.
     * 3. If the child is a directory, just call its getSize().
     */
    @Override
    long getSize() {
        long size = 0;

        for(Entry entry : children){
            size += entry.getSize();
        }

        return size;
    }

    public boolean mkdir(final String name){

        //Check duplicate
        for(Entry entry : children){
            if (entry.getName().equals(name) && entry instanceof Directory){
                return false;
            }
        }

        children.add(new Directory(name,this));
        return true;
    }

    public boolean addEntry(Entry newEntry){

        for (Entry entry : children){
            if (entry.getName().equals(newEntry.getName()) && entry.getClass() == newEntry.getClass()){
                return false;
            }
        }

        children.add(newEntry);
        return true;
    }



    public List<Entry> getChildren(){
        return children;
    }
}
