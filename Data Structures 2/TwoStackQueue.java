import java.util.NoSuchElementException;
public class TwoStackQueue<T> implements Queue<T> {

    private Stack<T> s1;
    private Stack<T> s2;
    
    public TwoStackQueue() {
        s1 = new ArrayStack<>();
        s2 = new ArrayStack<>();
    }
    
    public void enqueue(T x) {
        s1.push(x);
    }
    
    public T dequeue() throws NoSuchElementException {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }          
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        return s2.pop();
    }
    
    public boolean isEmpty() {
        return s2.isEmpty() && s1.isEmpty(); // replace this
    }
    
}