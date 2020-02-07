package com.dingyong.room.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;

/**
 * Created by：dingyong on 2020/2/6 09:42
 * email：dingyongjxnu@163.com
 */
@Entity(tableName = "playlist_song_join",
        primaryKeys = {"playlistId", "songId"},
        foreignKeys = {
                @ForeignKey(entity = Playlist.class,
                        parentColumns = "id",
                        childColumns = "playlistId"),
                @ForeignKey(entity = Song.class,
                        parentColumns = "id",
                        childColumns = "songId")
        })
public class PlaylistSongJoin {
    public int playlistId;
    public int songId;

    @Override
    public String toString() {
        return "PlaylistSongJoin{" +
                "playlistId=" + playlistId +
                ", songId=" + songId +
                '}';
    }
}

