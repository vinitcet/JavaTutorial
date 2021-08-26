package com.vinit.example.morganstanley;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws Exception {
        // read the string filename
        String filename;
        filename = "abc.txt";
        //System.out.println(filename);
        Map<String,Integer> mm= new TreeMap<>();
        try(BufferedReader br= new BufferedReader(new FileReader(filename))){
            String line;
            while((line=br.readLine())!=null){
                String a =(line.split(" "))[0];
                if(mm.containsKey(a)){
                    mm.put(a, mm.get(a)+1);
                }else{
                    mm.put(a, 1);
                }
            }
            FileOutputStream out = new FileOutputStream("records_"+filename);
            for(Map.Entry<String, Integer> entry: mm.entrySet()){
                // System.out.println(entry.getKey()+" "+entry.getValue());
                out.write((entry.getKey()+" "+entry.getValue()).getBytes());
            }
            out.close();
        }
    }
}
