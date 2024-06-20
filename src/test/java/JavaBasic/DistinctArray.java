package JavaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DistinctArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 8, 6, 4, 5, 8, 8};
        int[] numbs = Arrays.stream(arr).distinct().toArray();
        int[] sortedArray = Arrays.stream(numbs).sorted().toArray();
        System.out.println(sortedArray[sortedArray.length-4]);
//        int firstMax = 0;
//        int secondMax = 0;
//        int thirdMax = 0;
//        for (int num : numbs) {
//            if (num > firstMax) {
//                thirdMax = secondMax;
//                secondMax = firstMax;
//                firstMax = num;
//            } else if (num > secondMax){
//                thirdMax = secondMax;
//                secondMax = num;
//            } else if (num > thirdMax) {
//                thirdMax = num;
//            }
//        }
//        System.out.println(thirdMax);
    }

}