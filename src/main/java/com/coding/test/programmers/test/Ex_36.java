package com.coding.test.programmers.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Ex_36 {
    public String solution(int a, int b) {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a-1, b);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);

        String answer = sdf.format(date).toUpperCase();
        return answer;
    }
}
