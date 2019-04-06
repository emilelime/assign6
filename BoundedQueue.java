import javafoundations.CircularArrayQueue;
/**
 * Write a description of class BoundedQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoundedQueue<T> extends CircularArrayQueue
{
    // instance variables - replace the example below with your own
    // A constructor that takes an integer argument corresponding to the capacity of the bounded queue
    // A predicate isFull() that indicates if the bounded queue is at capacity or not
    // An enqueue method that overrides the javafoundations.CircularArrayQueue enqueue method and only enqueues an element if the queue is not at capacity
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Constructor for objects of class BoundedQueue
     */
    public BoundedQueue()
    {
        // initialise instance variables
        super();
        //boundedQueue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * A predicate isFull() that indicates if the bounded queue is at capacity or not
     * @return boolean, true if bounded queue is at capacity, false otherwise
     */
    public boolean isFull()
    {
        // put your code here
        return (size() == DEFAULT_CAPACITY);
    }
    
    /**
     * enqueues an element if the queue is not at capacity
     * @param element the element to be enqueued
     */
    /*public void enqueue (element)
    { 
        if (!isFull()){
            queue[rear] = element;
            rear = (rear+1) % queue.length;
            count++;
        }
    }*/
    
    
    public static void main (String[] args)
    { 
        BoundedQueue bq = new BoundedQueue();
        // testing is full on empty bounded queue, expect false
        bq.isFull();
        bq.enqueue("hi");
        // expect true
        bq.isFull();
    }
}
