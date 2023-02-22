import java.util.Scanner;
// _______Abstract_Board_Class_______
public abstract class Board {
    Scanner input = new Scanner(System.in);
    //_______Attributes_______
    protected int board_size;
    protected char[][] grid;

    //_______Methodes_______
    // Set n and book space for n x n grid
    Board(int sz) {
        this.set_size(sz);
        // initialize the board with dots
        grid = new char[board_size][board_size];
        for (int i = 0; i < board_size; ++i){
            for (int j = 0; j < board_size; ++j){
                grid[i][j] = ' ';
            }   
        }
    }

    // set the board size
    private void set_size(int sz){
        // check for non-negative size
        while(sz <= 0){
            System.out.println("Error, Invalid size :(");
            System.out.print("Enter a non-negative size: ");
            sz = input.nextInt();
        }
        this.board_size = sz;
    }
    // Return true  if move is valid and put it on board or return false
    public abstract boolean update_board(int x, int y, char symbol);

    // Returns true if symbol owner wins
    public abstract boolean is_winner(char symbol);

    // Return true if board status indicates a draw
    public abstract boolean is_draw();

    // check if the move is valid
    public final boolean is_valid_move(int x, int y){
        if (x >= 0 && y >= 0 && x < board_size && y < board_size && grid[x][y] == ' ') return true;
        else return false;
    }

    // Display the board and the pieces on it
    public final void display_board() {
        // Store board shape to display
        String coordinates[][] = new String[board_size][board_size];
        String symbols[][] = new String[board_size][board_size];
        for (int i = 0; i < board_size; ++i){
            for (int j = 0; j < board_size; ++j){
                // fill coordinates array
                coordinates[i][j] = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                // fill symbols array
                symbols[i][j] = "  " + grid[i][j] + "  ";
            }
        }
        // get the lenth of the board line
        int line_size = coordinates.length * 5;
        // dispalay the shape of the board
        for (int i = 0; i < board_size; ++i){
            // display the current symbol
            for (int j = 0; j < board_size; ++j){
                System.out.print(symbols[i][j]);
                if (j != board_size - 1) System.out.print("|");
            }
            System.out.println();
            // display the current coordinates
            for (int j = 0; j < board_size; ++j){
                System.out.print(coordinates[i][j]);
                if (j != board_size - 1) System.out.print("|");
            }
            // print a border and new line
            System.out.println();
            // ignore the last border
            if (i == board_size - 1) {
                System.out.println();
                continue;
            }
            for (int k = 0; k < line_size; ++k){
                if (k != 0 && (k % 5) == 0){
                    // vertical edges
                    System.out.print("|");
                }
                // horizontal edges
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
