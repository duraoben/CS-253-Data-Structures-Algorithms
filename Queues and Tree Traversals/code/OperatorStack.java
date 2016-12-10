
/**
 * Write a description of class OperatorStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperatorStack implements LLStack
{
    private Node top;
    private int size;

    public OperatorStack() {
        top = null;
        size = 0;
    }          

    public boolean empty () {
        return (top == null);
    }

    public int size () {
        return size;
    }

    public void push (String c) {
        Node newNode = new Node ();
        newNode.setData(c);
        newNode.setNext(top);
        top = newNode;
        size++;     
    }

    public String pop () {
        String c;
        c = top.getData();
        top = top.getNext();
        size--;
        return c;
    }

    public String ontop () {
        String c = pop();
        push(c);
        return c;
    }
    
    public int stackPriority(String c)
    {
        int value = 0;
        if(c.equals("*"))
            value = 2;
        else if(c.equals("/"))
            value = 2;
        else if(c.equals("+"))
            value = 1;
        else if(c.equals("-"))
            value = 1;
        else if(c.equals("("))
            value = 3;
        else if(c.equals("#"))
            value = 0;
        return value;
    }
}
