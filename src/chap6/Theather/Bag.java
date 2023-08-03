package chap6.Theather;

import chap1.initial.Invitation;
import chap1.initial.Ticket;

public class Bag { // 가방 클래스

    private Long amount; // 현금
    private Invitation invitation; // 초대장
    private Ticket ticket; // 티켓

    public Bag(long amount) { // 초대장 없이 현금만 보관하는 경우
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) { // 초대장과 현금을 함께 보관하는 경우
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public long hold(Ticket ticket) {
        if (hasInvitation()) {
            this.ticket = ticket;
            return 0L;
        } else {
            this.ticket = ticket;
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

}
