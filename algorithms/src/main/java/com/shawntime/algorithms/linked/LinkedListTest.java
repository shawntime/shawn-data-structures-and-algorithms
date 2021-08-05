package com.shawntime.algorithms.linked;

import com.shawntime.algorithms.List;

public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> dataList = new LinkedList<>();
        dataList.add(1);
        dataList.add(2);
        dataList.add(0, 3);
        dataList.add(1, 10);
        dataList.add(dataList.size(), 20);

        System.out.println(dataList.indexOf(20));
        System.out.println(dataList.contains(10));
        System.out.println(dataList);
        dataList.remove(3);
        System.out.println(dataList);
        dataList.remove(0);
        System.out.println(dataList);
        dataList.remove(dataList.size() - 1);
        System.out.println(dataList);
    }
}
