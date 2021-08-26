package com.vinit.example.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

public class XMLConvert {
    public static void main(String[] args) {
        Book b = new Book();
        b.setId(1l);
        b.setAuthor("VInit");
        b.setDate(new Date());
        b.setName("Padh Lo");

        Book b2 = readFile();
        System.out.println(b2.toString());
    }

    private static void createFile(Book b) {
        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(b, new File("book.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static Book readFile() {

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Book.class);
            return (Book) context.createUnmarshaller().unmarshal(new FileReader("book.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Book();
    }
}
