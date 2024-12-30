package org.InterviewProblems;

import java.util.Arrays;

public class ReorderNegativePositiveElementsInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 5, 4, 2, -5, -1, -1, -2, 1, -1};
        int negIndex = -1;
        int posCount = 0;
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (posCount != 0) {
                    int temp = arr[i];
                    int count = 0;
                    while (count < posCount) {
                        arr[i - count] = arr[negIndex + posCount - count];
                        count++;
                        steps++;
                    }
                    arr[negIndex + 1] = temp;
                }
                negIndex++;
            } else {
                posCount++;
            }
            steps++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(steps);
    }

}
