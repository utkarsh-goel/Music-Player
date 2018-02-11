package com.example.utkarsh.musicplayer;

/**
 * Created by utkarsh on 10/2/18.
 */

public class SongInfo {
    private String SongName;
    private String ArtistName;
    private String SongURL;

    public SongInfo() {
    }

    public SongInfo(String songName, String artistName, String songURL) {
        SongName = songName;
        ArtistName = artistName;
        SongURL = songURL;
    }

    public String getSongName() {
        return SongName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public String getSongURL() {
        return SongURL;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public void setSongURL(String songURL) {
        SongURL = songURL;
    }
}
