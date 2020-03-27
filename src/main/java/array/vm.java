package array;

import java.util.*;

public class vm {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("yellowShirt");
        s.add("redHat");
        s.add("blackShirt");
        s.add("bluePants");
        s.add("redHat");
        s.add("pinkHat");
        s.add("blackShirt");
        s.add("yellowShirt");
        s.add("greenPants");
        s.add("greenPants");
        String ss = featuredProduct(s);
        System.out.println(ss);

    }

    public static String featuredProduct(List<String> products) {
        // Write your code here
        TreeMap<String, Integer> counts = new TreeMap<>();


        SortedSet<Map.Entry<String, Integer>> sortedProds = new TreeSet<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2) {
                        return p1.getValue().compareTo(p2.getValue());
                    }

                });


        products.forEach(product -> {
            if (counts.get(product) == null)
                counts.put(product, 1);
            else {
                int val = counts.get(product) + 1;
                counts.put(product, val);
            }
        });

        sortedProds.addAll(counts.entrySet());

        return sortedProds.first().getKey();
    }
}
