public class Course {
    private static int next_id = 0;

    public final int id;
    protected String name;
    protected String desc;
    protected int credits;
    protected int teacher_id;

    public Course(String name, String desc, int credits, int teacher_id) {
        this.id = next_id++;
        this.name = name;
        this.desc = desc;
        this.credits = credits;
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return desc;
    }

    public int getCredits() {
        return credits;
    }

    public int getTeacherId() {
        return teacher_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTeacherId(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
