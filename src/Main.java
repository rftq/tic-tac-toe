import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int ROW_COUNT = 3;
    private static int COL_COUNT = 3;

    private static String CELL_STATE_EMPTY = " ";
    private static String CELL_STATE_X = "X";
    private static String CELL_STATE_O = "O";

    private static String GAME_STATE_X_WON = "X победили!";
    private static String GAME_STATE_O_WON = "O победили!";
    private static String GAME_STATE_DRAW = "Ничья";
    private static String GAME_STATE_NOT_FINISHED = "Игра не закончена";

    private static Scanner scanner = new Scanner(System.in);

    private static Random random = new Random();


    public static void main(String[] args) {
//        String[][] board = createBoard();
//        board[0][0] = CELL_STATE_X;
//        inputCellCoordinates(board);

        startGameRound();
        System.out.println("Hello world!");
    }

    public static void startGameRound() {
        String[][] board = createBoard();
        startGameLoop(board);
    }

    public static String[][] createBoard() {
        String[][] board = new String[ROW_COUNT][COL_COUNT];

        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                board[row][col]= CELL_STATE_EMPTY;
            }
        }
        return board;
    }

    public static void startGameLoop(String[][] board) {

        makePlayerTurn(board);
        printBoard(board);

        System.out.println();

        makeBotTurn(board);
        printBoard(board);

        boolean b = areAllCellsTaken(board);
        int a = 123;

//        while (gameNotOver)
//            playerTurn
//            botTurn
//        checkGameState (X_WON, O_WON, DRAW, GAME_NOT_OVER)
    }

    public static void makePlayerTurn(String[][] board) {
        //get input
        int[] coordinates = inputCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_X;
        //place X on board
    }

    public static int[] inputCellCoordinates(String[][] board) {
        System.out.println("Введите координаты через пробел (0-2):");

        do {
            //допущения - не проверяем на наличие пробела и корректность цифр
            String[] input = scanner.nextLine().split(" ");

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            if ((row < 0) || (row >= ROW_COUNT) || (col < 0) || (col >= COL_COUNT)) {
                System.out.println("Некорректное значение! Введите два числа (ряд и колонку) от 0 до 2 через пробел:");
            } else if (!Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                System.out.println("Данная ячейка уже занята");
            } else {
                return new int[]{row, col};
            }
        } while (true);
    }

    public static void makeBotTurn(String[][] board) {
        System.out.println("Ход бота");
        int[] coordinates = getRandomEmptyCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_O;
    }

    public static int[] getRandomEmptyCellCoordinates(String[][] board) {
        do {
            int row = random.nextInt(ROW_COUNT);
            int col = random.nextInt(COL_COUNT);

            if (Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                return new int[]{row, col};
            }
        } while (true);
        //get random empty cell
        //place O on board
    }

    public static String checkGameState() {
        // X = 1, O = -1, empty = 0
        //count sums for rows, columns, diagonals

//        if sum.contains(3) -> X won
//        if sum.contains(-3) -> O won
//        if allCellsTaken() -> draw
//        else -> game not over
        return "";
    }


    public static boolean areAllCellsTaken(String[][] board) {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                if (Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }



    public static void printBoard(String[][] board) {
        System.out.println("---------");
        for (int row = 0; row < ROW_COUNT; row++) {
            String line = "| ";
            for (int col = 0; col < COL_COUNT; col++) {
                line += board[row][col] + " ";
            }
            line += "|";

            System.out.println(line);
        }
        System.out.println("---------");
    }
}