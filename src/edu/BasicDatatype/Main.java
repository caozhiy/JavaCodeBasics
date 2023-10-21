package edu.BasicDatatype;

public class Main {
    public static void main(String[] args) {
        int a = -8, b = 8, c = 4;
        System.out.println(a << 2);
        System.out.println(b << 2);
        System.out.println(c << 2);
        System.out.println(a >> 2);
        System.out.println(b >> 2);
        System.out.println(c >> 2);
        String str = "ccf";
        f();
        System.out.println(str);
    }

    public static void f() {
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10, shi = i / 10 % 10, bai = i / 100;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i)
                System.out.println(i);
        }
        for (int row = 1; row < 10; row++) {
            for (int col = 1; col <= row; col++) {
                StringBuilder builder = new StringBuilder();
                builder.append(col).append(" × ").append(row).append(" = ").append(row * col);
                System.out.printf("%s\t", builder.toString());
            }
            System.out.println();
        }
        int result = 1;
        for (int target = 4; target < 10; target++) {
            int prev = 1, cur = 1;
            for (int i = 3; i <= target; i++) {
                result = prev + cur;
                prev = cur;
                cur = result;
            }
            System.out.println(result);
        }
    }
}
