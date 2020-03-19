import java.util.ArrayList;

public class FIFOQueue<T> {

    private ArrayList<T>queue;

    public FIFOQueue(){
        queue = new ArrayList<T>();
    }

    public boolean push(T t){
        return queue.add(t);
    }

    public T pop(){
        return queue.remove(0);
    }

    public int sizeOfQueue(){
        return queue.size();
    }

    public T get(int index){
        return queue.get(index);
    }


}
