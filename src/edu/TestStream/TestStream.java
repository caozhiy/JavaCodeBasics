package edu.TestStream;

import java.io.*;

public class TestStream {
    public static void main(String[] args) {
        File file = new File("resource/test.txt");
        testCharStream(file);
        testFileStream(file);
    }


    public static void testCharStream(File file) {
        File dst = new File("resource/c.txt");
        if (!dst.exists()) {
            try {
                dst.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileReader reader = new FileReader(file);
             FileWriter writer = new FileWriter(dst)) {
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
                writer.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {
            char[] chars = new char[10];
            int len = 0;

            while ((len = reader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
                writer.write(chars, 0, len);
                writer.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (PrintStream stream = new PrintStream(System.out)) {
            stream.print("hello");
        }


    }

    public static void testFileStream(File file) {
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream("resource/a.txt", true)) {
            int ch;
            while ((ch = in.read()) != -1) {
                System.out.print((char) ch);
                out.write(ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file), 50);
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("resource/b.txt"))) {
            byte[] bytes = new byte[10];
            int len = 0;
            // 设置标记点，标记至多保存多少bytes，与BufferedSize取最大值
            input.mark(10);
            long total = file.getTotalSpace(), sum = 0L;
            while ((len = input.read(bytes)) != -1) {
                output.write(bytes, 0, len);
                sum += len;
                System.out.println(new String(bytes, 0, len));
                System.out.printf("已完成 %.2f %%\n", sum / total * 100.0);
            }
            System.out.println();

            // 回到标记处
            input.reset();
            len = input.read(bytes);
            System.out.println(new String(bytes, 0, len));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
