public class Human {
    private static int next_id = 0;

    public final int id;
    protected Gender gender;
    protected String[] names;

    public Human(Gender gender, String[] names) {
        this.gender = gender;
        this.names = names;
        this.id = next_id;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public String[] getNames() {
        return names;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
