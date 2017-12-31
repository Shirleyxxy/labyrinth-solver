/**
 * Implements a node in a labyrinth. A node in a labyrinth can be PATH, WALL,
 * ENTRANCE, or EXIT.
 * 
 * Created by peter on 3/29/17.
 */
public enum LabyrinthNode {

	PATH(true, false, false), WALL(false, false, false), ENTRANCE(true, true, false), EXIT(true, false, true);

	private final boolean isPassable;
	private final boolean isEntrance;
	private final boolean isExit;

	LabyrinthNode(boolean passable, boolean entrance, boolean exit) {
		isPassable = passable;
		isEntrance = entrance;
		isExit = exit;
	}

	/**
	 * Checks if a node is passable.
	 * 
	 * @return true if node is passable, false otherwise.
	 */
	public boolean isPassable() {
		return isPassable;
	}

	/**
	 * Checks if a node is an entrance.
	 * 
	 * @return true if node is an entrance, false otherwise.
	 */
	public boolean isEntrance() {
		return isEntrance;
	}

	/**
	 * Checks if a node is an exit.
	 * 
	 * @return true if node is an exit, false otherwise.
	 */
	public boolean isExit() {
		return isExit;
	}

	/**
	 * Returns the string representation of a node.
	 * 
	 * @return string
	 */
	public String toString() {
		String result = super.toString();

		if (isPassable())
			result += " is Passable";

		else
			result += " is not Passable";

		if (isEntrance())
			result += ", Entrance";

		if (isExit())
			result += ", Exit";

		return result;
	}

	/**
	 * Draws a node based on its type.
	 * 
	 * @return string
	 */
	public String drawNode() {
		String result = "";

		if (isEntrance())
			result += "E";

		else if (isExit())
			result += "X";

		else if (isPassable())
			result += "_";

		else
			result += "#";

		return result;
	}

	public static void main(String[] args) {
		for (LabyrinthNode l : LabyrinthNode.values()) {
			System.out.println(l.toString());
		}
	}
}
