//Problem 1: Given the following collection
//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,14,15);
//Using Java functional style (Java streams), please write a program that is doing the following operations in the following order:
//a)keep only the numbers which are multiple of 3 or multiple of 2;
//b)transform each remaining number into a string, that consists of a prefix "A", the successor of the number and the suffix "B"
//(eg. 6 is transformed into "A7B")
//c)concatenate all the strings

/*
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15);

        String result = numbers.stream()
                .filter(n -> n % 2 == 0 || n % 3 == 0)  // Keep only numbers which are multiple of 2 or 3
                .map(n -> "A" + (n + 1) + "B")         // Transform each number into the specified string format
                .reduce("", (a,b)->(a+b));// Collect the results into a string, using ";" as delimiter

        // Print the result
        System.out.println(result);
    }
}

*/
//Problem 2: Given the following collection
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,14,15,16);
//        Using Java functional style (Java streams), please write a program that is doing the following operations in the following order:
//        a)eliminates all the numbers which are not multiple of 4;
//        b)transform each remaining number into its succesor (eg. 4 is transformed into 5);
//       c)compute the sum modulo 2 of the remaining numbers (eg. (9 +5) mod 2=0)

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String [] args)
    {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,14,15,16);
        Integer result = numbers.stream()
                .filter(n-> n%4 !=0)
                .map(n-> n+1)
                .reduce(0, (a,b)->(a+b)%2);

                //.collect(Collectors.toList());

        System.out.println(result);
        /*
        int initialValue=15;
        int sum = numbers.stream()
                .filter(n-> n%4 !=0)
                .map(n-> n+1)
                .reduce(initialValue,Integer::sum);
        System.out.println("Sum is: ");
        System.out.println(sum %2);

         */

    }
}

