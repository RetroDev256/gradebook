import java.util.Scanner;

public class Main {
    private static final Database db = new Database();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("--- Gradebook REPL\n");
        printMenu();

        while (true) {
            System.out.print("\nREPL: ");
            switch (scanner.nextLine().trim()) {
                case "1" -> addStudent();
                case "2" -> addTeacher();
                case "3" -> addCourse();
                case "4" -> enrollStudent();
                case "5" -> addAssignment();
                case "6" -> addGrade();
                case "7" -> showReportCard();
                case "0" -> {
                    return;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.print("Options:\n");
        System.out.print("[1] Add Student\n");
        System.out.print("[2] Add Teacher\n");
        System.out.print("[3] Add Course\n");
        System.out.print("[4] Add Enrollment\n");
        System.out.print("[5] Add Assignment\n");
        System.out.print("[6] Add Grade\n");
        System.out.print("[7] View Report Card\n");
        System.out.print("[0] Exit\n");
    }

    private static String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (line.length() != 0)
                return line;
            System.out.print("Try again.\n");
        }
    }

    private static int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Try again.\n");
            }
        }
    }

    private static Gender inputGender() {
        System.out.print("Valid gender options:\n");
        System.out.print("MALE / FEMALE / NON_BINARY\n");
        while (true) {
            System.out.print("Enter Gender: ");
            String gender_str = scanner.nextLine();
            switch (gender_str.toUpperCase().trim()) {
                case "MALE" -> {
                    return Gender.MALE;
                }
                case "FEMALE" -> {
                    return Gender.FEMALE;
                }
                case "NON_BINARY" -> {
                    return Gender.NON_BINARY;
                }
                case "" -> {
                    return Gender.UNSPECIFIED;
                }
                default -> {
                    System.out.print("Invalid option.\n");
                }
            }
        }

    }

    private static void addStudent() {
        String first = inputString("Enter student's first name: ");
        String last = inputString("Enter student's last name: ");
        var student = new Student(inputGender(), new String[] { first, last });
        System.out.printf("Student added with ID: %d\n", student.id);
        db.student_list.add(student);
    }

    private static void addTeacher() {
        String first = inputString("Enter teacher's first name: ");
        String last = inputString("Enter teacher's last name: ");
        var teacher = new Teacher(inputGender(), new String[] { first, last });
        System.out.printf("Teacher added with ID: %d\n", teacher.id);
        db.teacher_list.add(teacher);
    }

    private static void addCourse() {
        String name = inputString("Enter course name: ");
        String desc = inputString("Enter course description: ");
        int teacher_id = inputInt("Enter teacher ID: ");
        int credits = inputInt("Enter course credit count: ");
        var course = new Course(name, desc, credits, teacher_id);
        System.out.printf("Course added with ID: %d\n", course.id);
        db.course_list.add(course);
    }

    private static void addAssignment() {
        String name = inputString("Enter assignment name: ");
        String desc = inputString("Enter assignment description: ");
        int points = inputInt("Enter assignment points: ");
        int course_id = inputInt("Enter course ID: ");
        var assignment = new Assignment(name, desc, points, course_id);
        System.out.printf("Assignment added with ID %d\n", assignment.id);
        db.assignment_list.add(assignment);
    }

    private static void enrollStudent() {
        int student_id = inputInt("Enter student ID: ");
        int course_id = inputInt("Enter course ID: ");
        var enrollment = new Enrollment(student_id, course_id);
        System.out.printf("Enrollment added with ID %d\n", enrollment.id);
        db.enrollment_list.add(enrollment);
    }

    private static void addGrade() {
        int points = inputInt("Enter points earned: ");
        int student_id = inputInt("Enter student ID: ");
        int assignment_id = inputInt("Enter assignment ID: ");
        var grade = new Grade(points, student_id, assignment_id);
        System.out.printf("Grade recorded.\n");
        db.grade_list.add(grade);
    }

    private static void showReportCard() {
        int student_id = inputInt("Enter student ID: ");
        db.getStudent(student_id).ifPresentOrElse(
                s -> s.printReport(db),
                () -> System.out.println("Student not found."));
    }
}