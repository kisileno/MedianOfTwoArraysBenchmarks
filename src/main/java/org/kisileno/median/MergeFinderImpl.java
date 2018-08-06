package org.kisileno.median;

public class MergeFinderImpl implements MedianFinder {
    @Override
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int i = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        int resultSize = arr1.length + arr2.length;
        int endAt = resultSize / 2;
        int prev = 0;
        int current = 0;

        while (i++ <= endAt) {

            if (leftIndex >= arr1.length) {
                prev = current;
                current = arr2[rightIndex++];
            } else if (rightIndex >= arr2.length) {
                prev = current;
                current = arr1[leftIndex++];
            } else {


                int fromLeft = arr1[leftIndex];
                int fromRight = arr2[rightIndex];

                if (fromLeft < fromRight) {
                    leftIndex++;
                    prev = current;
                    current = fromLeft;
                } else {
                    rightIndex++;
                    prev = current;
                    current = fromRight;
                }
            }
        }
        if (resultSize % 2 == 0) {
            return (prev + current) / 2.0;
        } else {
            return current;
        }

    }

    public static void main(String[] args) {
        MergeFinderImpl finder = new MergeFinderImpl();
        int[] a1 = new int[]{1,3};
        int[] a2 = new int[]{2};
        System.out.println(finder.findMedianSortedArrays(a1, a2));
    }
}
