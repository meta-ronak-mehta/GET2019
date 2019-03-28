import java.util.Comparator;

class comparator implements Comparator<Node> { 
  
        @Override
        public int compare(Node node0, Node node1) 
        { 
            return node0.getWeight() - node1.getWeight(); 
        } 
    } 