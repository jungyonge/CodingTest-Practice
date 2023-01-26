package com.coding.test.goorm;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GR_74852 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String id = scanner.next();
        String pw1 = scanner.next();
        String pw2 = scanner.next();

        boolean checkId = validateId(id);
        boolean checkPassword = validatePassword(pw1, pw2);

        if(checkId && checkPassword){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
    }

    public static boolean validateId(String id){
        Pattern pattern = Pattern.compile("^\\d|[a-z]*$");
        Matcher matcher = pattern.matcher(id);

        return matcher.find();
    }

    public static boolean validatePassword(String pw1, String pw2){
        if(!pw1.equals(pw2)){
            return false;
        }
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$])[A-Za-z\\d!@#$]{8,20}$");
        Matcher matcher = pattern.matcher(pw1);

        return matcher.find();
    }
}
