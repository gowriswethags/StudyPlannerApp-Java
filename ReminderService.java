import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReminderService extends Thread {
    private final StudyPlanner planner;
    private boolean running = true;

    public ReminderService(StudyPlanner planner) {
        this.planner = planner;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(60000); // Check every minute
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (StudySession session : planner.getSessions()) {
                if (!session.isComplete()) {
                    LocalDateTime sessionTime = LocalDateTime.parse(session.getDate() + " " + session.getTime(), formatter);
                    if (sessionTime.isBefore(now.plusMinutes(5)) && sessionTime.isAfter(now)) {
                        System.out.println("Reminder: Upcoming session - " + session);
                    }
                }
            }
        }
    }

    public void stopService() {
        running = false;
        this.interrupt();
    }
}
