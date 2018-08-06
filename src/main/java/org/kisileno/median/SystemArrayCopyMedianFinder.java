package org.kisileno.median;

import java.util.Arrays;

public class SystemArrayCopyMedianFinder implements MedianFinder {

    @Override
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        Arrays.sort(merged);
        if (merged.length % 2 == 0) {
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2 ] ) / 2.0;
        } else {
            return (merged[merged.length / 2]);
        }
    }
}
