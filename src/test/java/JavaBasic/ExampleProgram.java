package JavaBasic;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleProgram {
    public static void main(String []args){
        int num = 10;
        int first = 0;
        int second = 1;
        System.out.print(first+", "+second);
        int temp;
        for (int i = 0; i < num; i++){
            temp = first + second;
            first = second;
            second = temp;
            System.out.print(", "+temp);
        }
    }
}
