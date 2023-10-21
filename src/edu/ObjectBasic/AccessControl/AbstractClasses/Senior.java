package edu.ObjectBasic.AccessControl.AbstractClasses;

import edu.ObjectBasic.AccessControl.Interfaces.USB;
import edu.ObjectBasic.Status;

public class Senior extends Medium {

    private Status status;

    public Senior(int age, double num) {
        super(age, num);
    }

    @Override
    public void printer() {
        System.out.println(this.inner + super.age);
    }

    @Override
    public boolean connect(USB usb, String version) {
        return super.connect(usb, version);
    }

    @Override
    public boolean breakConnect() {
        return false;
    }

    @Override
    public boolean getStatus() {
        return false;
    }
}
