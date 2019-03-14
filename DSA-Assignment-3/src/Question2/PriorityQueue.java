package Question2;

import exceptionhandling.QueueException;

public interface PriorityQueue {

    /**
     * Method to insert values to the queue
     * 
     * @param value
     *            to be added to the queue
     * @return true if val is added successfully else false
     * @throws QueueException
     *             if queue is empty or full
     */
    public boolean enqueue(Job value) throws QueueException;

    /**
     * Method to remove a value from the queue
     * 
     * @return the Job object
     * 
     * @throws QueueException
     *             if queue is empty or full
     */
    public Job dequeue() throws QueueException;

    /**
     * Method to find if the queue is empty or not
     * 
     * @return true if queue is empty else false
     */
    public boolean isEmpty();

    /**
     * Method to find if a queue is full or not
     * 
     * @return true if queue is full else false
     */
    public boolean isFull();
}
