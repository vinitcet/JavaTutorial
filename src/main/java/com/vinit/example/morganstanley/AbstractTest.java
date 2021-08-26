package com.vinit.example.morganstanley;

public abstract class AbstractTest {

    public int getNum() {
        return 45;
    }

    public abstract class Ber {
        public int getNum() {
            return 38;
        }
    }

    public static void main(String[] args) {
        AbstractTest ab = new AbstractTest() {

            public int getNum() {
                return 22;
            }
        };
        AbstractTest.Ber t =ab.new Ber(){
            public int getNum() {
                return 57;
            }
        };
        System.out.println(ab.getNum()+" "+t.getNum());
    }
}

