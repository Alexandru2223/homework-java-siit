package tema10.testsExercises.exercise5.musicplayer;

public final class Rating {
    public final int score;

    public Rating(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Rating must be between 0 and 100, inclusive");
        }
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (score != rating.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return score;
    }

    @Override
    public String toString() {
        return "Rating{score=" + score + '}';
    }
}
