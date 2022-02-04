import stdlib.StdOut;

import java.util.Comparator;
import java.util.Iterator;

public class Genome implements Iterable<Character>, Comparable<Genome> {
    private String s; // instance variable to hold the Genome sequence string

    // constructs a Genome object
    Genome(String s) {
        boolean valid = true;
        for (char c: s.toCharArray()) {
            // checking to make sure the correct letters are in sequence
            valid = ((c == 'A') || (c <= 'C')) || ((c >= 'T') || (c <= 'G'));
            if (!valid) {
                throw new IllegalArgumentException("Can Only contain A,C,T,G");
            }
        }
        this.s = s;
    }
    // returns (G + C) / (A + T + G + C) * 100 for this genome.
    public double gcContent() {
        int gc = 0;
        for (char c: s.toCharArray()) {
            if (c == 'G' || c == 'C') {
                gc++;
            }
        }
        return 100.0 * gc / s.length();
    }
    // Returns a string representation of this genome.
    public String toString() {
        return s.length() + ":" + s;
    }
    // Returns a comparison of this and other genome based on their lengths.
    public int compareTo(Genome other) {
        int x = this.s.length();
        int y = other.s.length();
        if (x < y) {
            return -1;
        } else if (x == y) {
            return 0;
        } else {
            return 1;
        }

    }
    // Returns a comparator for comparing genomes based on their GC content.
    public static Comparator<Genome> gcOrder() {
        return new GCOrder();
    }
    // Returns an iterator for iterating over this genome in reverse order.
    public Iterator<Character> iterator() {
        return new ReverseIterator();
    }

    // A comparator for comparing genomes based on their GC content.
    private static class GCOrder implements Comparator<Genome> {
        // Returns a comparison of g1 and g2 based on ghe GC content
        public int compare(Genome g1, Genome g2) {
            double x = g1.gcContent();
            double y = g2.gcContent();
            if (x < y) {
                return -1;
            } else if (x == y) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    // An iterator for iterating over genome in reverse order
    private class ReverseIterator implements Iterator {
        private int i; // index of current letter in genome.
        // constructs an iterator
        public ReverseIterator() {
            this.i = s.length() - 1;
        }
        // Returns true if there are more letters in the genome and false
        // otherwise
        public boolean hasNext() {
            return i >= 0;
        }
        // Returns the next letter in the genome
        public Object next() {
            return s.charAt(i--);
        }
    }

    // Unit Tests the data tye [DO NOT EDIT]
    public static void main(String[] args) {
        Genome g1 = new Genome(args[0]);
        Genome g2 = new Genome(args[1]);
        StdOut.println("g1                       = " + g1);
        StdOut.println("g2                       = " + g2);
        StdOut.println("g1.gcContent()           = " + g1.gcContent());
        StdOut.println("g2.gcContent()           = " + g2.gcContent());
        StdOut.println("g1.compareTo(g2)         = " + g1.compareTo(g2));
        StdOut.println("GCOrder::compare(g1, g2) = " + Genome.gcOrder().compare(g1, g2));
        StdOut.print("reverse(g1)              = ");
        for (char c : g1) {
            StdOut.print(c);
        }
        StdOut.println();
    }
}