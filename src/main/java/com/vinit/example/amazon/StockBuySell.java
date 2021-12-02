package com.vinit.example.amazon;

import java.util.ArrayList;
import java.util.List;

public class StockBuySell {

    void stockBuySell(int[] price, int count) {
        if (count < 2) {
            System.out.println("Price must be given for two days");
            return;
        }
        List<Trans> arr = new ArrayList<>();
        int i = 0;
        while (i < count - 1) {
            while (i < count - 1 && price[i + 1] <= price[i]) {
                i++;
            }
            if (i == count - 1) {
                break;
            }
            Trans trans = new Trans();
            trans.buy = i++;
            while (i < count && price[i - 1] <= price[i]) {
                i++;
            }
            trans.sell = i - 1;
            arr.add(trans);
        }
        for (Trans trans : arr) {
            System.out.println("Buy on day:" + trans.buy + " Sell on day: " + trans.sell + "  Profit: " + (price[trans.sell] - price[trans.buy]));
        }
    }

    class Trans {
        int buy;
        int sell;
    }

    public static void main(String[] args) {
        StockBuySell stock = new StockBuySell();
        //int price[] = {100, 180, 260, 310, 40, 535, 695};
        int price[] = {7, 1, 5, 3, 6, 4};
        int n = price.length;
        // System.out.println();
        // fucntion call
        stock.stockBuySell(price, n);
    }
}
