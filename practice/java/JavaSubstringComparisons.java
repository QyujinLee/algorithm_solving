// original link
// https://www.hackerrank.com/challenges/java-string-compare/problem

import java.util.Scanner;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        if(s.length() < 1 || s.length() > 1000) {
            return "length of 's' must be more than 0 and less then 1001";
        }
        if(s.length() < k) {
            return "k can't be greater than length of 's'";
        }

        int lastIdx = k;
        // int arrLen = s.length - k + 1;
        // String[] subStringArr = new String[arrLen];

        for(int firstIdx = 0; lastIdx < s.length(); firstIdx++) {
            String target = s.substring(firstIdx, lastIdx);

            if(firstIdx == 0) {

                smallest = target;
                largest = target;

            } else {

                for(int i = 0; i < k; i++) {
                    
                    int targetChar = target.charAt(i);
                    int smalllestChar = smallest.charAt(i);
                    int largestChar = largest.charAt(i);

                    if(targetChar > largestChar) {
                        largest = target;
                        break;
                    } else if(targetChar < smalllestChar) {
                        smallest = target;
                        break;
                    }
                }
            }

            lastIdx++;
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}