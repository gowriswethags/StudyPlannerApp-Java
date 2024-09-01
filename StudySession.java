

public class StudySession {
    private static int counter = 0;
    private final int id;
    private String title;
    private String date;
    private String time;
    private int priority;
    private boolean isComplete;
    private String tag;

    public StudySession(String title, String date, String time, int priority, String tag) {
        this.id = ++counter;
        this.title = title;
        this.date = date;
        this.time = time;
        this.priority = priority;
        this.tag = tag;
        this.isComplete = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Session ID: " + id +
                "\nTitle: " + title +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nPriority: " + priority +
                "\nTag: " + tag +
                "\nComplete: " + (isComplete ? "Yes" : "No") + "\n";
    }
}
