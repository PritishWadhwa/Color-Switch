package sample;

import java.util.Random;

public enum COLOR {
    PURPLE,
    PINK,
    YELLOW,
    AQUA;
    private static final COLOR[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static COLOR getRandomColor() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}