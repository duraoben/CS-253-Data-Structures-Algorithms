/**
 * converts infix to postfix and evaluates the expression.
 * 
 * @author (ben durao) 
 * @version (10/30/16)
 */
public class InfixQueue implements LLQueue
{
    private int size;
    private Node front;
    private Node rear;

    public InfixQueue() {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty () {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void enqueue (String c) {
        Node newNode = new Node ();
        newNode.setData(c);
        newNode.setNext(null);
        if (this.empty()) 
            front = newNode;
        else
            rear.setNext(newNode);
        rear = newNode;
        size++;
    }

    public String dequeue() {
        String c;
        c = front.getData();
        front = front.getNext();
        size--;
        if (this.empty())
            rear = null;
        return c;
    }

    public String front () {
        return front.getData();
    }
    
    public int infixPriority(String c)
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
        else if(c.equals(")"))
            value = 0;
        else if(c.equals("#"))
            value = 0;
        return value;
    }
}