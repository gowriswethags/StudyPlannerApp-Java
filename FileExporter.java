import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileExporter {
    public static boolean exportSessions(List<StudySession> sessions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("study_sessions.txt"))) {
            for (StudySession session : sessions) {
                writer.write(session.toString());
                writer.write("\n---\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
