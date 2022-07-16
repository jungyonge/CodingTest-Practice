package com.coding.test.programmers.test;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex_42 {
    public static String[] solution(String[] record) {
        ArrayList<String> arrayList = new ArrayList();
        HashMap<String,String> nameMap = new HashMap<>();
        for(String s : record){
            String[] command = s.split(" ");
            if(!nameMap.containsKey(command[1]) || command[0].equals("Enter")){
                nameMap.put(command[1],command[2]);
            }
            if(command[0].equals("Enter")){
                arrayList.add(command[1] + "님이 들어왔습니다.");
            }else if(command[0].equals("Leave")){
                arrayList.add(command[1] + "님이 나갔습니다.");
            }else if(command[0].equals("Change")){
                nameMap.put(command[1],command[2]);
            }
        }
        String[] answer = new String[arrayList.size()];
        int i = 0;
        for(String s : arrayList){

            String uid = s.substring(0,s.indexOf("님이 "));
            String res = s.replace(uid,nameMap.get(uid));
            answer[i] = res;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);

    }
}
