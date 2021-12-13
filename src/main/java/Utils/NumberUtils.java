package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class NumberUtils {

    public static int getRandomInteger(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
