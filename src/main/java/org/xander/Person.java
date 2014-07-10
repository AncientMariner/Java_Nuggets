package org.xander;

public class Person {
    private String name;
    private int age;

    public Person(String personName, int personAge) {
        name = personName;
        age = personAge;
    }

    public Person(Person p) {
        this(p.getName(), p.getAge());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
