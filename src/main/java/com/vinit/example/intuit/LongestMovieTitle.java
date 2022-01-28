package com.vinit.example.intuit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LongestMovieTitle {
    public static List<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {
        //String[] str = {"OF MICE AND MEN", "MEN IN BLACK", "BLACK MASS"};
        //String[] str = {"OF MICE AND MEN", "BLACK MASS", "MEN IN BLACK"};
        String[] str = {"Mission apple", "Mission Mission", "apple Impossible", "apple k apple", "apple d apple", "z apple a", "z x c",
                "Impossible a", "a b c", "c d", "Impossible Impossible", "Impossible apple", "a a", "apple z", "d e", "e f"};
        System.out.println("The longest movie name can be: " + LongestMovie(str));
    }

    public static String LongestMovie(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                //adding in end
                if (str[i].substring(str[i].lastIndexOf(" ") + 1).equalsIgnoreCase(str[j].substring(0, str[j].indexOf(" ")))) {
                    Movie m = new Movie();
                    m.setStart(str[i].substring(0, str[i].indexOf(" ")));
                    m.setEnd(str[j].substring(str[j].lastIndexOf(" ") + 1));
                    m.setCount(2);
                    m.setSentence(str[i] + str[j].substring(str[j].indexOf(" ")));
                    movieList.add(m);
                }
                //adding in the start
                if (str[j].substring(str[j].lastIndexOf(" ") + 1).equalsIgnoreCase(str[i].substring(0, str[i].indexOf(" ")))) {
                    Movie m = new Movie();
                    m.setStart(str[j].substring(0, str[j].indexOf(" ")));
                    m.setEnd(str[i].substring(str[i].lastIndexOf(" ") + 1));
                    m.setCount(2);
                    m.setSentence(str[j] + str[i].substring(str[i].indexOf(" ")));
                    movieList.add(m);
                }
            }
            List<Movie> internalMovie = new ArrayList<>();
            //checking in the list
            for (Movie m : movieList) {
                if (m.getStart().trim().equalsIgnoreCase(str[i].substring(str[i].lastIndexOf(" ") + 1))) {
                    Movie mi = new Movie();
                    mi.setStart(str[i].substring(0, str[i].indexOf(" ")));
                    mi.setEnd(m.end);
                    mi.setCount(m.getCount() + 1);
                    mi.setSentence(str[i] + m.getSentence().substring(m.getSentence().indexOf(" ")));
                    internalMovie.add(mi);
                }
                if (m.getEnd().trim().equalsIgnoreCase(str[i].substring(0, str[i].indexOf(" ")))) {
                    Movie mi = new Movie();
                    mi.setStart(m.getStart());
                    mi.setEnd(str[i].substring(str[i].lastIndexOf(" ") + 1));
                    mi.setCount(m.getCount() + 1);
                    mi.setSentence(m.getSentence() + str[i].substring(str[i].indexOf(" ")));
                    internalMovie.add(mi);
                }
            }
            movieList.addAll(internalMovie);
        }
        movieList.stream().forEach(s -> System.out.println(s.getSentence()));
        int max = 0;
        String op = "";
        for (Movie m : movieList) {
            if (m.getCount() > max) {
                max = m.getCount();
                op = m.getSentence();
            }
        }

        return op;
    }

}

class Movie {
    String start;
    String end;
    int count;
    String sentence;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}