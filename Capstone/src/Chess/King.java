package Chess;

public class King extends ChessPiece {
    public King(ChessBoard chessBoard, int positionX, int positionY, String color, String type, char uchar) {
        super(chessBoard, positionX, positionY, color, "King", uchar);
    }
    public boolean isMovementLegal(int newX, int newY){
        boolean success = (Movement.isLegalHorizontalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 1) ||
                Movement.isLegalVerticalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 1) ||
                Movement.isLegalDiagonalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 1));

        return  success;
    };
}

