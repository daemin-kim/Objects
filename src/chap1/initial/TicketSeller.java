package chap1.initial;

/*
    판매원은 매표소에서 초대장을 티켓으로 교환해주거나, 티켓을 판매하는 역할을 수행하며
    판매원은 자신이 일하는 매표소를 알고 있어야 한다.
 */

import chap1.initial.TicketOffice;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}

