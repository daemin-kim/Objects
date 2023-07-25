package chap2.initial;

import java.time.LocalDateTime;

/*
    영화 예매 시스템 설계하기

    요구사항 -> 영화 예매 시스템을 만들려고 한다. 이 시스템에서는 특정 조건을 만족시 예매자는 요금을 할인받을 수 있다.

    할인액을 결정하는 두 가지 규칙이 존재하는데, 하나는 할인 조건(Condition), 다른 하나는 할인 정책(Policy)이다.

    할인 조건은 가격의 할인 여부를 결정하며, '순서 조건', '기간 조건' 두 종류로 나뉜다.
    순서 조건 -> 상영 순번을 활용해 할인 여부를 결정함. ex) 순서 조건의 순번이 10인 경우, 매일 10번째 상영되는 영화를 예매한 사용자들은 할인 혜택을 받을 수 있다.
    기간 조건 -> 요일, 시작 시간, 종료 시간으로 구성되며, 영화 시작 시간이 해당 기간 안에 포함될 경우 요금을 할인 받을 수 있다.
    할인 조건은 다수의 할인 조건을 함께 저장할 수 있으며, 순서 조건과 기간 조건을 섞는 것도 가능하다.(여러 개의 순번 조건, 기간 조건을 같이 설정 가능)

    할인 정책은 할인 요금을 결정하며, 금액 할인 정책(Amount)과 비율 할인 정책(Percent)이 있다.
    금액 할인 정책 -> 예매 요금에서 일정 금액을 할인해주는 방식
    비율 할인 정책 -> 정가에서 일정 비율의 요금을 할인해주는 방식
    영화별로 하나의 할인 정책만 할당할 수 있으며, 할인 정책을 지정하지 않을 수도 있다.

    객체지향은 객체를 지향하는 것이다. 객체지향 언어에 익숙한 사람이라면 가장 먼저 어떤 class가 필요한지 고민할 것이다. 이후에는 클래스에 어떤 속성과 메서드가 필요한지 고민할 것이다
    하지만 이는 객체지향의 본질과는 거리가 있다.

    객체를 지향하기 위한 패러타임으로 전환하기 위해선 클래스가 아닌 객체에 초점을 맞춰야한다.
    이를 위해선 다음 2가지에 집중해야 한다.

    1. 어떤 클래스가 필요한지 고민하기 전에 어떤 객체들이 필요한지 고민하라. -> 클래스의 윤곽을 잡기 위해선 어떤 객체들이 어떤 상태와 행동을 가지는지를 먼저 결정해야 한다.
    2. 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야한다. 객체는 홀로 존재하는 것이 아니라 다른 객체에게 도움을 주거나 의존하면서 살아가는 협력적인 존재이다.
       객체를 협력하는 공동체의 일원으로 바라보는 것은 설계를 유연하고 확장 가능하게 만든다. 훌륭한 협력이 훌륭한 객체를 낳고 훌륭한 객체가 훌륭한 클래스를 낳는다.

    도메인(domain) -> 문제를 해결하기 위해 사용자가 프로그램을 사용하는 분야를 도메인이라고 부른다.

    객체지향 패러다임이 강력한 이유는 요구사항을 분석하는 초기 단계부터 프로그램을 구현하는 마지막 단계까지 객체라는 동일한 추상화 기법을 사용할 수 있기 때문이다.

 */

public class Screening {
    /*
        변수의 가시성은 private, 메서드의 가시성은 public이다. 클래스를 구현하거나 다른 개발자에 의해 개발된 클래스를 사용할 때, 가장 중요한 것은 클래스의 경계를 구분 짓는 것이다.
        클래스는 내부, 외부로 구분되며 훌륭한 클래스를 설계하기 위한 핵심은 어떤 부분을 외부에 공개하고 어떤 부분을 감출지 결정하는 것이다.
        외부에서는 객체의 속성에 직접 접근할 수 없도록 막고, 적절한 public 메서드를 통해서만 내부 상태를 변경할 수 있게 해야 한다.

        내부와 외부를 구분해야 하는 이유는 경계의 명확성이 객체의 자율성을 보장하며, 프로그래머에게 구현의 자유를 제공하기 때문이다.
     */
    private Movie movie; // 상영할 영화
    private int sequence; // 순번
    private LocalDateTime whenScreened; // 상영 시작 시간

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);

    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
