# Homework 2 - Programming (50 pts)

## Problem 1 - Two Stack Queue - 20 points

In this problem you will implement a Banker's queue, as discussed in class, which uses two completely separate stacks, `S1` and `S2`. Enqueue operations happen by pushing the data on to `S1`.
Dequeue operations are completed with a pop from `S2`. 

Write a class `TwoStackQueue` that provides the Queue ADT (by implementing the `Queue` interface) using two stacks. Provide all methods specified in the interface. Your class should not use any additional memory to store the data in the queue except for the two stacks. 
For your stacks, use the provided `ArrayStack` class.
Your `TwoStackQueue` should raise a [java.util.NoSuchElementException](https://docs.oracle.com/javase/7/docs/api/java/util/NoSuchElementException.html) when trying to dequeue from an empty queue. 
You may use the `TestTwoStackQueue` class to test your code.

## Problem 2 - Implementing Expression Trees - 30 points

Implement a class called *ExpressionTree* in the provided ExpressionTree.java file. The constructor to ExpressionTree will take in only one String that contains a *postfix* expression. The operands will be integers and the operators will be restricted to +, -, \*, and /. Individual tokens, that is, the operands and operators, will be delimited by only one space. So for example:

```34 2 - 5 *```

which corresponds to the (bracketed) infix expression ```(34 - 2 ) * 5```.

Your constructor should run the stack-based algorithm we discussed in class to build an expression tree. In order to implement the *ExpressionTree* class, you will have to implement a static nested class called *ExpressionNode*, which will contain the implementation of the individual nodes that form an expression tree. You should use these nodes to represent the individual operators and operands. You may use any code posted on Canvas or from the Weiss textbook as a starting point for this assignment. For a stack data structure, you can use either `ArrayStack` or java.util.LinkedList, provided that you only use stack methods on that class (push, pop, peek).

Once you have the ExpressionTree constructed you should provide the following four methods as required by the interface as well as the constructor as specified below:

* ```public int eval()``` - this method, when invoked on an expression tree object, will return the integer result of evaluating the expression tree. Your algorithm will need to call a private recursive method that takes in the root. Assume integer arithmetic at all times, including during division. Assume that no invalid arithmetic operations occur in the expression (e.g. no division by zero).
* ```public String getPostfix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding postfix expression. It will need to call a private recursive method that takes in the root. Each operator and operand must be delimited by only one space and there should be no extraneous white space on either ends of the String. Any deviations from these instructions, will result in a loss of points.
* ```public String getInfix()``` - this method, when invoked on an expression tree object, will return a String that contains the corresponding infix expression. It will need to call a private recursive method that takes in the root. The infix expression should use parentheses to disambiguate the expression. Try to minimize the number of ( ) used. However, you will receive full credit for any correct infix expression, even if it contains redundant ( ). As before, make sure that each symbol is separated by a single white space with no extraneous white spaces on either end of the string.
* ```public ExpressionTree(String expression)``` - this is the constructor of the expression tree.  It will take in a String that represents a postfix expression (as shown above). Build the expression tree from that postfix expression using the stack based algorithm here.

For this problem, you are encouraged to write your own tester class. Make sure to consider edge cases, such as invalid postfix expression inputs to your constructor. Your tester class will not be graded.
