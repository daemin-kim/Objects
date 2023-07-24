package chap1.initial;

/*
    이벤트에 당첨된 사람은 초대장을, 아닌 사람은 티켓을 구매할 수 있는 현금을 가지고 올 수 있음으로
    관람객이 소지품(초대장, 현금, 티켓)을 보관할 수 있는 가방을 들고 올 수 있다고 가정하자.
 */

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

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

}
