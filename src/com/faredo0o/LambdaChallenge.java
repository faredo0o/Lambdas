package com.faredo0o;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaChallenge {
    public static void main(String[] args) {


        Runnable runnable=()->{
            String[] words="Let's split this up to an array".split(" ");
            Arrays.stream(words)
                    .map(String::toUpperCase)
                    .sorted()
                    .filter(s->s.startsWith("A"))
                    .forEach(System.out::println);
        };
        new Thread(runnable).start();
        Function<String,String> lambdaFunction=s->{
            StringBuilder result=new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i%2==1){
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        };
        System.out.println(executeFunction(lambdaFunction,"1234567890"));
        System.out.println("==================");
        System.out.println( lambdaFunction.apply("1234567890"));
        //Supplier<String> iloveJava=()->"I Love Java";
        Supplier<String> iloveJava=()->{
            return "I Love Java";
        };
        System.out.println(iloveJava.get());

        List<String> topNames=Arrays.asList(
                "essam",
                "omar",
                "ali",
                "malek");
        topNames.stream()
                .map(s->s.substring(0,1).toUpperCase().concat(s.substring(1)))
                .peek(System.out::println)
                .sorted() // .sorted(String::compareTo)
                .forEach(System.out::println);
    }


    public static String executeFunction(Function<String,String> lambdaFunction,String source){
        return lambdaFunction.apply(source);
    }

}
