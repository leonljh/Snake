package snakegame.domain;
import snakegame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private int x;
    private int y;
    private Direction dir;
    private List<Piece> length;


    public Snake(int originalX, int originalY, Direction originalDirection){
        this.x = originalX;
        this.y = originalY;
        this.dir = originalDirection;
        Piece piece = new Piece(this.x,this.y);
        length = new ArrayList<Piece>();
        length.add(piece);
    }

    public Direction getDirection(){
        return this.dir;
    }

    public void setDirection(Direction dir){
        this.dir = dir;
    }

    public int getLength(){
        return length.size();
    }

    public List<Piece> getPieces(){
        return this.length;
    }

    public void move(){

    }

    public void grow(){

    }

    public boolean runsInto(Piece piece){

    }

    public boolean runsIntoItself(){

    }
}
