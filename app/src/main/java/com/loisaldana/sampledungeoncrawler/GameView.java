package com.loisaldana.sampledungeoncrawler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.view.MotionEvent;
import android.view.View;

/*
Created by Canados
*/

public class GameView extends View {

    private int canvasWidth;
    private int canvasHeight;
    Canvas canvas;

    float scaleNum;

    public int screenWidth;
    public int screenHeight;

    Player character = new Player(); // creating player object here
    Bitmap mapBitmap; // this is bitmap we using for background

    public GameView(Context context) {
        super(context);


        character.playerBitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.knuckles1);
        character.playerBitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.knuckles2);
        character.playerBitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.knuckles3);
        character.playerBitmap[3] = BitmapFactory.decodeResource(getResources(), R.drawable.knuckles4);
        character.playerBitmap[4] = BitmapFactory.decodeResource(getResources(), R.drawable.knuckles5);
        character.playerBitmap[5] = BitmapFactory.decodeResource(getResources(), R.drawable.knuckles6);
        character.HPBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.life);
        mapBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.map);

    }

    /* Here we can add images that we want to draw. This function also updates */
    @Override
    protected void onDraw(Canvas canvas) {

        canvasWidth = canvas.getWidth(); // if we needed to reference to it
        canvasHeight = canvas.getHeight(); // if we needed to reference to it


        canvas.drawBitmap(mapBitmap, 0, 0, null); // call background image on canvas


        //Draw player's spite with animation
        if(character.sprite_wings_up)
        {
            if(character.spriteStep == 1 || character.spriteStep == 3 || character.spriteStep == 5)
            {
                character.playerCurrentBitmap = character.playerBitmap[character.tempBitmap];
                character.drawPlayer(canvas, character.playerBitmap[character.tempBitmap]); // sprite #1
                character.sprite_wings_up = false;
                character.spriteStep = character.spriteStep + 1;
                character.tempBitmap = character.tempBitmap + 1;
            }

        }
        else if(!character.sprite_wings_up)
        {
            if(character.spriteStep == 2 || character.spriteStep == 4)
            {
                character.playerCurrentBitmap = character.playerBitmap[character.tempBitmap];
                character.drawPlayer(canvas, character.playerBitmap[character.tempBitmap]); // sprite #2
                character.sprite_wings_up = true;
                character.spriteStep = character.spriteStep + 1;
                character.tempBitmap = character.tempBitmap + 1;
            }
            else if(character.spriteStep == 6)
            {
                character.playerCurrentBitmap = character.playerBitmap[character.tempBitmap];
                character.drawPlayer(canvas, character.playerBitmap[character.tempBitmap]); // sprite #2
                character.sprite_wings_up = true;
                character.spriteStep = 1;
                character.tempBitmap = 0;

            }

        }
        character.drawPlayersLifes(canvas, character.HPBitmap); // call player's HP on HUD
        character.drawPlayersStats(canvas); // call player's score on HUD
        canvas.setDensity(100);

        //System.out.println("DENSITY " + scaleNum);

        //System.out.println("MAPBITMAP WIDTH " + mapBitmap.getWidth() + "    CANVAS WIDTH " + canvas.getWidth());
        //System.out.println("MAPBITMAP DENSYTY " + mapBitmap.getDensity());
        //System.out.println("CANVAS DENSYTY " + canvas.getDensity());

    }

    //Start is here (we can deleted if we don't need it)
    void OnStart()
    {

    }

    //Update function is here
    void Update()
    {

        character.SetPlayerSpeed(character.GetPlayerSpeed() + 2); // imitation player's gravity
        character.SetPlayerScore(character.GetPlayerScore() + 1); // Testing Get() Set() for player's score
    }


    //If we touch screen we changing player's movement...
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            character.sprite_wings_up = true;
            character.SetPlayerSpeed(-30);
        }
        return true;
    }

}


