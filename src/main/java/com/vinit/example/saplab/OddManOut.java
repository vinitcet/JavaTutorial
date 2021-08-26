package com.vinit.example.saplab;

import java.util.ArrayList;
import java.util.Arrays;

public class OddManOut {
    public String getTheOddOneOut(String lineWithNumbers, int numberCount) {
        String[] numberArr = lineWithNumbers.split("[ ]");
        Arrays.sort(numberArr);
        ArrayList<String> list1 = new ArrayList<String>();

        for (int index = 0; index < numberCount; index++) {
            String strNumber = numberArr[index];

            if ((index % 2) == 0 && index != (numberCount - 1)) {
                list1.add(strNumber);
            } else if (!list1.contains(strNumber)) {
                if (index == (numberCount - 1) || !strNumber.equals(numberArr[index + 1])) {
                    return strNumber;
                } else {
                    return list1.get(list1.size() - 1);
                }
            }
        }

        return null;
    }
}