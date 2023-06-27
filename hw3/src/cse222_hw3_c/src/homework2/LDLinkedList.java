package homework2;

import java.util.AbstractList;
import java.util.List;

public class LDLinkedList<E> extends AbstractList<E> implements List<E> {

    private Node<E> head ;
    private int size ;
    private int tombstones ;

    private static class Node<E> {
        E item;
        Node<E> next;
        boolean deleted = false;

        Node(E item) {
            this.item = item;
            this.next = null;
            this.deleted = false;
        }
    }

    public LDLinkedList(){
        head = null;
        size = 0;
        tombstones = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + size);
        }



        Node<E> current = this.head;
        int i = 0;
        while (current != null) {
            if (!current.deleted) {
                if (i == index) {
                    return current.item;
                }
                i++;
            }
            current = current.next;
        }
        throw new IllegalStateException("Could not find valid node at index " + index);

    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        int i = 0;
        while (current != null) {
            if (!current.deleted && i == index) {
                E oldValueToReturn = current.item; // Since the set function in Java API returns the removed item, we store it and return it at the and of the method.
                current.item = element;
                return oldValueToReturn;
            }
            if (!current.deleted) {
                i++;
            }
            current = current.next;
        }
    return current.item;

    }

    @Override
    public boolean add(E item) {
        Node<E> newNode = new Node<>(item);
        //newNode.next = null;

        Node<E> current = head;

        if (head == null) {
            head = newNode;
        }else{
            
            while(current.next != null){
                current = current.next;
            }
            
            current.next = newNode;
            current.next.next = null;

        }
        size++;
        return true;
    }

    @Override
    public E remove(int index){

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds. Size: " + size);
        }

        Node<E> current = head;

        if(tombstones < 2){
            for(int i=0;i<index;i++){
                current = current.next;
            }
            current.deleted = true;
            tombstones = tombstones + 1;
            size--;

            return current.item;
        }

        if(tombstones == 2){

            current = head;

            while(current != null){

                if(current.next.deleted == true){
                    Node<E> toRemove = current.next;
                    Node<E> toConnect = current.next.next;
                    current.next = toConnect;
                    tombstones--;
                    size--;
                    if(tombstones == 0){
                        //this.size = this.size - 2;
                        return toRemove.item;
                    }
                }

                current = current.next;
            }
        }
    return current.item;
    }

    @Override
    public int size(){
        return size;
    }








}