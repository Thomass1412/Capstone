package Chess;

public class ChessBoard {

    private ChessPiece[][] pieces;

    public ChessBoard() {
        pieces = new ChessPiece[8][8];
    }

    public ChessPiece getChessPiece(int x, int y){
        return pieces[x][y];
    }
    public boolean movePiece(ChessBoard chessBoard, ChessPiece piece, int x, int y, int x2, int y2) {

        if (!piece.isMovementLegal(x2, y2) || !Movement.isSquareAvailable(chessBoard, piece, x2, y2))
            return false;
        if(Movement.isKingChecked(chessBoard, piece.getColor())){
            return false;
        }

        int fromX = piece.getPositionX();
        int fromY = piece.getPositionY();

        pieces[x][y] = null; // Clear the old position
        pieces[x2][y2] = piece; // Set the new position

        piece.setX(x2);
        piece.setY(y2);
        return true;
    }

    public void initializeGame(ChessBoard chessBoard){

        pieces[0][0] = new Rook(chessBoard, 0, 0, "White", "Rook", '\u265c');
        pieces[0][7] = new Rook(chessBoard, 0, 7, "White", "Rook", '\u265c');
        pieces[7][0] = new Rook(chessBoard, 7, 0, "Black", "Rook", '\u2656');
        pieces[7][7] = new Rook(chessBoard, 7, 7, "Black", "Rook", '\u2656');

        pieces[0][1] = new Knight(chessBoard, 0, 1, "White", "Knight", '\u265e');
        pieces[0][6] = new Knight(chessBoard, 0, 6, "White", "Knight", '\u265e');
        pieces[7][1] = new Knight(chessBoard, 7, 1, "Black", "Knight", '\u2658');
        pieces[7][6] = new Knight(chessBoard, 7, 6, "Black", "Knight", '\u2658');

        pieces[0][2] = new Bishop(chessBoard, 0, 2, "White", "Bishop", '\u265d');
        pieces[0][5] = new Bishop(chessBoard, 0, 5, "White", "Bishop", '\u265d');
        pieces[7][2] = new Bishop(chessBoard, 7, 2, "Black", "Bishop", '\u2657');
        pieces[7][5] = new Bishop(chessBoard, 7, 5, "Black", "Bishop", '\u2657');

        pieces[0][3] = new Queen(chessBoard, 0, 3, "White", "Queen", '\u265b');
        pieces[7][3] = new Queen(chessBoard, 7, 3, "Black", "Queen", '\u2655');

        pieces[0][4] = new King(chessBoard, 0, 4, "White", "King", '\u265a');
        pieces[7][4] = new King(chessBoard, 7, 4, "Black", "King", '\u2654');

        for (int col = 0; col < 8; col++) {
            pieces[1][col] = new Pawn(chessBoard, 1, col, "White", "Pawn", '\u265f');
            pieces[6][col] = new Pawn(chessBoard, 6, col, "Black", "Pawn", '\u2659');
        }
    }
}
