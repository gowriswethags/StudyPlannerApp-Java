import java.util.Scanner;

public class StudyPlannerApp {
    private static final StudyPlanner planner = new StudyPlanner();
    private static final ReminderService reminderService = new ReminderService(planner);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            reminderService.start(); // Start reminder service

            while (true) {
                System.out.println("\n--- Study Planner Menu ---");
                System.out.println("1. Add a new study session");
                System.out.println("2. View all study sessions");
                System.out.println("3. Update a study session");
                System.out.println("4. View study sessions by priority");
                System.out.println("5. Mark a session as complete");
                System.out.println("6. Filter sessions by tag");
                System.out.println("7. Export sessions to file");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();
                System.out.println();
                System.out.println();

                switch (choice) {
                    case "1":
                        planner.addSession();
                        break;
                    case "2":
                        planner.viewSessions();
                        break;
                    case "3":
                        updateSession(scanner);
                        break;
                    case "4":
                        planner.viewSessionsByPriority();
                        break;
                    case "5":
                        planner.markComplete();
                        break;
                    case "6":
                        filterSessionsByTag(scanner);
                        break;
                    case "7":
                        exportSessionsToFile();
                        break;
                    case "8":
                        System.out.println("Goodbye!");
                        reminderService.stopService(); // Stop reminder service
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    private static void updateSession(Scanner scanner) {
        System.out.print("Enter the session ID to update: ");
        int sessionId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();

        System.out.print("Enter new date (leave blank to keep current): ");
        String newDate = scanner.nextLine();

        System.out.print("Enter new time (leave blank to keep current): ");
        String newTime = scanner.nextLine();

        if (planner.updateSession(sessionId, newTitle, newDate, newTime)) {
            System.out.println("Session updated successfully.");
        } else {
            System.out.println("Session not found.");
        }
    }

    private static void filterSessionsByTag(Scanner scanner) {
        System.out.print("Enter tag to filter by: ");
        String tag = scanner.nextLine();
        planner.viewSessionsByTag(tag);
    }

    private static void exportSessionsToFile() {
        if (FileExporter.exportSessions(planner.getSessions())) {
            System.out.println("Sessions exported successfully.");
        } else {
            System.out.println("Failed to export sessions.");
        }
    }
}
