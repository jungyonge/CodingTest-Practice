package com.coding.test.programmers.heapcodingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Ex_2 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42627
//    디스크 컨트롤러

    public int solution(int[][] jobs) {
        int answer = 0;
        boolean progressing = false;

        Arrays.sort(jobs, (job1, job2) -> {
            if (job1[0] == job2[0]) {
                return Integer.compare(job1[1], job2[1]);
            } else {
                return Integer.compare(job1[0], job2[0]);
            }
        });

        ArrayList<Job> queue = new ArrayList<>();
        for (int[] job : jobs) {
            queue.add(new Job(job[0], job[1], 0, false,false));
        }

        PriorityQueue<Job> priorityQueue = new PriorityQueue<>();

//        PriorityQueue<Job> priorityQueue = new PriorityQueue<Job>(new Comparator<Job>() {
//            public int compare(Job o1, Job o2) {
//                if(o1.getEnterTime() < o2.getEnterTime()){
//                    return -1;
//                }
//                return 1;
//            }
//        });
        Job nowJob = null;
        int nowTime = 0;

        while (true) {

            for (int i = 0; i < queue.size(); i++) {
                Job tempJob = queue.get(i);
                if (tempJob.enterTime <= nowTime && !tempJob.isOnQueue()) {
                    tempJob.setOnQueue(true);
                    priorityQueue.offer(tempJob);
                }
            }


            if(nowJob == null && !priorityQueue.isEmpty()){
                nowJob = priorityQueue.poll();
                nowJob.setInProgressing(true);
            }

            if (nowJob != null && nowJob.getNeedTime() > 0) {
                nowJob.setNeedTime(nowJob.getNeedTime() - 1);
                nowJob.setTotalTime(nowJob.getTotalTime() + 1);
                if(nowJob.getNeedTime() == 0 && !priorityQueue.isEmpty()){
                    answer += nowJob.getTotalTime();
                    nowJob = null;
                }
            }



            if(nowJob == null && !priorityQueue.isEmpty()){
                nowJob = priorityQueue.poll();
                nowJob.setInProgressing(true);
                nowJob.setNeedTime(nowJob.getNeedTime() - 1);
                nowJob.setTotalTime(nowJob.getTotalTime() + 1);
            }


            for (Job temp : queue){
                if(!temp.isInProgressing()){
                    temp.setTotalTime(temp.getTotalTime() + 1);
                }
            }

            if (priorityQueue.isEmpty() && nowJob.getNeedTime() == 0) {
                answer += nowJob.getTotalTime();
                break;
            }

            nowTime++;
        }
        return answer / jobs.length;
    }

    class Job implements Comparable<Job> {

        int enterTime;
        int needTime;

        int totalTime;

        boolean inProgressing;

        boolean onQueue;

        public Job(int enterTime, int needTime, int totalTime, boolean inProgressing,boolean onQueue) {
            this.enterTime = enterTime;
            this.needTime = needTime;
            this.totalTime = totalTime;
            this.inProgressing = inProgressing;
            this.onQueue = onQueue;
        }

        @Override
        public int compareTo(Job job) {
            if (this.needTime > job.needTime) {
                return 1;
            } else {
                return -1;
            }
        }

        public int getEnterTime() {
            return enterTime;
        }

        public void setNeedTime(int needTime) {
            this.needTime = needTime;
        }

        public int getNeedTime() {
            return needTime;
        }

        public void setOnQueue(boolean onQueue) {
            this.onQueue = onQueue;
        }

        public boolean isOnQueue() {
            return onQueue;
        }

        public void setInProgressing(boolean inProgressing) {
            this.inProgressing = inProgressing;
        }

        public void setEnterTime(int enterTime) {
            this.enterTime = enterTime;
        }

        public int getTotalTime() {
            return totalTime;
        }

        public boolean isInProgressing() {
            return inProgressing;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }
    }

//    public int solution(int[][] jobs) {
//        int answer = 0;
//        int currentTime = 0;
//        int allTime = 0;
//        int visitedNum = 0;
//        boolean[] isVisited = new boolean[jobs.length];
//        PriorityQueue<Job> heap = new PriorityQueue();
//
//        Arrays.sort(jobs, (job1, job2) -> {
//            if (job1[0] == job2[0]) {
//                return Integer.compare(job1[1], job2[1]);
//            } else {
//                return Integer.compare(job1[0], job2[0]);
//            }
//        });
//
//        isVisited[0] = true;
//        heap.add(new Job(jobs[0][0], jobs[0][1]));
//        currentTime += jobs[0][0];
//        visitedNum++;
//
//        while (!heap.isEmpty() || visitedNum != jobs.length) {
//
//            if (!heap.isEmpty()) {
//                Job currentJob = heap.poll();
//                currentTime += currentJob.jobTime;
//                allTime += (currentTime - currentJob.start);
//            } else {
//                currentTime++;
//            }
//
//            for (int i = 0; i < jobs.length; i++) {
//                if (isVisited[i]) {
//                    continue;
//                }
//                if (currentTime >= jobs[i][0]) {
//                    isVisited[i] = true;
//                    heap.add(new Job(jobs[i][0], jobs[i][1]));
//                    visitedNum++;
//                }
//            }
//        }
//
//        answer = allTime / jobs.length;
//        return answer;
//    }

//    class Job implements Comparable<Job> {
//
//        int start;
//        int jobTime;
//
//        Job(int start, int jobTime) {
//            this.start = start;
//            this.jobTime = jobTime;
//        }
//
//        @Override
//        public int compareTo(Job job) {
//            if (this.jobTime > job.jobTime) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//    }


    public static void main(String[] args) {

        Ex_2 solution = new Ex_2();
        System.out.println(solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));


    }
}
