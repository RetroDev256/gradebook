public class Assignment {
    private static int next_id = 0;

    public final int id;
    protected String name;
    protected String desc;
    protected int points;
    public final int course_id;

    public Assignment(String name, String desc, int points, int course_id) {
        this.id = next_id++;
        this.name = name;
        this.desc = desc;
        this.points = points;
        this.course_id = course_id;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return desc;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }
}
