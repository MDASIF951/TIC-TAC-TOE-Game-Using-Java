# Tic-Tac-Toe Game

This is a simple Tic-Tac-Toe game implemented in Java. It allows a human player to play against an AI opponent.

## Features

-   **Human vs. AI:** Play against a computer-controlled opponent.
-   **Board Display:** Clear and easy-to-understand display of the game board.
-   **Win Detection:** Automatically detects wins (rows, columns, diagonals).
-   **Draw Detection:** Detects when the game ends in a draw.
-   **Input Validation:** Validates player input to ensure it's within the board boundaries.
-   **Random AI Moves:** The AI makes random, but valid moves.

## How to Run

1.  **Prerequisites:**
    -      Java Development Kit (JDK) installed on your system.
2.  **Compilation:**
    -      Open a terminal or command prompt.
    -      Navigate to the directory containing the `Game.java`, `TicTacToe.java`, `Player.java`, `Humanplayer.java` and `AIplayer.java` files.
    -      Compile the Java files using the following command:
        ```bash
        javac Game.java
        ```
3.  **Execution:**
    -      Run the compiled `Game` class:
        ```bash
        java Game
        ```
4.  **Gameplay:**
    -      The game will start, and the board will be displayed.
    -      You will be prompted to enter the row and column (0-2) where you want to place your mark ('X').
    -      The AI ('O') will then make its move.
    -      The game continues until a player wins or the game ends in a draw.

## Code Structure

-   **`TicTacToe` class:**
    -      Represents the game board and its state.
    -      Handles board initialization, display, and mark placement.
    -      Provides methods to check for wins and draws.
-   **`Player` abstract class:**
    -      Defines the common properties and behavior of players (human and AI).
    -   Contains the isValidMove method.
    -   Contains the abstract method makeMove.
-   **`Humanplayer` class:**
    -      Extends the `Player` class.
    -      Handles human player input and mark placement.
-   **`AIplayer` class:**
    -      Extends the `Player` class.
    -      Generates random moves for the AI.
-   **`Game` class:**
    -      The main class that orchestrates the game.
    -      Creates instances of the `TicTacToe`, `Humanplayer`, and `AIplayer` classes.
    -      Manages the game loop and determines the winner.

## Example Gameplay

| _ | _ | _ |
| _ | _ | _ |
| _ | _ | _ |
Bob, enter the Row and Column: 0 0 TAI placed a mark at (1, 1)
| X | _ | _ |
| _ | O | _ |
| _ | _ | _ |
Bob, enter the Row and Column: 0 1 TAI placed a mark at (2, 0)
| X | X | _ |
| _ | O | _ |
| O | _ | _ |
Bob, enter the Row and Column: 0 2
| X | X | X |
| _ | O | _ |
| O | _ | _ |
Bob HAS WON.
