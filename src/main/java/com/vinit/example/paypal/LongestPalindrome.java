package com.vinit.example.paypal;

/*Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.*/
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        char c = 'a';
        System.out.println(Integer.valueOf(c));
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        //cnt is a count array
        //OddCount is whether there is an odd number of characters, 1 means yes, 0 means no
        //ans is the final answer
        int[] cnt = new int[52];
        int OddCount = 0;
        int ans = 0;
        // Count the number of occurrences of each letter in the string s
        for (char c : s.toCharArray()) {
            // are lowercase letters a-97
            if (c >= 97) {
                cnt[26 + c - 'a']++; // a=> 26+97-97 = 26
            }
            // are uppercase letters A-65
            else {
                cnt[c - 'A']++;// A=>65-66=0
            }
        }
        // Each character can be used cnt/2*2 times
        // If a character appears odd number of times, change the OddCount value to 1
        for (int i = 0; i < 52; i++) {
            ans += cnt[i] / 2 * 2; //handled both even and odd number
            if (cnt[i] % 2 == 1) {
                OddCount = 1; // odd count is alwways set to 1 independent of no of odd counts
            }
        }
        //If a character appears an odd number of times, the answer is increased by 1
        ans += OddCount;
        return ans;
    }

    // Function to find the longest palindrome by removing
// or shuffling characters from the given string
    static String findLongestPalindrome(String str) {
        // to stores freq of characters in a string
        int count[] = new int[256];

        // find freq of characters in the input string
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        // Any palindromic string consists of three parts
        // beg + mid + end
        String beg = "", mid = "", end = "";

        // solution assumes only lowercase characters are
        // present in string. We can easily extend this
        // to consider any set of characters
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // if the current character freq is odd
            if (count[ch] % 2 == 1) {
                // mid will contain only 1 character. It
                // will be overridden with next character
                // with odd freq
                mid = String.valueOf(ch);

                // decrement the character freq to make
                // it even and consider current character
                // again
                count[ch--]--;
            } // if the current character freq is even
            else {
                // If count is n(an even number), push
                // n/2 characters to beg string and rest
                // n/2 characters will form part of end
                // string
                for (int i = 0; i < count[ch] / 2; i++) {
                    beg += ch;
                }
            }
        }

        // end will be reverse of beg
        end = beg;
        end = reverse(end);

        // return palindrome string
        return beg + mid + end;
    }

    static String reverse(String str) {
        // convert String to character array
        // by using toCharArray
        String ans = "";
        char[] try1 = str.toCharArray();

        for (int i = try1.length - 1; i >= 0; i--) {
            ans += try1[i];
        }
        return ans;
    }
}
