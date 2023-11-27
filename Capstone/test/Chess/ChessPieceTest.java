package Chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessPieceTest {

    ChessPiece piece = null;

    @BeforeEach
    public void beforeEach(){
        ChessBoard chessBoard = new ChessBoard();
        piece = new ChessPiece(chessBoard, 0, 1, "White", "Knight", '\u265e') {
        @Override
        public boolean isMovementLegal(int x, int y) {
            return false;
        }
    };}

    @Test
    void testSetX() {
        piece.setX(10);
        assertEquals(10, piece.getPositionX());
    }
}