package tema10.testsExercises.exercise5.musicplayer;

public enum StarRating {

    FIVE_STARS(5),
    FOUR_STARS(4),
    THREE_STARS(3),
    TWO_STARS(2),
    ONE_STARS(1),
    ZERO_STARS(0);

    public final int numberOfStars;

    private StarRating(int stars) {
        this.numberOfStars = stars;
    }
}
