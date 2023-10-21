package edu.ObjectBasic.AccessControl;

import edu.ObjectBasic.AccessControl.AbstractClasses.Medium;
import edu.ObjectBasic.AccessControl.AbstractClasses.Senior;
import edu.ObjectBasic.AccessControl.Inner.Inner;
import edu.ObjectBasic.AccessControl.AbstractClasses.Bases;
import edu.ObjectBasic.AccessControl.Other.OtherClass;


public class Main {
    public static void main(String[] args) {
        Inner inner = new Inner();
        OtherClass otherClass = new OtherClass();
        boolean flag = otherClass.onlyPackageClass == null;
        otherClass.onlyPackageClass = otherClass.getOnlyPackageClass();
        System.out.println(flag);
        System.out.println(otherClass.onlyPackageClass);
    }

    public static void f() {
        Senior senior = new Senior(25, 300.2);
        boolean flag = senior.connect(new Medium(26, 95.2) {
            @Override
            public void printer() {
                System.out.println("hello Medium");
            }

            @Override
            public boolean breakConnect() {
                return false;
            }

            @Override
            public boolean getStatus() {
                return false;
            }
        }, "2.0.2");


    }
}
