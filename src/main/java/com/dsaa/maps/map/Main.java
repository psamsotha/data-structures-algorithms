package com.dsaa.maps.map;

public class Main {

    public static void main(String... args) {
        Map<String, Integer> ints = new UnsortedTableMap<>();
        ints.put("One", 1);
        ints.put("Two", 2);
        ints.put("Three", 3);

        System.out.println(ints);

        for (Map.Entry<String, Integer> entry: ints.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        ints.remove("One");
        ints.remove("Three");

        System.out.println(ints);
    }
}
