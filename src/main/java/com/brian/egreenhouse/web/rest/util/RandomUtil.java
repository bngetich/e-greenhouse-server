package com.brian.egreenhouse.web.rest.util;

import java.util.Random;

public class RandomUtil {

    public static int getRandomInteger(int min, int max){
        Random r = new Random();

        return r.ints(min, max + 1).findFirst().getAsInt();
    }
}
