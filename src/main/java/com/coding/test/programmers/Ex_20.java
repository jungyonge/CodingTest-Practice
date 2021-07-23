package com.coding.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex_20 {
    boolean[] visited ;				// 방문여부 체크
    List<String> list = new ArrayList<String>();	// 경로들을 담을 리스트
    String routes = "";				// 경로를 표시할 전역변수

    public String[] solution(String[][] tickets) {
        String[] answers = new String[tickets.length+1];
        visited = new boolean[tickets.length];
        answers = new String[tickets.length+1];

        for(int i=0;i<tickets.length;i++) {
            if(tickets[i][0].equals("ICN")) {
                // 방문여부를 체크해주고,
                visited[i]=true;
                routes ="ICN";
                dfs(tickets, tickets[i][1],1);
                // false로 체크하는 이유는 ,
                // ICN으로 시작하는 다른 정점을 후에 방문하기 위함이다.
                visited[i]=false;
            }
        }
        // 알파벳 순서대로 정렬
        Collections.sort(list);
        answers = list.get(0).split(",");
        System.out.println(Arrays.toString(answers));
        return answers;
    }


    public void dfs(String[][] tickets, String departure, int count) {
        // 출발지를 경로에 추가
        routes +=","+departure;
        if(count == tickets.length) {
            list.add(routes);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(departure)  && !visited[i]) {
                visited[i]=true;
                dfs(tickets, tickets[i][1], count+1 );

                // 같은 방문지가 있는 경우, 다른 방문지를 돌기위해 false로 설정
                // 그리고 routes에서도 지워주기 위해 subString(0, length-4)으로 설정
                visited[i]=false;
                routes = routes.substring(0, routes.length()-4);
            }
        }
    }

    public static void main(String[] args) {
        Ex_20 ex_20 = new Ex_20();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        ex_20.solution(tickets);
    }
}
