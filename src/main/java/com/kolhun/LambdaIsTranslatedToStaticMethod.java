package com.kolhun;


import java.util.Arrays;

public class LambdaIsTranslatedToStaticMethod {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(LambdaIsTranslatedToStaticMethod.class.getDeclaredMethods()));
        // the generated static methods are :
        // private static void com.kolhun.LambdaIsTranslatedToStaticMethod.lambda$extracted1$1(),
        // private static void com.kolhun.LambdaIsTranslatedToStaticMethod.lambda$extracted0$0()
        Runnable r = extracted0();
        r.run();
    }

    public static Runnable extracted0() {
        Runnable r = () -> System.out.println("Hello");
        return r;
    }

    public static Runnable extracted1() {
        Runnable r = () -> System.out.println("Hello");
        return r;
    }
}
