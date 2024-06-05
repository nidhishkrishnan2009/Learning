package com.learning.datastructure;

import lombok.ToString;

public class SinglyLinkedList {
    Node head;
    public static void main(String[] args) {
        Node head=new Node(1);
        Node node1=new Node(2);
        head.next=node1;
        Node node2=new Node(3);
        node1.next=node2;
        Node tail=new Node(4);
        node2.next=tail;
        System.out.println(head);
    }

}

@ToString
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}