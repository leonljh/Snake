package snakegame.gui;
import snakegame.game.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable{

    private SnakeGame snakeGame;
    private int pieceLength;

    public DrawingBoard(SnakeGame snakeGame, int pieceLength){
        this.snakeGame = snakeGame;
        this.pieceLength = pieceLength;
        this.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);

        for(int i = 0; i < snakeGame.getSnake().getLength(); i++) {

            int x = snakeGame.getSnake().getPieces().get(i).getX()*pieceLength;
            int y = snakeGame.getSnake().getPieces().get(i).getY()*pieceLength;

            g.fill3DRect(x,y,pieceLength,pieceLength,true);
        }

        g.setColor(Color.RED);
        g.fillOval(snakeGame.getApple().getX()*pieceLength,snakeGame.getApple().getY()*pieceLength,pieceLength,pieceLength);
    }

    @Override
    public void update() {
        repaint();
    }
}
