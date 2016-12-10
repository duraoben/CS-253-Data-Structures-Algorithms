
/**
 * Write a description of class PostfixQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PostfixQueue implements LLQueue
{
    private int size;
    private Node front;
    private Node rear;

    public PostfixQueue() {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty () {
        return (size == 0);
    }

    public int size () {
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

    public String dequeue () {
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
}
