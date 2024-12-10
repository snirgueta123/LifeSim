

import java.util.Random;

public class LifeMatrix {

	private boolean[][] lifeMatrix;//  // 2D array representing the state of life for each cell (alive/dead)
	private static final Random random = new Random();

	/*
    Initializes the matrix with the given size. Throws an exception if the size is 0 or negative.
	 */
	public LifeMatrix(int matrixSize) {
		if (matrixSize <= 0) {
			throw new IllegalArgumentException("Matrix size must be greater than 0");
		}
		lifeMatrix = new boolean[matrixSize][matrixSize];
	}

	/*
	 * Initializes the life matrix with random values. Each cell is either alive (true) or dead (false).
	 */
	public void NewFirstMatrix(int matrixSize) {

		for (int i = 0; i < lifeMatrix.length; i++) {
			for (int j = 0; j < lifeMatrix[0].length; j++) {
				lifeMatrix[i][j] = random.nextBoolean();
			}
		}
	}

	/*
	 * Computes the next generation of the life matrix according to Conway's Game of Life rules:
	 * 1. A live cell with fewer than 2 or more than 3 live neighbors dies.
	 * 2. A dead cell with exactly 3 live neighbors becomes alive.
	 * 3. A live cell with 2 or 3 live neighbors stays alive.
	 */

	public void nextGeneration() {

		//// Create a new matrix to store the next generation of life statuses
		boolean[][] nextGenerationMatrix  = new boolean[lifeMatrix.length][lifeMatrix[0].length];
		for (int row = 0; row < lifeMatrix.length; row++) {
			for (int col  = 0; col  < lifeMatrix[row].length; col++) {
				int liveNeighborsCount = getNumOfAliveNeighbours(row, col );// Calculate the number of live neighbors.
				boolean currentCellStatus  = lifeMatrix[row][col ];

				// // If the cell is alive and has fewer than 2 or more than 3 neighbors, it dies
				if (lifeMatrix[row][col ] && (liveNeighborsCount < 2 || liveNeighborsCount >= 4)) {
					currentCellStatus  = false;
				}

				// If the cell is dead and has exactly 3 neighbors, it becomes alive
				else if (!lifeMatrix[row][col] && liveNeighborsCount == 3) {
					currentCellStatus  = true;
				}
				nextGenerationMatrix [row][col] = currentCellStatus ;
			}
		}
		lifeMatrix = nextGenerationMatrix ;
	}

	/*
	 * Calculates the number of live neighbors for a cell at coordinates (x, y).
	 * This is done by checking all 8 neighboring positions around the cell.
	 */
	private int getNumOfAliveNeighbours(int x, int y) {
		int aliveNeighbors = 0;

		// Directions array for the 8 possible neighbors (top-left, top, top-right, left, right, bottom-left, bottom, bottom-right)
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

		// Iterate through each of the 8 possible neighbors
		for (int i = 0; i < dx.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			// Check if the neighbor is within bounds and is alive
			if (newX >= 0 && newX < lifeMatrix.length && newY >= 0 && newY < lifeMatrix[0].length) {
				if (lifeMatrix[newX][newY]) {
					aliveNeighbors++;
				}
			}
		}

		return aliveNeighbors;
	}

	/*
	 *  Returns the current life matrix.
	 */
	public boolean[][] getMatrix() {
		return lifeMatrix;
	}

	public static String randomChoice(String option1, String option2) {

		return random.nextBoolean() ? option1 : option2;
	}

}
