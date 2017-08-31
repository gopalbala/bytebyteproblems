package com.gb.bytebybyteproblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by gbalasubramanian on 29/08/17.
 */
public class BuildOrder {
    public static List<Integer> getBuildOrder(int[][] processes) {
        Set<Integer> temperoaryMark = new HashSet<>();
        Set<Integer> permanentMark = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < processes.length; i++) {
            if (!permanentMark.contains(i)) {
                visit(i, processes, temperoaryMark, permanentMark, result);
            }
        }
        return result;
    }

    private static void visit(int process, int[][] processes, Set<Integer> temperoaryMark, Set<Integer> permanentMark, List<Integer> result) {
        if (temperoaryMark.contains(process)) {
            throw new RuntimeException("Cycle found");
        }
        if (!permanentMark.contains(process)) {
            temperoaryMark.add(process);
            for (int i : processes[process]) {
                visit(i, processes, temperoaryMark, permanentMark, result);
            }
            permanentMark.add(process);
            temperoaryMark.remove(process);
            result.add(process);
        }
    }

    public static void main(String[] args) {
        System.out.println(getBuildOrder(new int[][]{{}, {0}, {1}, {2}, {3}}));
                //new int[]{0, 1, 2, 3, 4});
        System.out.println(getBuildOrder(new int[][]{{}, {0}, {0}, {1, 2}, {1, 2, 3}}));
    }
}
