package chap4.improvedDataFocus;

import chap2.initial.Money;
import chap4.dataFocus.Customer;
import chap4.dataFocus.Reservation;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
