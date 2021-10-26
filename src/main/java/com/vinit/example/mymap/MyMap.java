package com.vinit.example.mymap;

import java.util.ArrayList;

public class MyMap<K, V> {

    private int numBuckets = 1 << 4;
    // bucketArray is used to store array of chains
    private ArrayList<Node<K, V>> bucketArray = new ArrayList<>();

    private int size=0;

    //intializing the array
    MyMap (){
        for(int i=0;i<numBuckets;i++){
            bucketArray.add(null);
        }
    }

    public V get(K key) {
        // Find head of chain for given key
        int bucketIndex = getBucket(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        // Search key in chain
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        // If key not found
        return null;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int bucketIndex = getBucket(key);
        //getting head
        Node<K, V> head = bucketArray.get(bucketIndex);
        //Check if key is already present
        if (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
            }
            head = head.next;
        }
        size++;
        newNode.next=head;
        bucketArray.set(bucketIndex,newNode);
    }

    public V remove(K key){
        int bucketIndex= getBucket(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        Node<K, V> prev = null;
        while(head!=null){
            if(head.key.equals(key)){
                break;
            }
            prev=head;
            head=head.next;
        }
        if(head==null){
            return null;
        }
        size--;
        if(prev==null){
            bucketArray.set(bucketIndex,head.next);
        }else {
            prev.next=head.next;
        }
        return head.value;
    }

    private int getBucket(K key) {
        int hashCode = key.hashCode();
        return hashCode % numBuckets;

    }

    static class Node<K, V> {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyMap<Integer,String> testMap= new MyMap<>();
        testMap.put(1,"Vinit");
        testMap.put(2,"Priya");
        testMap.put(3,"Vihaan");
        System.out.println(testMap.get(2));
        System.out.println(testMap.get(1));
        System.out.println(testMap.size);
        System.out.println(testMap.remove(1));
        System.out.println(testMap.size);
    }
}
