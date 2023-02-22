import java.util.Scanner;
public class App {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("______________Hello, World!______________");
        // Test-1: XO_Board class constructor
        XO_Board XO_Game1 = new XO_Board(3);
        System.out.println("\nTest-1 - XO_Board() | (Passed)");
        XO_Board XO_Game2 = new XO_Board(-9);
        System.out.println("\nTest-1 - g2(negative_value) | (Passed)");
        // Test-2: display_board method for XO_Board class
        XO_Game2.display_board();
        System.out.println("\nTest-2 - XO_Board::display_board() | (passed)");
        // Test-3: Full game
        while(XO_Game1.is_draw()){
            XO_Game1.display_board();
            int x, y;
            char s;
            do{
                System.out.println("Enter the the coordinates of the cell...");
                System.out.print("X: ");
                x = input.nextInt();
                System.out.print("Y: ");
                y = input.nextInt();
                System.out.print("Enter your symbol: ");
                s = input.next().charAt(0);
            }while(XO_Game1.update_board(x, y, s) == false);
            XO_Game1.update_board(x, y, s);
            if (XO_Game1.is_winner(s)){
                XO_Game1.display_board();
                System.out.println("Player " + s + " won!");
            }
        }
        System.out.println("Test-3 - XO_FULL_GAME  (Passed)");
    }
}
