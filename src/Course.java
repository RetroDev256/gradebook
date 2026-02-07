import java.util.ArrayList;
import java.util.List;

public class Course {
    private static int next_id = 0;

    public final int id;
    public final String name;
    public final String desc;
    public final int credits;
    public final int teacher_id;

    public Course(String name, String desc, int credits, int teacher_id) {
        this.id = next_id++;
        this.name = name;
        this.desc = desc;
        this.credits = credits;
        this.teacher_id = teacher_id;
    }

    // Given a list of assignments, filter them for this course only
    public ArrayList<Assignment> getAssignments(List<Assignment> list) {
        var result = new ArrayList<Assignment>(list.size());
        for (Assignment a : list)
            if (a.course_id == id)
                result.add(a);
        return result;
    }

    // Given a list of enrollments, filter them for this course only
    public ArrayList<Enrollment> getEnrollments(List<Enrollment> list) {
        var result = new ArrayList<Enrollment>(list.size());
        for (Enrollment e : list)
            if (e.course_id == id)
                result.add(e);
        return result;
    }
}
