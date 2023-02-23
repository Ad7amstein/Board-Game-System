// XO game board : test the abstract board class
public class XO_Board extends Board{
    XO_Board(int sz){
        super(sz);
    }
    @Override
    // Return true  if move is valid and put it on board or return false
    public boolean update_board(int x, int y, char symbol){
        if (!super.is_valid_move(x, y)) return false;
        super.grid[x][y] = symbol;
        return true;
    }
    @Override
    // Returns true if symbol owner wins
    public boolean is_winner(char symbol){
        boolean row = true, col = true, rdiag = true, ldiag = true;
        for (int i = 0; i < board_size; ++i){
            row = true; col = true;
            for (int j = 0; j < board_size; ++j){
                // check for the rows
                if (grid[i][j] != symbol) {
                    row = false;
                }
                // check for the coloumns
                if (grid[j][i] != symbol) {
                    col = false;
                }
            }
            if (row || col) return true;
        }
        // check for the diagonals
        for (int i = 0; i < board_size; ++i){
            if (grid[i][i] != symbol) rdiag = false;
        }
        if (grid[0][2] != symbol || grid[1][1] != symbol || grid[2][0] != symbol){
            ldiag = false;
        }
        if (rdiag || ldiag) return true;
        return false;
    }
    @Override
    // Return true if board status indicates a draw
    public boolean is_draw(){
        boolean is_space = false;
        for (int i = 0; i < board_size; ++i){
            for (int j = 0; j < board_size; ++j){
                if (grid[i][j] == ' ') return false;
            }
        }
    }
}
