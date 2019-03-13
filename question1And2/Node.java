package question1And2;
public class Node<T> {
    
    T data;
    Node<T> next;

    Node(T d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "[data=" + data + ", next=" + next + "]";
        }
    }
}
