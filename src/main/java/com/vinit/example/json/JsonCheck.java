package com.vinit.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinit.example.jaxb.Book;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.DataInput;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class JsonCheck {
    public static void main(String[] args) {
        Book b = new Book();
        b.setId(1l);
        b.setAuthor("VInit");
        b.setDate(new Date());
        b.setName("Padh Lo");
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString= null;
        try {
             jsonString = objectMapper.writeValueAsString(b);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);

        ObjectMapper rev = new ObjectMapper();
        try {
            Book b2=rev.readValue(jsonString,Book.class);
            System.out.println(b2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
