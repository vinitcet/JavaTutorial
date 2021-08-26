package com.vinit.example.morganstanley;

import java.util.ArrayList;
import java.util.List;

public class FirstDuplicate {
    public static void main(String[] args) {
        String s="Vinit Kumar";
        List<String> lst=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if(lst.contains(String.valueOf(s.charAt(i)))){
                System.out.println("First Duplicate is: "+s.charAt(i));
                break;
            }else{
                lst.add(String.valueOf(s.charAt(i)));
            }
        }
        System.out.println(lst);
    }

}
