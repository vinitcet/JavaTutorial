package com.vinit.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxStockProfit {

    static class Interval {
        int buy;
        int sell;
    }

    static void buySell(int price[], int n) {
        if (n < 2) {
            return;
        }
        int count = 0;
        List<Interval> sol = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            //local minima
            while (i < n - 1 && price[i + 1] <= price[i]) {
                n++;
            }
            if (i == n - 1) {
                break;
            }
            Interval interval = new Interval();
            interval.buy = i++;
            //local maxima
            while (i < n && price[i] >= price[i - 1]) {
                i++;
            }
            interval.sell = i - 1;
            sol.add(interval);
            count++;
        }
        if (count == 0) {
            System.out.println("No profit in this price");
        } else {
            for (int j = 0; j < count; j++) {
                System.out.println("Buy on day: " + sol.get(j).buy + " Sell on day: " + sol.get(j).sell + " Profit: " + (price[sol.get(j).sell] - price[sol.get(j).buy]));
            }
        }

    }

    public static void main(String[] args) {
        int price[] = {210, 100, 180, 260, 440, 310,
                40, 535, 695, 10, 20, 30, 40, 50, 30, 100, 200, 10};
        int n = price.length;
        buySell(price, n);
    }
}
