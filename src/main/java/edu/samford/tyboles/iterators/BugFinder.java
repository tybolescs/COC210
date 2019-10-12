/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.tyboles.iterators;

import edu.samford.tyboles.lists.DLinkedList;
import java.util.Iterator;

/**
 *
 * @author Tyrone
 */
public class BugFinder {
    public static void main(String[] args) {
        DLinkedList<Integer> ints = new DLinkedList<>();
        ints.insertLast(25);
        ints.insertLast(35);
        ints.remove(ints.first());
        ints.insertLast(45);
        ints.insertLast(15);
        System.out.println("after removing: " + ints.size());
        Iterator<Integer> it = ints.iterator();
        it.next();
        it.remove();
        it.next(); // this should FAIL!!!!!!!
    }
}
