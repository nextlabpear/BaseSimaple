package com.nextlabpear.basesimple.data;

public class Node<E> {

    private Node<E> next;
    private E data;

    Node(E data){
        this.data = data;
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getData() {
        return data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> clone(){
        Node<E> node = null;
        try{
            node = (Node<E>)super.clone();
        }catch (Exception ex){

        }
        return node;
    }
}
