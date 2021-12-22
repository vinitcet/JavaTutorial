package com.vinit.example.machinecode.snakeandladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeLadder {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Enter number of snakes");
        Scanner sc = new Scanner(System.in);
        int noSnakes = sc.nextInt();
        int i = 0;
        List<Snake> snakes = new ArrayList<>();
        while (i < noSnakes) {
            System.out.println("Enter snake " + (i + 1) + " head location:");
            int head = sc.nextInt();
            System.out.println("Enter snake " + (i + 1) + " tail location:");
            int tail = sc.nextInt();
            if (head > 99 || head < tail || head < 1 || tail < 1) {
                System.out.println("Invalid snake");
                continue;
            }
            snakes.add(new Snake(head, tail));
            i++;
        }
        System.out.println("Enter number of ladder");
        int noladder = sc.nextInt();
        int j = 0;
        List<Ladder> ladders = new ArrayList<>();
        while (j < noladder) {
            System.out.println("Enter ladder " + (j + 1) + " head location:");
            int start = sc.nextInt();
            System.out.println("Enter ladder " + (j + 1) + " tail location:");
            int end = sc.nextInt();
            if (end > 99 || end < start || start < 1 || end < 1) {
                System.out.println("Invalid snake");
                continue;
            }
            for (Snake s : snakes) {
                if (s.tail == start && s.head == end) {
                    System.out.println("A snake exist at same location , please change the value");
                    continue;
                }
            }
            snakes.add(new Snake(start, end));
            j++;
        }
        System.out.println("Enter number of players");
        int noplayers = sc.nextInt();
        int k = 0;
        List<Player> players = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (k < noplayers) {
            System.out.println("Enter player " + (k + 1) + " name:");
            String name = reader.readLine();
            Thread.sleep(1000);
            Player p = new Player(name);
            players.add(p);
            k++;
        }
        System.out.println("**************Going to start game************");
        playGame(players, snakes, ladders);
        sc.close();
        reader.close();
    }

    //return (int) ((Math.random() * (max - min)) + min);
    public static int generateNumber() {
        return (int) ((Math.random() * (7 - 1)) + 1);
    }

    static int pos = 0;

    public static void playGame(List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
        boolean gameRunning = true;
        while (gameRunning) {
            as:
            for (int i = 0; i < players.size(); i++) {
                int num = generateNumber();
                if (players.get(i).isActive() && players.get(i).location == 0 && num != 6) {
                    System.out.println(players.get(i).getName() + " got " + num + " yet to start game");
                    continue as;
                } else if (players.get(i).isActive()) {
                    System.out.println(players.get(i).getName() + " got " + num);
                    int loc = players.get(i).location + num;
                    if (loc > 100) {
                        continue;
                    } else if (loc == 100) {
                        System.out.println(players.get(i).getName() + " completed the match on " + (pos + 1) + " position.");
                        players.get(i).setPosition(++pos);
                        players.get(i).setActive(false);
                    }
                    for (Snake s : snakes) {
                        if (s.head == loc) {
                            players.get(i).location = s.tail;
                            System.out.println(players.get(i).getName() + " is bitten by snake. New location is  " + players.get(i).getLocation());
                            continue as;
                        }
                    }
                    for (Ladder s : ladders) {
                        if (s.start == loc) {
                            players.get(i).location = s.end;
                            System.out.println(players.get(i).getName() + " is running on Ladder. New location is  " + players.get(i).getLocation());
                            i--;
                            continue as;
                        }
                    }
                    players.get(i).setLocation(loc);
                    System.out.println(players.get(i).getName() + " new location is  " + players.get(i).getLocation());
                }
                if (num == 6) {
                    i--;
                }
            }
            checkGameRunning(players);
        }

    }

    public static boolean checkGameRunning(List<Player> players) {
        int count = 0;
        for (Player p : players) {
            if (p.position > 0) {
                count++;
            }
        }
        return count >= players.size() - 1 ? true : false;
    }

}
