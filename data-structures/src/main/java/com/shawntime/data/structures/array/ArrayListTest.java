package com.shawntime.data.structures.array;

import com.shawntime.data.structures.List;

public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();
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
