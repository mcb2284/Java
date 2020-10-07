import java.lang.Math; 

/**
 * Data Structures in Java 
 * COMS W3134, Columbia University - Fall 2019
 * Basic structure of a binary tree.
 */
public class BinaryTree<T> {

    // The BinaryTree is essentially just a wrapper around the linked 
    // structure of BinaryNodes, rooted in root.
    protected BinaryNode<T> root;

    /**
     * Represents a binary subtree.
     */
    protected static class BinaryNode<NodeT>{

        public NodeT             data;  // the data 
        public BinaryNode<NodeT> left;  // left subtree
        public BinaryNode<NodeT> right; // right subtree
    
        /**
         * Construct a new binary node. 
         */
        public BinaryNode(NodeT theData, BinaryNode<NodeT> leftChild, 
                                         BinaryNode<NodeT> rightChild ) {
            data    = theData; 
            left    = leftChild;
            right   = rightChild;
        }

        public BinaryNode(NodeT theData) {
            data = theData;
            left = null;
            right = null;
        }

       
        public void printTree() { // This is the printTree method of the Node class
            if (left != null) 
                left.printTree(); 
            System.out.println(data); 

            if (right != null)
                right.printTree();             
        }
        
        
        /**
         * Return a bracketed string represention of this tree.        
         */
        public String toString() {

            if (left == null && right == null) // if this is a leaf
                return data.toString();
           
            StringBuilder sb = new StringBuilder( "("); 
            sb.append(data);
            sb.append(" ");
            if (left != null)
                sb.append(left.toString());
            else 
                sb.append("*");
            sb.append(" ");
            if (right != null) 
                sb.append(right.toString());
            else
                sb.append("*");
            sb.append(")");
            return sb.toString();
        }


    } // Nested class BinaryNode ends here.
   

 
    /**
     * Construct a new empty BinaryTree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a new BinaryTree wrapper around the BinaryNode rootNode.
     */
    public BinaryTree(BinaryNode<T> rootNode) {
        root = rootNode;
    }



    /** 
     * Factory method that creates a new BinaryTree with two subtrees, that contains theItem
     * as the data object attached to its root.  
     * The two btree methods make it possible to easily construt binary trees like this: 
     * BinaryTree<Integer> t = btree(1,btree(2,btree(3),btree(4)),btree(5));
     * @return a new BinaryTree with two children.  
     */ 
    public static <T> BinaryTree<T> btree(T theItem, BinaryTree<T> t1, BinaryTree<T> t2) {
        BinaryNode<T> root = new BinaryNode<T>(theItem, t1.root, t2.root);
        return new BinaryTree<T>(root); 
    }
    
    /**
     * Factory method that creates a new BinaryTree with no children, which contains 
     * theItem as data object attached to its root.
     * @return a new BinaryTree with no children.
     */
    public static <T> BinaryTree<T> btree(T theItem) {
        return new BinaryTree<T>(new BinaryNode<T>(theItem));
    }

    public String toString() {
        if (root == null) 
            return "()";
        else 
            return root.toString();
    }

    public void printTree() { // This is the printTree method of the Tree class
        printTreeRecursive(root); 
    }
    
    public void printTreeRecursive(BinaryNode<T> node) { // This is a method of the TREE, not the node
        System.out.println(node.data); 
        if (node.left != null)
            printTreeRecursive(node.left);
        if (node.right != null)
            printTreeRecursive(node.right);
    }
    
    public int getHeight() {
        return getHeightRecursive(root); 
    }
    
    public int getHeightRecursive(BinaryNode<T> node) {
        
        if (node == null) 
            return -1; 
            
        int left_height = getHeightRecursive(node.left);               
        int right_height = getHeightRecursive(node.right);
         
        return Math.max(left_height, right_height) + 1; 
        
    }
    
    /**
     * Test method: Create and print a BinaryTree. 
     */ 
    public static void main(String[] args) {
        
        //BinaryNode<String> node1 = BinaryNode<>("1"); 
        //BinaryNode<String> node2 = BinaryNode<>("2");
        //BinaryNode<String> node3 = BinaryNode<>("+", node1, node2); 
        
        BinaryTree<String> tree = btree("*", btree("+", btree("1"), btree("2")), btree("3"));
        System.out.println(tree); // implicitly, this calls tree.toString to obtain the string.  
        System.out.println(tree.getHeight());

    }

}
