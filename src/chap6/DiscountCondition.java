package chap6;

import chap4and5.dataFocus.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
