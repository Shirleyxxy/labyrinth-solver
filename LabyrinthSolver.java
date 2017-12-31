import java.util.*;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Implements the methods to find the shortest path from the start of the
 * labyrinth to the exit.
 * 
 * Created by peter on 3/28/17.
 * 
 * @author Xueying Xu (Shirley)
 */
public class LabyrinthSolver {

	/**
	 * Converts a labyrinth position to graph vertex number.
	 * 
	 * @param l
	 * @param w
	 * @param labwidth
	 * @return graph vertex number
	 */
	public static int labyrinthToNodeNumber(int l, int w, int labwidth) {
		return l * labwidth + w;
	}

	/**
	 * Converts the labyrinth into a graph representation by adding edges to the
	 * graph.
	 * 
	 * @param lab
	 * @param mazeGraph
	 * @return graph representation of the labyrinth
	 */
	public static Graph labyrinthToGraph(Labyrinth lab, Graph mazeGraph) {
		// loop through the entire labyrinth
		for (int l = 0; l < lab.getLength(); l++) {
			for (int w = 0; w < lab.getWidth(); w++) {
				// check every node in the labyrinth
				LabyrinthNode currLabNode = lab.getNode(l, w);

				switch (currLabNode) {
				case WALL: {
					break;
				}

				// top-left of the labyrinth
				case ENTRANCE: {
					LabyrinthNode rightNode = lab.getNode(l, w + 1);
					if (rightNode.isPassable()) {
						mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
								labyrinthToNodeNumber(l, w + 1, lab.getWidth()));
					}

					LabyrinthNode belowNode = lab.getNode(l + 1, w);
					if (belowNode.isPassable()) {
						mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
								labyrinthToNodeNumber(l + 1, w, lab.getWidth()));
					}
					break;
				}

				// bottom-right of the labyrinth
				case EXIT: {
					LabyrinthNode leftNode = lab.getNode(l, w - 1);
					if (leftNode.isPassable()) {
						mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
								labyrinthToNodeNumber(l, w - 1, lab.getWidth()));
					}

					LabyrinthNode topNode = lab.getNode(l - 1, w);
					if (topNode.isPassable()) {
						mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
								labyrinthToNodeNumber(l - 1, w, lab.getWidth()));
					}
					break;
				}

