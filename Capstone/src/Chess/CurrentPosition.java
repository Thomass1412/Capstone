package Chess;

public class CurrentPosition {

    public static void printCurrentPosition(ChessBoard chessBoard){
        for (int file = 7; file >= 0; file--) {
            for (int rank = 0; rank < 8; rank++) {
                ChessPiece piece = chessBoard.getChessPiece(file, rank);
                if (piece == null && rank % 2 == 0 && file % 2 == 0 || piece == null && rank % 2 != 0 && file % 2 != 0 ) {
                    System.out.print('\u2b1b'); // Empty white square
                    System.out.print('\u2006');
                } else if (piece == null) {
                    System.out.print('\u2b1c'); // Empty black square
                    System.out.print('\u2006');
                } else {
                    System.out.print(piece.getUnicodeCharacter() + " ");
                }
            }
            System.out.println(); // Move to the next rank
        }
    }
}
