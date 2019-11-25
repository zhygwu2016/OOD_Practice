package WrapperDesignPattern;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator){
        this.iterator = iterator;
        peek = null;
    }

    public Integer peek(){
        if(peek != null) return peek;

        peek = iterator.next();

        return peek;
    }

    @Override
    public boolean hasNext() {
        if(peek != null) return true;

        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        if(peek != null){
            final Integer temp = peek;
            peek = null;
            return temp;
        }

        return iterator.next();
    }

    public void remove() {

    }
}
