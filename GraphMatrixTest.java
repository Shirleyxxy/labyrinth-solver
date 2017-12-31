import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the functionality of GraphMatrix.
 * 
 * Created by peter on 3/28/17.
 * 
 * @author Xueying Xu (Shirley)
 */
public class GraphMatrixTest {
	GraphMatrix twoVertexEmptyGraph;
	GraphMatrix twoVertexFullGraph;
	GraphMatrix fiveVerticesGraph;

	@Before
	public void setUp() {
		twoVertexEmptyGraph = new GraphMatrix(2);

		twoVertexFullGraph = new GraphMatrix(2);
		twoVertexFullGraph.vertexMatrix[0][1] = true;
		twoVertexFullGraph.vertexMatrix[1][0] = true;

		fiveVerticesGraph = new GraphMatrix(5);
		fiveVerticesGraph.vertexMatrix[0][1] = true;
		fiveVerticesGraph.vertexMatrix[0][4] = true;
		fiveVerticesGraph.vertexMatrix[1][0] = true;
		fiveVerticesGraph.vertexMatrix[1][2] = true;
		fiveVerticesGraph.vertexMatrix[1][3] = true;
		fiveVerticesGraph.vertexMatrix[1][4] = true;
		fiveVerticesGraph.vertexMatrix[2][1] = true;
		fiveVerticesGraph.vertexMatrix[2][3] = true;
		fiveVerticesGraph.vertexMatrix[3][1] = true;
		fiveVerticesGraph.vertexMatrix[3][2] = true;
		fiveVerticesGraph.vertexMatrix[3][4] = true;
		fiveVerticesGraph.vertexMatrix[4][0] = true;
		fiveVerticesGraph.vertexMatrix[4][1] = true;
		fiveVerticesGraph.vertexMatrix[4][3] = true;

	}

	@Test
	public void constructor() {
		assertNotNull(twoVertexEmptyGraph);
		assertNotNull(twoVertexFullGraph);
		assertNotNull(fiveVerticesGraph);
	}

	@Test
	public void addEdge() {
		twoVertexEmptyGraph.addEdge(0, 1);
		assertTrue(twoVertexEmptyGraph.vertexMatrix[0][1]);
		assertTrue(twoVertexEmptyGraph.vertexMatrix[1][0]);

		fiveVerticesGraph.addEdge(0, 2);
		assertTrue(fiveVerticesGraph.vertexMatrix[0][2]);
		assertTrue(fiveVerticesGraph.vertexMatrix[2][0]);
	}

	@Test
	public void deleteEdge() {
		twoVertexEmptyGraph.vertexMatrix[0][1] = true;
		assertTrue(twoVertexEmptyGraph.vertexMatrix[0][1]);
		twoVertexEmptyGraph.deleteEdge(0, 1);
		assertFalse(twoVertexEmptyGraph.vertexMatrix[0][1]);
		assertFalse(twoVertexEmptyGraph.vertexMatrix[1][0]);

		twoVertexFullGraph.deleteEdge(1, 0);
		assertFalse(twoVertexFullGraph.vertexMatrix[1][0]);
		assertFalse(twoVertexFullGraph.vertexMatrix[0][1]);

		fiveVerticesGraph.deleteEdge(1, 4);
		assertFalse(fiveVerticesGraph.vertexMatrix[1][4]);
		assertFalse(fiveVerticesGraph.vertexMatrix[4][1]);
	}

	@Test
	public void getEdge() {
		assertTrue(twoVertexFullGraph.getEdge(0, 1));
		assertTrue(twoVertexFullGraph.getEdge(1, 0));

		assertFalse(twoVertexEmptyGraph.getEdge(0, 1));
		assertFalse(twoVertexEmptyGraph.getEdge(1, 0));

		assertTrue(fiveVerticesGraph.getEdge(2, 3));
		assertTrue(fiveVerticesGraph.getEdge(3, 2));
		assertFalse(fiveVerticesGraph.getEdge(0, 3));
		assertFalse(fiveVerticesGraph.getEdge(3, 0));
	}

	@Test
	public void getAdjacent() {
		assertEquals(0, twoVertexEmptyGraph.getAdjacent(1).length);
		assertEquals(1, twoVertexFullGraph.getAdjacent(0).length);
		assertEquals(3, fiveVerticesGraph.getAdjacent(4).length);

		int[] testArray1 = fiveVerticesGraph.getAdjacent(1);
		assertEquals(4, testArray1.length);
		assertEquals(0, testArray1[0]);
		assertEquals(2, testArray1[1]);
		assertEquals(3, testArray1[2]);
		assertEquals(4, testArray1[3]);

		int[] testArray2 = fiveVerticesGraph.getAdjacent(0);
		assertEquals(2, testArray2.length);
		assertEquals(1, testArray2[0]);
		assertEquals(4, testArray2[1]);
	}

	@Test
	public void getVertexCount() {
		assertEquals(2, twoVertexEmptyGraph.getVertexCount());
		assertEquals(2, twoVertexFullGraph.getVertexCount());
		assertEquals(5, fiveVerticesGraph.getVertexCount());
	}
}