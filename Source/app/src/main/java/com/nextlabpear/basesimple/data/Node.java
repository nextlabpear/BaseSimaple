package com.nextlabpear.basesimple.data;

public class Node {

    private Node next;
    private int data;

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }
}
