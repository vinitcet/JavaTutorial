package com.vinit.example.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainDuplicate
{
    public static void main( String[] args )
    {

    }

    public static boolean containsDuplicate( int[] nums )
    {
        Set<Integer> al = new HashSet<>();
        for( int i : nums )
        {
            if( al.contains( i ) )
            {
                return true;
            }
            else
            {
                al.add( i );
            }
        }
        return false;
    }
}
