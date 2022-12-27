package org.LeetcodeProblems.Easy;

import java.util.HashMap;
import java.util.HashSet;

public class RingsAndRods {
    /*
    There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings that are placed onto the rods. Every two characters in rings forms a color-position pair that is used to describe each ring where:

The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.

Return the number of rods that have all three colors of rings on them.

Constraints:

rings.length == 2 * n
1 <= n <= 100
rings[i] where i is even is either 'R', 'G', or 'B' (0-indexed).
rings[i] where i is odd is a digit from '0' to '9' (0-indexed).
     */

    public static void main(String[] args) {
        System.out.println(countPoints("B0R0G0R9R0B0G0"));
    }

    public static int countPoints(String rings) {
        HashMap<Character,HashSet<Character>> rodMap = new HashMap<>();
        int count = 0;
        for(int i = 0; i < rings.length();i+=2){
            HashSet<Character> colors = new HashSet<>();
            char rod = rings.charAt(i+1);
            char color = rings.charAt(i);
            if(rodMap.containsKey(rod))
                colors = rodMap.get(rod);
            colors.add(color);
            rodMap.put(rod,colors);
        }
        for (HashSet<Character> set : rodMap.values()){
            if (set.size() == 3)
                count++;
        }
        return count;
    }
}
