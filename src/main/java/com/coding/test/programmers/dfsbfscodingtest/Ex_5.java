package com.coding.test.programmers.dfsbfscodingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ex_5 {

    public String[] solution(String[][] tickets) {
        String[] answer =  new String[tickets.length + 1];
        List<String> relay = new LinkedList<>();
        for(int i = 0; i < tickets.length ; i++){
            List<String> tempRelay = new LinkedList<>();
            boolean[] visited = new boolean[tickets.length];
            String[] ticket = tickets[i];
            if(ticket[0].equals("ICN")){
                tempRelay.add(ticket[0]);
                tempRelay.add(ticket[1]);
                dfs(tickets, i , visited, tempRelay);
//                System.out.println(tempRelay);
                if(relay.size() == 0 && tempRelay.size() == tickets.length + 1){
                    relay.addAll(tempRelay);
                }else if(tempRelay.size() == tickets.length + 1){
                    for(int j = 0; j < relay.size() ; j ++){
                        int ox = compareStrings(relay.get(j), tempRelay.get(j) );
                        if (ox > 0) {
                            relay.clear();
                            relay.addAll(tempRelay);
                            break;
                        }
                    }
                }
            }
        }

        answer  = relay.stream()
                .map(String::toUpperCase)
                .toArray(String[]::new);
        return answer;
    }

    public int compareStrings(String s1, String s2) {

        int comparedResult = s1.compareTo(s2);

        return comparedResult;


    }

    void dfs(String [][]tickets, int i, boolean [] visited,  List<String> tempRelay){
        //현재 노드를 방문 처리
        visited[i] = true;
        int checkAdd = tempRelay.size();

        if(tempRelay.size() == tickets.length + 1){
            return;
        }
        for(int j = 0 ; j < tickets.length ; j ++){
            String[] tempTicket = tickets[j];
//            System.out.println(Arrays.toString(tempTicket));
            if(!visited[j] && tempTicket[0].equals(tempRelay.get(tempRelay.size() - 1))){
                tempRelay.add(tempTicket[1]);
                dfs(tickets, j, visited, tempRelay);
            }

            if(j == tickets.length - 1 && checkAdd == tempRelay.size()){
                visited[i] = false;
                tempRelay.remove(tempRelay.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Ex_5 ex_5 = new Ex_5();
//        ex_5.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
//        ex_5.solution(new String[][]{{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}});
//        ex_5.solution(new String[][]{{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}});
        ex_5.solution(new String[][]{{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}});
    }
}
