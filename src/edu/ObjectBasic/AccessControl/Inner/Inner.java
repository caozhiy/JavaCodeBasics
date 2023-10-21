package edu.ObjectBasic.AccessControl.Inner;

public class Inner {
    public String inner;
    protected int age;
    private double num;

    public class One{
        public int a;
        protected int b;

        double d;
        private int c;
        final public int sa = 0;
    }

    public void funcPublic() {
        System.out.println("This is public function!");
    }

    protected void funcProtected() {
        System.out.println("This is protected function!");
    }
}
