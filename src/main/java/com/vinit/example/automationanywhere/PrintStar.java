package com.vinit.example.automationanywhere;

import java.util.Scanner;

public class PrintStar {

    public static void main(String[] args) {

        /*       *
         ***
         ******/
        Scanner sc = new Scanner(System.in);
        System.out.println("Print height of the tree");
        int height = sc.nextInt();
        for (int i = 1; i < height; i++) {
            for (int j = i; j < height; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < i * 2; ) {
                System.out.print("*");
                k++;
            }
            System.out.println();

        }
    }
}

