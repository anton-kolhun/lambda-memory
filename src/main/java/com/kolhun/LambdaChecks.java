package com.kolhun;


import java.util.function.Consumer;

public class LambdaChecks {

    public static void main(String[] args) {

        /*List<String> strs = Arrays.asList("1", "2", "3", "4");
        strs.forEach(
                val -> System.out.println(val)
        );*/
        //new lambda instance gets created each time

        Consumer<String> capturingLambda = createCapturingLambda();
        Consumer<String> capturingLambda2 = createCapturingLambda();
        System.out.println(capturingLambda == capturingLambda2);

        Consumer<String> notCapturingLambda = createNotCapturingLambda();
        Consumer<String> notCapturingLambda2 = createNotCapturingLambda();
        System.out.println("equal references:  " + (notCapturingLambda == notCapturingLambda2));

        Consumer<String> anonymousClass = createAnonymousClass();
        Consumer<Integer> anonymousClass2 = createAnonymousClass2();
        System.out.println(anonymousClass);

        Consumer<String> throwingException = x -> {
            throw new RuntimeException("fs");
        };

        throwingException.accept("xz");


    }


    public static Consumer<String> createCapturingLambda() {
        return System.out::println; // put breakpoint in LambdaMetaFactory and check
    }

    public static Consumer<String> createNotCapturingLambda() {
        return x -> System.out.println(x);
    }

    public static Consumer<String> createAnonymousClass() {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
    }

    public static Consumer<Integer> createAnonymousClass2() {
        return new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.println(s);
            }
        };
    }


}
