import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Assignment {
    private static int next_id = 0;

    public final int id;
    public final String name;
    public final String desc;
    public final int points;
    public final int course_id;

    public Assignment(String name, String desc, int points, int course_id) {
        this.id = next_id++;
        this.name = name;
        this.desc = desc;
        this.points = points;
        this.course_id = course_id;
    }

    // Given a list of grades, filter them for this assignment only
    public ArrayList<Grade> getGrades(List<Grade> list) {
        var result = new ArrayList<Grade>(list.size());
        for (Grade g : list)
            if (g.assignment_id == id)
                result.add(g);
        return result;
    }

    // Given a list of grades and student, filter them this assignment only
    public Optional<Grade> studentGrade(List<Grade> list, int student_id) {
        for (Grade g : getGrades(list)) {
            if (g.student_id == student_id)
                return Optional.of(g);
        }
        return Optional.empty();
    }
}
