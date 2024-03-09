package zombicide.util;

public enum Expertise {
    STAGE_THREE(3),
    STAGE_SEVEN(7),
    STAGE_ELEVEN(11);

    final int threshold;

    Expertise(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public static Expertise getStage(int value) {
        for (Expertise stage : Expertise.values())
            if (stage.getThreshold() == value)
                return stage;
        return null;
    }
}
