package edu.ObjectBasic.AccessControl.AbstractClasses;

import edu.ObjectBasic.AccessControl.Interfaces.USB;

public abstract class Bases implements USB {
    public String inner;
    protected int age;
    private double num;

    private static char sex;

    public static char getSex() {
        return sex;
    }

    public static void setSex(char sex) {
        Bases.sex = sex;
    }

    public Bases(int age, double num) {
        this.age = age;
        this.num = num;
    }

    /*
    * abstract 类中可以全都是实现了的方法，但它仍然不能实例化
    * */
    public void funcPublic() {
        System.out.println("This is public function!");
    }

    protected void funcProtected() {
        System.out.println("This is protected function!");
    }
}
