package edu.ObjectBasic.AccessControl.AbstractClasses;

import edu.ObjectBasic.AccessControl.Interfaces.Bluetooth;

public abstract class Medium extends Bases implements Bluetooth {

    public String medium;
    protected int height;
    private double weight;

    public Medium(int age, double num) {
        super(age, num);
    }

    private void access() {
        System.out.println(this.age + this.inner);
    }

    abstract public void printer();
}
