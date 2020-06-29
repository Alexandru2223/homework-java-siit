package tema10.testsExercises.exercise5.musicplayer;

public interface UserRatedMusicLibrary extends MusicLibrary {

    StarRating userRatingOf(Song song);

    static class StarRatingConverter {
        public Rating convert(StarRating starRating) {
            return new Rating(starRating.numberOfStars * 20);
        }
    }

    @Override
    default Rating ratingOf(Song song) {
         StarRatingConverter starRatingConverter = new StarRatingConverter();
        Rating convert = starRatingConverter.convert(userRatingOf(song));
        return convert;
    }
}
