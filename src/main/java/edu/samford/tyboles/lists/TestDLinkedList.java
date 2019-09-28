/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.tyboles.lists;
import java.util.ArrayList;
/**
 *
 * @author Tyrone
 */
public class TestDLinkedList {
    public static void main(String[] args) {
        DLinkedList<String> list= new DLinkedList<>();
        DLinkedList<Integer> ratings = new DLinkedList<>();
        ArrayList<Double> area = new ArrayList<>();
        
        
        //test an empty list
        System.out.println("size==0:              " + list.size());
        System.out.println("toString=='':         " + list.toString());
        System.out.println("size==0:              " + ratings.size());
        System.out.println("toString=='':         " + ratings.toString());
        System.out.println("size==0:              " + area.size());
        System.out.println("toString==''          " + area.toString());
        
        // test a one item list
        long starttime = System.nanoTime();
        list.insertFirst("BHM");
        long finishtime = System.nanoTime();
        System.out.println("insertFirst - one item list - " + (finishtime-starttime));
        ratings.insertFirst(10);
        area.add(0,3.2);
        System.out.println("size ==1:             " + list.size());
        System.out.println("toString=='BHM,':     " + list.toString());
        System.out.println("size==1:              " + ratings.size());
        System.out.println("toString=='10':       " + ratings.toString());
        System.out.println("size==1:              " + area.size());
        System.out.println("toString=='[3.2]'     " + area.toString());
        
        
        //test a two item list
        list.insertLast("ATL");
        ratings.insertLast(7);
        area.add(6.4);
        System.out.println("size==2:                   " + list.size());
        System.out.println("toString=='BHM,ATL,':      " + list);
        System.out.println("size==2:                   " + ratings.size());
        System.out.println("toString=='10,7':          " +ratings.toString());
        System.out.println("size==3:                   " + area.size());
        System.out.println("toString=='[3.2,6.4]'      " + area.toString());
        
         
    }
}
