package org.LeetcodeProblems;

import java.util.HashMap;

public class FindMinimumRounds {

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,2,3,3,3,3}));
    }

    public static int minimumRounds(int[] tasks) {

        HashMap<Integer, Integer> taskDiff = new HashMap<>();

        if (tasks.length < 2)
            return -1;

        for (int i : tasks) {
            if (taskDiff.containsKey(i))
                taskDiff.put(i, taskDiff.get(i) + 1);
            else {
                taskDiff.put(i, 1);
            }
        }

        if (taskDiff.containsValue(1))
            return -1;

        int rounds = 0;
        for (int i : taskDiff.keySet()) {
            int value = taskDiff.get(i);
            switch (value % 3) {
                case 0:
                    rounds += value / 3;
                    break;
                case 1:
                    while (value - 3 >= 2) {
                        value -= 3;
                        rounds++;
                    }
                    rounds += value / 2;
                    break;
                case 2:
                    rounds += value / 3;
                    value %= 3;
                    rounds += value / 2;
                    break;
            }
        }

        return rounds;

    }
}
