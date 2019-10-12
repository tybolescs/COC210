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
public class NoisyFilter2 {
    static DLinkedList<Integer> temps = new DLinkedList<>();
    public static void main(String[] args) {
        double rate = 0;
        double total = 0;
        while (total / 20 < 1) {
total = 0;
            for (int i = 0; i < 20; i++) {
generateNoisyData(90, 110, rate);// needs to be in a loop where it gets 1% until the difference between avg 2 and avg 1 equals 1%
                double avg1 = calculateAverage();
                // System.out.println("average with noisy data: " + avg1);
filterNoisyData(90, 110);
                double avg2 = calculateAverage();
                // System.out.println("average without noisy data: " + avg2);
total += Math.abs(avg2 - avg1);

}

            System.out.println("rate: " + rate + ", average difference: " + (total / 20));
rate += 0.0001;

}

}

    /**

 * Generate date between low and high with 1-noiseprob probability otherwise
 * generate some random data.
 *
 * @param low
 * @param high
 * @param noiseprob
 */

    private static void generateNoisyData(int low, int high, double noiseprob) {
        java.util.Random r = new java.util.Random();
temps = new DLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            if (Math.random() < noiseprob) {
                // currently at 1% noisy data 
                // second part of the assignment is to change this percentage
                // generate a noisy reading
temps.insertLast(r.nextInt(50));
} else {
                // generate typical Alabama summer reading
temps.insertLast(low + r.nextInt(high - low));

}

}

}

    private static double calculateAverage() {
        double total = 0;
        for (Integer temp : temps) {
total += temp;
}
        double average = total / temps.size();
        return average;

}

    /**
 * Remove any dat outside of the expected range.
 */

    private static void filterNoisyData(int low, int high) {
        Iterator<Integer> it = temps.iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (temp < low || temp > high) {

it.remove();

}

}
}
}

