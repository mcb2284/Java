  import java.util.Iterator; 

/**
 *  A Range iterable that can be used to iterate over a sequence of integers
 *  (similar to Python's range function).
 */
public class Range implements Iterable<Integer> {
  // you probably need some variables here and an inner class.

  Integer current;
  Integer end;
  Integer i;
   
  
  //The constructor sets up the current which is the starting number
  //the end which is the stopping number
  //and i which is the increment or decrement of the range.
  public Range(int start, int stop, int step) {
    i = step;
    current = start;
    end = stop; 
  } 
  
  
  //Create a rangeIterator
  public Iterator<Integer> iterator() {
    return new rangeIterator(); // change this    
  }
  
  
  //rangeIterator moves through the range, incrementing/decrementing 
  // the current as necessary
  private class rangeIterator implements Iterator<Integer>{

    public boolean hasNext(){
      if(i > 0){
        return current <= end;
      }
      else 
        return current >= end;
    }
    
    public Integer next(){
      Integer next = current;
      current += i;
      return next;
    }
    
    public void remove(){
      
    }
  }
  
}

