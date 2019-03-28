import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static GraphImp graph;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Size of Graph");
        int size = getValidInteger();
        try {
            graph = new GraphImp(size);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            MyLogFile.writeToFile(e.getMessage());
            System.exit(0);
        }
        int choice = 0;
        while (choice != 9) {

            System.out.println("1 Add Edge");
            System.out.println("2 IsConnected");
            System.out.println("3 Rechable");
            System.out.println("4 Minimum spanning tree");
            System.out.println("5 Shortest Path");
            System.out.println("9 Exit!!");
            choice = getValidInteger();
            switch (choice) {
            case 1:
                System.out.println("Source: ");
                int source = getValidInteger();
                System.out.println("Destination: ");
                int destination = getValidInteger();
                System.out.println("weight: ");
                int weight = getValidInteger();
                try {
                    graph.addEdge(source, destination, weight);
                    System.out.println("Edge Added!!!");
                } catch (AssertionError e) {
                    System.out.println(e.getMessage());
                    MyLogFile.writeToFile(e.getMessage());
                }
                graph.printTree();
                break;
            case 2:
                if (graph.isConnected())
                    System.out.println("Graaph is connected");
                else
                    System.out.println("Graph is not Connected");
                break;
            case 3:
                System.out.println("Enter Vertex to get all rechable Vertex");
                int vertex = getValidInteger();
                try {
                    List<Integer> rechableVertex = graph
                            .getReachableVerttices(vertex);
                    for (Integer i : rechableVertex)
                        System.out.print(i + "  ");
                } catch (AssertionError e) {
                    System.out.println(e.getMessage());
                    MyLogFile.writeToFile(e.getMessage());
                }
                break;
            case 4:
                int tree[] = graph.getMST();
                for (int i = 1; i < tree.length; i++)
                    System.out.println(i + " has parent: " + tree[i]);
                break;
            case 5:
                System.out.println("vertex 1:");
                source = getValidInteger();
                System.out.println("vertex 2:");
                destination = getValidInteger();
                try {
                    int shortestPathlength = graph.getShortestPath(source,destination);
                    System.out.println("Shortest Path between " + source  + " and " + destination + " is " + shortestPathlength);
                } catch (AssertionError e) {
                    System.out.println(e.getMessage());
                    MyLogFile.writeToFile(e.getMessage());
                }

                break;
            case 9:
                sc.close();
                break;
            default:
                System.out.println("Enter a valid choice!!!");

            }
        }
    }

    /**
     * @return :an integer passed by user with exception handling
     */
    public static int getValidInteger() {
        int value = 0;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextInt();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. "
                        + "Incorrect input: an integer is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }

}
