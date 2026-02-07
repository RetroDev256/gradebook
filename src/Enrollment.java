public class Enrollment {
    private static int next_id = 0;

    public final int id;
    public final int student_id;
    public final int course_id;

    public Enrollment(int student_id, int course_id) {
        this.id = next_id++;
        this.student_id = student_id;
        this.course_id = course_id;
    }
}
