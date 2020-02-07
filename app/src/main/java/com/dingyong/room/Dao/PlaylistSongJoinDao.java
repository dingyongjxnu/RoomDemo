package com.dingyong.room.Dao;

import com.dingyong.room.entity.Playlist;
import com.dingyong.room.entity.PlaylistSongJoin;
import com.dingyong.room.entity.Song;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by：dingyong on 2020/2/6 09:43
 * email：dingyongjxnu@163.com
 */
@Dao
public interface PlaylistSongJoinDao {
    @Insert
    void insert(PlaylistSongJoin playlistSongJoin);

    @Insert
    void insert(Playlist playlist);

    @Insert
    void insert(Song playlist);

    @Query("SELECT * FROM Song")
    List<Song> getAllSong();

    @Query("SELECT * FROM Playlist")
    List<Playlist> getAllPlayList();

    @Query("SELECT * FROM playlist " +
            "INNER JOIN playlist_song_join " +
            "ON playlist.id=playlist_song_join.playlistId " +
            "WHERE playlist_song_join.songId=:songId")
    List<Playlist> getPlaylistsForSong(final int songId);

    @Query("SELECT * FROM song " +
            "INNER JOIN playlist_song_join " +
            "ON song.id=playlist_song_join.songId " +
            "WHERE playlist_song_join.playlistId=:playlistId")
    List<Song> getSongsForPlaylist(final int playlistId);
}
