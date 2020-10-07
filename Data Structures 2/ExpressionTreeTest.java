public class ExpressionTreeTest{
    
    public static void main(String[] args){
        ExpressionTree test = new ExpressionTree("1 2 3 * + 4 5 * 6 + 7 * + ");
        System.out.println("Infix: " + test.getInfix());
        System.out.println("Postfix: " + test.getPostfix());
        System.out.println("Evalutation: " + test.eval());

    }
}