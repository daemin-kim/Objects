package chap1.initial;

public class Theater { // 소극장 클래스

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        }
        else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}

/*
    이 작은 프로그램은 몇 가지 문제점을 가지고 있다.

    먼저, enter 메서드가 수행하는 일을 말로 풀어보면 다음과 같다

    소극장은 먼저 관람객의 가방 안에 초대장이 들어 있는지 확인하고, 만약 초대장이 들어 있다면, 이벤트에 당첨된 관람객임으로 판매원에게서 받은 티켓을 관람객의 가방에 넣어준다.
    가방 안에 초대장이 없다면 티켓을 판매해야 한다. 이 경우 소극장은 관람객의 가방에서 티켓 금액만큼을 차감한 후, 매표소의 금액을 증가시킨다.
    마지막으로 소극장은 관람객의 가방 안에 티켓을 넣어줌으로써 관람객의 입장 절차를 끝낸다.

    문제는 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재라는 점이다.

    자신이 관람객이라고 가정하였을 때, 소극장이라는 제 3자가 초대장을 확인하기 위해 가방을 마음대로 열어보고, 내용물을 확인한 뒤, 돈을 가져간다고 생각하면 기분이 좋지 않을 것이다

    자신이 판매원이라고 가정하여도, 동일한 문제가 발생한다. 소극장이 판매원의 허락 없이 매표소에 보관중인 티켓과 현금에 마음대로 접근하고, 티켓이 하나씩 사라지고
    돈이 쌓이는 모습을 보고만 있어야 한다.

    현재의 코드는 우리의 상식과는 너무나도 다르게 동작하기 때문에 코드를 읽는 사람과 의사소통에도 문제가 생긴다.

    그리고 이 코드는 여러 가지 세부적인 내용을 모두 기억하고 있어여 하기 때문에, 작성하는 사람뿐만 아니라 읽는 사람 모두에게 부담을 준다.

    가장 큰 문제는, Audience와 TicketSeller를 변경할 경우 Theater도 함께 변경하여야 한다는 문제다.

    이 코드는 관람객이 현금과 초대장을 보관하기 위해 가방을 소지하고 있다고 가정하고 있으며, 판매원이 매표소에서만 티켓을 판매한다고 가정한다.
    관람객이 가방을 가지고 있지 않거나, 현금이 아닌 카드로 결제를 하려고 한다면 어떻게 할까? 이러한 가정이 흔들리는 순간 코드도 흔들리게 된다.

    이것은 객체 사이의 의존성(dependency)와 관련된 문제이다.

    의존성은 변경에 대한 영향을 암시한다. 어떤 객체가 변경될 때 그 객체에게 의존하는 다른 객체도 함께 변경될 수 있다는 사실이 내포되어 있기 때문이다.

    그렇다고 객체 사이의 의존성을 완전히 없애는 것이 정답은 아니다. 객체지향 설계는 서로 의존하면서 협력하는 객체들의 공동체를 구축하는 것이기 때문이다.

    우리는 애플리케이션의 기능을 구현하는 데 필요한 최소한의 의존성만을 유지하고 불필요한 의존성을 제거하여야 한다.

    객체 사이의 의존성이 과한 경우 결합도(coupling)가 높다고 한다. 반대로 객체들의 합리적인 수준으로 의존할 경우 결합도가 낮다고 한다.

    두 객체 사이의 결합도를 낮춰 변경이 용이하도록 설계를 만드는 것이 설계의 목표가 되어야 한다.

 */























