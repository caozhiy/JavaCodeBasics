package edu.ObjectBasic.AccessControl.Other;

public class OtherClass {
    public OnlyPackageClass onlyPackageClass;
    public String inner;
    protected int age;
    private double num;

    public void funcPublic() {
        System.out.println("This is public function!");
    }

    protected void funcProtected() {
        System.out.println("This is protected function!");
    }

    public OnlyPackageClass getOnlyPackageClass() {
        if (this.onlyPackageClass == null) {
            return new OnlyPackageClass();
        } else
            return this.onlyPackageClass;
    }
}
