package com.coding.test.programmers.hanhwa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test2 {

    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks,
        String[] employees) {

        ArrayList<ArrayList<Integer>> teamList = new ArrayList<>();
        ArrayList<Integer> remoteEmployeeList = new ArrayList<>();
        boolean[] officeCheck = new boolean[num_teams];

        for (int i = 0; i < num_teams; i++) {
            teamList.add(new ArrayList<>());
        }

        int id = 1;
        for (String employee : employees) {
            int team = Integer.parseInt(employee.substring(0, 1));
            String tasks = employee.substring(2);
            boolean check = false;
            boolean office = false;
            for (String task : office_tasks) {
                if (tasks.contains(task)) {
                    office = true;
                    break;
                }
            }

            if(!office){
                for (String task : remote_tasks) {
                    if (tasks.contains(task)) {
                        check = true;
                        break;
                    }
                }
            }

            if (check) {
                teamList.get(team - 1).add(id);
            } else {
                officeCheck[team - 1] = true;
            }
            id++;
        }

        for (int team = 0; team < teamList.size(); team++) {

            int index = 0;
            Collections.sort(teamList.get(team));

            if (!officeCheck[team] && teamList.get(team).size() > 1) {
                index = 1;
            }
            for (int i = index; i < teamList.get(team).size(); i++) {
                remoteEmployeeList.add(teamList.get(team).get(i));
            }

        }

        Collections.sort(remoteEmployeeList);

        return remoteEmployeeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        System.out.println(
            Arrays.toString(
                solution(2, new String[]{"design"}, new String[]{"building", "supervise"},
                    new String[]{"2 design", "1 design",
                        "2 design"})));
        System.out.println(
            Arrays.toString(
                solution(3, new String[]{"development", "marketing", "hometask"},
                    new String[]{"recruitment", "education", "officetask"},
                    new String[]{"1 development hometask", "1 recruitment marketing", "2 hometask",
                        "2 development marketing hometask", "3 marketing", "3 officetask",
                        "3 development"})));

    }
}
