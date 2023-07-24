package chap1.initial;

import chap1.initial.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    관람객이 소극장에 입장하기 위해서는 매표소에서 초대장을 티켓으로 교환하거나 구매해야한다.
    따라서 매표소에는 관람객에게 판매할 티켓과 티켓의 판매 금액이 보관되어 있어야 한다.

    또한 판매 금액을 더하거나 차감하는 메서드도 구현해야 한다.
 */
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
