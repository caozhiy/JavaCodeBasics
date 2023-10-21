package edu.ObjectBasic.AccessControl.Other;

/*
    一个文件中可以只有非public类，如果只有一个非public类，此类可以跟文件名不同。
    但是只能在同一个软件包中使用、创建对象、操作函数，不能在外部包的地方使用
 */
class OnlyPackageClass {
    public static long population;
    public double investment;
    public static void f() {
        System.out.println("OnlyPackageClass");
    }

    public static long getPopulation() {
        return population;
    }

    public static void setPopulation(long population) {
        OnlyPackageClass.population = population;
    }
}
