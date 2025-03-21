import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	
	static char[][] board;

	public TicTacToe() {
		board = new char[3][3];
		initBoard();
	}

	void initBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	static void dispBoard() {
		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	static void placeMark(int row, int col, char mark) {
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			board[row][col] = mark;
		} else {
			System.out.println("Invalid position.");
		}
	}

	static boolean checkColWin() {
		for (int j = 0; j <= 2; j++) {
			if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
				return true;
			}
		}
		return false;
	}

	static boolean checkRowWin() {
		for (int i = 0; i <= 2; i++) {
			if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	static boolean checkDiagWin() {
		return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
				(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
	}

	static boolean checkDraw() {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}

//PLAYER CLASS
abstract class Player {
	String name;
	char mark;

	abstract void makeMove();

	boolean isValidMove(int row, int col) {
		return row >= 0 && row <= 2 && col >= 0 && col <= 2 && TicTacToe.board[row][col] == ' ';
	}
}

class Humanplayer extends Player {
	
	public Humanplayer(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	void makeMove() {
		Scanner scan = new Scanner(System.in);
		int row, col;

		TicTacToe.dispBoard();

		do {
			System.out.println(name + ", enter the Row and Column: ");
			row = scan.nextInt();
			col = scan.nextInt();
		} while (!isValidMove(row, col));

		TicTacToe.placeMark(row, col, mark);
	}
}

class AIplayer extends Player {
	public AIplayer(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	void makeMove() {
		int row, col;
		Random r = new Random();

		do {
			row = r.nextInt(3);
			col = r.nextInt(3);
		} while (!isValidMove(row, col));

		TicTacToe.placeMark(row, col, mark);
		System.out.println(name + " placed a mark at (" + row + ", " + col + ")");
	}
}

public class Game {
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		Humanplayer p1 = new Humanplayer("Bob", 'X');
		AIplayer p2 = new AIplayer("TAI", 'O');
		Player cp = p1;

		while (true) {
			System.out.println(cp.name + "'s TURN");
			cp.makeMove();

			if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
				TicTacToe.dispBoard(); // Display final board
				System.out.println(cp.name + " HAS WON.");
				break;
			} else if (TicTacToe.checkDraw()) {
				TicTacToe.dispBoard(); // Display final board
				System.out.println("GAME IS A DRAW");
				break;
			} else {
				cp = (cp == p1) ? p2 : p1;
			}
		}
	}
}