				case PATH: {
					// case 1: top-right of the labyrinth
					if (l == 0) {
						if (w == lab.getWidth() - 1) {
							LabyrinthNode leftNode = lab.getNode(l, w - 1);
							if (leftNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l, w - 1, lab.getWidth()));
							}

							LabyrinthNode belowNode = lab.getNode(l + 1, w);
							if (belowNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l + 1, w, lab.getWidth()));
							}
							// case 2: top row of the labyrinth (except the top-right node)
						} else {

							LabyrinthNode leftNode = lab.getNode(l, w - 1);
							if (leftNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l, w - 1, lab.getWidth()));
							}

							LabyrinthNode rightNode = lab.getNode(l, w + 1);
							if (rightNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l, w + 1, lab.getWidth()));
							}

							LabyrinthNode belowNode = lab.getNode(l + 1, w);
							if (belowNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l + 1, w, lab.getWidth()));
							}
						}
					}
					// case 3: bottom-left of the labyrinth
					else if (l == lab.getLength() - 1) {
						if (w == 0) {

							LabyrinthNode topNode = lab.getNode(l - 1, w);
							if (topNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l - 1, w, lab.getWidth()));
							}

							LabyrinthNode rightNode = lab.getNode(l, w + 1);
							if (rightNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l, w + 1, lab.getWidth()));
							}

							// case 4: bottom row of the labyrinth (except the bottom-left node)
						} else {

							LabyrinthNode topNode = lab.getNode(l - 1, w);
							if (topNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l - 1, w, lab.getWidth()));
							}

							LabyrinthNode rightNode = lab.getNode(l, w + 1);
							if (rightNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l, w + 1, lab.getWidth()));
							}

							LabyrinthNode leftNode = lab.getNode(l, w - 1);
							if (leftNode.isPassable()) {
								mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
										labyrinthToNodeNumber(l, w - 1, lab.getWidth()));
							}
						}
					}

					// case 5: left boundary of the labyrinth (except the left-bottom node)
					else if (w == 0 && l != lab.getLength() - 1) {

						LabyrinthNode topNode = lab.getNode(l - 1, w);
						if (topNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l - 1, w, lab.getWidth()));
						}

						LabyrinthNode belowNode = lab.getNode(l + 1, w);
						if (belowNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l + 1, w, lab.getWidth()));
						}

						LabyrinthNode rightNode = lab.getNode(l, w + 1);
						if (rightNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l, w + 1, lab.getWidth()));
						}
					}

					// case 6: right boundary of the labyrinth (except the top-right node)
					else if (w == lab.getWidth() - 1 && l != 0) {

						LabyrinthNode topNode = lab.getNode(l - 1, w);
						if (topNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l - 1, w, lab.getWidth()));
						}

						LabyrinthNode belowNode = lab.getNode(l + 1, w);
						if (belowNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l + 1, w, lab.getWidth()));
						}

						LabyrinthNode leftNode = lab.getNode(l, w - 1);
						if (leftNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l, w - 1, lab.getWidth()));
						}

						// nodes not on the boundaries
					} else {

						LabyrinthNode leftNode = lab.getNode(l, w - 1);
						if (leftNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l, w - 1, lab.getWidth()));
						}

						LabyrinthNode rightNode = lab.getNode(l, w + 1);
						if (rightNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l, w + 1, lab.getWidth()));
						}

						LabyrinthNode topNode = lab.getNode(l - 1, w);
						if (topNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l - 1, w, lab.getWidth()));
						}

						LabyrinthNode belowNode = lab.getNode(l + 1, w);
						if (belowNode.isPassable()) {
							mazeGraph.addEdge(labyrinthToNodeNumber(l, w, lab.getWidth()),
									labyrinthToNodeNumber(l + 1, w, lab.getWidth()));
						}
					}
					break;
				}

				}
			}
		}
		return mazeGraph;
	}

	/**
	 * Returns the shortest path from the start of the labyrinth to the exit.
	 * 
	 * @param mazeGraph
	 * @return the shortest path
	 */
	public static int[] breadFirstSearch(Graph mazeGraph) {
		// the source node is the entrance of the labyrinth
		int sourceNode = 0;
		// the exit node is in the bottom-right of the labyrinth
		int exitNode = mazeGraph.getVertexCount() - 1;
		// a boolean array to keep track of whether a node has been visited
		boolean[] marked = new boolean[mazeGraph.getVertexCount()];
		// an array to keep track of the previous node visited
		int[] previous = new int[mazeGraph.getVertexCount()];
		// initializes all the values for the previous nodes to be -1
		for (int i = 0; i < mazeGraph.getVertexCount(); i++) {
			previous[i] = -1;
		}
		// a queue for nodes to visit
		Queue<Integer> queue = new LinkedList<Integer>();

		// starts with the source node
		queue.add(sourceNode);
		marked[sourceNode] = true;

		while (!queue.isEmpty()) {
			int v = queue.remove();
			if (v == exitNode) {
				break;
			} else {
				// checks every unvisited neighbor of the current node
				for (int w : mazeGraph.getAdjacent(v)) {
					if (!marked[w]) {
						marked[w] = true;
						// stores the most previously visited node
						previous[w] = v;
						// adds the node to the queue
						queue.add(w);
					}
				}
			}
		}

		// traces the path in reverse order
		Stack<Integer> reversePath = new Stack<Integer>();
		int currentNode = mazeGraph.getVertexCount() - 1;
		while (previous[currentNode] != -1) {
			reversePath.add(currentNode);
			currentNode = previous[currentNode];
		}
		reversePath.add(sourceNode);

		int[] path = new int[reversePath.size()];

		// pops up indices from the stack to report the path from the source node
		for (int i = 0; i < path.length; i++) {
			path[i] = reversePath.pop();
		}

		return path;
	}

	public static void main(String[] args) {
		// Design the Labyrinth
		Labyrinth testLab = new Labyrinth();
		System.out.println("The Starting Labyrinth");
		System.out.println(testLab.drawMap());

		// Convert the Labyrinth to a graph
		Graph mazeGraph = new GraphMatrix(testLab.getLength() * testLab.getWidth());
		labyrinthToGraph(testLab, mazeGraph);
		System.out.println(mazeGraph);

		// Draw the final path
		int[] path = breadFirstSearch(mazeGraph);
		if (path == null)
			System.out.println("There is no solution path");
		else
			System.out.println(Arrays.toString(path));
	}
}
