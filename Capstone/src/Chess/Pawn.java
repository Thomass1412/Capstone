package Chess;

public class Pawn extends ChessPiece {
    public Pawn(ChessBoard chessBoard, int positionX, int positionY, String color, String type, char uchar) {
            super(chessBoard, positionX, positionY, color, "Pawn", uchar);
    }

    // get the color, make sure the x position is not lower/higher than the newX
    @Override
    public boolean isMovementLegal(int newX, int newY) {

        if(this.getColor() == "Black" && newX >= this.getPositionX() ||this.getColor() == "White" && newX <= this.getPositionX())
            return false;

        int diagonalMovement;
        ChessPiece targetSquare = chessBoard.getChessPiece(newX, newY);
        if(targetSquare != null && targetSquare.getColor() != this.getColor()){
            diagonalMovement = 1;
        } else {
            diagonalMovement = 0;
        }

        if(this.getPositionX() == 1 && this.getColor() == "White" || this.getPositionX() == 6 && this.getColor() == "Black" ) {
            boolean success = (Movement.isLegalHorizontalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 0) ||
                    Movement.isLegalVerticalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 2) ||
                    Movement.isLegalDiagonalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, diagonalMovement));
            return success;
        } else {
            boolean success = (Movement.isLegalHorizontalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 0) ||
                    Movement.isLegalVerticalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, 1) ||
                    Movement.isLegalDiagonalMovement(this.chessBoard, this.getPositionX(), this.getPositionY(), newX, newY, diagonalMovement));
            return success;
        }
    };
}
