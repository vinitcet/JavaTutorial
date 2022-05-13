package com.vinit.algorithm.lnklist;

public class MyLinkedList
{

    public static void display( Node node )
    {
        Node head = node;
        while( head != null )
        {
            System.out.print( head.data + " -> " );
            head = head.next;
        }
        System.out.println( "X" );
    }

    public static void displayRecursive( Node node )
    {
        if( node != null )
        {
            System.out.print( node.data + " -> " );
            displayRecursive( node.next );
        }
    }

    public static void displayRecursiveReverse( Node node )
    {
        if( node != null )
        {
            displayRecursiveReverse( node.next );
            System.out.print( node.data + " <- " );
        }
    }

    public static int countElements( Node node )
    {
        int count = 0;
        while( node != null )
        {
            node = node.next;
            count++;
        }
        return count;
    }

    public static int countElementRecursive( Node node )
    {
        if( node != null )
        {
            return countElementRecursive( node.next ) + 1;
        }
        else
        {
            return 0;
        }
    }

    public static int sumElements( Node node )
    {
        int sum = 0;
        while( node != null )
        {
            sum += node.data;
            node = node.next;

        }
        return sum;
    }

    public static int sumElementRecursive( Node node )
    {
        if( node != null )
        {
            return node.data + sumElements( node.next );
        }
        else
        {
            return 0;
        }
    }

    public static int max( Node node )
    {
        int m = Integer.MIN_VALUE;
        while( node != null )
        {
            if( node.data > m )
            {
                m = node.data;
                node = node.next;
            }
        }
        return m;
    }

    public static int maxRecursive( Node node )
    {
        int x = 0;
        if( node != null )
        {
            x = maxRecursive( node.next );
            return x > node.data ? x : node.data;
        }
        else
        {
            return Integer.MIN_VALUE;
        }
    }

    public static Node search( Node node, int data )
    {
        while( node != null )
        {
            if( data == node.data )
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static Node searchRecursive( Node node, int data )
    {
        if( node == null )
        {
            return null;
        }
        if( node.data == data )
        {
            return node;
        }
        return searchRecursive( node.next, data );
    }

    public static void main( String[] args )
    {
        Node n1 = new Node( 3 );
        n1.next = new Node( 4 );
        n1.next.next = new Node( 5 );
        //display( n1 );
        Node test = n1;
        //displayRecursive( test );
        //displayRecursiveReverse( n1 );
        // System.out.println( countElements( n1 ) );
        // System.out.println( countElementRecursive( test ) );
        //System.out.println( sumElements( n1 ) );
        //System.out.println( sumElementRecursive( test ) );4
        // System.out.println( maxRecursive( test ) );
        // System.out.println( max( n1 ) );
        System.out.println( searchRecursive( test, 3 ).toString() );
        System.out.println( search( n1, 3 ).toString() );
    }


}

class Node
{
    int data;
    Node next;

    public Node( int data )
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "Node{" +
            "data=" + data +
            '}';
    }
}
