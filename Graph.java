/**
 * Interface for implementing a graph.
 * 
 * Created by peter on 3/28/17.
 */
public interface Graph {

	/**
	 * add bi-directional (undirected) edge to the graph
	 * 
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to);

	/**
	 * delete bi-directional (undirected) edge from the graph
	 * 
	 * @param from
	 * @param to
	 */
	public void deleteEdge(int from, int to);

	/**
	 * getEdge returns true if edge exists and false if edge does not exist
	 * 
	 * @param from
	 * @param to
	 * @return true if edge exists, false otherwise.
	 */
	public boolean getEdge(int from, int to);

	/**
	 * getAdjacent returns array filled with vertices adjacent to the given node
	 * 
	 * @param from
	 * @return array filled with vertices adjacent to the given node
	 */
	public int[] getAdjacent(int from);

	/**
	 * getVertexCount returns count of vertices in the graph
	 * 
	 * @return number of vertices in the graph
	 */
	public int getVertexCount();
}
