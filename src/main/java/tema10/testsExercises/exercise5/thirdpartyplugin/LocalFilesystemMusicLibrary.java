package tema10.testsExercises.exercise5.thirdpartyplugin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import tema10.testsExercises.exercise5.musicplayer.MusicLibrary;
import tema10.testsExercises.exercise5.musicplayer.Song;

public class LocalFilesystemMusicLibrary implements MusicLibrary {


    private final Set<Song> allSongs;

    public LocalFilesystemMusicLibrary(Song... allSongs) {
        this.allSongs = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(allSongs)));
    }

    @Override
    public Collection<Song> allSongs() {
        return allSongs;
    }

    @Override
    public int timesPlayed(Song song) {
        // Could read a local database file to find the number of times played
        return 4;
    }
}
