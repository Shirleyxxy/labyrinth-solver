/**
 * Implements a labyrinth. Assumes that the labyrinth entrance will always be in
 * the top-left position and that the exit will always be in the bottom-right
 * position.
 * 
 * Created by peter on 3/29/17.
 */
public class Labyrinth {

	private LabyrinthNode map[][];

	// public Labyrinth() {
	//
	// int l = 3;
	// int w = 3;
	// map = new LabyrinthNode[l][w];
	//
	// map[0][0] = LabyrinthNode.ENTRANCE;
	// map[0][1] = LabyrinthNode.WALL;
	// map[0][2] = LabyrinthNode.WALL;
	//
	// map[1][0] = LabyrinthNode.PATH;
	// map[1][1] = LabyrinthNode.WALL;
	// map[1][2] = LabyrinthNode.WALL;
	//
	// map[2][0] = LabyrinthNode.PATH;
	// map[2][1] = LabyrinthNode.PATH;
	// map[2][2] = LabyrinthNode.EXIT;
	//
	// // you will want to build a larger labyrinth
	// // to more completely test your code
	// }

	/**
	 * Constructs a default test labyrinth.
	 */
	public Labyrinth() {

		int l = 5;
		int w = 5;
		map = new LabyrinthNode[l][w];

		map[0][0] = LabyrinthNode.ENTRANCE;
		map[0][1] = LabyrinthNode.PATH;
		map[0][2] = LabyrinthNode.WALL;
		map[0][3] = LabyrinthNode.WALL;
		map[0][4] = LabyrinthNode.PATH;

		map[1][0] = LabyrinthNode.WALL;
		map[1][1] = LabyrinthNode.PATH;
		map[1][2] = LabyrinthNode.PATH;
		map[1][3] = LabyrinthNode.PATH;
		map[1][4] = LabyrinthNode.WALL;

		map[2][0] = LabyrinthNode.WALL;
		map[2][1] = LabyrinthNode.WALL;
		map[2][2] = LabyrinthNode.WALL;
		map[2][3] = LabyrinthNode.PATH;
		map[2][4] = LabyrinthNode.WALL;

		map[3][0] = LabyrinthNode.PATH;
		map[3][1] = LabyrinthNode.PATH;
		map[3][2] = LabyrinthNode.PATH;
		map[3][3] = LabyrinthNode.PATH;
		map[3][4] = LabyrinthNode.WALL;

		map[4][0] = LabyrinthNode.PATH;
		map[4][1] = LabyrinthNode.PATH;
		map[4][2] = LabyrinthNode.PATH;
		map[4][3] = LabyrinthNode.PATH;
		map[4][4] = LabyrinthNode.EXIT;

	}

	/**
	 * Constructs an empty labyrinth with given length and width.
	 * 
	 * @param l
	 * @param w
	 */
	public Labyrinth(int l, int w) {
		map = new LabyrinthNode[l][w];
	}

	/**
	 * Returns the width of the labyrinth.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return map[0].length;
	}

	/**
	 * Returns the length of the labyrinth.
	 * 
	 * @return length
	 */
	public int getLength() {
		return map.length;
	}

	/**
	 * Returns a labyrinth node stored in a given position.
	 * 
	 * @param l
	 * @param w
	 * @return labyrinth node
	 */
	public LabyrinthNode getNode(int l, int w) {
		if ((l >= 0) && (l < map.length) && (w >= 0) && (w < map[0].length)) {
			return map[l][w];
		}
		return null;
	}

	/**
	 * Returns the string representation of the labyrinth.
	 * 
	 * @return string representation of the labyrinth
	 */
	public String drawMap() {
		String temp = "";
		for (int l = 0; l < getLength(); l++) {
			for (int w = 0; w < getWidth(); w++) {
				temp += getNode(l, w).drawNode();
			}
			temp += "\n";
		}
		return temp;
	}

	public static void main(String[] args) {
		Labyrinth testLab = new Labyrinth();
		System.out.println(testLab.drawMap());
	}
}
