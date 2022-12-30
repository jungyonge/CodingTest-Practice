package com.coding.test.programmers.codingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PG_42862 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Student> studentList = new LinkedList<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0 ; i < n ; i++){
            Student student = new Student(false,true, i);
            studentList.add(student);
        }

        for(int i : lost){

            studentList.get(i - 1).setLost(true);
        }

        for(int i : reserve){
            i = i - 1;
            if(studentList.get(i).isLost()){
                studentList.get(i).setLost(false);
                studentList.get(i).setReserve(false);
            }
        }

        for(int i : reserve){
            i = i - 1;

            if(i - 1 >= 0){
                if(studentList.get(i - 1).isLost() && studentList.get(i).isReserve()){
                    studentList.get(i - 1).setLost(false);
                    studentList.get(i).setReserve(false);
                    continue;
                }
            }

            if(i + 1 < n){
                if(studentList.get(i + 1).isLost() && studentList.get(i).isReserve()){
                    studentList.get(i + 1).setLost(false);
                    studentList.get(i).setReserve(false);
                    continue;
                }
            }


        }

        for(Student student : studentList){
            if(!student.isLost()){
                answer++;
            }
        }

        return answer;
    }

    class Student {
        boolean lost;
        boolean reserve;

        int number;

        public Student(boolean lost, boolean reserve, int number){
            this.lost = lost;
            this.reserve = reserve;
            this.number = number;
        }

        public void setLost(boolean lost) {
            this.lost = lost;
        }

        public void setReserve(boolean reserve) {
            this.reserve = reserve;
        }

        public boolean isLost() {
            return lost;
        }

        public boolean isReserve() {
            return reserve;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

}
