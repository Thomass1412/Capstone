package Chess;
import java.util.Scanner;

public class ChessDemo {
    public static void main(String[] args) {
        startGame();

    }
    static void startGame(){
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initializeGame(chessBoard);
        int turn = 0;

        System.out.println("Lets play a game of chess, white makes the first move. ");


        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Turn " + ++turn);
            CurrentPosition.printCurrentPosition(chessBoard);
            String input = scanner.nextLine();

            // Parse input
            String[] parts = input.split(" ");
            if (parts.length != 4) {
                System.out.println("Invalid input. Enter four coordinates.");
                turn -= 1;
                continue;
            }

            int fromX = Integer.parseInt(parts[0]);
            int fromY = Integer.parseInt(parts[1]);
            int toX = Integer.parseInt(parts[2]);
            int toY = Integer.parseInt(parts[3]);

            ChessPiece piece = chessBoard.getChessPiece(fromX, fromY);

            if(piece == null){
                System.out.println("Invalid move");
                turn -= 1;
                continue;
            }

            if(turn % 2 != 0 && piece.getColor() == "Black" || turn % 2 == 0 && piece.getColor() == "White" ){
                System.out.println("It is not your turn");
                turn -= 1;
                continue;
            } else if(chessBoard.movePiece(chessBoard, piece, fromX, fromY, toX, toY)){
                System.out.println("Move Succesfull");
            } else {
                System.out.println("Invalid move");
                turn -= 1;
                continue;
            };

        }while(gameOver());
    }

    static boolean gameOver(){
        return false;
    }
}
