import java.util.Arrays;

/**
 * Implements a graph with an adjacency matrix.
 * 
 * @author Xueying Xu (Shirley)
 */
public class GraphMatrix implements Graph {

	protected boolean[][] vertexMatrix;

	protected int numVertices;

	/**
	 * Constructs an empty graph with the given number of vertices.
	 * 
	 * @param numVertices
	 */
	public GraphMatrix(int numVertices) {

		vertexMatrix = new boolean[numVertices][numVertices];
		this.numVertices = numVertices;
	}

	/**
	 * Adds an undirected edge to the graph.
	 * 
	 * @param from
	 * @param to
	 */
	public void addEdge(int from, int to) {
		if (!vertexMatrix[from][to]) {
			vertexMatrix[from][to] = true;
			vertexMatrix[to][from] = true;
		}
	}

	/**
	 * Deletes an undirected edge from the graph
	 * 
	 * @param from
	 * @param to
	 */
	public void deleteEdge(int from, int to) {
		if (vertexMatrix[from][to]) {
			vertexMatrix[from][to] = false;
			vertexMatrix[to][from] = false;
		}
	}

	/**
	 * Checks if an certain edge exists.
	 * 
	 * @param from
	 * @param to
	 * @return true if the edge exists, false otherwise.
	 */
	public boolean getEdge(int from, int to) {
		return vertexMatrix[from][to];
	}

	/**
	 * Returns array filled with vertices adjacent to the given node
	 * 
	 * @param from
	 * @return array filled with adjacent nodes
	 */
	public int[] getAdjacent(int from) {
		// creates an empty array
		int[] neighbors = new int[0];
		for (int i = 0; i < numVertices; i++) {
			if (vertexMatrix[from][i]) {
				// copies the array and increases its length by 1
				neighbors = Arrays.copyOf(neighbors, neighbors.length + 1);
				// adds the integer representing a neighbor node to the end of the array
				neighbors[neighbors.length - 1] = i;
			}
		}
		return neighbors;
	}

	/**
	 * Returns the number of vertices in the graph.
	 * 
	 * @return the number of vertices
	 */
	public int getVertexCount() {
		return numVertices;
	}
}
