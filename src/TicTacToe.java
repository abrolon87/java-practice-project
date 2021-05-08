import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

  static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
  static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

  public static void main(String[] args) {
    char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
        { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
    printGameBoard(gameBoard);

    while (true) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Take your turn by choosing a number (1-9):");
      int playerPos = scan.nextInt();
      while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
        System.out.println("Position already taken!");
        playerPos = scan.nextInt();
      }
      move(gameBoard, playerPos, "player");

      String result = checkWinner();
      if (result.length() > 0) {
        System.out.println(result);
        break;
      }

      Random rand = new Random();
      int cpuPos = rand.nextInt(9) + 1;
      while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
        System.out.println("Position already taken!");
        playerPos = scan.nextInt();
      }
      move(gameBoard, cpuPos, "cpu");

      printGameBoard(gameBoard);

      result = checkWinner();
      if (result.length() > 0) {
        System.out.println(result);
        break;
      }

    }

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
      playerPositions.add(pos);
    } else if (user.equals("cpu")) {
      token = 'O';
      cpuPositions.add(pos);
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

  public static String checkWinner() {

    List<Arrays> topRow = Arrays.asList(1, 2, 3);
    List midRow = Arrays.asList(4, 5, 6);
    List bottomRow = Arrays.asList(7, 8, 9);
    List leftCol = Arrays.asList(1, 4, 7);
    List midCol = Arrays.asList(2, 5, 8);
    List rightCol = Arrays.asList(3, 6, 9);
    List leftDiag = Arrays.asList(1, 5, 9);
    List rightDiag = Arrays.asList(3, 5, 7);

    List<List> winCombos = new ArrayList<List>();
    winCombos.add(topRow);
    winCombos.add(midRow);
    winCombos.add(bottomRow);
    winCombos.add(leftCol);
    winCombos.add(midCol);
    winCombos.add(rightCol);
    winCombos.add(leftDiag);
    winCombos.add(rightDiag);

    for (List l : winCombos) {
      if (playerPositions.containsAll(l)) {
        return "Congratulations! Yuo won!";
      } else if (cpuPositions.containsAll(l)) {
        return "CPU wins, Sorry :(";
      } else if (playerPositions.size() + cpuPositions.size() == 9) {
        return "Board full. Game over!";
      }
    }

    return "";
  }

}