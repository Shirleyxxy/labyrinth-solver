import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests the functionality of LabyrinthSolver.
 * 
 * Note: Tests are updated with a larger 5 * 5 default labyrinth.
 * 
 * Created by peter on 4/2/17.
 */
public class LabyrinthSolverTest {

	Labyrinth testLab;
	Graph g;

	@Before
	public void setup() {
		testLab = new Labyrinth();
		g = new GraphMatrix(testLab.getLength() * testLab.getWidth());
		g = LabyrinthSolver.labyrinthToGraph(testLab, g);
	}

	@Test
	public void labyrinthToNodeNumber() {
		int node = LabyrinthSolver.labyrinthToNodeNumber(6, 7, 10);
		assertEquals(67, node);
	}

	@Test
	public void labyrinthToGraph() {
		int trueCount = 0;
		for (int i = 0; i < g.getVertexCount(); i++) {
			for (int j = 0; j < g.getVertexCount(); j++) {
				if (g.getEdge(i, j))
					trueCount++;
			}
		}
		assertEquals(34, trueCount);
	}

	@Test
	public void breadFirstSearch() {
		assertArrayEquals(new int[] {0, 1, 6, 7, 8, 13, 18, 23, 24}, LabyrinthSolver.breadFirstSearch(g));
	}
}