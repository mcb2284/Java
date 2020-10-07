import java.util.ArrayList;
import java.util.Arrays;
public class ExpressionTree {


    ArrayList<String> postExpression;//Arraylist of the input
    ArrayStack<ExpressionNode> exTree;//Stack to hold all the trees/subTrees
    ExpressionNode root;
    boolean isValid;
    
    
    public ExpressionTree(String postfix) {
        postExpression = new ArrayList<>(Arrays.asList(postfix.split("\\s")));
        exTree = new ArrayStack<>();
        root = null;
        isValid = true;
        treeBuilder();
                
    }
   
    
    /***********************************************************************
     * Evaluates the Postfix Expression  and returns an integer value
     ***********************************************************************/ 
    public int eval() {
       if(isValid){
              return evalStack(root);           
        }
        else
            return -1;      
    }
        
    //The evalStack method uses a stack to evaluate the postfix expression 
    public int evalStack(ExpressionNode t){
        
        ArrayStack<Integer> total = new ArrayStack<>();

        for(String temp : postExpression){            
            
            if(isInt(temp)){
                total.push(Integer.parseInt(temp));
            }
            else{
                switch(temp){
                    case "*":
                        total.push(total.pop() * total.pop());
                        break;
                    case "/":
                        total.push(total.pop() / total.pop());
                        break;
                    case "+":
                        total.push(total.pop() + total.pop());
                        break;
                    case "-":
                        total.push(total.pop() - total.pop());
                        break;
                    default:
                        break;
                }
            }
        }
        return total.pop();
    }
    
    
    /***********************************************************************
     * Using the recursive method below gets the post fix notation from the 
     * expression tree.
     ***********************************************************************/ 
    public String getPostfix() {
        if(isValid){
            return postfixRecursive(root);             
        }
        else
            return "Invalid Postfix Expression.";

    }
    
   
    //This method follows the same structure as the infix method 
    //and the binary tree class we discusssed in class 
    private String postfixRecursive(ExpressionNode t){
        
        if(t.left == null && t.right == null){
            return t.data;
        }                
        StringBuilder sb = new StringBuilder("");
        if(t.left != null){
            sb.append(postfixRecursive(t.left));
            sb.append(" ");
        }      
        if(t.right != null){
            sb.append(postfixRecursive(t.right));
            sb.append(" ");
        }
        sb.append(t.data);
        
        return sb.toString();
    }
    
    
    /***********************************************************************
     * Infix calls the infix recusive method to get the infix notation from
     * the expression tree
     ***********************************************************************/     
    public String getInfix() {
        if(isValid){
            return infixRecursive(root);            
        }
        else
            return "Invalid Postfix Expression.";        
        
    }
    
    //This method builds an infix string from the 
    //expression tree. The method i used was similar
    //to the binary tree class we did in class. 
    private String infixRecursive(ExpressionNode t){
        
        if(t.left == null && t.right == null){
            return t.data;
        }
                
        StringBuilder sb = new StringBuilder("");
        sb.append("( ");
        if(t.left != null){
            sb.append(infixRecursive(t.left));
            sb.append(" ");
        }
        sb.append(t.data);
        sb.append(" ");
        if(t.right != null){
           sb.append(infixRecursive(t.right));
           sb.append(" ");
        }
        sb.append(" )");
        return sb.toString();
    }
    
    
    
    
    
    //Builds the expression tree using a stack
    private void treeBuilder(){
        int count = 0;
        try{
            for (String temp : postExpression){
                if(isInt(temp)){
                    count++;
                    root = new ExpressionNode(temp);
                    exTree.push(root);
                }
                else{
                    count--;
                    root = new ExpressionNode(temp, exTree.pop(), exTree.pop());
                    exTree.push(root);
                }            
            }            
        }
        catch(IndexOutOfBoundsException e){
            isValid = false;
        }
        if(count != 1){
            isValid = false;
        }

    } 
    
       
    //tests the string for an integer
    private boolean isInt(String x){
        try{
            Integer.parseInt(x);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

         
        
  
    
    
    
    /***********************************************************
    *Expression node is the node class for the ExpressionTree
    ************************************************************/
    private static class ExpressionNode{
         
        private String data;//Node value
        private ExpressionNode left;//Left node 
        private ExpressionNode right;//Right node
               
        //Root node
        public ExpressionNode(String value){
            data = value;
            left = null;
            right = null;
        }
        
        //Root node with children
        public ExpressionNode(String value, ExpressionNode rightNode, ExpressionNode leftNode){
            data = value;
            left = leftNode;
            right = rightNode;
        }
        
        public String toString(){
            return data.toString();
        }
        
        

       
    }
        
}