package chap1.improved;

import chap1.initial.Audience;

public class Theater { // 소극장 클래스

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience); // -> sellTo 메서드를 호출하는 간단한 코드로 바뀐다.
    }

    /*
        Audience와 TicketSeller가 직접 Bag과 TicketOffice를 처리하는 자율적인 존재가 되도록 설계를 변경하여 보자.

        우선 enter 메서드에서 TicketOffice에 접근하는 모든 코드를 TicketSeller 내부로 숨겼다.
        TicketSeller에 sellTo 메서드를 추가한 후 있던 로직을 모두 옮겼다.

        TicketSeller에서 getTicketOffice 메서드도 삭제되었으며, ticketOffice의 가시성이 private으로 설정되었기 때문에
        ticketOffice에 더 이상 직접 접근할 수 없다. 결과적으로 ticketOffice에 대한 접근은 오직 TicketSeller에게만 존재하게 된다.

        Theater는 오직 TicketSeller의 인터페이스에만 의존한다.
     */
}
