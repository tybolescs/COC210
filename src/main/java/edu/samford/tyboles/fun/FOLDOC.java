/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.tyboles.fun;

import edu.samford.tyboles.lists.DLinkedList;
import edu.samford.tyboles.trees.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Tyrone
 */
public class FOLDOC {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner filein = new Scanner(new File("Dictionary.txt"));
        String currentTerm = "";
        String currentDefinition = "";
        DLinkedList<FOLDOCTerm> list = new DLinkedList<>();
        BST<FOLDOCTerm> bst = new BST<>();
        while (filein.hasNextLine()) {
            String nextLine = filein.nextLine();
            if (nextLine.trim().equals("")) {
                // we must have a blank link... let's add a blanklin to the beginning
                currentDefinition += "\n";
            } else if (nextLine.charAt(0) == '\t') {
                // we must be still going with the current definition
                currentDefinition += nextLine.trim() + "\n";
            } else {
                // we must have encountered a new term
                // so...
                // 1. Add the old term(if there was one) to our data structure(s)
                if (!currentTerm.equals("")) {
                    FOLDOCTerm newterm = new FOLDOCTerm(currentTerm.trim(), currentDefinition.trim());
                    list.insertLast(newterm);
                    bst.add(newterm);

                }

                // 2. Grab the new term
                currentTerm = nextLine.trim();

                // 3. Reset the current definition
                currentDefinition = "";
            }

        }
        
        //bst.rebalance();
        System.out.println("Linked list: " + list.size() + " terms.");
        System.out.println("Binary search tree: " + bst.size() + " terms.");
        Scanner stdin = new Scanner(System.in);
        while (true) {
            System.out.print("What term would you like to find? ");
            String searchstr = stdin.nextLine();  // retrieves the search term
            if (searchstr.equals("-exit-")) {
                break;   // exit out of the loop because the user must have entered -exit-
            }
            // now perform the search on both data structures, measuring how long it takes
            System.out.println("Searching for: " + searchstr);  // temporary debugging display
            FOLDOCTerm faketerm = new FOLDOCTerm(searchstr, ""); // note the empty definition
            long start = System.nanoTime();         // code to be measured
            Object listhit = list.search(faketerm);
            long finish = System.nanoTime();
            long duration = finish - start;
            long start2 = System.nanoTime();         // code to be measured
            Object bsthit = bst.search(faketerm);
            long finish2 = System.nanoTime();
            long duration2 = finish2 - start2;
            System.out.println(listhit + "," + bsthit);
            System.out.println(duration + "," + duration2);
        }
    }
}
