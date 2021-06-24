package com.coding.test.equal;

public class EqualObj {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            System.out.println("Object Same");
            return true;
        }

        EqualObj that = (EqualObj) obj;

        if (this.name == null && that.name != null) {
            return false;
        }

        if (this.age == that.age && this.name.equals(that.name)) {
            System.out.println("Object Value Same");
            return true;
        }

        return false;
    }
}
