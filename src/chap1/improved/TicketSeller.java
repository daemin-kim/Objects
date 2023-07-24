package chap1.improved;

import chap1.initial.*;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }

    /*
        변경된 코드에서 Audience는 자신의 가방 안에 초대장이 있는지를 스스로 확인한다.
        외부의 제3자가 자신의 가방을 열어보도록 허용하지 않는다. Audience가 Bag을 직접 처리하기 때문에 외부에서는 더 이상
        Audience가 Bag을 소유하고 있다는 사실을 알 필요가 없다.
        이제 TicketSeller가 Audience의 인터페이스에만 의존한다.
     */
}
