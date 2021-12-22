package com.vinit.example.machinecode.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tictac {
    public static List<String> pos = new ArrayList<>(9);
    static String winner = "";

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the player 1 name with X");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String player1 = br.readLine();
        System.out.println("Enter the player 2 name with O");
        String player2 = br.readLine();
        for (int i = 0; i < 9; i++) {
            pos.add(i, "" + (i + 1));
        }
        displayBoard();
        playgame(player1, player2);
        System.out.println(winner +"Wins !!!");
    }

    public static void playgame(String s1, String s2) {
        Scanner sc = new Scanner(System.in);
        int in = 0;
        int i = 0;
        while (!checkWinner()) {
            if (i % 2 == 0) {
                System.out.println(s1 + " chance" + " enter location for X");
                in = sc.nextInt();
                if (in < 1 || in > 9) {
                    System.out.println("Invalid input, please retry");
                }
                pos.set(in - 1, "X");
                winner = s1;
            } else {
                System.out.println(s2 + " chance" + " enter location for y");
                in = sc.nextInt();
                if (in < 1 || in > 9) {
                    System.out.println("Invalid input, please retry");
                }
                pos.set(in - 1, "O");
                winner = s2;
            }
            displayBoard();
            i++;
            if (i == 9) {
                winner= "No One";
                break;
            }

        }
    }

    public static boolean checkWinner() {
        String c1 = pos.get(0) + pos.get(1) + pos.get(2);
        String c2 = pos.get(3) + pos.get(4) + pos.get(5);
        String c3 = pos.get(6) + pos.get(7) + pos.get(8);
        String c4 = pos.get(0) + pos.get(3) + pos.get(6);
        String c5 = pos.get(1) + pos.get(4) + pos.get(7);
        String c6 = pos.get(2) + pos.get(5) + pos.get(8);
        String c7 = pos.get(0) + pos.get(4) + pos.get(8);
        String c8 = pos.get(2) + pos.get(4) + pos.get(6);
        if (c1.equals("000") || c2.equals("000") || c3.equals("000") || c4.equals("000") || c5.equals("000") || c6.equals("000") || c7.equals("000") || c8.equals("000")
                || c1.equals("XXX") || c2.equals("XXX") || c3.equals("XXX") || c4.equals("XXX") || c5.equals("XXX") || c6.equals("XXX") || c7.equals("XXX") || c8.equals("XXX")) {
            return true;
        }
        return false;
    }

    public static void displayBoard() {
        System.out.println(pos.get(0) + " | " + pos.get(1) + " | " + pos.get(2));
        System.out.println("- - - - -");
        System.out.println(pos.get(3) + " | " + pos.get(4) + " | " + pos.get(5));
        System.out.println("- - - - -");
        System.out.println(pos.get(6) + " | " + pos.get(7) + " | " + pos.get(8));
    }

}
