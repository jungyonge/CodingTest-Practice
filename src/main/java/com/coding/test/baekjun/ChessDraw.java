package com.coding.test.baekjun;

import java.util.Scanner;

public class ChessDraw {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        String[][] chess = new String[X][Y];
        int whiteCount = 0;
        int blackCount = 0;
        for (int i = 0; i < X; i++) {
            String[] line = scanner.next().split("");
            for (int j = 0; j < Y; j++) {
                chess[i][j] = line[j];
            }
        }

        int XGap = X - 7;
        int YGap = Y - 7;
        int needReDraw = 9999999;
        for (int i = 0; i < XGap; i++) {
            for (int j = 0; j < YGap; j++) {
                String first = chess[i][j];
                String start = chess[i][j];

                System.out.println(i + " " + j);
                if (i == 1 && j == 15) {
                    System.out.println("s");
                }
                for (int c = 0; c < 2; c++) {
                    int reDraw = 0;

                    for (int tempI = 0 + i; tempI < 8 + i; tempI++) {
                        for (int tempJ = 0 + j; tempJ < 8 + j; tempJ++) {
                            if (!chess[tempI][tempJ].equals(start)) {
                                reDraw++;
                            }
                            if (start.equals("W")) {
                                start = "B";
                            } else {
                                start = "W";
                            }
                            if (tempJ == 8 + j - 1) {
                                if (start.equals("W")) {
                                    start = "B";
                                } else {
                                    start = "W";
                                }
                            }
                        }
                    }
                    if (reDraw < needReDraw) {
                        needReDraw = reDraw;
                    }
                    if (first.equals("W")) {
                        start = "B";
                    } else {
                        start = "W";
                    }

                }

            }
        }

        System.out.println(needReDraw);

    }
}
