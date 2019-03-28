import java.util.List;

public interface Graph {

    /**
     * Method used to find if a graph is connected i.e., all nodes are
     * reachable, or not
     * 
     * @return true if graph is connected else false
     */
    public boolean isConnected();

    /**
     * Method to find list of all nodes that are reachable from the given source
     * node
     * 
     * @param source
     *            of which all reachable nodes has to find
     * @return the list of all reachable node
     */
    public List<Integer> getReachableVerttices(int source);

    /**
     * Method to find minimum spanning tree of a graph
     * 
     * @return the integer array of the node's vertices such as the total sum of
     *         the edges in minimum
     */
    public int[] getMST();

    /**
     * Method to find the shortest path between the source and the destination
     * 
     * @param source
     *            begining index of the traversal
     * @param destiination
     *            end index of the traversal
     * @return minimum distance
     */
    public int getShortestPath(int source, int destiination);

}