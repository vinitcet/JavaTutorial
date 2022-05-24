package com.vinit.example.leet;

public class LengthLastWord
{
    public static void main( String[] args )
    {
        String s = "   fly me   to   the moon  ";
        System.out.println( lengthOfLastWordFaster( s ) );
        System.out.println( lengthOfLastWord( s ) );
    }

    public static int lengthOfLastWord( String s )
    {
        //s = s.trim();
        String[] str = s.split( " " );
        return str[str.length - 1].length();
    }

    public static int lengthOfLastWordFaster( String s )
    {
        int length = 0;
        for( int i = ( s.length() - 1 ); i >= 0; i-- )
        {
            if( s.charAt( i ) == ' ' )
            {
                if( length > 0 )
                {
                    return length;
                }
            }
            else
            {
                length++;
            }
        }
        return length;
    }
}
