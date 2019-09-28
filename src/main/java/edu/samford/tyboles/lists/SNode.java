/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.tyboles.lists;

/**
 *
 * @author Tyrone
 */
public class SNode<T> {
    
    // Attributes
    protected T e; // the "element" (i.e., data) stored at this node
    protected SNode<T> next; // the "link" (i.e., reference) to the next node 
    
    public SNode (T e, SNode<T> next) {
        this.e =e;
        this.next = next;
        
    }
    
    public SNode<T> getNext() {
        return next;
    }
    
    public void setNext(SNode<T> next) {
        this.next = next;
    }
    
    public T element() {
        return e;
    }
    
    public void setElement(T e) {
        this.e = e;
    }
}
