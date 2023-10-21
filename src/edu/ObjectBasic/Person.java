package edu.ObjectBasic;

public class Person {
    String name;
    char sex;
    int age;

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.sex);
        assert person.name == null: "name 是空";
        Status status = Status.valueOf("Running");
        System.out.println(Status.Sleeping.getStatus());
        System.out.println(status);
    }
}
