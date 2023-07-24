package chap1.improved;

import chap1.initial.Bag;
import chap1.initial.Ticket;

public class Audience { // 관람객 클래스
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // buy 메서드는 인자로 전달된 Ticket을 Bag에 넣은 후, 지불된 금액을 반환한다.
    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        }
        else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}

