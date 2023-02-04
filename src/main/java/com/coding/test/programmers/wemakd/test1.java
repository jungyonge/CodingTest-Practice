package com.coding.test.programmers.wemakd;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;
import java.util.Date;
import java.text.ParseException;
public class test1 {

    public static String solution(String[] log) throws ParseException {
        String answer = "";
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        int sum = 0;
        for(int i = 0 ; i < log.length ; i++){
            System.out.println(i);
            Date d1 = f.parse(log[i]);
            Date d2 = f.parse(log[i + 1]);
            long diff = d2.getTime() - d1.getTime() ;
            long min = (diff / 1000) / 60;
            if(min >= 5 && min < 105){
                sum += min;
            }
            if(min >= 105){
                sum += 105;
            }
            i++;
        }
        int hours = sum / 60;
        int minutes = sum % 60;
        answer = String.format("%02d:%02d", hours, minutes);

        return answer;
    }
    public static void main(String[] args) throws ParseException {

        System.out.println(solution(new String[]{"08:30","09:00","14:00","16:00","16:01","16:06","16:07","16:11"}));
    }
}
