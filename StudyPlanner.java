

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudyPlanner {
    private final List<StudySession> sessions = new ArrayList<>();

    public void addSession() {
        String title = Utils.input("Enter session title: ");
        String date = Utils.input("Enter session date (YYYY-MM-DD): ");
        String time = Utils.input("Enter session time (HH:MM): ");
        int priority = Integer.parseInt(Utils.input("Enter priority (1-5, 1 being the highest): "));
        String tag = Utils.input("Enter a tag (e.g., 'Math', 'Project'): ");
        sessions.add(new StudySession(title, date, time, priority, tag));
        System.out.println("Session added successfully.");
    }

    public void viewSessions() {
        if (sessions.isEmpty()) {
            System.out.println("No study sessions found.");
        } else {
            for (StudySession session : sessions) {
                System.out.println(session);
            }
        }
    }

    public void viewSessionsByPriority() {
        if (sessions.isEmpty()) {
            System.out.println("No study sessions found.");
        } else {
            sessions.stream()
                    .sorted(Comparator.comparingInt(StudySession::getPriority))
                    .forEach(System.out::println);
        }
    }

    public boolean updateSession(int sessionId, String newTitle, String newDate, String newTime) {
        for (StudySession session : sessions) {
            if (session.getId() == sessionId) {
                if (!newTitle.isEmpty()) {
                    session.setTitle(newTitle);
                }
                if (!newDate.isEmpty()) {
                    session.setDate(newDate);
                }
                if (!newTime.isEmpty()) {
                    session.setTime(newTime);
                }
                return true;
            }
        }
        return false;
    }

    public void markComplete() {
        int sessionId = Integer.parseInt(Utils.input("Enter session ID to mark as complete: "));
        for (StudySession session : sessions) {
            if (session.getId() == sessionId) {
                session.setComplete(true);
                System.out.println("Session marked as complete.");
                return;
            }
        }
        System.out.println("Session not found.");
    }

    public void viewSessionsByTag(String tag) {
        boolean found = false;
        for (StudySession session : sessions) {
            if (session.getTag().equalsIgnoreCase(tag)) {
                System.out.println(session);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No sessions found with tag: " + tag);
        }
    }

    public List<StudySession> getSessions() {
        return sessions;
    }
}
