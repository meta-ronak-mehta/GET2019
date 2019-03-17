import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class BinarySearchTree<T> implements Dictionary<T> {

    private Node<T> root;

    // Constructor to add Data from JSON Object
    public BinarySearchTree(JSONObject object) {
        this.root = null;
        for (Object key : object.keySet()) {
            addNode(String.valueOf(key).toLowerCase(), (T) object.get(key));
        }
    }

    /**
     * Method to add tree node to a tree
     * 
     * @param key
     * @param value
     * @return true if tree node is added successfully else false
     */
    @Override
    public void addNode(String key, T value) {
        // if key is empty
        if (key == null || key.equals(" ")) {
            throw new AssertionError("invalid key");
        }
        // if value is empty
        else if (value == null || value.equals(" ")) {
            throw new AssertionError("invalid value");
        }
        // create new Node to be inserted
        Node<T> newNode = new Node<T>(key, value);
        // call recursive function traverse from root to correct Position to add newNode
        this.root = insertRec(this.root, newNode);
        return;

    }

    // A recursive function to insert a new key in BST
    private Node<T> insertRec(Node<T> currentNode, Node<T> newNode) {
        // If the current Node is empty return a new node
        if (currentNode == null) {
            currentNode = newNode;
            return currentNode;
        }
        // Otherwise recur down the tree
        if (newNode.getData().getKey().compareToIgnoreCase(currentNode.getData().getKey()) < 0)
            currentNode.leftNode = insertRec(currentNode.leftNode, newNode);
        else
            currentNode.rightNode = insertRec(currentNode.rightNode, newNode);

        // return the (unchanged) node pointer
        return currentNode;

    }

    /**
     * Method to delete tree node with a given key
     * 
     * @param key to be deleted
     */
    @Override
    public void deleteNode(String key) {
        // if key is empty
        if (key == null || key.equals(" ")) {
            throw new AssertionError("invalid key");
        }
        this.root = deleteRec(root, key);
        return;
    }

    // A recursive function to delete data Containing key in BST
    private Node<T> deleteRec(Node<T> currentNode, String key) {
        // If the sub-tree is empty
        if (currentNode == null)
            return currentNode;

        /* Otherwise, recur down the tree */
        if (key.compareToIgnoreCase(currentNode.getData().getKey()) < 0)
            currentNode.leftNode = deleteRec(currentNode.leftNode, key);
        else if (key.compareToIgnoreCase(currentNode.getData().getKey()) > 0)
            currentNode.rightNode = deleteRec(currentNode.rightNode, key);

        // if key is same as currentNode's Data's key then This is the node to be
        // deleted
        else {
            // node with only one child or no child
            if (currentNode.leftNode == null)
                return currentNode.rightNode;
            else if (currentNode.rightNode == null)
                return currentNode.leftNode;

            // node with two children: make the smallest in the right subtree
            Data<T> data = minValue(currentNode.rightNode);
            currentNode.setData(data);

            // Delete the inorder successor
            currentNode.rightNode = deleteRec(currentNode.rightNode, currentNode.getData().getKey());
        }
        // return the (unchanged) node pointer
        return currentNode;
    }

    /**
     * Method to return the value mapped to the given key
     * 
     * @param key whose value is to be search
     * @return the value mapped to the given key
     */
    @Override
    public T getValue(String key) {
        Node<T> currentNode = this.root;
        while (currentNode != null) {
            // if key is matched return value of corresponding key
            if (currentNode.getData().getKey().equalsIgnoreCase(key))
                return currentNode.getData().getValue();
            // if key is small traverse left sub tree
            if (key.compareToIgnoreCase(currentNode.getData().getKey()) < 0)
                currentNode = currentNode.leftNode;
            // else traverse right sub tree
            else
                currentNode = currentNode.rightNode;
        }
        return null;
    }

    /**
     * method to return list if data
     * 
     * @return sorted list of Data
     */
    @Override
    public List<Data<T>> sortedOrder() {
        List<Data<T>> sortedList = new ArrayList<Data<T>>();
        inorderRec(root, sortedList);
        return sortedList;
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node<T> currentNode, List<Data<T>> sortedList) {
        if (currentNode != null) {
            inorderRec(currentNode.getLeftNode(), sortedList);
            sortedList.add(currentNode.getData());
            inorderRec(currentNode.getRightNode(), sortedList);
        }
    }

    /**
     * Method to return the list of sorted nodes between the given two key values
     * 
     * @param key1 is smaller than key2
     * @param key2 requires to greater than key2
     * @return list of sorted nodes between keys
     */
    @Override
    public List<Data<T>> sortBetweenTwoKeyValue(String key1, String key2) {
        List<Data<T>> sortedList = new ArrayList<Data<T>>();

        // key is valid or not
        if (key1.length() < 1 || key1 == null || key1.equals(" ") || key2.length() < 1 || key2 == null
                || key2.equals(" ")) {
            throw new AssertionError("key doesnt exist");
        } else if (key1.compareToIgnoreCase(key2) > 0)
            throw new AssertionError("Key 1 must be smaller then key 2");

        // call recursive function
        sortBetweenTwoKeyValueRec(root, sortedList, key1, key2);

        return sortedList;
    }

    private void sortBetweenTwoKeyValueRec(Node<T> currentNode, List<Data<T>> sortedList, String key1, String key2) {
        if (currentNode != null) {
            sortBetweenTwoKeyValueRec(currentNode.getLeftNode(), sortedList, key1, key2);
            if (currentNode.getData().getKey().compareToIgnoreCase(key1) >= 0
                    && currentNode.getData().getKey().compareToIgnoreCase(key2) <= 0)
                sortedList.add(currentNode.getData());
            sortBetweenTwoKeyValueRec(currentNode.getRightNode(), sortedList, key1, key2);
        }

    }

    // helper function to get minimum key form given Node
    private Data<T> minValue(Node<T> currentNode) {
        Data<T> minKey = currentNode.getData();
        while (currentNode.leftNode != null) {
            minKey = currentNode.leftNode.getData();
            currentNode = currentNode.leftNode;
        }
        return minKey;
    }

}
