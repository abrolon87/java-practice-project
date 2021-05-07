import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
        { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
    printGameBoard(gameBoard);

    Scanner scan = new Scanner(System.in);
    System.out.println("Take your turn by choosing a number 1-9:");
    int pos = scan.nextInt();

    System.out.println(pos);

    move(gameBoard, pos, "player");

    printGameBoard(gameBoard);
  }

  public static void printGameBoard(char[][] gameBoard) {
    for (char[] row : gameBoard) {
      for (char c : row) {
        System.out.print(c);
      }
      System.out.println();
    }
  }

  public static void move(char[][] gameBoard, int pos, String user) {
    char token = ' ';
    if (user.equals("player")) {
      token = 'X';
    } else if (user.equals("cpu")) {
      token = 'O';
    }

    switch (pos) {
      case 1:
        gameBoard[0][0] = token;
        break;
      case 2:
        gameBoard[0][2] = token;
        break;
      case 3:
        gameBoard[0][4] = token;
        break;
      case 4:
        gameBoard[2][0] = token;
        break;
      case 5:
        gameBoard[2][2] = token;
        break;
      case 6:
        gameBoard[2][4] = token;
        break;
      case 7:
        gameBoard[4][0] = token;
        break;
      case 8:
        gameBoard[4][2] = token;
        break;
      case 9:
        gameBoard[4][4] = token;
        break;
      default:
        break;
    }
  }

}