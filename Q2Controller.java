/*
 * The program initializes a life matrix, displays it on a canvas, and updates the matrix based on Conway's Game of Life rules.
 * The user can click the "Next" button to progress to the next generation.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Q2Controller {

	@FXML
	private Canvas canv;
	private GraphicsContext gc;
	private LifeMatrix lifeMatrix;//LifeMatrix object representing the 10x10 grid of life cells.
	private final int SIZE=10;
	private boolean isFirstPressed=true;//Flag to track if it's the first time the button is pressed.

	/*Initializes the controller. Sets up the GraphicsContext and initializes the LifeMatrix with the specified size.
	 * */

	public void initialize() {
		gc = canv.getGraphicsContext2D();
		lifeMatrix = new LifeMatrix(SIZE); // init empty matrix

	}

	@FXML
	//The function that manages the whole show and the change between the years.
	void btnPressed(ActionEvent event) {
		double canvWidth=canv.getWidth();// Get the width of the Canvas
		double canvHeight=canv.getHeight(); // Get the height of the Canvas

		gc.clearRect(0, 0, canvWidth, canvHeight); // Clear the canvas before redrawing

		if(isFirstPressed)
		{
			// Initialize the life matrix with random values on the first button press
			lifeMatrix.NewFirstMatrix(SIZE);
			renderLifeMatrix();// Render the matrix on the canvas
			isFirstPressed = false;
		}
		else
		{
			// Compute the next generation of cells
			lifeMatrix.nextGeneration();
			renderLifeMatrix();

		}
	}

	/*
	 * Renders the life matrix on the canvas by drawing a grid. Each cell is drawn as either filled (alive) or empty (dead).
	 */
	private void renderLifeMatrix() {
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
		boolean[][] matrix = lifeMatrix.getMatrix();
		double canvasWidth = canv.getWidth();
		double canvasHeight = canv.getHeight();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				double x = i / (double) SIZE * canvasWidth;
				double y = j / (double) SIZE * canvasHeight;
				double w = canvasWidth / SIZE;
				double h = canvasHeight / SIZE;
				//// If the cell is alive, fill it with color
				if (matrix[i][j]) {
					gc.fillRect(x, y, w, h);
				}
				// Always draw the border of each cell
				gc.strokeRect(x, y, w, h);
			}
		}
	}


}  




