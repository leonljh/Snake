package snakegame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import snakegame.Direction;
import snakegame.domain.Apple;
import snakegame.domain.Snake;
import snakegame.gui.Updatable;

public class SnakeGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Snake snake;
    private Apple apple;

    public SnakeGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        snake = new Snake(width/2,height/2,Direction.DOWN);
        Random random = new Random();
        int randomX = random.nextInt(width);
        int randomY = random.nextInt(height);
        apple = new Apple(randomX,randomY);
        System.out.println("snake called");

        addActionListener(this);
        setInitialDelay(2000);


    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("action performed");
        if (!continues) {
            return;
        }

        snake.move();
        if(this.snake.runsInto(this.apple)){
            snake.grow();
            apple = null;
            Random random = new Random();
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            apple = new Apple(randomX,randomY);
        }
        if(snake.runsIntoItself()){
            continues = false;
        }
        updatable.update();
        setDelay(1000/snake.getLength());
    }

    public Snake getSnake(){
        return this.snake;
    }

    public void setSnake(Snake snake){
        this.snake = snake;
    }

    public Apple getApple(){
        return this.apple;
    }

    public void setApple(Apple apple){
        this.apple = apple;
    }
}
