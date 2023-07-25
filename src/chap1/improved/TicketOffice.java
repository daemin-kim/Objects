package chap1.improved;

import chap1.initial.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}

/*
    TicketSeller로부터 TicketOffice간의 의존성을 없애주었지만, 수정 후에 TicketOffice와 Audience간의 새로운 의존성이 추가되었다.
    전체 설계의 관점에서 결합도가 상승한 것이다. 어떻게 해야할까, 어떤 것을 우선시 해야 할까
    이는 개발팀이나 개인적인 판단에 달린 문제다. 트레이드오프의 시점이 온 것이다.

    어떤 기능을 설계하는 방법은 한 가지 이상일 수 있다.
    동일한 기능을 한 가지 이상의 방법으로 방법으로 설계할 수 있기 때문에 결국 설계는 트레이드 오프의 산물이다.
    모든 사람들을 만족시킬 수 있는 설계를 만들 수는 없다.

    설계는 균형의 예술과 같다. 훌륭한 설계는 적절한 트레이드오프의 결과물이다. 이게 어려우면서도 흥미진진한 작업이다.

    비록 현실에서는 수동적인 존재라고 하더라도 일단 객체지향의 세계에 들어오면 모든 것이 능동적이고 자율적인 존재로 바뀐다.
    이를 anthropomorphism 이라고 부른다.

    이해하기 쉽고 변경하기 쉬운 코드를 작성하고 싶으면 차라리 한 편의 애니메이션을 만든다고 생각하는 것이 편할 듯 싶다.
    코드 안에서는 웃고, 떠들고, 화내는 가방을 만날 수도 있다. 당황하지 말자.

    설계의 정의 -> 코드를 배치하는 것

    설계는 코드를 작성하는 매 순간 코드를 어떻게 배치할 것인지 결정하는 과정에서 나온다.

    initial과 improved에 있는 코드의 실행 결과는 같지만, 서로 다른 설계를 가졌다.

    그렇다면 좋은 설계란 무엇일까? 우리는 오늘 완성해야 하는 기능을 구현하는 코드를 짜는 동시에 내일 쉽게 변경할 수 있는
    코드를 짜야 한다. 좋은 설계란 오늘 요구하는 기능을 온전히 수행하면서 내일의 변경을 매끄럽게 수용할 수 있는 설계이다.

    왜 변경을 수용할 수 있는 설계가 중요한 것일까? 요구사항이 항상 변경되기 때문이다. 개발을 시작하는 시점에 구현에 필요한 모든 요구사항을 수집하는 것은 불가능하다.
    만약 되더라도 개발이 진행되는 동안 요구사항은 바뀔 수 밖에 없다.

    또한 변경을 수용할 수 있는 형태가 중요한 이유는 버그이다. 코드를 수정하지 않으면 버그는 발생하지 않겠지만 요구사항은 필연적으로 코드 수정을 초래하고
    코드 수정은 버그가 발생할 가능성을 높인다.
 */

