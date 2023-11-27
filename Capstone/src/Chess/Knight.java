package Chess;

public class Knight extends ChessPiece {
    public Knight(ChessBoard chessBoard, int positionX, int positionY, String color, String type, char uchar) {
        super(chessBoard, positionX, positionY, color, "Knight", uchar);
    }

    public boolean isMovementLegal(int newX, int newY){

        int dx = Math.abs(newX - this.getPositionX());
        int dy = Math.abs(newY - this.getPositionY());

        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            return true;
        }

        return false;
    };
}
