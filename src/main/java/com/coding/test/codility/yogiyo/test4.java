package com.coding.test.codility.yogiyo;

public class test4 {

    static int min = Integer.MAX_VALUE;
    static int[] box_array = new int[]{5,3};
    public static int solution(int n) {
        if (n == 4 || n == 7) {
            return -1;
        } else if (n % 5 == 0) {
            return (n / 5);
        } else if (n % 5 == 1 || n % 5 == 3) {
            return (n / 5) + 1;
        } else if (n % 5 == 2 || n % 5 == 4) {
            return (n / 5) + 2;
        }
        return  -1;
    }

    public static void dfs(int now_weight, int box_count){
        if(now_weight == 0){
            min = Math.min(min, box_count);
            return;
        }else if(now_weight < 0){
            return;
        }
        for(int i = 0 ; i < 2; i ++){
            now_weight = now_weight - box_array[i];
            dfs(now_weight, box_count + 1);
            now_weight = now_weight + box_array[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
        System.out.println(solution(7));
        System.out.println(solution(11));

    }
}
