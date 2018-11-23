
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic(IProblemState problemState) {

	    // if the given state is the goal state - return 0 as heuristic value
	    if (problemState.isGoalState())
	        return 0;

	    // otherwise calculate the heuristic of the state using manhattan distance
		return manhattan(problemState);

	}

    /**
     * This function gives a heuristic evaluation for the given problem state using manhattan distance
     * @param problemState
     * @return the manhattan distance of the given problem state
     */
    public double manhattan(IProblemState problemState) {
	    TilePuzzleState tilePuzzleState = (TilePuzzleState) problemState;
	    int[][] tilePuzzle = tilePuzzleState._tilePuzzle;
        double manhattanDistance = 0;
        int expected = 0;
        for (int row = 0; row < tilePuzzle.length; row++) {
            for (int col = 0; col < tilePuzzle[row].length; col++) {
                int value = tilePuzzle[row][col];
                expected++;
                if (value != 0 && value != expected) {
                    int expectedRow =  (value - 1) / tilePuzzle.length;
                    int expectedCol =  (value - 1) % tilePuzzle.length;
                    manhattanDistance += value * (Math.abs(row - expectedRow) + Math.abs(col - expectedCol));
                }
            }
        }
        return manhattanDistance;
    }
	
}
