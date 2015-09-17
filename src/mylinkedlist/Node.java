/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;

/**
 *
 * @author apple
 */
public class Node {
    Object data;
    Node next;
    
    public Node(Object obj) {
        this.data = obj;
        this.next = null;
    }
    
    public Object getData(){
        return this.data;
    }
        
    public Node getNext(){
       return this.next;
    }
    
    public void setNext(Node _next){
        this.next = _next;
    }
    
    public String toString(){
        return data + " ";
    }
}
