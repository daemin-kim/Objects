package chap6;

import chap4and5.dataFocus.Screening;

public class SequenceDiscountCondition implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
