package com.nextlabpear.basesimple.data;

public class SimpleLinkedList {

    private Node head;
    private Node end;
    private int size;

    public SimpleLinkedList(){
        head = null;
        end = null;
        size = 0;
    }

    public boolean add(int index, Node node) {
        if( index < 0 || index > this.size - 1 )
            return false;

        Node next = null;
        if( index == 0 ) {
            if(this.head == null) {
                this.head = new Node();
                this.head.setNext( node );
                end= node;
            }
            else {
                next = this.head.getNext();
                node.setNext(next);
                this.head.setNext(node);
            }
        }
        else {
            Node point = this.head;
            for( int i = 0; i < index - 1; i++ ) {
                point = point.getNext();
                node = point.getNext();
            }

            if(next != null)
                node.setNext( next );
            point.setNext(node);
        }

        this.size++;
        return true;
    }

    public void add(Node node){
        if(this.head == null) {
            this.head = new Node();
            this.head.setNext( node );
        }
        else {
            Node next = this.head.getNext();

            node.setNext(this.head);
            for( )

        }
    }

}
