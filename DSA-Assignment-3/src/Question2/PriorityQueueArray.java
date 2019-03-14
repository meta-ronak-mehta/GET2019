package Question2;

import java.util.Arrays;

import exceptionhandling.MyLogFile;
import exceptionhandling.QueueException;

public class PriorityQueueArray implements PriorityQueue {

    private Job[] queue;
    private int rear, front, maxSize;

    public PriorityQueueArray(int maxSize) {
        this.queue = new Job[maxSize];
        this.maxSize = maxSize;
        this.rear = -1;
        this.front = -1;
    }

    @Override
    public boolean enqueue(Job job) throws QueueException {
        boolean result;
        try {
            if (!isFull()) {
                if (rear == -1) {
                    front++;
                    rear++;
                } else {
                    rear = (rear + 1) % maxSize;
                }
                int pos = -1;
                // to get the index where we have to store that job
                for (int i = front; i <= (rear - 1); i++) {
                    if (job.getPriority() > queue[i].getPriority()) {
                        pos = i;
                        break;
                    }
                }
                if (pos != -1) {
                    // move elements to the right side
                    for (int i = (rear - 1); i >= pos; i--) {
                        queue[(i + 1) % this.maxSize] = queue[i];
                    }
                    queue[pos] = job;
                    result = true;
                }
                // add next element at end as it has the lowest priority
                else {
                    queue[rear] = job;
                    result = true;
                }
            } else
                throw new QueueException("The queue is full!");
        } catch (QueueException error) {
            throw new QueueException("Exception Caught at Enqueue");
        }
        return result;
    }

    @Override
    public Job dequeue() throws QueueException {
        Job job = null;
        try {
            if (!isEmpty()) {
                if (front == rear) {
                    job = queue[front];
                    front = -1;
                    rear = -1;
                } else {
                    job = queue[front];
                    front = (front + 1) % maxSize;
                }
            } else
                throw new QueueException("The queue is empty!");
        } catch (QueueException error) {
            throw new QueueException("Exception Caught at dequeue");
        }
        return job;
    }

    @Override
    public boolean isEmpty() {
        return rear == -1 && front == -1 ? true : false;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public String toString() {
        return "PriorityQueueArray [" + Arrays.toString(queue) + "]";
    }
}
