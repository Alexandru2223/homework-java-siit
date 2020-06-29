package tema10.testsExercises.exercise5.thirdpartyplugin;

import java.util.Arrays;
import java.util.Collection;

import tema10.testsExercises.exercise5.musicplayer.MusicLibrary;
import tema10.testsExercises.exercise5.musicplayer.Rating;
import tema10.testsExercises.exercise5.musicplayer.Song;

public class CloudScrobblingMusicLibrary implements MusicLibrary {
    private final CloudScrobblingService cloudScrobblingService;

    public CloudScrobblingMusicLibrary() {
        this.cloudScrobblingService = new CloudScrobblingService();
    }

    @Override
    public Collection<Song> allSongs() {
        return cloudScrobblingService.retrieveAllSongs();
    }

    @Override
    public int timesPlayed(Song song) {
        return cloudScrobblingService.retrieveTimesPlayedFromCloud(song);
    }

    public static final class CloudScrobblingService {

        public int retrieveTimesPlayedFromCloud(Song song) {
            // Simulate real cloud service by returning a random number
            return (int) (1 + Math.round(Math.random() % 500));
        }

        public int retrieveScrobbledRatingOf(Song song) {
            // Simulate real cloud service by returning a stable but meaningless number
            switch (song.getTitle()) {
                case "Candy":
                    return 78;
                case "A Change Is Gonna Come":
                    return 65;
                case "Desolation Row":
                    return 34;
                case "Bad Moon Rising":
                    return 28;
                case "Eleanor Rigby":
                    return 42;
                default:
                    return 0;
            }
        }

        public Collection<Song> retrieveAllSongs() {
            return Arrays.asList(
                    new Song("A Change Is Gonna Come", "Sam Cooke"),
                    new Song("Bad Moon Rising", "Creedence Clearwater Revival"),
                    new Song("Candy", "Paulo Nutini"),
                    new Song("Desolation Row", "Bob Dylan"),
                    new Song("Eleanor Rigby", "The Beatles"));
        }
    }

    @Override
    public Rating ratingOf(Song song) {
        return new Rating(cloudScrobblingService.retrieveScrobbledRatingOf(song));
    }
}
