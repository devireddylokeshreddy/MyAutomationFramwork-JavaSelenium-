package JavaBasic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberProblems {
    @Test
    public void primeNumber(){
//        int num = 4;
        for (int i = 0; i < 10; i++){
            if (isPrime(i)){
                System.out.println(i+" is a Prime Number");
            } else {
                System.out.println(i+" is not a Prime Number");
            }
        }
    }

    public boolean isPrime(int num){
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= num/2; i++){
            if (num%i == 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void primeNumberList(){
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 11, 13, 17, 19, 20, 23, 29, 31, 35, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
//        numbers.stream().filter(n -> n<2).forEach(n -> System.out.println(n + " is not a prime number"));
        numbers.stream().filter(this::isPrime).forEach(n -> System.out.print(n+","));
        List<Integer> num = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println();
        System.out.println(num);
    }
    public boolean isPrime(Integer n){
        return n > 1 && IntStream.range(2, n).noneMatch(i -> n%i==0);
    }

    @Test
    public void verifyTheGivenNumberIsAPrimeNumberOrNot(){
        int n = 6;
        if (isPrime(n)) {
            System.out.println(n + " is a Prime Number");
        } else {
            System.out.println(n + " is not a Prime Number");
        }
    }

    @Test
    public void changeListOfWordsToUpperCase(){
        List<String> words = Arrays.asList("lokeh","ravi","yogi");
        List<String> upperCaseWords;
        upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseWords);
    }

    @Test
    public void numberPalindrome(){
        int num = 12345;
        int[] arr = {1,2,3};
        int g = arr.length+arr[1];
//        char[] ch = String.valueOf(num).toCharArray();
//        StringBuilder temp = new StringBuilder();
//        int revNum;
//        for (int i = String.valueOf(num).length()-1; i >= 0; i--){
//            temp.append(ch[i]);
//        }
//        revNum = Integer.parseInt(String.valueOf(temp));
//        System.out.println(revNum);
        int rev = 0;
        while (num!=0){
            int digit = num%10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        System.out.println(rev);
    }
    
}
