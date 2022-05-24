package com.vinit.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LintLinkedList
{
    private static ListNode head;

    public static void main( String[] args )
    {
        ListNode n1 = new ListNode( 1 );
        n1.next = new ListNode( 2 );
        n1.next.next = new ListNode( 3 );
        n1.next.next.next = new ListNode( 4 );
        n1.next.next.next.next = new ListNode( 5 );
        n1.next.next.next.next.next = new ListNode( 6 );
        n1.next.next.next.next.next.next = new ListNode( 7 );
        print( n1 );
        //print( reverseBetween( n1, 3, 6 ) );
        int[] arr = {1,2,2,1};

        for( int i : arr )
        {
            insertAtEnd( i );
        }
        // System.out.println( detectCycle( head ).val );
        print( head );
        head = removeElements( head, 2 );
        print( head );

    }

    public static void insertAtEnd( int node )
    {
        if( head == null )
        {
            head = new ListNode( node );
        }
        else
        {
            ListNode last = head;
            while( last.next != null )
            {
                last = last.next;
            }
            last.next = new ListNode( node );
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 =  (h1 != null) ? h1.next : headB;
            h2 =  (h2 != null) ? h2.next : headA;
        }
        return h2;
    }

    static void print( ListNode n )
    {
        while( n != null )
        {
            System.out.print( n.val + " -> " );
            n = n.next;
        }
        System.out.println( "X" );
    }

    public ListNode reverseBetweentheir( ListNode head, int m, int n )
    {
        // Empty list
        if( head == null )
        {
            return null;
        }
        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while( m > 1 )
        {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;
        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while( n > 0 )
        {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        // Adjust the final connections as explained in the algorithm
        if( con != null )
        {
            con.next = prev;
        }
        else
        {
            head = prev;
        }
        tail.next = cur;
        return head;
    }

    public static ListNode reverseBetween( ListNode head, int left, int right )
    {
        if( head == null )
        {
            return null;
        }
        ListNode start = head;
        ListNode cur = null;
        ListNode prev2 = null;
        while( start != null )
        {
            if( start.val == left )
            {
                cur = start;
                break;
            }
            prev2 = start;
            start = start.next;
        }
        ListNode prev = null;
        ListNode next = null;
        while( cur != null )
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            if( cur.val == right )
            {
                break;
            }
        }
        prev2.next = prev;
        start.next = cur;
        return head;
    }

    public static ListNode removeElements( ListNode head, int val )
    {
        ListNode node = head;
        ListNode prev = null;
        while( node != null )
        {
            if( node.val == val && prev == null )
            {
                head = node.next;
            }
            else if( node.val == val )
            {
                prev.next = node.next;
            }
            else
            {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode removeElements2( ListNode head, int val )
    {
        if( head == null )
            return null;
        head.next = removeElements2( head.next, val );
        if( head.val == val )
            return head.next;
        else
            return head;
    }

    public static ListNode detectCycle( ListNode head )
    {
        if( head == null )
        {
            return null;
        }

        Set<Integer> ls = new HashSet<>();
        while( head.next != null )
        {
            if( ls.contains( head.val ) )
            {
                return head;
            }
            else
            {
                ls.add( head.val );
            }
            head = head.next;
        }
        return null;
    }
}

class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode( int val )
    {
        this.val = val;
    }

    ListNode( int val, ListNode next )
    {
        this.val = val;
        this.next = next;
    }


}
