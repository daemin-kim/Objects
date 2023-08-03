package chap6.Theather;

import chap1.initial.Ticket;

public class Audience { // 관람객 클래스
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
