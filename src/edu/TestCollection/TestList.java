package edu.TestCollection;

import java.util.*;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {
        testQueue();

    }

    static void testQueue() {
        Queue<Double> queue = new LinkedList<>();
        try {
            queue.offer(8.0);
            queue.offer(2.042);
            queue.offer(9.82);
            queue.offer(.2);
            queue.offer(-2.2);
            queue.poll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        queue.forEach(System.out::println);
        Deque<Double> deque = new ArrayDeque<>(queue);
        System.out.println(deque);
        queue = new PriorityQueue<>(queue);
        System.out.println(queue);

    }

    public static void testList() {
        List<String> list = new ArrayList<>();

        try {
            list.add("Hello");
            list.add("World");
            list.add(0, "hello");
            list.add("AAA");
            list.add("HBA");
            list.add("HBC");
            list.set(5, "I have a good day because I will eat hotpot during lunchtime.");
            list.replaceAll(s -> s + s.length());
            list.forEach(s -> System.out.printf("我是 '%s'\n", s));
            list.remove(2);
            list.removeIf(s -> s.length() < 5);
            list.sort((a, b) -> -1 * a.compareToIgnoreCase(b));
            System.out.println("=====我是分界线=====");
            list.forEach(s -> System.out.printf("我是 '%s'\n", s));

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {

            e.printStackTrace();
            throw new NoSuchElementException("找不到该元素");
        }

        System.out.println("-------分界线-------\n");
        list = new LinkedList<>(list);

        try {
            list.addAll(1, Arrays.asList("Loop", "Continue", "CBAD"));
            list.addAll(2, Arrays.asList("Loop", "Continue", "CBAD"));
            list.addAll(2, Arrays.asList("Loop", "Continue", "CBAD"));
            list.addAll(2, Arrays.asList("Loop", "Continue", "CBAD"));
            list.addAll(2, Arrays.asList("Loop", "Continue", "CBAD"));
            System.out.println(list);
            System.out.println("****** 我是分界线 ******\n");
//            list.addAll(list);
            list = list.stream()
                    .filter(s -> !s.contains("Con"))
                    .map(s -> s.replaceAll("o{2,}", "~ ^oOo^ ~"))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("wuwuwu");
        }
        System.out.println(list);

    }
}
