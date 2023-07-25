package chap1.improved;

import chap1.initial.Ticket;

public class Audience { // 관람객 클래스
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // buy 메서드는 인자로 전달된 Ticket을 Bag에 넣은 후, 지불된 금액을 반환한다.
    // Bag의 구현을 캡슐화시켰으니 이제 Audience를 Bag의 구현이 아닌 인터페이스에만 의존하도록 수정하였다.
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}

