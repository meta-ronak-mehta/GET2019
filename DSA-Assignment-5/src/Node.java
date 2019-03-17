public class Node<T> {

    Data<T> data;
    Node<T> leftNode;
    Node<T> rightNode;

    // constructor
    public Node(String key, T value) {
        this.data = new Data<T>(key, value);
        this.leftNode = null;
        this.rightNode = null;
    }

    // getter setter methods
    public Data<T> getData() {
        return data;
    }

    public void setData(Data<T> data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

}
