package com.coding.test.programmers.heapcodingtest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
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

        Queue<Job> queue = new LinkedList<Job>();
        for(int[] job : jobs){
            queue.offer(new Job(job[0],job[1], 0, false));
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
        Job nowJob = queue.poll();
        int nowTime = 0;

        priorityQueue.offer(nowJob);

        while (true) {

            if (nowJob == null && !priorityQueue.isEmpty()) {
                nowJob = priorityQueue.poll();
            }

            if (nowJob != null && nowJob.getNeedTime() > 0) {
                nowJob.setNeedTime(nowJob.getNeedTime() - 1);
                nowJob.setTotalTime(nowJob.getTotalTime() + 1);
            }

            if (nowJob != null) {
                if (priorityQueue.peek() != null) {
                    if (nowJob.getNeedTime() == 0
                            && priorityQueue.peek().getEnterTime() >= answer) {
                        answer += nowJob.getTotalTime();
                        nowJob = priorityQueue.poll();
                        if (nowJob != null) {
                            nowJob.setNeedTime(nowJob.getNeedTime() - 1);
                        }
                    } else if (!priorityQueue.isEmpty() && nowJob.getNeedTime() == 0
                            && priorityQueue.peek().getEnterTime() < answer) {
                        answer += nowJob.getTotalTime();
                        nowJob = null;
                    }
                }
            }

            for (Job tempJob : queue) {
                if(tempJob.enterTime <= nowTime){
                    priorityQueue.offer(queue.poll());
                }
            }


            for (Job tempJob : priorityQueue) {
                tempJob.setTotalTime(tempJob.getTotalTime() + 1);
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

        public Job(int enterTime, int needTime, int totalTime, boolean inProgressing) {
            this.enterTime = enterTime;
            this.needTime = needTime;
            this.totalTime = totalTime;
            this.inProgressing = inProgressing;
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
        System.out.println(solution.solution(new int[][]{{0, 10}, {4, 10}, {15, 2}, {5, 11}}));


    }
}
