package com.vinit.example.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MyFileReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\vinit\\Desktop\\Corona Help\\agra.txt")));
        String line;
        //System.out.println(br.readLine());
        /* while ((line = br.readLine()) != null) {
            System.out.println(line);
        }*/
        Path path = Paths.get("C:\\Users\\vinit\\Desktop\\Corona Help\\agra.txt");
        //Files.readAllLines(path);
        Stream<String> str=Files.lines(path);//.parallel();
        str.filter(s->s.contains("a")).forEach(System.out::println);

        BufferedReader br2= Files.newBufferedReader(Paths.get("C:\\Users\\vinit\\Desktop\\Corona Help\\agra.txt"));

    }
}
