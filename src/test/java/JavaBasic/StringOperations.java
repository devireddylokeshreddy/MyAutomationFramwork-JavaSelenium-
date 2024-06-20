package JavaBasic;

import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringOperations {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String s = "alphabatically11854";
        s = s.replaceAll("[0-9]","");
        System.out.println(s);
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            int count = 0;
            for (int j = 0; j < s.length(); j++){
                if (c[i] == c[j]){
                    count++;
                }
            }
            System.out.println("The occurrences of '"+c[i]+"' is: "+count);
        }

        String str = "tomorrow";
//        str = str.replace("o","$");
//        System.out.println(str);
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            if(ch[i] == 'o'){
                ch[i] = '$';
            }
        }
        System.out.println(ch);

        int n = 100;
        int first = 0;
        int second = 1;
        int temp;
        System.out.print(first+", "+second);
        for (int i = 0; i < n; i++){
            temp = first + second;
            System.out.print(", "+temp);
            first = second;
            second = temp;
        }

        System.out.println();
        String str1 = "Nine";
        String rev = "";
        char[] cha = str1.toCharArray();
        for (int i = str1.length()-1; i >= 0; i--){
            rev += cha[i];
        }
        if (str1.equalsIgnoreCase(rev)){
            System.out.println("The given string is a Palindrome.");
        }
        System.out.println(rev);

        String str2 = "abcsddccd";
        char[] array = str2.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            int count = 1;
            for (int j = i+1; j < array.length; j++){
                if (array[i] == array[j]){
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            if (count > 1){
                result.append(str2.charAt(i));
                result.append(count);
            } else {
                result.append(array[i]);
            }
        }
        System.out.println(result);

        String str3 = "Akshay";
        char[] ch3 = str3.toCharArray();
        for (int i = str3.length()-1; i >= 0 ; i--) {
            System.out.print(ch3[i]);
        }
    }
}
