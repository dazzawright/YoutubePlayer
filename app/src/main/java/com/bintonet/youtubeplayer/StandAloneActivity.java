package com.bintonet.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by darren on 12/12/14.
 */
public class StandAloneActivity extends ActionBarActivity implements View.OnClickListener {

    public static final String GOOGLE_API_KEY = "AIzaSyA9hwh7ulFx4gnoJXYsVZP2pXEqIELazaA";
    public static final String YOUTUBE_VIDEO_ID = "PE7mI8tdB4Y";
    public static final String YOUTUBE_PLAYLIST_ID = "PL1CA6335E0D3699B6";

    private Button btnPlay;
    private Button btnPlaylist;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standalone);

        btnPlay = (Button) findViewById(R.id.btnStart);
        btnPlaylist = (Button) findViewById(R.id.btnPlaylist);

        btnPlay.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

    }

   public void onClick(View view){
       Intent intent = null;
       if(view ==btnPlay){
           //single video
           intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
       }else if (view == btnPlaylist){
           //play playlist
           intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST_ID);
       }

       if(intent != null){
           startActivityForResult(intent, 0);
       }
   }
}
