package com.loisaldana.sampledungeoncrawler;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioManager {

    MediaPlayer bgTheme;
    MediaPlayer playerUP;
    MediaPlayer hit;
    MediaPlayer score;
    MediaPlayer level;

    private int playerMoveUp = 0;

    public void PlayBgTheme(Context context)
    {
        if(bgTheme == null)
        {
            bgTheme = MediaPlayer.create(context, R.raw.bgtheme);
        }
        bgTheme.start();
        bgTheme.setLooping(true);
    }


    public void PlayPlayerMoveUp(Context context)
    {
        if(playerUP == null)
        {
            playerUP = MediaPlayer.create(context, R.raw.player_up);
        }
        if(playerMoveUp == 3)
        {
            playerUP.start();
            playerMoveUp = 0;
        }
        playerMoveUp = playerMoveUp + 1;
    }

    public void PlayHit(Context context)
    {
        if(hit == null)
        {
            hit = MediaPlayer.create(context, R.raw.hit);
        }
        hit.start();
    }

    public void PlayScore(Context context)
    {
        if(score == null)
        {
            score = MediaPlayer.create(context, R.raw.score);
        }
        score.start();
    }

    public void PlayLevel(Context context)
    {
        if(level == null)
        {
            level = MediaPlayer.create(context, R.raw.level);
        }
        level.setLooping(false);
        level.start();

    }

    public void Pause()
    {

    }

    public void Stop()
    {

    }
}

