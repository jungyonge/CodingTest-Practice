package com.coding.test.programmers.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class test3 {

    static class Exponent {

        String origin;
        int exp;

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Exponent)) {
                return false;
            }
            Exponent exponent = (Exponent) o;
            return getExp() == exponent.getExp() && Objects.equals(getOrigin(),
                exponent.getOrigin());
        }

        public int hashCode() {
            return Objects.hash(getOrigin(), getExp());
        }
    }

    public static String solution(String exp1, String exp2) {
        HashSet<Exponent> set = new HashSet();

        getExponentList(exp1, set);
        getExponentList(exp2, set);

        ArrayList<Exponent> list = new ArrayList(set);
        list.sort(Comparator.comparing(Exponent::getExp).reversed());
        StringBuilder sb = new StringBuilder();

        return list.stream().map(Exponent::getOrigin).collect(Collectors.joining(" + "));
    }

    public static void getExponentList(String exp_str,  HashSet<Exponent> set) {
        String[] exp_array = exp_str.split(" \\+ ");
        for (String origin : exp_array) {
            Exponent exponent = new Exponent();
            exponent.setOrigin(origin);
            String[] temp = origin.split("x\\^");
            exponent.setExp(Integer.parseInt(temp[1]));

            if (set.contains(exponent)) {
                set.remove(exponent);
                String new_origin = Integer.parseInt(temp[0]) * 2 + "x^" + temp[1];
                exponent.setOrigin(new_origin);
            }

            set.add(exponent);
        }
    }

    public static void main(String[] args) {

        System.out.println(solution("2x^5 + 3x^3 + 2x^1", "6x^6 + 4x^4 + 3x^3 + 2x^2"));
    }
}
