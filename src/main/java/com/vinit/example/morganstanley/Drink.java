package com.vinit.example.morganstanley;

import java.util.TreeSet;

public class Drink implements  Comparable{
    public String name;
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        Drink d1= new Drink();
        d1.name="coffee";
        Drink d2= new Drink();
        d2.name="tea";
        TreeSet<Drink> ts = new TreeSet();
        ts.add(d1);
        ts.add((d2));
        System.out.println(ts);
        for(Drink o:ts){
            System.out.println(o.name);
        }
    }
}
