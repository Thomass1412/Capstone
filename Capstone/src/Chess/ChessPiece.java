package Chess;
public abstract class ChessPiece {
    private int positionX, positionY;
    private String color;
    private String type;
    private char Uchar;
    ChessBoard chessBoard;


    public ChessPiece(ChessBoard chessBoard, int x, int y, String color, String type, char uchar) {
        this.positionX = x;
        this.positionY = y;
        this.chessBoard = chessBoard;
        this.color = color;
        this.type = type;
        this.Uchar = uchar;
    }

    public void setX(int x){
        this.positionX = x;
    }

    public void setY(int y){
        this.positionY = y;
    }
    String getColor(){
       return this.color;
    };

    public char getUnicodeCharacter(){
        return this.Uchar;
    }
    public int getPositionX(){
        return this.positionX;
    }
    public int getPositionY(){
        return this.positionY;
    }
    public String getType(){
        return this.type;
    }

    public abstract boolean isMovementLegal(int x, int y);

    void setColor(){

    }
}
