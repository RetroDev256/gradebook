// This child class exists simply to tag Human

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human {
    public Teacher(Gender gender, String[] names) {
        super(gender, names);
    }

    // Given a list of courses, filter them for this teacher only
    public ArrayList<Course> getCourses(List<Course> list) {
        var result = new ArrayList<Course>(list.size());
        for (Course c : list)
            if (c.teacher_id == id)
                result.add(c);
        return result;
    }
}
