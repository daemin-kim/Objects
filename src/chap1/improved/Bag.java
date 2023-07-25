package chap1.improved;

import chap1.initial.Invitation;
import chap1.initial.Ticket;

public class Bag { // 가방 클래스

    private Long amount; // 현금
    private Invitation invitation; // 초대장
    private Ticket ticket; // 티켓

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

}

/*
    기존에 Audience에 수동적인 존재였던 Bag을 스스로 자신을 책임지는 자율적인 존재로 바꿔보았다.
    Bag의 내부 상태에 접근하는 모든 로직을 Bag 안으로 캡슐화해서 결합도를 낮추었다.
 */