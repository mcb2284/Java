import java.util.List; 
import java.util.ArrayList;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    
    
    
    
    /********************************************************************************
     * smallestGreaterThan tests the root to make sure it isn't null then creates the 
     * currenthigh which holds the the current greater than value.
     ********************************************************************************/  
    @Override
	T smallestGreaterThan(T low) {
        
        
        if(root == null){
            throw new NullPointerException();
        }
        T currentHigh = root.data;
        
        return smallestGreaterThan(root, low, currentHigh); 
    }
    

    
    
    /********************************************************************************
     * The current high value is tested against the other nodes. If a value is found 
     * that is less than the current high and greater than the low value the current
     * high is updated.
     ********************************************************************************/ 
    private T smallestGreaterThan(BinaryNode<T> x, T low, T currentHigh){
        
       if(x.data.compareTo(currentHigh) == -1 && x.data.compareTo(low) == 1){              
           currentHigh = x.data;                 
       }         
       
        if (x.left != null){           
           currentHigh = smallestGreaterThan(x.left, low, currentHigh);           
       }
       
        if(x.right != null){            
           currentHigh = smallestGreaterThan(x.right, low, currentHigh);          
       }
            
        
       return currentHigh;
             
    }
  
    
   
    
    
    /********************************************************************************
     * getRange creates an array list then calls the recursive range method to populate
     * the list. 
     ********************************************************************************/     
    @Override
    List<T> getRange(T low, T high) {
               
        List<T> rangeList = new ArrayList<T>();
        recursiveRange(root, rangeList, low, high);
        
        return rangeList; 
    }  
    
    
    
    /********************************************************************************
     * recursiveRange moves through the BST and compares the values to the range 
     * and if the value is with in range it adds it to the list.
     ********************************************************************************/ 
    private List<T> recursiveRange(BinaryNode<T> x, List<T> rangeList, T low, T high){
               
        if(x == null){
            return null;
        }
        recursiveRange(x.left, rangeList, low, high);
        if(x.data.compareTo(low) >= 0 && x.data.compareTo(high) <= 0){            
            rangeList.add(x.data);                                   
        }
        recursiveRange(x.right, rangeList, low, high);
        
        
        return rangeList;
    }
    
                                    
   
    
    /********************************************************************************
    * Creates a new BST and calls the overloaded reverse method.
    ********************************************************************************/                       
    @Override
    BinarySearchTree<T> reverse() {
   
        BinarySearchTree<T> reverseTree = new BetterBST<>();      
        
        return reverse(reverseTree, root); 
    }
    
    
    
                                       
    
    /********************************************************************************
     * This reverse method traverses the original BST and inputs the values into the 
     * reverseTree using the reverseInsert method.
     ********************************************************************************/    
    private BinarySearchTree<T> reverse(BinarySearchTree<T> reverseTree, BinaryNode<T> t){
        if(t == null){
            return null;
        }
                       
        
        reverseTree.root = reverseInsert( t.data,  reverseTree.root);  
        if(t.left != null){
            reverseTree = reverse(reverseTree, t.left);
        }
        if(t.right != null){
            reverseTree = reverse(reverseTree,t.right);
        }
           
        return reverseTree;
    }
                                    

                                    
    
                                    
    
    /********************************************************************************
    * The reverseInsert method is like the BST insert method however inserts greater
    *     * than values on the left and less than values on the right.
    ********************************************************************************/                                                                                                   
    private BinaryNode<T> reverseInsert( T x, BinaryNode<T> t ) {
        if( t == null )
            return new BinaryNode<T>( x, null, null );
        
        int compareResult = x.compareTo( t.data );
            
        if( compareResult > 0 )
            t.left = reverseInsert( x, t.left );
        else if( compareResult < 0 )
            t.right = reverseInsert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }                	
    
}