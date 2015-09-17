
package mylinkedlist;


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
    public void setData(Object _obj){
        this.data = _obj;
    }
    
    public String toString(){
        return data + " ";
    }
}
