public class Human {
    private static int next_id = 0;

    public final int id;
    public final Gender gender;
    public final String[] names;

    public Human(Gender gender, String[] names) {
        this.gender = gender;
        this.names = names;
        this.id = next_id;
    }

    public String formatName() {
        if (names == null || names.length == 0) {
            return "[unknown]";
        }

        var builder = new StringBuilder();
        int last_idx = names.length - 1;
        builder.append(names[last_idx]);

        if (names.length > 1) {
            builder.append(',');

            for (int i = 0; i < last_idx; i++) {
                builder.append(" %s".formatted(names[i]));
            }
        }

        return builder.toString();
    }
}
