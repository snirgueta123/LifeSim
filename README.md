# Conway's Game of Life - LifeSim

LifeSim is a simulation of Conway's Game of Life, a zero-player game that models the evolution of life on a grid. The game operates on a matrix (10x10), where each cell represents a habitat that can either be alive or dead.

## Table of Contents
- [What is Conway's Game of Life?](#what-is-conways-game-of-life)
- [Features](#features)
- [How to Run the Project](#how-to-run-the-project)
- [Game Rules](#game-rules)
- [Example Input/Output](#example-inputoutput)
- [License](#license)

## What is Conway's Game of Life?

Conway's Game of Life is a cellular automaton devised by mathematician John Conway. It simulates the behavior of cells on a grid where each cell follows simple rules based on the state of its neighbors. The grid is updated generation by generation, with cells either coming to life, surviving, or dying based on the number of live neighbors.

The game doesn't require human intervention once started. It runs automatically based on the rules of birth, survival, and death.

## Features

- **Random Initialization**: The game grid is initialized randomly with some cells alive and others dead.
- **Next Generation Button**: After each generation, users can click a button to advance to the next generation.
- **Visualization**: The grid is visually represented using JavaFX's `Canvas` component, with each cell shown as a square. Cells are colored differently based on whether they are alive or dead.
- **Interactive UI**: Users can interact with the program through a GUI and see the grid update after each generation.

## How to Run the Project

1. **Clone the Repository**:
   To clone this repository, run the following command:
   ```bash
   git clone https://github.com/snirgueta123/LifeSim.git

## Game Rules

The Game of Life follows three basic rules for each cell:
1.Birth: A dead cell with exactly three live neighbors will become alive.
2.Survival: A live cell with two or three live neighbors will continue to live.
3.Death: A live cell with fewer than two live neighbors dies from loneliness. A live cell with more than three live neighbors dies from overcrowding.

These rules are applied simultaneously to all cells in the grid at each step.

## Example Input/Output

Example 1:
 - Initial Grid:
    - Random initialization of cells (some cells are alive, some are dead).
 - First Generation:
    -After clicking the "Next Generation" button, the grid updates based on the rules, and you can observe cells either dying or coming to life.
Example 2:
 1.Initial Setup: Random configuration.
 2.After clicking "Next Generation": The grid will change, with some cells alive and others dead, based on the neighbor count.

