package Chess;

public class Movement {
    public static boolean isLegalHorizontalMovement(ChessBoard board, int x1, int y1, int x2, int y2, int maxDistance)
    {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        // If moving horizontally and not further than allowed
        if (dy == 0 && dx <= maxDistance)
        {
            // Check if the piece passed any other piece in order to make this move
            int lower = Math.min(x1, x2) + 1;
            int higher = Math.max(x1, x2);

            for (; lower < higher; lower++)
                if (board.getChessPiece(lower, y1) != null)
                    return false; // False if trying to pass over another piece

            return true; // All according to the rules
        }

        return false; // Invalid horizontal movement
    }

    public static boolean isLegalVerticalMovement(ChessBoard board, int x1, int y1, int x2, int y2, int maxDistance)
    {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        maxDistance = Math.abs(maxDistance);

        // If not moving, moving vertically or further than allowed
        if (dx == 0 || dy != 0 || dx > maxDistance)
            return false;

        // Check if piece passed any other piece in order to make this move
        int lower = Math.min(x1, x2) + 1;
        int higher = Math.max(x1, x2);

        for (; lower < higher; lower++)
            if (board.getChessPiece(lower,y1) != null)
                return false; // False if trying to pass over another piece

        return true; // All according to the rules
    }

    public static boolean isLegalDiagonalMovement(ChessBoard board, int x1, int y1, int x2, int y2, int maxDistance)
    {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        maxDistance = Math.abs(maxDistance);

        // If not purely diagonal or further movement than allowed
        if (dx != dy || dx > maxDistance)
            return false;

        // Check if piece passed any other piece in order to make this move
        int currX = x1 + (x2 < x1 ? -1 : 1);
        int currY = y1 + (y2 < y1 ? -1 : 1);
        while (currX != x2 && currY != y2)
        {
            if (board.getChessPiece(currX,currY) != null)
                return false;

            currX += (x2 < x1 ? -1 : 1);
            currY += (y2 < y1 ? -1 : 1);
        }

        return true;
    }

    public static boolean isSquareAvailable(ChessBoard chessBoard, ChessPiece piece, int x, int y){

        ChessPiece targetPiece = chessBoard.getChessPiece(x, y);

        if (targetPiece != null && targetPiece.getColor() == piece.getColor()){
            return false;
        }
        return true;
    }

    public static boolean isKingChecked(ChessBoard chessBoard, String color){

        int kingX = - 1;
        int kingY = -1;

        // find king
        for(int col = 0 ; col < 8; col++){
            for(int row = 0; row < 8; row++) {
                ChessPiece potentialKing = chessBoard.getChessPiece(col, row);

                if (potentialKing != null && potentialKing.getType() == "King" && potentialKing.getColor() == color) {
                    kingX = potentialKing.getPositionX();
                    kingY = potentialKing.getPositionY();
                } else {
                    continue;
                }
            }
        }

        // ireterate on opponents pieces to if any can capture the king
        for(int col = 0 ; col < 8; col++){
            for(int row = 0; row < 8; row++) {
                ChessPiece opp = chessBoard.getChessPiece(col, row);

                if(opp == null)
                    continue;

                if(opp.getColor() == color){
                    continue;
                } else if (opp.isMovementLegal(kingX, kingY)) {
                    return true;
                }
            }
        }
        return false;
    };

    public static boolean isKingCheckMated(){
        return false;
    }
}