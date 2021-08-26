package com.vinit.example.morganstanley;

public class WordWrap {
    public static void main(String[] args) {
        String str = "This is to acknowledge the receipt from VINIT KUMAR the sum of rupees 8333/- (Rs. Eight Thousand Three Hundred Thirty Three only towards house rent for the month of April 2019, towards the property bearing the address 888, 3rd Floor, 9th Cross, 16th Main, BTM Layout, 2nd Stage (EWS), Bangalore -560076\n";
        Integer line = 30;
        printWordWrap(str, line);
    }

    public static void printWordWrap(String str, Integer line) {
        if (str.length() < line) {
            System.out.println(str);
            return;
        }
        int loc;
        String istr = str.substring(0, line);
        if (istr.endsWith(" ")) {
            loc = 30;
        } else {
            loc = (istr.lastIndexOf(" "));
        }
        String strp = str.substring(0, loc);
        System.out.println(strp);

        printWordWrap(str.substring(loc), line);


    }
}
