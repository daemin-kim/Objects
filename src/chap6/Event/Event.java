package chap6.Event;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
        !from.toLocalTime().equals(schedule.getFrom()) ||
        !duration.equals(schedule.getDuration())) {
            // reschedule(schedule);
            // Event가 RecurringSchedule에 설정된 조건을 만족하지 못할 경우 Event의 상태를 조건을 만족시키도록 변경한 후 (문제가 되는 곳) false를 반환한다.
            // 명령과 쿼리의 두 가지 역할을 동시에 수행하고 있다. 개념적으로는 쿼리, 실제로는 부수효과를 가지는 명령이다.
            return false;
        }
        return true;
    }
    // 반환값을 가지면 쿼리, 반환값을 가지지 않으면 명령
     public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)), schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
