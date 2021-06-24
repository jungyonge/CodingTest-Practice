package com.coding.test.equal;

public class Equal {

    public static void main(String[] args) {
        EqualObj p1 = new EqualObj();
        p1.setAge(27);
        p1.setName("YoungJae");

        EqualObj p2 = new EqualObj();
        p2.setAge(27);
        p2.setName("YoungJae");

        System.out.println(p1.equals(p2)); // false
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}
