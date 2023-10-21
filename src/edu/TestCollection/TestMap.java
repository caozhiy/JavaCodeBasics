package edu.TestCollection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        testMap();
    }

    public static void testMap() {
        Map<String, int[]> map = new HashMap<>();

        map.put("czy", new int[]{1, 4});
        map.put("ust", new int[]{9, 9, 4});
        map.put("kgb", new int[]{-8, -4,-158});
        map.put("uk", new int[]{1, 4});
        map.put("cn", new int[]{5, 9, 14, 18});

        try {
            int[] hels = map.get("hel");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        for (String s : map.keySet()) {
            System.out.println("Key:" + s + " Value:" + Arrays.toString(map.get(s)));
        }

        try {
            map.put("czy", new int[]{95, 5, 15});
            map.putIfAbsent("ra", new int[4]);
            map.remove("korean");
            map.replace("ust", new int[]{1587});
            if (map.containsKey("kgb")) {
                map.computeIfPresent("kgb", (s, ints) -> Arrays.stream(ints).map(Math::abs).toArray());
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, int[]> entry :
                map.entrySet()) {
            System.out.println(Arrays.toString(entry.getValue()));
        }

        for (Map.Entry<String, int[]> stringEntry : map.entrySet()) {
            System.out.println(stringEntry.getKey());
            System.out.println(Arrays.toString(stringEntry.getValue()));
        }


    }
}
