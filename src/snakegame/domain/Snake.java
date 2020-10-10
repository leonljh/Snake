package snakegame.domain;
import snakegame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private int x;
    private int y;
    private Direction dir;
    private List<Piece> snake;
    private boolean growin;



    public Snake(int originalX, int originalY, Direction originalDirection){
        this.x = originalX;
        this.y = originalY;
        this.dir = originalDirection;
        Piece piece = new Piece(this.x,this.y);
        snake = new ArrayList<Piece>();
        snake.add(piece);
        growin = false;
    }

    public Direction getDirection(){
        return this.dir;
    }

    public void setDirection(Direction dir){
        this.dir = dir;
    }

    public int getLength(){
        return snake.size();
    }

    public List<Piece> getPieces(){
        return this.snake;
    }

    public void move(){
        //first 3 moves will implement grow
        //after that it just moves

        if(getLength() < 3){
            growin = true;
        }

        Piece p = null;

        if(getDirection() == Direction.LEFT){
            p = new Piece(x-1,y);
            x -= 1;
        }
        if(getDirection() == Direction.RIGHT) {
            p = new Piece(x+1,y);
            x += 1;
        }
        if(getDirection() == Direction.UP) {
            p = new Piece(x,y+1);
            y += 1;
        }
        if(getDirection() == Direction.DOWN){
            p = new Piece(x,y-1);
            y -= 1;
        }

        snake.add(p);

        if(!growin){
            snake.remove(0);
        }
        else{
           growin = false;
        }
    }

    public void grow(){
        growin = true;
    }

    public boolean runsInto(Piece piece){
        if(piece.getX() == this.x && piece.getY() == this.y){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean runsIntoItself() {
        //first find location of head.
        //if head location and set direction leads to a clash, run true;
        //else run false

        for (int i = 0; i < snake.size()-1; i++) {
            if (this.x == snake.get(i).getX() && this.y == snake.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
}
