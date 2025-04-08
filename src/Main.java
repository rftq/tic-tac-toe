public class Main {
    private static int ROW_COUNT = 3;
    private static int COL_COUNT = 3;

    private static String CELL_STATE_EMPTY = " ";
    private static String CELL_STATE_X = "X";
    private static String CELL_STATE_O = "O";


    public static void main(String[] args) {
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
//        while (gameNotOver)
//            playerTurn
//            botTurn
//        checkGameState (X_WON, O_WON, DRAW, GAME_NOT_OVER)
    }

    public static void makePlayerTurn() {
        //get input
        //validate input
        //place X on board
    }

    public static void makeBotTurn() {
        //get random empty cell
        //place O on board
    }

    public static void checkGameState() {
        // X = 1, O = -1, empty = 0
        //count sums for rows, columns, diagonals

//        if sum.contains(3) -> X won
//        if sum.contains(-3) -> O won
//        if allCellsTaken() -> draw
//        else -> game not over
    }
}