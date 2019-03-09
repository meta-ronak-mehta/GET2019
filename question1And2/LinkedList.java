package question1And2;

public class LinkedList<T> {

    Node<T> head; // head of list
    int size;

    /**
     * Method to insert a new node
     * 
     * @param data to be inserted
     */
    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);

        // If the Linked List is empty, then make the new node as head
        if (this.head == null) {
            this.head = newNode;
            this.size = 1;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = newNode;
            this.size++;
        }
    }

    /**
     * To rotate the sub list
     * 
     * @param left              position of sublist
     * @param right             position of sublist
     * @param noOfRotationSteps no of steps to be rotate
     */
    public void clockwiseSubListRotation(int left, int right, int noOfRotationSteps) {
        int size = right - left + 1;
        if (noOfRotationSteps > size) {
            noOfRotationSteps = noOfRotationSteps % size;
        }
        if (left < 0 || right > this.size || noOfRotationSteps <= 0 || left > right)
            return;
        // let list (1 2 3 4 5 6 7 ) and call for(2 5 2 )
        Node<T> lthNode = null;
        if (left == 1) {
            lthNode = this.head;
        }

        Node<T> current = this.head;
        int count = 0;
        Node<T> end = null;
        Node<T> pre = null; // Previous of l-th node
        while (current != null) {
            count++;
            // store previous of Lth Node if head is Lth then no changes
            if (count == left - 1) {
                pre = current;
                lthNode = current.next;
            }
            // connect the previous of Lth to the node after rotation required
            // updated list to (1 4 5 6 7) end points to 3 which is going to be
            // connect to next of right
            if (count == right - noOfRotationSteps) {
                if (left == 1) {
                    end = current;
                    this.head = current.next;
                } else {
                    end = current;
                    pre.next = current.next;
                }
            }

            // updated list to (1 4 5 2 3 6 7)
            if (count == right) {
                Node<T> temp = current.next;
                current.next = lthNode;
                end.next = temp;
                return;
            }
            current = current.next;
        }
    }

    /**
     * create loop in list
     * 
     * @param loopPoint
     */
    public void makeLoop(int loopPoint) {

        if (loopPoint > this.size)
            return;
        // traverse the linked list until loop point not found
        Node<T> currentNode = this.head;
        int count = 1;
        while (count < loopPoint) {
            currentNode = currentNode.next;
            count++;
        }
        // backup the joint point
        Node<T> jointPoint = currentNode;

        // traverse remaining nodes
        while (currentNode.next != null)
            currentNode = currentNode.next;

        // joint the last node to k-th element
        currentNode.next = jointPoint;
    }

    /**
     * 
     * @return true if loop occur else false
     */
    public boolean detectLoop() {
        if (this.head == null) {
            new NullPointerException("empty list");
        }

        Node<T> slowNode = this.head;
        Node<T> fastNode = this.head;

        while (fastNode.next != null || fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "LinkList [head=" + head + "]";
    }

}