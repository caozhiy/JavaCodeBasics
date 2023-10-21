package edu.ObjectBasic.AccessControl.Inner;

public class DifferentInnerClasses {
    public static double aDouble = -1.;
    protected static double bDouble = -2.;
    static double cDouble = -3.;
    private static double dDouble = -4.;
    public int anInt = 1;
    protected int bnInt = 2;
    int cnInt = 3;
    private int dnInt = 4;

    public static void test() {
//        System.out.println("访问成员内部类的成员变量：" + new MemberClass().anInt );
        System.out.println("访问静态内部类的静态成员:" + StaticMemberClass.dDouble);
        System.out.println("访问静态内部类的静态方法:");
        StaticMemberClass.staticf();
    }

    static public void staticf() {
        System.out.println(DifferentInnerClasses.aDouble);
        System.out.println(DifferentInnerClasses.bDouble);
        System.out.println(DifferentInnerClasses.cDouble);
        System.out.println(DifferentInnerClasses.dDouble);
    }

    public void afunc() {
        System.out.println(this.anInt);
    }

    protected void bfunc() {
        System.out.println(this.bnInt);
    }

    void cfunc() {
        System.out.println(this.cnInt);
    }

    private void dfunc() {
        System.out.println(this.dnInt);
    }

    static public class StaticMemberClass {
        public static double aDouble = -1.;
        protected static double bDouble = -2.;
        static double cDouble = -3.;
        private static double dDouble = -4.;
        public int anInt = 1;
        protected int bnInt = 2;
        int cnInt = 3;
        private int dnInt = 4;

        static public void staticf() {
            System.out.println(DifferentInnerClasses.StaticMemberClass.aDouble);
            System.out.println(DifferentInnerClasses.StaticMemberClass.bDouble);
            System.out.println(DifferentInnerClasses.StaticMemberClass.cDouble);
            System.out.println(DifferentInnerClasses.StaticMemberClass.dDouble);
        }

        public void afunc() {
            System.out.println(this.anInt);
        }

        protected void bfunc() {
            System.out.println(this.bnInt);
        }

        void cfunc() {
            System.out.println(this.cnInt);
        }

        private void dfunc() {
            System.out.println(this.dnInt);
        }

        public void test() {
//            System.out.println("访问外部类的非静态变量：" + DifferentInnerClasses.this.anInt);
//            System.out.println("访问外部类的非静态方法：" + DifferentInnerClasses.this.afunc());
            System.out.println("访问外部类的静态变量：" + DifferentInnerClasses.dDouble);
            System.out.println("访问外部类的静态方法：");
            DifferentInnerClasses.staticf();
        }
    }

    // 成员内部类
    public class MemberClass {
        //        public static double aDouble = -1.;
//        protected static double bDouble = -2.;
//        static double cDouble = -3.;
//        private static double dDouble = -4.;
        public int anInt = 10;
        protected int bnInt = 20;
        int cnInt = 30;
        private int dnInt = 40;

//        static public void f(){
//
//        }


        public void memberfunc() {
            System.out.println("访问外部类的非静态变量：" + DifferentInnerClasses.this.anInt);
            System.out.println("访问外部类的非静态变量：" + DifferentInnerClasses.this.bnInt);
            System.out.println("访问外部类的非静态变量：" + DifferentInnerClasses.this.cnInt);
            System.out.println("访问外部类的非静态变量：" + DifferentInnerClasses.this.dnInt);

            System.out.println("访问外部类的静态变量:" + DifferentInnerClasses.aDouble);
            System.out.println("访问外部类的静态变量:" + DifferentInnerClasses.bDouble);
            System.out.println("访问外部类的静态变量:" + DifferentInnerClasses.cDouble);

            System.out.println("使用外部类的非静态方法：");
            DifferentInnerClasses.this.afunc();
            DifferentInnerClasses.this.bfunc();
            DifferentInnerClasses.this.cfunc();
            DifferentInnerClasses.this.dfunc();

            System.out.println("使用外部类的静态方法：");
            DifferentInnerClasses.staticf();
        }
    }
}
