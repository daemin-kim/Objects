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

        캡슐화를 개선한 후에 가장 크게 달라진 점은 Audience와 TicketSeller가 내부 구현을 외부에 노출하지 않고
        자신의 문제를 스스로 책임지고 해결한다는 것이다.

        수정된 Audience와 TicketSeller는 코드를 읽는 사람과의 의사소통을 원활하게 할 수 있도록 바뀌었고
        Audience나 TicketSeller의 내부 구현을 변경하더라도, Theater를 함께 변경할 필요가 없어졌다.

        객체의 자율성을 높이는 방향으로 설계를 개선한 것이다.
        핵심은 객체 내부의 상태를 캡슐화하고 객체 간의 오직 메시지를 통해서만 상호작용하도록 만드는 것이다.
     */
}
