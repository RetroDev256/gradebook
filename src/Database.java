import java.util.ArrayList;
import java.util.Optional;

public class Database {
    public ArrayList<Course> course_list = new ArrayList<>();
    public ArrayList<Enrollment> enrollment_list = new ArrayList<>();
    public ArrayList<Teacher> teacher_list = new ArrayList<>();
    public ArrayList<Student> student_list = new ArrayList<>();
    public ArrayList<Assignment> assignment_list = new ArrayList<>();
    public ArrayList<Grade> grade_list = new ArrayList<>();

    public Optional<Course> getCourse(int course_id) {
        for (Course course : course_list)
            if (course.id == course_id)
                return Optional.of(course);
        return Optional.empty();
    }

    public Optional<Enrollment> getEnrollment(int enrollment_id) {
        for (Enrollment enrollment : enrollment_list)
            if (enrollment.id == enrollment_id)
                return Optional.of(enrollment);
        return Optional.empty();
    }

    public Optional<Teacher> getTeacher(int teacher_id) {
        for (Teacher teacher : teacher_list)
            if (teacher.id == teacher_id)
                return Optional.of(teacher);
        return Optional.empty();
    }

    public Optional<Student> getStudent(int student_id) {
        for (Student student : student_list)
            if (student.id == student_id)
                return Optional.of(student);
        return Optional.empty();
    }

    public Optional<Assignment> getAssignment(int assignment_id) {
        for (Assignment assignment : assignment_list)
            if (assignment.id == assignment_id)
                return Optional.of(assignment);
        return Optional.empty();
    }
}
