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
        try {
            return "[data=" + data + ", next=" + next + "]";
        }catch(StackOverflowError t) {
            System.err.println("Stcak overflow catch");
            return "";
        }
    }
}
