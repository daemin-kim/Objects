package chap6.Theather;

import chap4and5.dataFocus.Screening;

public class PeriodCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
