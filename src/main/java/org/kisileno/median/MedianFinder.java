package org.kisileno.median;

import java.util.Arrays;
import java.util.Random;

public interface MedianFinder {

    double findMedianSortedArrays(int[] arr1, int[] arr2);



    static int [] generateSortedArray(int length) {
        Random random = new Random();
        int [] result = new int[length];
        for (int i = 0 ; i< length; i++) {
            result[i] = random.nextInt();
        }
        Arrays.sort(result);
        return result;
    }
}
