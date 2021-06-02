package com.nextlabpear.basesimple.data;


public class SimpleLinkedList<E> {


    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SimpleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public Node<E> find(int index) {

        if(index < 0 || index >= size )
            return null;

        Node<E> node = head;
        for( int i = 0; i < size; i++){
            node = node.getNext();
        }

        return node;
    }

    public void addF(E value) {
        Node<E> node = new Node<>(value);
        node.setNext(head);
        head = node;
        size++;

        if(head.getNext() == null)
            tail = head;

    }

    public void add(E value){
        if( size == 0 )
            addF(value);
        else
        {
            Node<E> node = new Node<>(value);
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    public boolean add(int index, E value){

        if(index == 0) {
            addF(value);
            size++;
            return true;
        }

        if(index == size) {
            add(value);
            size++;
            return true;
        }

        Node pre = find(index);
        if(pre != null){
            Node<E> node = new Node<>(value);
            node.setNext( pre.getNext() );
            pre.setNext(node);
            size++;
        }
        else {
            return false;
        }

        return true;
    }


    public E remove(){

        E data = head.getData();

        Node<E> node = head.getNext();
        head.setData(null);
        head.setNext(null);
        head = node;
        size--;


        if(size == 0)
            tail = null;

        return data;
    }

    public E remove( int index ){
        if(index < 0 || index >= size )
            return null;

        if(index == 0)
            return remove();

        Node<E> pre = find(index - 1);
        Node<E> node = pre.getNext();
        Node<E> next = node.getNext();

        if(next == null)
            tail = pre;

        E data = node.getData();

        node.setData(null);
        node.setNext(null);
        size--;

        pre.setNext(next);
        return data;
    }



}
