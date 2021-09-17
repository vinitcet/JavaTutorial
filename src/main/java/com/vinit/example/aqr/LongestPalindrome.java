package com.vinit.example.aqr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "aliban fighters were killed in fight against Afghan resistance forces in Afghanistan’s northeastern province aba of Panjshir, the resistance forces have claimed. vinitiniv Taliban and opposition forces battled on Saturday to control the Panjshir Valley north of Kabul, the last Afghan province holding out against the Islamist group, with both sides claiming to have the upper hand without producing conclusive evidence.";
        str.replace(",", " ");
        str.replace(".", " ");
        List<String> chara = Arrays.asList(str.split(" "));
        System.out.println(chara);
        Map<String, Integer> palindromemap = new HashMap<>();
        for (String s : chara) {
            if (s.toString().trim().length() > 2) {
                if (
                        IntStream.range(0, s.trim().length() / 2).noneMatch(i -> s.trim().charAt(i) != s.trim().charAt(s.trim().length() - i - 1))
                ) {
                    palindromemap.putIfAbsent(s.trim(), s.trim().length());
                }
            }
        }
        System.out.println(palindromemap);
    }

}

