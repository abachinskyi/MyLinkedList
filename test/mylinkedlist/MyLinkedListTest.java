
package mylinkedlist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyLinkedListTest {
    
    public MyLinkedListTest() {
    }
    public void fill(MyLinkedList list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add("a");
        list.add("b");
        list.add("c");
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEmty method, of class MyLinkedList.
     */
    @Test
    public void testIsEmty() {
        System.out.println("isEmty");
        MyLinkedList instance = new MyLinkedList();
        assertTrue(instance.isEmty());
        instance.add(1);
        assertFalse(instance.isEmty());
    }

    /** 
     * Test of add method, of class MyLinkedList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object t = null;
        t = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(t);
        Node result = instance.getHead().getNext();
        assertEquals(t,result.getData());
        t = 0.25;
        instance.add(t);
        result = result.getNext();
        assertEquals(t,result.getData());
        t = "abc";
        instance.add(t);
        result = result.getNext();
        assertEquals(t,result.getData());  
    }

    /**
     * Test of add method, of class MyLinkedList.
     */
    @Test
    public void testAdd_GenericType_int() {
        System.out.println("add(,)");
        Object t = 1;
        int index = 1;
        MyLinkedList instance = new MyLinkedList();
        instance.add(t, index);
        assertEquals(t,instance.get(index));
        t = 0.5;
        instance.add(t, index);
        assertEquals(t,instance.get(index));
        t = "abc";
        index = 2;
        instance.add(t, index);
        assertEquals(t,instance.get(index));
    }

    /**
     * Test of get method, of class MyLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 1;
        MyLinkedList instance = new MyLinkedList();
        fill(instance); // 6 elements in list   
        Object test = "test1";
        instance.add(test,index);
        Object expResult = test;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        test = "test2";
        index = 5;
        instance.add(test,index);
        expResult = test;
        result = instance.get(index);
        assertEquals(expResult, result);
        test = "test3";
        index = -100;
        expResult = null;
        result = instance.get(index);
        assertEquals(expResult, result);
        index = 100;
        expResult = null;
        result = instance.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class MyLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        
        MyLinkedList instance = new MyLinkedList();
        fill(instance); // 6 elements in list
        int index = 7;
        boolean result = instance.remove(index);
        assertFalse(result);
        assertEquals(6,instance.size());
        index = 4;
        result = instance.remove(index);
        assertTrue(result);
        assertEquals(5,instance.size());
    }

    /**
     * Test of size method, of class MyLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MyLinkedList instance = new MyLinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        fill(instance);
        expResult = 6;
        result = instance.size();
        assertEquals(expResult, result);
        instance.add("test1");
        expResult = 7;
        result = instance.size();
        assertEquals(expResult, result);
        instance.remove(3);
        expResult = 6;
        result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHead method, of class MyLinkedList.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        MyLinkedList instance = new MyLinkedList();
        Node expResult = null;
        Object test = "test";
        instance.add(test);
        Node result1 = instance.getHead();
        Node result2 = result1.getNext();
        //assertEquals(expResult, result1);
        assertEquals(test,result2.getData());
    }

    /**
     * Test of revert method, of class MyLinkedList.
     */
    @Test
    public void testRevert() {
        System.out.println("revert");
        MyLinkedList instance = new MyLinkedList();
        fill(instance);
        Node tail = instance.getHead();
        while(tail.getNext() != null){
            tail = tail.getNext();
        }
        Node expResult = tail;
        Node result = instance.revert().getNext();
        assertEquals(expResult, result);       
    }
}
