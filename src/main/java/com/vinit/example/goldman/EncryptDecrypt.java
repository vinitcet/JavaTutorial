package com.vinit.example.goldman;


public class EncryptDecrypt {

    public static void main(String[] args) {

        System.out.println(secureChannel(1, "Open", "321"));
        System.out.println(secureChannel(2, "Oppeeennnn", "123"));
    }


    static String secureChannel(int operation, String message, String key) {
        if (operation == 1) {
            if (message == null || message.trim() == " " || key == null || key == " ")
                System.out.println(message);

            int msgLen = 0;
            int keyLen = 0;
            StringBuilder sb = new StringBuilder();
            while (keyLen != key.length() && msgLen != message.length()) {
                int count = (key.charAt(keyLen) - '1') + 1;
                char ch = message.charAt(msgLen);
                while (count != 0) {
                    sb.append(ch);
                    count--;
                }
                keyLen++;
                msgLen++;
            }
            while (msgLen != message.length()) {
                sb.append(message.charAt(msgLen));
                msgLen++;
            }

            return sb.toString();
        } else if (operation == 2) {
            if (message == null || message == " " || key == null || key == " ")
                System.out.println(message);
            int msgLen = 0;
            int keyLen = 0;
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            while (keyLen != key.length() && msgLen != message.length()) {
                int count = (int) key.charAt(keyLen) - '1' + 1;
                counter = counter + count;
                char ch = message.charAt(counter - 1);
                sb.append(ch);
                keyLen++;
                msgLen = counter;
            }
            while (msgLen != message.length()) {
                sb.append(message.charAt(msgLen));
                msgLen++;
            }
            return sb.toString();
        }
        return null;
    }
}