/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;
import java.lang.NullPointerException;
import org.junit.Test;
public class MyLinkedList<T> {

    private Node head;
    private int listCount;

    public MyLinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public boolean isEmty() {
        return this.head.getNext() == null;
    }

    public void add(T t) {    //adds specified element to the end of list
        Node temp = new Node(t);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }

    public void add(T t, int index) {    //adds specified element to the 'index' position
        if(index > size() && index < 0){
            System.out.println("Can't add. Impermissible index.");
            return;
        }
        Node temp = new Node(t);
        Node current = head;
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }

    public Object get(int index) {
        // index must be 1 or higher
        if (index <= 0 || index > size()) {
            return null;
        }
        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean remove(int index) {
        if (index < 1 || index > size()) {
            return false;
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return true;
    }

    public int size() {
        return listCount;
    }
    
    public Node getHead(){
        return this.head;
    }
    public Node revert() {
        Node headCopy = head;
        if ( this.isEmty())
            return head;
        Node previous = null, temp = null;
        while(head.getNext()!=null){
            temp = head.getNext();
            head.setNext(previous);
            previous = head;
            if (temp == null) 
                break;
            head = temp;
            Node h1 = head  ;                
        }
        temp = headCopy; 
        head.setNext(previous);
        Node p1 = head;
        temp.setNext(p1);
        head = temp;
        return head;
    }
    public void show(){
        if(this.isEmty())
            System.out.println("empty");
        Node current = head;
        try{ 
            while( current.getNext() != null){
                System.out.print(current.getNext().getData().toString()+ " ");
                current = current.getNext();
            }
        }
        catch (NullPointerException npe){}
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Object> x1 = new MyLinkedList<>();
        x1.add(1);
        x1.add("a");
        x1.add(2);
        x1.add("b");
        x1.add(3);
        x1.add("c");
        x1.add(4);
        x1.add("d");
        x1.add(5);
        x1.show();
        Node head = x1.revert();
        x1.show();
        System.out.println(x1.get(0).toString());
    }
}
