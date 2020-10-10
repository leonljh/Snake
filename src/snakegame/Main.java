package snakegame;

import snakegame.domain.Snake;

public class Main {
    public static void main(String[] args) {
        Snake worm = new Snake(5, 5, Direction.RIGHT);
        System.out.println(worm.getPieces()); // 5,5
        worm.move();
        System.out.println(worm.getPieces()); //5,5 6,5
        worm.move();
        System.out.println(worm.getPieces()); // [(5,5), (6,5), (7,5)]
        worm.move();
        System.out.println(worm.getPieces()); //[(6,5), (7,5), (8,5)]
        worm.grow();
        System.out.println(worm.getPieces()); //[(6,5), (7,5), (8,5)]
        worm.move();
        System.out.println(worm.getPieces());  //[(6,5), (7,5), (8,5), (9,5)]

        worm.setDirection(Direction.LEFT);
        System.out.println(worm.runsIntoItself());
        worm.move();
        System.out.println(worm.runsIntoItself());
    }
}
