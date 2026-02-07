public class Main {
    public static void main(String[] args) {
        // Initialize the database
        var db = new Database();

        // Create a Student
        String[] student_name = { "Jane", "Doe" };
        var jane = new Student(Gender.FEMALE, student_name);
        db.student_list.add(jane);

        // Create a Teacher
        String[] teacher_name = { "Bob", "Ross" };
        var bob = new Teacher(Gender.MALE, teacher_name);
        db.teacher_list.add(bob);

        // Create a Course
        var cse_110 = new Course("CSE-110",
                "Programming With Zig",
                3, bob.id);
        db.course_list.add(cse_110);

        // Create Assignments for the course
        var midterm = new Assignment("Midterm",
                "First big test", 100, cse_110.id);
        db.assignment_list.add(midterm);
        var project_1 = new Assignment("Project 1",
                "Zig Calculator", 50, cse_110.id);
        db.assignment_list.add(project_1);
        var homework = new Assignment("Homework",
                "Arrays", 20, cse_110.id);
        db.assignment_list.add(homework);

        // Enroll Jane in the course
        var enrollment = new Enrollment(jane.id, cse_110.id);
        db.enrollment_list.add(enrollment);

        // Assign Grades to Jane
        db.grade_list.add(new Grade(85, jane.id, midterm.id));
        db.grade_list.add(new Grade(45, jane.id, project_1.id));
        db.grade_list.add(new Grade(20, jane.id, homework.id));

        // Display Jane's report card
        jane.printReport(db);
    }
}