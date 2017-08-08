/**
 *
 */
package com.lutepluto.algs4.sorting.elementarysort;

import java.util.Random;

/**
 * @author lute
 */
public class DeckSort {

    public static enum Suit {
        SPADES, HEARTS, CLUBS, DIAMONDS;

        public static Suit codeOf(int code) {
            for (Suit suit : Suit.values()) {
                if (suit.ordinal() == code) {
                    return suit;
                }
            }
            return Suit.SPADES;
        }
    }

    public static class Card implements Comparable<Card> {

        private Suit suit;

        private int rank;

        public Card(Suit suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Card o) {
            if (!this.suit.equals(o.getSuit())) {
                return this.suit.ordinal() - o.getSuit().ordinal();
            }
            return this.rank - o.getRank();
        }

        /**
         * @return the suit
         */
        public Suit getSuit() {
            return suit;
        }

        /**
         * @return the rank
         */
        public int getRank() {
            return rank;
        }

    }

    public static void sort(Card[] cards) {
        for (int i = 1; i < cards.length; i++) {
            for (int j = i; j > 0 && less(cards[j], cards[j - 1]); j--) {
                exch(cards, j, j - 1);
            }
        }
    }

    private static boolean less(Card a, Card b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Card[] cards, int i, int j) {
        Card tmp = cards[i];
        cards[i] = cards[j];
        cards[j] = tmp;
    }

    public static void main(String[] args) {
        Card[] cards = generateCards();
        print(cards);
        sort(cards);
        print(cards);
    }

    private static void print(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            System.out.printf("%s-%d ", cards[i].getSuit(), cards[i].getRank());
        }
        System.out.println();
    }

    private static Card[] generateCards() {
        Random rand = new Random(System.currentTimeMillis());
        int N = rand.nextInt(20);
        Card[] cards = new Card[N];
        for (int i = 0; i < N; i++) {
            Suit suit = Suit.codeOf(rand.nextInt(4));
            int rank = rand.nextInt(14);
            cards[i] = new Card(suit, rank);
        }
        return cards;
    }

}
