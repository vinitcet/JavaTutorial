package com.vinit.example.machinecode.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    private static Set<Slot> slotList = new HashSet<>();
    private static final String TWO_Wheeler = "Two-Wheeler";
    private static final String FOUR_Wheeler = "Four-Wheeler";
    private static Set<Vechicle> vehicleList = new HashSet<>();
    public static Set<Integer> free2Wheeler = new HashSet<>();
    public static Set<Integer> free4Wheeler = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //generate raw data
        createParkingLot();
        while (true) {
            displayOptions();
            int noOperation = 3;
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            if (op < 1 || op > noOperation) {
                System.out.println("Invalid operation");
            }
            if (op == 1) {
                System.out.println("Going to get free parking details");
                getFreeParking();
            }
            if (op == 2) {
                System.out.println("Going to park a vehicle");
                Vechicle vechicle;
                System.out.println("Enter Vehicle number");
                String vn = br.readLine();
                System.out.println("Enter Vehicle type");
                String vt = br.readLine();
                if (vt.contains("2")) {
                    vechicle = new Bike();
                    vechicle.setType(TWO_Wheeler);
                } else if (vt.contains("4")) {
                    vechicle = new Car();
                    vechicle.setType(FOUR_Wheeler);
                } else {
                    System.out.println("Invalid vehicle type");
                    return;
                }
                vechicle.setId(vn);
                parkVechicle(vechicle);
                vehicleList.add(vechicle);
            }
            if (op == 3) {
                System.out.println("Going to unpark a vehicle");
                System.out.println("Enter Vehicle number");
                String vn = br.readLine();
                Vechicle vechicle = null;
                for (Vechicle v : vehicleList) {
                    if (v.getId().equals(vn)) {
                        vechicle = v;
                    }
                    break;
                }
                vechicle.setId(vn);
                unparkVechicle(vechicle);
                vehicleList.remove(vechicle);
            }
        }
    }

    public static void displayOptions() {
        System.out.println("Welcome to ABC parking lot");
        System.out.println("Please enter the operation");
        System.out.println("1. Get Free parking details");
        System.out.println("2. Park a vehicle");
        System.out.println("3. Unpark a vehicle");
    }

    public static void getFreeParking() {
        int count = 0;
        for (Slot s : slotList) {
            if (s.getBookedBy() == null) {
                if (s.getSlotType() == TWO_Wheeler) {
                    free2Wheeler.add(s.getSlotId());
                } else {
                    free4Wheeler.add(s.getSlotId());
                }
            }
        }
        System.out.println("Free" + TWO_Wheeler + " parking: " + free2Wheeler.size());
        System.out.println("Free" + FOUR_Wheeler + " parking: " + free4Wheeler.size());
    }

    public static void createParkingLot() {
        //floor
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 50; j++) {
                Slot s = new Slot();
                s.setFloor(i);
                s.setSlotId(1 * 10 + j);
                s.setSlotType(TWO_Wheeler);
                slotList.add(s);
            }
            for (int j = 51; j <= 100; j++) {
                Slot s = new Slot();
                s.setFloor(i);
                s.setSlotId(1 * 10 + j);
                s.setSlotType(FOUR_Wheeler);
                slotList.add(s);
            }
        }
    }

    public static void parkVechicle(Vechicle vn) {
        if (vn.getType() == TWO_Wheeler) {
            if (free2Wheeler.size() > 1) {
                int slotId = free2Wheeler.stream().findFirst().get();
                Slot sl = null;
                for (Slot s : slotList) {
                    if (s.getSlotId() == slotId) {
                        sl = s;
                        break;
                    }
                }
                sl.setBookedBy(vn.getId());
                free2Wheeler.remove(slotId);
                System.out.println("Vehicle " + vn.getId() + " is parked at " + sl.getSlotId() + " on Floor: " + sl.getFloor());
            } else {
                System.out.println("No Parking slot is free :(");
            }
        } else {
            if (free4Wheeler.size() > 1) {
                int slotId = free4Wheeler.stream().findFirst().get();
                Slot sl = null;
                for (Slot s : slotList) {
                    if (s.getSlotId() == slotId) {
                        sl = s;
                        break;
                    }
                }
                sl.setBookedBy(vn.getId());
                free4Wheeler.remove(slotId);
                System.out.println("Vehicle " + vn.getId() + " is parked at " + sl.getSlotId() + " on Floor: " + sl.getFloor());
            } else {
                System.out.println("No Parking slot is free :(");
            }
        }
    }

    public static void unparkVechicle(Vechicle vn) {
        for (Slot s : slotList) {
            if (s.getBookedBy().equals(vn.getId())) {
                System.out.println(vn.getId() + " is going to unparked  from " + s.getSlotId() + " from " + s.getFloor() + " Floor.");
                if (s.getSlotType() == TWO_Wheeler) {
                    free2Wheeler.add(s.getSlotId());
                } else {
                    free4Wheeler.add(s.getSlotId());
                }
                break;
            }
        }
    }
}
