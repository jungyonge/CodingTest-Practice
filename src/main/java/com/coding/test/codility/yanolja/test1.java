package com.coding.test.codility.yanolja;

import java.util.ArrayList;
import java.util.HashSet;

public class test1 {


    static boolean check(String s)
    {
        HashSet<Character> characterHashSet = new HashSet<>();

        for(int i = 0; i < s.length(); i++)
        {
            if (characterHashSet.contains(s.charAt(i)))
            {
                return false;
            }
            characterHashSet.add(s.charAt(i));
        }
        return true;
    }

    static ArrayList<String> dfs(String[] arr, int startAt) {
        ArrayList<String> checkList = new ArrayList<>();
        checkList.add("");

        if (startAt == arr.length )
            return checkList;

        ArrayList<String> tempList = dfs(arr, startAt + 1);

        ArrayList<String> findList = new ArrayList<>(tempList);

        for (String s : tempList) {
            String test = s + arr[startAt];

            if (check(test))
                findList.add(test);
        }
        return findList;
    }

    static int solutions(String[] A)
    {
        ArrayList<String> tmp = dfs(A, 0);

        int lenth = 0;

        for (String s : tmp) {
            lenth = Math.max(lenth, s.length());
        }

        return lenth;
    }

    // Driver code
    public static void main (String[] args)
    {
        ArrayList<String> s = new ArrayList<>();
        s.add("abcdefgh");

        System.out.println(solutions(new String[]{"potato","kayak","banana","racecar"}));
    }


}
