import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int k) {

        this.k = k;
        heap = new PriorityQueue<>();
    }

    /*************************************************************************************
     * Count ensures the capacity of the heap and adds any element greater than the 
     * current smallest element in the heap. 
     *************************************************************************************/ 
    public void count(T x) {
   
        if(heap.size() < k){// If the size limit has not been reached the element is added to the heap
            heap.offer(x);
        }
        else{// size limit has been reached
            
            if(heap.peek().compareTo(x) < 0){// If the next element is larger that the top element of the heap
                                             // the top of the heap is removed and the next element is added.
                heap.remove();
                heap.offer(x);                 
            }                  
        }               
    }

    /*************************************************************************************
     * kbest copies the heap into a temporary heap (currentHeap) then polls the elements
     * into an arraylist (heapList) and the arraylist is returned.
     *************************************************************************************/    
    public List<T> kbest() {
         
        List<T> heapList = new ArrayList<>();
        PriorityQueue<T> currentHeap = new PriorityQueue<>();
        
        currentHeap.addAll(heap);//Adds the heap into the current heap
        
        while(!currentHeap.isEmpty()){
            heapList.add(currentHeap.poll());//polls the elements from the heap into the arraylist. 
        }
        
        return heapList;
    }
    
}