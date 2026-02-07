// This child class exists simply to tag Human

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Student extends Human {
    public Student(Gender gender, String[] names) {
        super(gender, names);
    }

    // Given a list of grades, filter them for this student only
    public ArrayList<Grade> getGrades(List<Grade> list) {
        var result = new ArrayList<Grade>(list.size());
        for (Grade g : list)
            if (g.student_id == id)
                result.add(g);
        return result;
    }

    // Given a list of enrollments, filter them for this student only
    public ArrayList<Enrollment> getEnrollments(List<Enrollment> list) {
        var result = new ArrayList<Enrollment>(list.size());
        for (Enrollment e : list)
            if (e.student_id == id)
                result.add(e);
        return result;
    }

    // Print the report card given an assignment list and grade list
    public void printReport(Database db) {
        // Overall grade report
        System.out.printf("Grade Report: %s\n", formatName());

        // Report per-enrollment
        for (Enrollment e : getEnrollments(db.enrollment_list)) {
            Course c = db.getCourse(e.course_id).orElseThrow();
            Teacher t = db.getTeacher(c.teacher_id).orElseThrow();
            System.out.printf(" - Course: %s\n", c.name);
            System.out.printf("   - Teacher: %s\n", t.formatName());
            System.out.print("   - Assignments:\n");

            int total_earned = 0;
            int total_possible = 0;

            // Report per-assignment grade
            for (Assignment a : c.getAssignments(db.assignment_list)) {
                Optional<Grade> opt_grade = a.studentGrade(db.grade_list, id);
                int earned_points = opt_grade.map(g -> g.points).orElse(0);

                double grade = getGrade(earned_points, a.points);
                System.out.printf("     - %s: %.2f%%", a.name, grade);
                System.out.printf(" / %s\n", getLetterGrade(grade));

                total_earned += earned_points;
                total_possible += a.points;
            }

            double grade = getGrade(total_earned, total_possible);
            System.out.printf("   - Grade: %.2f%%\n", grade);
            System.out.printf("   - Letter: %s\n", getLetterGrade(grade));
            System.out.printf("   - Status: %s\n", getPassingStatus(grade));
        }
    }

    private static double getGrade(int earned_points, int possible_points) {
        // The final grade defaults to 100%
        double final_grade = 100.00;

        // Do not divide by zero when calculating the grade
        if (possible_points > 0) {
            double earned_f = (double) earned_points;
            double possible_f = (double) possible_points;
            final_grade = 100 * earned_f / possible_f;
        }

        return final_grade;
    }

    // Given a grade [0, 100] - print the letter grade
    private static String getLetterGrade(double grade) {
        if (grade >= 97.0)
            return "A+";
        if (grade >= 93.0)
            return "A";
        if (grade >= 90.0)
            return "A-";
        if (grade >= 87.0)
            return "B+";
        if (grade >= 83.0)
            return "B";
        if (grade >= 80.0)
            return "B-";
        if (grade >= 77.0)
            return "C+";
        if (grade >= 73.0)
            return "C";
        if (grade >= 70.0)
            return "C-";
        if (grade >= 67.0)
            return "D+";
        if (grade >= 63.0)
            return "D";
        if (grade >= 60.0)
            return "D-";

        return "F";
    }

    // Given a grade [0, 100] - print the grade status
    private static String getPassingStatus(double grade) {
        if (grade >= 90.0)
            return "Honors";
        if (grade >= 60.0)
            return "Passing";

        return "Failing";
    }
}
