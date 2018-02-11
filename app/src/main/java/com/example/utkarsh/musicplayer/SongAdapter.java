package com.example.utkarsh.musicplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by utkarsh on 10/2/18.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder>
{

    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    private Context context;
    private OnItemClickListener onItemClickListener;

    public SongAdapter(ArrayList<SongInfo> _songs, Context context) {
        this._songs = _songs;
        this.context = context;
    }

    public interface OnItemClickListener
    {
        void onItemClick(Button b, View v, SongInfo obj, int position);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener=onItemClickListener;
    }

    SongAdapter(Context context,ArrayList<SongInfo> _songs)
    {
        this.context=context;
        this._songs=_songs;
    }

    @Override
    public SongAdapter.SongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(context).inflate(R.layout.row_song,parent,false);
        return new SongHolder(myview);
    }

    @Override
    public void onBindViewHolder(final SongAdapter.SongHolder songHolder, final int position) {
        final SongInfo c = _songs.get(position);

        songHolder.tvSongName.setText(_songs.get(position).getSongName());
        songHolder.tvSongArtist.setText(_songs.get(position).getArtistName());

        //songHolder.songName.setText(c.SongName);
        //songHolder.artistName.setText(c.ArtistName);

        songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null)
                {
                    onItemClickListener.onItemClick(songHolder.btnAction,view,c,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView tvSongName,tvSongArtist;
        Button btnAction;

        public SongHolder(View itemView) {
            super(itemView);
            tvSongName=(TextView)itemView.findViewById(R.id.tvSongName);
            tvSongArtist=(TextView)itemView.findViewById(R.id.tvArtistName);
            btnAction=(Button)itemView.findViewById(R.id.btnAction);
        }
    }
}
