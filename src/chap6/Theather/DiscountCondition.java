package chap6.Theather;

import chap4and5.dataFocus.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
