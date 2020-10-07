import java.util.List;
import java.util.ArrayList;

public class TestBetterBST{
    
    public static void main(String[] args){
        
        BinarySearchTree<Integer> my_tree = new BetterBST<>();
        
        my_tree.insert(7);
        my_tree.insert(8);
        my_tree.insert(3);
        my_tree.insert(5);
        my_tree.insert(9);
        my_tree.insert(1);
        my_tree.insert(6);
        my_tree.insert(2);
        my_tree.insert(4);
        
        List<Integer> my_list = new ArrayList<>();
        
      
        System.out.println("Smallest Greater Than: " + my_tree.smallestGreaterThan(5));
        System.out.println("Range: " + my_tree.getRange(1,5));
        System.out.println(my_tree);
        System.out.println(my_tree.reverse());
        
      
              
        
    }
}