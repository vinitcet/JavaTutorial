package com.vinit.example.model;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) {
        Users user = new Users();
        user.setId(1);
        user.setName("Vinit");
        //Serialization
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("users.ser"));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
        //    objectOutputStream.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ByteStream written");
        //Deserialzation
        try (
                FileInputStream fileInputStream = new FileInputStream(new File("users.txt"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Users getUser = (Users) objectInputStream.readObject();
            System.out.println(getUser.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
