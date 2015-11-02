
        package com.example.shardendu.airhockey1;

        import android.app.Activity;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.content.SharedPreferences;
        import android.content.SharedPreferences.Editor;
        import android.content.pm.ActivityInfo;
        import android.graphics.Bitmap;
        import android.graphics.Bitmap.Config;
        import android.graphics.BlurMaskFilter;
        import android.graphics.BlurMaskFilter.Blur;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Paint.Align;
        import android.graphics.Paint.Style;
        import android.graphics.Path;
        import android.graphics.PorterDuff;
        import android.graphics.Typeface;
        import android.media.SoundPool;
        import android.os.Bundle;
        import android.support.v4.app.DialogFragment;
        import android.support.v4.view.MotionEventCompat;
        import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
        import android.support.v4.widget.CursorAdapter;
        import android.util.FloatMath;
        import android.util.Log;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.ViewGroup.LayoutParams;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;

        import com.example.shardendu.airhockey1.CommonActivity;
        // import com.google.ads.AdRequest;
        //import com.google.ads.AdSize;
        //import com.google.ads.AdView;

public class GameActivity extends CommonActivity {


    public void setPlayerMalletSize(){
        Background bck = new Background(this);
        bck.setPlayerMalletSize();
    }

    public void setGoalSize(){
        Background bck = new Background(this);
        bck.setGoalSize();
    }
    static int[] ballBlurColor;
    static int[] ballColor;
    static float ballRad;
    static int colorsNo;
    static int[] dataQuads;
    static float decelHit;
    static long doubleDelay;
    static int[] edgeBottomBlurColor;
    static int[] edgeBottomColor;
    static float edgeLoc;
    static int[] edgeTopBlurColor;
    static int[] edgeTopColor;
    static int[] fieldColor;
    static float goalWidth;
    static float goalWidthPlayer;
    static int[] lineColor;
    static int[] malletBottomBlurColor;
    static int[] malletBottomInnerColor;
    static int[] malletBottomMiddleColor;
    static int[] malletBottomOuterColor;
    static float malletInnerRad;
    static float malletMiddleRad;
    static float malletOuterRad;
    static float malletInnerRad2;
    static float malletMiddleRad2;
    static float malletOuterRad2;
    static int[] malletTopBlurColor;
    static int[] malletTopInnerColor;
    static int[] malletTopMiddleColor;
    static int[] malletTopOuterColor;
    static float[] relBallSizePro;
    static float[] relBatSizePro;
    static float[] relGoalSizePro;
    static int[] scoreBlurColor;
    static int[] scoreColor;
    static long startDelay;
    static float velHitMax;
    static float velMax;
    static float velMaxPlayer;
    static float velMin;
    int aa;
    int ab;
    int ac;
    int ad;
    //private AdView adView;
    int ae;
    int af;
    int ag;
    int backEnded;
    float ballGo2X;
    float ballGo2Y;
    float ballGoX;
    float ballGoY;
    float ballRadScaled;
    float ballStartX;
    float ballStartY;
    long ballTime;
    float ballVel;
    float ballVelX;
    float ballVelY;
    float batBottomCenterX;
    float batBottomCenterY;
    float batBottomGoX;
    float batBottomGoY;
    float batBottomProjectX;
    float batBottomProjectY;
    float batBottomStartX;
    float batBottomStartY;
    float batBottomVel;
    float batBottomVelX;
    float batBottomVelY;
    float batTopCenterX;
    float batTopCenterY;
    float batTopGoX;
    float batTopGoY;
    float batTopProjectX;
    float batTopProjectY;
    float batTopStartX;
    float batTopStartY;
    float batTopVel;
    float batTopVelX;
    float batTopVelY;
    Bitmap bgndBitmap;
    int bgndLoaded;
    int canvasH;
    int canvasW;
    int coordX;
    int coordY;
    long currentTime;
    int[] dataColors;
    int difficulty;
    long doubleTime;
    Canvas drawCanvas;
    int drawNo;
    Paint drawPaint;
    int drawStart;
    float edgeLocScaled;
    float fa;
    float fb;
    float fc;
    float fd;
    float fe;
    float ff;
    float fg;
    float fh;
    float fi;
    float fj;
    float fk;
    float fl;
    float fm;
    SharedPreferences gGameSettings;
    long gameDuration;
    long gameEndTime;
    int gameEnded;
    long trackMalletTime;
    long trackGoalTime;

    RelativeLayout gameLayout;
    String gameType;
    float goalOffset;
    float goalWidthScaled;
    float goalWidthScaledPlayer;
    int hitFlag;
    long hitTime;
    int landscape;
    float malletInnerRadScaled;
    float malletInnerRadScaled2;
    float malletMiddleRadScaled;
    //new variable
    float malletMiddleRadScaled2;
    float malletOuterRadScaled;
    float malletOuterRadScaled2;
    Paint paint;
    Paint paintBlur;
    Path path;
    int paused;
    long paused2Time;
    long pausedBallTime;
    long pausedGameEndTime;
    long pausedTime;
    int players;
    float[] relBallSize;
    float[] relBatSize;
    float[] relBatSize2;
    float[] relGoalSize;
    float[] relVel;
    float[] relVelPro;
    int scoreBottom;
    int scoreTop;
    int screenH;
    int screenH2;
    int screenW;
    int screenW2;
    int soundGoal;
    int soundGoalAct;
    int soundLoaded;
    int soundMallet;
    int soundMalletAct;
    SoundPool soundPool;
    int soundSet;
    int soundWall;
    int soundWallAct;
    int theme;
    int useSound;
    float velMaxBottom;
    float velMaxScaled;
    float velMaxTop;
    float velMinScaled;
    float volume;

    class Background extends View {


        public Background(Context context) {
            super(context);
            Log.d(CommonActivity.TAG, "Background");
        }

        public void setPlayerMalletSize(){
            if(bgndLoaded!=1) {
                GameActivity.this.malletMiddleRadScaled = (GameActivity.malletMiddleRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
                GameActivity.this.malletOuterRadScaled = (GameActivity.malletOuterRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
                GameActivity.this.malletInnerRadScaled = (GameActivity.malletInnerRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            }
            else{
                if(System.currentTimeMillis()-trackMalletTime > 30000){
                    malletMiddleRad = 0.06f;
                    malletOuterRad = 0.09f;
                    malletInnerRad = 0.04f;
                }
                else {
                    malletMiddleRad = 0.09f;
                    malletOuterRad = 0.13f;
                    malletInnerRad = 0.06f;
               }
                GameActivity.this.malletMiddleRadScaled = (GameActivity.malletMiddleRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
                GameActivity.this.malletOuterRadScaled = (GameActivity.malletOuterRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
                GameActivity.this.malletInnerRadScaled = (GameActivity.malletInnerRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            }
        }

        public void setGoalSize(){

            if(bgndLoaded!=1) {
                goalWidthPlayer = 0.39f;
                GameActivity.this.goalWidthScaledPlayer = (GameActivity.goalWidthPlayer * ((float) GameActivity.this.screenW)) * GameActivity.this.relGoalSize[GameActivity.this.difficulty];
            }
            else {
                if (System.currentTimeMillis() - trackGoalTime > 30000) {
                    goalWidthPlayer = 0.39f;
                    GameActivity.this.goalWidthScaledPlayer = (GameActivity.goalWidthPlayer * ((float) GameActivity.this.screenW)) * GameActivity.this.relGoalSize[GameActivity.this.difficulty];
                } else {
                    goalWidthPlayer = 0.6f;
                    GameActivity.this.goalWidthScaledPlayer = (GameActivity.goalWidthPlayer * ((float) GameActivity.this.screenW)) * GameActivity.this.relGoalSize[GameActivity.this.difficulty];
                }
            }
        }
        public void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            GameActivity.this.screenW = w;
            GameActivity.this.screenH = h;
            if (w < h) {
                GameActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                GameActivity.this.landscape = 0;
            } else {
                GameActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                GameActivity.this.screenH = w;
                GameActivity.this.screenW = h;
                GameActivity.this.landscape = 1;
            }
            GameActivity.this.edgeLocScaled = GameActivity.edgeLoc * ((float) GameActivity.this.screenW);
            GameActivity.this.goalWidthScaled = (GameActivity.goalWidth * ((float) GameActivity.this.screenW)) * GameActivity.this.relGoalSize[GameActivity.this.difficulty];
            setGoalSize();
            GameActivity.this.goalWidthScaledPlayer = (GameActivity.goalWidthPlayer * ((float) GameActivity.this.screenW)) * GameActivity.this.relGoalSize[GameActivity.this.difficulty];
            GameActivity.this.ballRadScaled = (GameActivity.ballRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBallSize[GameActivity.this.difficulty];
            //GameActivity.this.malletMiddleRadScaled = (GameActivity.malletMiddleRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            //GameActivity.this.malletOuterRadScaled = (GameActivity.malletOuterRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            //GameActivity.this.malletInnerRadScaled = (GameActivity.malletInnerRad * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            GameActivity.this.malletMiddleRadScaled2 = (GameActivity.malletMiddleRad2 * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            GameActivity.this.malletOuterRadScaled2 = (GameActivity.malletOuterRad2 * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            GameActivity.this.malletInnerRadScaled2 = (GameActivity.malletInnerRad2 * ((float) GameActivity.this.screenW)) * GameActivity.this.relBatSize[GameActivity.this.difficulty];
            setPlayerMalletSize();
            GameActivity.this.velMaxScaled = (((float) GameActivity.this.screenW) / GameActivity.velMax) * GameActivity.this.relVel[GameActivity.this.difficulty];
            GameActivity gameActivity = GameActivity.this;
            float f = ((float) GameActivity.this.screenW) / GameActivity.velMaxPlayer;
            GameActivity.this.velMaxTop = f;
            gameActivity.velMaxBottom = f;
            GameActivity.this.velMinScaled = ((float) GameActivity.this.screenW) / GameActivity.velMin;
            gameActivity = GameActivity.this;
            GameActivity gameActivity2 = GameActivity.this;
            float f2 = (float) GameActivity.this.screenW2;
            GameActivity.this.batTopCenterX = f2;
            gameActivity2.batTopStartX = f2;
            gameActivity.batTopGoX = f2;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            f2 = (float) GameActivity.this.screenW2;
            GameActivity.this.batBottomCenterX = f2;
            gameActivity2.batBottomStartX = f2;
            gameActivity.batBottomGoX = f2;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            f2 = (GameActivity.this.goalWidthScaled / 2.0f) + GameActivity.this.edgeLocScaled;
            GameActivity.this.batTopCenterY = f2;
            gameActivity2.batTopStartY = f2;
            gameActivity.batTopGoY = f2;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            f2 = (((float) GameActivity.this.screenH) - (GameActivity.this.goalWidthScaled / 2.0f)) + GameActivity.this.edgeLocScaled;
            GameActivity.this.batBottomCenterY = f2;
            gameActivity2.batBottomStartY = f2;
            gameActivity.batBottomGoY = f2;
            GameActivity.this.screenH2 = GameActivity.this.screenH / 2;
            GameActivity.this.screenW2 = GameActivity.this.screenW / 2;
            if (GameActivity.this.players == 0 || GameActivity.this.players == 3) {
                GameActivity.this.velMaxTop = GameActivity.this.velMaxScaled;
            }
            if (GameActivity.this.players == 1 || GameActivity.this.players == 3) {
                GameActivity.this.velMaxBottom = GameActivity.this.velMaxScaled;
            }
            GameActivity.this.paintBlur.setMaskFilter(new BlurMaskFilter(GameActivity.this.malletOuterRadScaled - GameActivity.this.malletMiddleRadScaled, Blur.NORMAL));
            System.gc();
        }

        /*public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            setPlayerMalletSize();
            setGoalSize();
            if (GameActivity.this.bgndLoaded == 0) {
                GameActivity.this.bgndLoaded = 1;
                GameActivity.this.coordX = GameActivity.this.screenW;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.bgndBitmap = Bitmap.createBitmap(GameActivity.this.coordX, GameActivity.this.coordY, Config.RGB_565);
                Canvas bgndCanvas = new Canvas(GameActivity.this.bgndBitmap);
                bgndCanvas.drawColor(GameActivity.fieldColor[GameActivity.this.theme]);
                GameActivity.this.paint.setAntiAlias(true);
                GameActivity.this.paint.setColor(GameActivity.lineColor[GameActivity.this.theme]);
                GameActivity.this.paint.setStyle(Style.STROKE);
                GameActivity.this.paint.setStrokeWidth((float) (GameActivity.this.screenH / 115));
                GameActivity.this.paintBlur.setAntiAlias(true);
                GameActivity.this.paintBlur.setStyle(Style.FILL);

                copy = bgndCanvas;

                GameActivity.this.coordX = 0;
                GameActivity.this.coordY = GameActivity.this.screenH2;
                getcoords();
                GameActivity.this.aa = GameActivity.this.coordX;
                GameActivity.this.ab = GameActivity.this.coordY;
                GameActivity.this.coordX = GameActivity.this.screenW;
                GameActivity.this.coordY = GameActivity.this.screenH2;
                getcoords();
                bgndCanvas.drawLine((float) GameActivity.this.aa, (float) GameActivity.this.ab, (float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.paint);
                GameActivity.this.coordX = GameActivity.this.screenW2;
                GameActivity.this.coordY = GameActivity.this.screenH2;
                getcoords();
                bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaled/ 2.0f, GameActivity.this.paint);
                GameActivity.this.coordX = GameActivity.this.screenW2;
                GameActivity.this.coordY = GameActivity.this.screenH - ((int) GameActivity.this.edgeLocScaled);
                getcoords();
                bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaled / 2.0f, GameActivity.this.paint);
                GameActivity.this.coordX = GameActivity.this.screenW2;
                GameActivity.this.coordY = (int) GameActivity.this.edgeLocScaled;
                getcoords();
                bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaledPlayer / 2.0f, GameActivity.this.paint);
                GameActivity.this.paint.setAntiAlias(true);
                GameActivity.this.paint.setColor(-GameActivity.lineColor[GameActivity.this.theme]);
                GameActivity.this.paint.setStyle(Style.FILL);
                GameActivity.this.path.reset();
                GameActivity gameActivity = GameActivity.this;
                int i = (GameActivity.this.screenW - ((int) GameActivity.this.goalWidthScaled)) / 2;
                GameActivity.this.coordX = i;
                gameActivity.aa = i;
                GameActivity.this.ab = (int) GameActivity.this.edgeLocScaled;
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = 0;
                getcoords();
                GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = 0;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = 0;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH - GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH - GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paint);
                GameActivity.this.paint.setAntiAlias(true);
                GameActivity.this.paint.setStyle(Style.FILL);
                GameActivity.this.paintBlur.setColor(GameActivity.edgeTopBlurColor[GameActivity.this.theme]);
                GameActivity.this.ab = (((int) GameActivity.this.edgeLocScaled) * 4) / 2;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) (GameActivity.this.goalWidthScaled - GameActivity.this.edgeLocScaled))) / 2;
                GameActivity.this.ac = 0;
                drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paintBlur);
                GameActivity.this.paint.setColor(GameActivity.edgeTopColor[GameActivity.this.theme]);
                GameActivity.this.ab = (int) GameActivity.this.edgeLocScaled;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) GameActivity.this.goalWidthScaledPlayer)) / 2;
                GameActivity.this.ac = 0;
                drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paint);
                GameActivity.this.paintBlur.setColor(GameActivity.edgeBottomBlurColor[GameActivity.this.theme]);
                GameActivity.this.ab = (((int) GameActivity.this.edgeLocScaled) * 4) / 2;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) (GameActivity.this.goalWidthScaled - GameActivity.this.edgeLocScaled))) / 2;
                GameActivity.this.ac = GameActivity.this.screenH;
                drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paintBlur);
                GameActivity.this.paint.setColor(GameActivity.edgeBottomColor[GameActivity.this.theme]);
                GameActivity.this.ab = (int) GameActivity.this.edgeLocScaled;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) GameActivity.this.goalWidthScaled)) / 2;
                GameActivity.this.ac = GameActivity.this.screenH;
                drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paint);
            }
            else{
                //bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaled / 2.0f, GameActivity.this.paint);
            }
            canvas.drawBitmap(GameActivity.this.bgndBitmap, 0.0f, 0.0f, null);
        }*/

        private void drawedges() {

            GameActivity.this.path.reset();
            GameActivity.this.coordX = 0;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.aa;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.aa;
            GameActivity.this.coordY = GameActivity.this.ac - GameActivity.this.ab;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = 0;
            GameActivity.this.coordY = GameActivity.this.ac - GameActivity.this.ab;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();

            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = 0;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();

            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
            GameActivity.this.coordY = GameActivity.this.ac - GameActivity.this.ab;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();

            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW;
            GameActivity.this.coordY = GameActivity.this.ac - GameActivity.this.ab;

            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }

            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = 0;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.ab;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.ab;
            GameActivity.this.coordY = GameActivity.this.screenH2;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = 0;
            GameActivity.this.coordY = GameActivity.this.screenH2;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();

            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = 0;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();

            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();

            GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.ab;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();

            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.ab;
            GameActivity.this.coordY = GameActivity.this.screenH2;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW;
            GameActivity.this.coordY = GameActivity.this.screenH2;
            if (GameActivity.this.coordY < 0) {
                GameActivity.this.coordY = GameActivity.this.ac + GameActivity.this.ab;
            }
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
            GameActivity.this.coordX = GameActivity.this.screenW;
            GameActivity.this.coordY = GameActivity.this.ac;
            getcoords();
            GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
        }

        private void getcoords() {
            if (GameActivity.this.landscape == 1) {
                int temp = GameActivity.this.coordY;
                GameActivity.this.coordY = GameActivity.this.coordX;
                GameActivity.this.coordX = temp;
            }
        }
    }

    class PlayGame extends View {
        public PlayGame(Context context) {
            super(context);
            Log.d(CommonActivity.TAG, "Playgame");
        }

        public void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            GameActivity gameActivity = GameActivity.this;
            GameActivity gameActivity2 = GameActivity.this;
            long currentTimeMillis = System.currentTimeMillis();
            gameActivity2.ballTime = currentTimeMillis;
            gameActivity.currentTime = currentTimeMillis;
            GameActivity.this.gameEndTime = GameActivity.this.gameDuration + GameActivity.this.currentTime;
            GameActivity.this.scoreTop = 0;
            GameActivity.this.scoreBottom = 0;
            GameActivity.this.paused = 0;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            float f = (float) GameActivity.this.screenW2;
            GameActivity.this.batTopStartX = f;
            gameActivity2.batTopCenterX = f;
            gameActivity.batTopGoX = f;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            f = (GameActivity.this.goalWidthScaled / 2.0f) + GameActivity.this.edgeLocScaled;
            GameActivity.this.batTopStartY = f;
            gameActivity2.batTopCenterY = f;
            gameActivity.batTopGoY = f;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            f = (float) GameActivity.this.screenW2;
            GameActivity.this.batBottomStartX = f;
            gameActivity2.batBottomCenterX = f;
            gameActivity.batBottomGoX = f;
            gameActivity = GameActivity.this;
            gameActivity2 = GameActivity.this;
            f = (((float) GameActivity.this.screenH) - (GameActivity.this.goalWidthScaled / 2.0f)) - GameActivity.this.edgeLocScaled;
            GameActivity.this.batBottomStartY = f;
            gameActivity2.batBottomCenterY = f;
            gameActivity.batBottomGoY = f;
            System.gc();
        }

        public synchronized boolean onTouchEvent(MotionEvent ev) {
            super.onTouchEvent(ev);
            int eventaction = ev.getAction();
            if (eventaction != 0 || GameActivity.this.gameEnded <= 0) {
                GameActivity.this.aa = ev.getPointerCount();
                GameActivity.this.ab = 0;
                while (GameActivity.this.ab < GameActivity.this.aa) {
                    GameActivity gameActivity;
                    GameActivity.this.coordX = (int) ev.getX(GameActivity.this.ab);
                    GameActivity.this.coordY = (int) ev.getY(GameActivity.this.ab);
                    getcoords();
                    if (((float) GameActivity.this.coordY) >= ((((float) GameActivity.this.screenH2) - GameActivity.this.malletOuterRadScaled) - GameActivity.this.ballRadScaled) + 1.0f || GameActivity.this.gameEnded >= 0) {
                        if (((float) GameActivity.this.coordY) <= ((((float) GameActivity.this.screenH2) + GameActivity.this.malletOuterRadScaled) + GameActivity.this.ballRadScaled) - 1.0f || GameActivity.this.gameEnded >= 0) {
                            if (eventaction == 0 && ((float) GameActivity.this.coordY) < ((float) GameActivity.this.screenH2) + ((GameActivity.this.malletOuterRadScaled + GameActivity.this.ballRadScaled) / 2.0f) && ((float) GameActivity.this.coordY) > ((float) GameActivity.this.screenH2) - ((GameActivity.this.malletOuterRadScaled + GameActivity.this.ballRadScaled) / 2.0f)) {
                                if (GameActivity.this.paused == 0) {
                                    GameActivity.this.pausedTime = GameActivity.this.currentTime;
                                    GameActivity.this.pausedBallTime = GameActivity.this.ballTime;
                                    GameActivity.this.pausedGameEndTime = GameActivity.this.gameEndTime;
                                    GameActivity.this.paused = 1;
                                } else if (GameActivity.this.paused == 1) {
                                    gameActivity = GameActivity.this;
                                    GameActivity gameActivity2 = GameActivity.this;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    gameActivity2.currentTime = currentTimeMillis;
                                    gameActivity.paused2Time = currentTimeMillis;
                                    GameActivity.this.ballTime = (GameActivity.this.pausedBallTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                                    GameActivity.this.gameEndTime = (GameActivity.this.pausedGameEndTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                                    GameActivity.this.paused = 2;
                                    invalidate();
                                }
                            }
                        } else if (GameActivity.this.paused == 0) {
                            GameActivity.this.batBottomGoX = (float) GameActivity.this.coordX;
                            GameActivity.this.batBottomGoY = (float) GameActivity.this.coordY;
                        }
                    } else if (GameActivity.this.paused == 0) {
                        GameActivity.this.batTopGoX = (float) GameActivity.this.coordX;
                        GameActivity.this.batTopGoY = (float) GameActivity.this.coordY;
                    }
                    gameActivity = GameActivity.this;
                    gameActivity.ab++;
                }
            } else {
                GameActivity.this.backEnded = 1;
                GameActivity.this.finish();
                System.gc();
            }
            return true;
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Background back = new Background(GameActivity.this);
            setGoalSize();
            //if (GameActivity.this.bgndLoaded == 0) {
                GameActivity.this.bgndLoaded = 1;
                GameActivity.this.coordX = GameActivity.this.screenW;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.bgndBitmap = Bitmap.createBitmap(GameActivity.this.coordX, GameActivity.this.coordY, Config.RGB_565);
                Canvas bgndCanvas = new Canvas(GameActivity.this.bgndBitmap);
                bgndCanvas.drawColor(GameActivity.fieldColor[GameActivity.this.theme]);
                GameActivity.this.paint.setAntiAlias(true);
                GameActivity.this.paint.setColor(GameActivity.lineColor[GameActivity.this.theme]);
                GameActivity.this.paint.setStyle(Style.STROKE);
                GameActivity.this.paint.setStrokeWidth((float) (GameActivity.this.screenH / 115));
                GameActivity.this.paintBlur.setAntiAlias(true);
                GameActivity.this.paintBlur.setStyle(Style.FILL);

                //copy = bgndCanvas;

                GameActivity.this.coordX = 0;
                GameActivity.this.coordY = GameActivity.this.screenH2;
                getcoords();
                GameActivity.this.aa = GameActivity.this.coordX;
                GameActivity.this.ab = GameActivity.this.coordY;
                GameActivity.this.coordX = GameActivity.this.screenW;
                GameActivity.this.coordY = GameActivity.this.screenH2;
                getcoords();
                bgndCanvas.drawLine((float) GameActivity.this.aa, (float) GameActivity.this.ab, (float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.paint);
                GameActivity.this.coordX = GameActivity.this.screenW2;
                GameActivity.this.coordY = GameActivity.this.screenH2;
                getcoords();
                bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaled/ 2.0f, GameActivity.this.paint);
                GameActivity.this.coordX = GameActivity.this.screenW2;
                GameActivity.this.coordY = GameActivity.this.screenH - ((int) GameActivity.this.edgeLocScaled);
                getcoords();
                bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaled / 2.0f, GameActivity.this.paint);
                GameActivity.this.coordX = GameActivity.this.screenW2;
                GameActivity.this.coordY = (int) GameActivity.this.edgeLocScaled;
                getcoords();
                bgndCanvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.goalWidthScaledPlayer / 2.0f, GameActivity.this.paint);
                GameActivity.this.paint.setAntiAlias(true);
                GameActivity.this.paint.setColor(-GameActivity.lineColor[GameActivity.this.theme]);
                GameActivity.this.paint.setStyle(Style.FILL);
                GameActivity.this.path.reset();
                GameActivity gameActivity = GameActivity.this;
                int i = (GameActivity.this.screenW - ((int) GameActivity.this.goalWidthScaled)) / 2;
                GameActivity.this.coordX = i;
                gameActivity.aa = i;
                GameActivity.this.ab = (int) GameActivity.this.edgeLocScaled;
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = 0;
                getcoords();
                GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = 0;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = 0;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.path.moveTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.screenW - GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH - GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH - GameActivity.this.ab;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                GameActivity.this.coordX = GameActivity.this.aa;
                GameActivity.this.coordY = GameActivity.this.screenH;
                getcoords();
                GameActivity.this.path.lineTo((float) GameActivity.this.coordX, (float) GameActivity.this.coordY);
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paint);
                GameActivity.this.paint.setAntiAlias(true);
                GameActivity.this.paint.setStyle(Style.FILL);
                GameActivity.this.paintBlur.setColor(GameActivity.edgeTopBlurColor[GameActivity.this.theme]);
                GameActivity.this.ab = (((int) GameActivity.this.edgeLocScaled) * 4) / 2;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) (GameActivity.this.goalWidthScaled - GameActivity.this.edgeLocScaled))) / 2;
                GameActivity.this.ac = 0;
                back.drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paintBlur);
                GameActivity.this.paint.setColor(GameActivity.edgeTopColor[GameActivity.this.theme]);
                GameActivity.this.ab = (int) GameActivity.this.edgeLocScaled;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) GameActivity.this.goalWidthScaledPlayer)) / 2;
                GameActivity.this.ac = 0;
                back.drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paint);
                GameActivity.this.paintBlur.setColor(GameActivity.edgeBottomBlurColor[GameActivity.this.theme]);
                GameActivity.this.ab = (((int) GameActivity.this.edgeLocScaled) * 4) / 2;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) (GameActivity.this.goalWidthScaled - GameActivity.this.edgeLocScaled))) / 2;
                GameActivity.this.ac = GameActivity.this.screenH;
                back.drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paintBlur);
                GameActivity.this.paint.setColor(GameActivity.edgeBottomColor[GameActivity.this.theme]);
                GameActivity.this.ab = (int) GameActivity.this.edgeLocScaled;
                GameActivity.this.aa = (GameActivity.this.screenW - ((int) GameActivity.this.goalWidthScaled)) / 2;
                GameActivity.this.ac = GameActivity.this.screenH;
                back.drawedges();
                bgndCanvas.drawPath(GameActivity.this.path, GameActivity.this.paint);
            //}
            canvas.drawBitmap(GameActivity.this.bgndBitmap, 0.0f, 0.0f, null);



            if (GameActivity.this.soundMalletAct > 0) {
                gameActivity = GameActivity.this;
                gameActivity.soundMalletAct--;
            }
            if (GameActivity.this.soundWallAct > 0) {
                gameActivity = GameActivity.this;
                gameActivity.soundWallAct--;
            }
            if (GameActivity.this.soundGoalAct > 0) {
                gameActivity = GameActivity.this;
                gameActivity.soundGoalAct--;
            }
            GameActivity.this.drawCanvas = canvas;
            GameActivity.this.canvasW = GameActivity.this.screenW;
            GameActivity.this.canvasH = GameActivity.this.screenH;
            if (GameActivity.this.paused > 0) {
                GameActivity.this.ballTime = (GameActivity.this.pausedBallTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                GameActivity.this.gameEndTime = (GameActivity.this.pausedGameEndTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                if (GameActivity.this.paused == 1) {
                    GameActivity.this.paused2Time = System.currentTimeMillis();
                }
                if (GameActivity.this.paused == 2 && System.currentTimeMillis() > GameActivity.this.paused2Time + GameActivity.startDelay) {
                    GameActivity.this.paused = 0;
                    GameActivity.this.currentTime = System.currentTimeMillis();
                    GameActivity.this.ballTime = (GameActivity.this.pausedBallTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                    GameActivity.this.gameEndTime = (GameActivity.this.pausedGameEndTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                }
            } else {
                GameActivity.this.currentTime = System.currentTimeMillis();
                if (GameActivity.this.currentTime == GameActivity.this.ballTime) {
                    gameActivity = GameActivity.this;
                    gameActivity.ballTime--;
                }
                if (GameActivity.this.ballGoY <= 0.0f) {
                    GameActivity.this.ballGoY = 1.0f;
                }
                if (GameActivity.this.ballGoY >= ((float) GameActivity.this.screenH)) {
                    GameActivity.this.ballGoY = (float) (GameActivity.this.screenH - 1);
                }
                if (GameActivity.this.currentTime > GameActivity.this.hitTime + GameActivity.doubleDelay) {
                    GameActivity.this.hitFlag = 0;
                }
                if (GameActivity.this.ballGoY < ((float) GameActivity.this.screenH2) && GameActivity.this.hitFlag == 2) {
                    GameActivity.this.hitFlag = 0;
                }
                if (GameActivity.this.ballGoY > ((float) GameActivity.this.screenH2) && GameActivity.this.hitFlag == 1) {
                    GameActivity.this.hitFlag = 0;
                }
                if (GameActivity.this.players == 0 || GameActivity.this.players == 3) {
                    if (((GameActivity.this.ballVelY > 0.0f || GameActivity.this.hitFlag != 0) && GameActivity.this.currentTime <= GameActivity.this.doubleTime + GameActivity.doubleDelay) || GameActivity.this.ballGoY > ((float) GameActivity.this.screenH2) || GameActivity.this.gameEnded >= 0) {
                        GameActivity.this.batTopGoX = (float) GameActivity.this.screenW2;
                        GameActivity.this.batTopGoY = (GameActivity.this.goalWidthScaled / 2.0f) + GameActivity.this.edgeLocScaled;
                    } else {
                        GameActivity.this.batTopGoX = GameActivity.this.goalOffset + (((GameActivity.this.ballGoX - GameActivity.this.goalOffset) * (((float) GameActivity.this.screenH) - GameActivity.this.batTopCenterY)) / (((float) GameActivity.this.screenH) - GameActivity.this.ballGoY));
                        if (GameActivity.this.ballGoY <= ((((float) GameActivity.this.screenH2) - GameActivity.this.malletOuterRadScaled) - GameActivity.this.ballRadScaled) + 1.0f) {
                            if (GameActivity.this.ballVelY <= 0.0f) {
                                GameActivity.this.doubleTime = GameActivity.this.currentTime;
                            }
                            GameActivity.this.batTopGoY = GameActivity.this.ballGoY;
                        }
                    }
                }
                if (GameActivity.this.players == 1 || GameActivity.this.players == 3) {
                    if (((GameActivity.this.ballVelY < 0.0f || GameActivity.this.hitFlag != 0) && GameActivity.this.currentTime <= GameActivity.this.doubleTime + GameActivity.doubleDelay) || GameActivity.this.ballGoY < ((float) GameActivity.this.screenH2) || GameActivity.this.gameEnded >= 0) {
                        GameActivity.this.batBottomGoX = (float) GameActivity.this.screenW2;
                        GameActivity.this.batBottomGoY = (((float) GameActivity.this.screenH) - (GameActivity.this.goalWidthScaled / 2.0f)) - GameActivity.this.edgeLocScaled;
                    } else {
                        GameActivity.this.batBottomGoX = GameActivity.this.goalOffset + (((GameActivity.this.ballGoX - GameActivity.this.goalOffset) * GameActivity.this.batBottomCenterY) / GameActivity.this.ballGoY);
                        if (GameActivity.this.ballGoY >= ((((float) GameActivity.this.screenH2) + GameActivity.this.malletOuterRadScaled) + GameActivity.this.ballRadScaled) - 1.0f) {
                            if (GameActivity.this.ballVelY >= 0.0f) {
                                GameActivity.this.doubleTime = GameActivity.this.currentTime;
                            }
                            GameActivity.this.batBottomGoY = GameActivity.this.ballGoY;
                        }
                    }
                }
                GameActivity.this.fa = (GameActivity.this.batTopGoX - GameActivity.this.batTopStartX) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                GameActivity.this.fb = (GameActivity.this.batTopGoY - GameActivity.this.batTopStartY) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                GameActivity.this.fc = (float) (Math.sqrt((GameActivity.this.fb * GameActivity.this.fb) + (GameActivity.this.fa * GameActivity.this.fa)) + 1.0E-6f);
                if (GameActivity.this.fc <= GameActivity.this.velMaxTop) {
                    GameActivity.this.batTopCenterX = GameActivity.this.batTopGoX;
                    GameActivity.this.batTopCenterY = GameActivity.this.batTopGoY;
                } else {
                    GameActivity.this.batTopCenterX = GameActivity.this.batTopStartX + (((GameActivity.this.batTopGoX - GameActivity.this.batTopStartX) * GameActivity.this.velMaxTop) / GameActivity.this.fc);
                    GameActivity.this.batTopCenterY = GameActivity.this.batTopStartY + (((GameActivity.this.batTopGoY - GameActivity.this.batTopStartY) * GameActivity.this.velMaxTop) / GameActivity.this.fc);
                }
                GameActivity.this.fa = (GameActivity.this.batBottomGoX - GameActivity.this.batBottomStartX) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                GameActivity.this.fb = (GameActivity.this.batBottomGoY - GameActivity.this.batBottomStartY) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                GameActivity.this.fc = (float) (Math.sqrt((GameActivity.this.fb * GameActivity.this.fb) + (GameActivity.this.fa * GameActivity.this.fa)) + 1.0E-6f);
                if (GameActivity.this.fc <= GameActivity.this.velMaxBottom) {
                    GameActivity.this.batBottomCenterX = GameActivity.this.batBottomGoX;
                    GameActivity.this.batBottomCenterY = GameActivity.this.batBottomGoY;
                } else {
                    GameActivity.this.batBottomCenterX = GameActivity.this.batBottomStartX + (((GameActivity.this.batBottomGoX - GameActivity.this.batBottomStartX) * GameActivity.this.velMaxBottom) / GameActivity.this.fc);
                    GameActivity.this.batBottomCenterY = GameActivity.this.batBottomStartY + (((GameActivity.this.batBottomGoY - GameActivity.this.batBottomStartY) * GameActivity.this.velMaxBottom) / GameActivity.this.fc);
                }
                if (GameActivity.this.batBottomCenterY + GameActivity.this.malletOuterRadScaled > ((float) GameActivity.this.screenH) - GameActivity.this.edgeLocScaled) {
                    GameActivity.this.batBottomCenterY = (((float) GameActivity.this.screenH) - GameActivity.this.edgeLocScaled) - GameActivity.this.malletOuterRadScaled;
                }
                if (GameActivity.this.batBottomCenterX + GameActivity.this.malletOuterRadScaled > ((float) GameActivity.this.screenW) - GameActivity.this.edgeLocScaled) {
                    GameActivity.this.batBottomCenterX = (((float) GameActivity.this.screenW) - GameActivity.this.edgeLocScaled) - GameActivity.this.malletOuterRadScaled;
                }
                if (GameActivity.this.batBottomCenterX - GameActivity.this.malletOuterRadScaled < GameActivity.this.edgeLocScaled) {
                    GameActivity.this.batBottomCenterX = GameActivity.this.edgeLocScaled + GameActivity.this.malletOuterRadScaled;
                }
                if (GameActivity.this.batTopCenterY - GameActivity.this.malletOuterRadScaled < GameActivity.this.edgeLocScaled) {
                    GameActivity.this.batTopCenterY = GameActivity.this.edgeLocScaled + GameActivity.this.malletOuterRadScaled;
                }
                if (GameActivity.this.batTopCenterX + GameActivity.this.malletOuterRadScaled > ((float) GameActivity.this.screenW) - GameActivity.this.edgeLocScaled) {
                    GameActivity.this.batTopCenterX = (((float) GameActivity.this.screenW) - GameActivity.this.edgeLocScaled) - GameActivity.this.malletOuterRadScaled;
                }
                if (GameActivity.this.batTopCenterX - GameActivity.this.malletOuterRadScaled < GameActivity.this.edgeLocScaled) {
                    GameActivity.this.batTopCenterX = GameActivity.this.edgeLocScaled + GameActivity.this.malletOuterRadScaled;
                }
            }
            setPlayerMalletSize();
            setGoalSize();
            GameActivity.this.coordX = (int) GameActivity.this.batBottomCenterX;
            GameActivity.this.coordY = (int) GameActivity.this.batBottomCenterY;
            getcoords();
            GameActivity.this.paint.setAntiAlias(true);
            GameActivity.this.paint.setStyle(Style.FILL);
            GameActivity.this.paintBlur.setColor(GameActivity.malletBottomBlurColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, (GameActivity.this.malletOuterRadScaled * 5.0f) / 4.0f, GameActivity.this.paintBlur);
            GameActivity.this.paint.setColor(GameActivity.malletBottomOuterColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.malletOuterRadScaled, GameActivity.this.paint);
            GameActivity.this.paint.setColor(GameActivity.malletBottomMiddleColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.malletMiddleRadScaled, GameActivity.this.paint);
            GameActivity.this.paint.setColor(GameActivity.malletBottomInnerColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.malletInnerRadScaled, GameActivity.this.paint);
            GameActivity.this.coordX = (int) GameActivity.this.batTopCenterX;
            GameActivity.this.coordY = (int) GameActivity.this.batTopCenterY;
            getcoords();
            GameActivity.this.paint.setAntiAlias(true);
            GameActivity.this.paintBlur.setColor(GameActivity.malletTopBlurColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, (GameActivity.this.malletOuterRadScaled2 * 5.0f) / 4.0f, GameActivity.this.paintBlur);
            GameActivity.this.paint.setColor(GameActivity.malletTopOuterColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.malletOuterRadScaled2, GameActivity.this.paint);
            GameActivity.this.paint.setColor(GameActivity.malletTopMiddleColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.malletMiddleRadScaled2, GameActivity.this.paint);
            GameActivity.this.paint.setColor(GameActivity.malletTopInnerColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.malletInnerRadScaled2, GameActivity.this.paint);
            if (GameActivity.this.paused == 0) {
                if (GameActivity.this.gameEnded > 0) {
                    GameActivity.this.ballGoX = (float) (-GameActivity.this.screenW);
                } else if (GameActivity.this.gameEnded == 0) {
                    GameActivity.this.ballGoX = (float) (-GameActivity.this.screenW);
                    gameActivity = GameActivity.this;
                    GameActivity gameActivity2 = GameActivity.this;
                    float f = (float) GameActivity.this.screenW2;
                    GameActivity.this.batTopStartX = f;
                    gameActivity2.batTopCenterX = f;
                    gameActivity.batTopGoX = f;
                    gameActivity = GameActivity.this;
                    gameActivity2 = GameActivity.this;
                    f = (GameActivity.this.goalWidthScaled / 1.0f) + GameActivity.this.edgeLocScaled;
                    GameActivity.this.batTopStartY = f;
                    gameActivity2.batTopCenterY = f;
                    gameActivity.batTopGoY = f;
                    gameActivity = GameActivity.this;
                    gameActivity2 = GameActivity.this;
                    f = (float) GameActivity.this.screenW2;
                    GameActivity.this.batBottomStartX = f;
                    gameActivity2.batBottomCenterX = f;
                    gameActivity.batBottomGoX = f;
                    gameActivity = GameActivity.this;
                    gameActivity2 = GameActivity.this;
                    f = (((float) GameActivity.this.screenH) - (GameActivity.this.goalWidthScaled / 2.0f)) - GameActivity.this.edgeLocScaled;
                    GameActivity.this.batBottomStartY = f;
                    gameActivity2.batBottomCenterY = f;
                    gameActivity.batBottomGoY = f;
                    if (GameActivity.this.currentTime > GameActivity.this.ballTime + GameActivity.startDelay) {
                        if (GameActivity.this.players == 3 || GameActivity.this.currentTime <= GameActivity.this.gameEndTime) {
                            GameActivity.this.gameEnded = -1;
                            gameActivity = GameActivity.this;
                            gameActivity2 = GameActivity.this;
                            long j = GameActivity.this.currentTime;
                            gameActivity2.ballTime = j;
                            gameActivity.doubleTime = j;
                            GameActivity.this.hitFlag = 0;
                            if (Math.random() < 0.5d) {
                                GameActivity.this.ballGoY = ((float) GameActivity.this.screenH2) + (GameActivity.this.goalWidthScaled / 2.0f);
                            } else {
                                GameActivity.this.ballGoY = ((float) GameActivity.this.screenH2) - (GameActivity.this.goalWidthScaled / 2.0f);
                            }
                            GameActivity.this.ballGoX = (float) GameActivity.this.screenW2;
                            GameActivity.this.ballStartX = GameActivity.this.ballGoX;
                            GameActivity.this.ballStartY = GameActivity.this.ballGoY;
                            GameActivity.this.ballVelX = 0.0f;
                            GameActivity.this.ballVelY = 0.0f;
                            GameActivity.this.goalOffset = (((float) GameActivity.this.screenW) + ((GameActivity.this.goalWidthScaled * 2.0f) * ((float) (Math.random() - 0.5d)))) / 2.0f;
                            GameActivity.this.coordX = (int) GameActivity.this.ballGoX;
                            GameActivity.this.coordY = (int) GameActivity.this.ballGoY;
                            getcoords();
                            GameActivity.this.paint.setAntiAlias(true);
                            GameActivity.this.paint.setColor(GameActivity.ballColor[GameActivity.this.theme]);
                            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.ballRadScaled, GameActivity.this.paint);
                            //canvas.drawCircle((float) GameActivity.this.coordX-20, (float) GameActivity.this.coordY-20, GameActivity.this.ballRadScaled, GameActivity.this.paint);
                        } else {
                            if (GameActivity.this.scoreTop == GameActivity.this.scoreBottom) {
                                GameActivity.this.gameEnded = 3;
                            } else if (GameActivity.this.scoreTop > GameActivity.this.scoreBottom) {
                                GameActivity.this.gameEnded = 1;
                            } else {
                                GameActivity.this.gameEnded = 2;
                            }
                            Editor editor = GameActivity.this.gGameSettings.edit();
                            editor.putInt(CommonActivity.GAME_PREFERENCES_GAMEOVER, GameActivity.this.gameEnded);
                            editor.commit();
                        }
                    }
                } else {
                    GameActivity.this.ballGoX = (((float) (GameActivity.this.currentTime - GameActivity.this.ballTime)) * GameActivity.this.ballVelX) + GameActivity.this.ballStartX;
                    GameActivity.this.ballGoY = (((float) (GameActivity.this.currentTime - GameActivity.this.ballTime)) * GameActivity.this.ballVelY) + GameActivity.this.ballStartY;
                    if (GameActivity.this.currentTime == GameActivity.this.ballTime) {
                        gameActivity = GameActivity.this;
                        gameActivity.ballTime--;
                    }
                    GameActivity.this.fa = ((((float) GameActivity.this.screenW) - GameActivity.this.goalWidthScaled) - (GameActivity.this.ballRadScaled / 2.0f)) / 2.0f;
                    GameActivity.this.fb = ((float) GameActivity.this.screenW) - GameActivity.this.fa;
                    if (GameActivity.this.ballGoY + GameActivity.this.ballRadScaled >= ((float) GameActivity.this.screenH) - GameActivity.this.edgeLocScaled) {
                        if (GameActivity.this.ballGoX <= GameActivity.this.fa || GameActivity.this.ballGoX >= GameActivity.this.fb) {
                            GameActivity.this.ballGoY = ((((float) GameActivity.this.screenH) - GameActivity.this.edgeLocScaled) - GameActivity.this.ballRadScaled) - 1.0f;
                            GameActivity.this.ballVelY = (-GameActivity.this.ballVelY) * GameActivity.decelHit;
                            gameActivity = GameActivity.this;
                            gameActivity.ballVelX *= GameActivity.decelHit;
                            soundwall();
                        } else if (GameActivity.this.ballGoY > ((float) GameActivity.this.screenH)) {
                            GameActivity.this.gameEnded = 0;
                            GameActivity.this.ballTime = GameActivity.this.currentTime;
                            gameActivity = GameActivity.this;
                            gameActivity.scoreTop++;
                            if (GameActivity.this.scoreTop > 6 && GameActivity.this.gameDuration == 6000000000000L) {
                                GameActivity.this.gameEndTime = 0;
                            }
                            if (GameActivity.this.scoreTop > 14 && GameActivity.this.gameDuration == 12000000000000L) {
                                GameActivity.this.gameEndTime = 0;
                            }
                            soundgoal();
                        } else {
                            if (GameActivity.this.ballGoX - GameActivity.this.ballRadScaled <= GameActivity.this.fa && GameActivity.this.ballVelX < 0.0f) {
                                GameActivity.this.ballGoX = GameActivity.this.fa + GameActivity.this.ballRadScaled;
                                GameActivity.this.ballVelX = -GameActivity.this.ballVelX;
                                soundwall();
                            }
                            if (GameActivity.this.ballGoX + GameActivity.this.ballRadScaled >= GameActivity.this.fb && GameActivity.this.ballVelX > 0.0f) {
                                GameActivity.this.ballGoX = GameActivity.this.fb - GameActivity.this.ballRadScaled;
                                GameActivity.this.ballVelX = -GameActivity.this.ballVelX;
                                soundwall();
                            }
                        }
                    }
                    if (GameActivity.this.ballGoY - GameActivity.this.ballRadScaled <= GameActivity.this.edgeLocScaled) {
                        if (GameActivity.this.ballGoX <= GameActivity.this.fa || GameActivity.this.ballGoX >= GameActivity.this.fb) {
                            GameActivity.this.ballGoY = (GameActivity.this.edgeLocScaled + GameActivity.this.ballRadScaled) + 1.0f;
                            GameActivity.this.ballVelY = (-GameActivity.this.ballVelY) * GameActivity.decelHit;
                            gameActivity = GameActivity.this;
                            gameActivity.ballVelX *= GameActivity.decelHit;
                            soundwall();
                        } else if (GameActivity.this.ballGoY < 0.0f) {
                            GameActivity.this.gameEnded = 0;
                            GameActivity.this.ballTime = GameActivity.this.currentTime;
                            gameActivity = GameActivity.this;
                            gameActivity.scoreBottom++;
                            if (GameActivity.this.scoreBottom > 6 && GameActivity.this.gameDuration == 6000000000000L) {
                                GameActivity.this.gameEndTime = 0;
                            }
                            if (GameActivity.this.scoreBottom > 14 && GameActivity.this.gameDuration == 12000000000000L) {
                                GameActivity.this.gameEndTime = 0;
                            }
                            soundgoal();
                        } else {
                            if (GameActivity.this.ballGoX - GameActivity.this.ballRadScaled <= GameActivity.this.fa && GameActivity.this.ballVelX < 0.0f) {
                                GameActivity.this.ballGoX = GameActivity.this.fa + GameActivity.this.ballRadScaled;
                                GameActivity.this.ballVelX = -GameActivity.this.ballVelX;
                                soundwall();
                            }
                            if (GameActivity.this.ballGoX + GameActivity.this.ballRadScaled >= GameActivity.this.fb && GameActivity.this.ballVelX > 0.0f) {
                                GameActivity.this.ballGoX = GameActivity.this.fb - GameActivity.this.ballRadScaled;
                                GameActivity.this.ballVelX = -GameActivity.this.ballVelX;
                                soundwall();
                            }
                        }
                    }
                    if (GameActivity.this.ballGoX + GameActivity.this.ballRadScaled >= ((float) GameActivity.this.screenW) - GameActivity.this.edgeLocScaled) {
                        GameActivity.this.ballGoX = ((((float) GameActivity.this.screenW) - GameActivity.this.edgeLocScaled) - GameActivity.this.ballRadScaled) - 1.0f;
                        GameActivity.this.ballVelX = (-GameActivity.this.ballVelX) * GameActivity.decelHit;
                        gameActivity = GameActivity.this;
                        gameActivity.ballVelY *= GameActivity.decelHit;
                        soundwall();
                        if (GameActivity.this.ballVelX + GameActivity.this.ballVelY < GameActivity.this.velMinScaled) {
                            gameActivity = GameActivity.this;
                            gameActivity.ballVelX *= 1.2f;
                            gameActivity = GameActivity.this;
                            gameActivity.ballVelY *= 1.2f;
                        }
                    }
                    if (GameActivity.this.ballGoX - GameActivity.this.ballRadScaled <= GameActivity.this.edgeLocScaled) {
                        GameActivity.this.ballGoX = (GameActivity.this.edgeLocScaled + GameActivity.this.ballRadScaled) + 1.0f;
                        GameActivity.this.ballVelX = (-GameActivity.this.ballVelX) * GameActivity.decelHit;
                        gameActivity = GameActivity.this;
                        gameActivity.ballVelY *= GameActivity.decelHit;
                        soundwall();
                        if (GameActivity.this.ballVelX + GameActivity.this.ballVelY < GameActivity.this.velMinScaled) {
                            gameActivity = GameActivity.this;
                            gameActivity.ballVelX *= 1.2f;
                            gameActivity = GameActivity.this;
                            gameActivity.ballVelY *= 1.2f;
                        }
                    }
                    GameActivity.this.fh = GameActivity.this.batTopCenterX - GameActivity.this.batTopStartX;
                    GameActivity.this.fi = GameActivity.this.batTopCenterY - GameActivity.this.batTopStartY;
                    if (Math.abs(GameActivity.this.fh) > Math.abs(GameActivity.this.fi)) {
                        GameActivity.this.aa = ((int) ((Math.abs(GameActivity.this.fh) * 2.0f) / GameActivity.this.malletOuterRadScaled)) + 1;
                    } else {
                        GameActivity.this.aa = ((int) ((Math.abs(GameActivity.this.fi) * 2.0f) / GameActivity.this.malletOuterRadScaled)) + 1;
                    }
                    gameActivity = GameActivity.this;
                    gameActivity.fh /= (float) GameActivity.this.aa;
                    gameActivity = GameActivity.this;
                    gameActivity.fi /= (float) GameActivity.this.aa;
                    GameActivity.this.fj = (GameActivity.this.ballGoX - GameActivity.this.ballStartX) / ((float) GameActivity.this.aa);
                    GameActivity.this.fk = (GameActivity.this.ballGoY - GameActivity.this.ballStartY) / ((float) GameActivity.this.aa);
                    GameActivity.this.ab = 0;
                    do {
                        gameActivity = GameActivity.this;
                        gameActivity.ab++;
                        GameActivity.this.fb = (GameActivity.this.ballStartX - GameActivity.this.batTopStartX) + (((float) GameActivity.this.ab) * (GameActivity.this.fj - GameActivity.this.fh));
                        GameActivity.this.fc = (GameActivity.this.ballStartY - GameActivity.this.batTopStartY) + (((float) GameActivity.this.ab) * (GameActivity.this.fk - GameActivity.this.fi));
                        GameActivity.this.fa = (float) (Math.sqrt((GameActivity.this.fb * GameActivity.this.fb) + (GameActivity.this.fc * GameActivity.this.fc)) + 1.0E-6f);
                        if (GameActivity.this.ab >= GameActivity.this.aa) {
                            break;
                        }
                    } while (GameActivity.this.fa > GameActivity.this.ballRadScaled + GameActivity.this.malletOuterRadScaled);
                    if (GameActivity.this.fa <= GameActivity.this.ballRadScaled + GameActivity.this.malletOuterRadScaled) {
                        soundmallet();
                        GameActivity.this.ballGo2X = GameActivity.this.batTopCenterX + ((GameActivity.this.fb * ((GameActivity.this.ballRadScaled + 1.0f) + GameActivity.this.malletOuterRadScaled)) / GameActivity.this.fa);
                        GameActivity.this.ballGo2Y = GameActivity.this.batTopCenterY + ((GameActivity.this.fc * ((GameActivity.this.ballRadScaled + 1.0f) + GameActivity.this.malletOuterRadScaled)) / GameActivity.this.fa);
                        GameActivity.this.ballVel = (float) Math.sqrt((GameActivity.this.ballVelX * GameActivity.this.ballVelX) + (GameActivity.this.ballVelY * GameActivity.this.ballVelY));
                        GameActivity.this.fd = (float) Math.atan2((double) GameActivity.this.fb, (double) GameActivity.this.fc);
                        GameActivity.this.fe = ((float) Math.atan2((double) GameActivity.this.ballVelX, (double) GameActivity.this.ballVelY)) - 3.1415927f;
                        GameActivity.this.ff = (GameActivity.this.fd * 2.0f) - GameActivity.this.fe;
                        GameActivity.this.fg = GameActivity.this.ff - GameActivity.this.fd;
                        if (GameActivity.this.fg > 3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg -= 6.2831855f;
                        }
                        if (GameActivity.this.fg < -3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg += 6.2831855f;
                        }
                        if (GameActivity.this.fg > 1.57f) {
                            GameActivity.this.ff = GameActivity.this.fd + 1.57f;
                        }
                        if (GameActivity.this.fg < -1.57f) {
                            GameActivity.this.ff = GameActivity.this.fd - 1.57f;
                        }
                        GameActivity.this.fh = (GameActivity.this.batTopCenterX - GameActivity.this.batTopStartX) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                        GameActivity.this.fi = (GameActivity.this.batTopCenterY - GameActivity.this.batTopStartY) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                        GameActivity.this.fj = (float) Math.atan2((double) GameActivity.this.fh, (double) GameActivity.this.fi);
                        GameActivity.this.fg = GameActivity.this.fj - GameActivity.this.fd;
                        if (GameActivity.this.fg > 3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg -= 6.2831855f;
                        }
                        if (GameActivity.this.fg < -3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg += 6.2831855f;
                        }
                        if (GameActivity.this.ballVel > GameActivity.this.velMaxScaled * GameActivity.velHitMax) {
                            GameActivity.this.ballVel = GameActivity.this.velMaxScaled * GameActivity.velHitMax;
                        }
                        GameActivity.this.fk = (float) Math.abs(Math.cos(GameActivity.this.fg));
                        GameActivity.this.ballVelX = (float) ((((Math.sin(GameActivity.this.ff) * GameActivity.this.ballVel) * GameActivity.decelHit) + (GameActivity.this.fh * GameActivity.this.fk)) - ((GameActivity.this.fi * GameActivity.this.fk) * Math.sin(GameActivity.this.fg)));
                        GameActivity.this.ballVelY = (float) ((((Math.cos(GameActivity.this.ff) * GameActivity.this.ballVel) * GameActivity.decelHit) + (GameActivity.this.fi * GameActivity.this.fk)) + ((GameActivity.this.fh * GameActivity.this.fk) * Math.sin(GameActivity.this.fg)));
                        GameActivity.this.ballGoX = GameActivity.this.ballGo2X;
                        GameActivity.this.ballGoY = GameActivity.this.ballGo2Y;
                        GameActivity.this.hitFlag = 1;
                        GameActivity.this.hitTime = GameActivity.this.currentTime;
                    }
                    GameActivity.this.fh = GameActivity.this.batBottomCenterX - GameActivity.this.batBottomStartX;
                    GameActivity.this.fi = GameActivity.this.batBottomCenterY - GameActivity.this.batBottomStartY;
                    if (Math.abs(GameActivity.this.fh) > Math.abs(GameActivity.this.fi)) {
                        GameActivity.this.aa = ((int) ((Math.abs(GameActivity.this.fh) * 2.0f) / GameActivity.this.malletOuterRadScaled)) + 1;
                    } else {
                        GameActivity.this.aa = ((int) ((Math.abs(GameActivity.this.fi) * 2.0f) / GameActivity.this.malletOuterRadScaled)) + 1;
                    }
                    gameActivity = GameActivity.this;
                    gameActivity.fh /= (float) GameActivity.this.aa;
                    gameActivity = GameActivity.this;
                    gameActivity.fi /= (float) GameActivity.this.aa;
                    GameActivity.this.fj = (GameActivity.this.ballGoX - GameActivity.this.ballStartX) / ((float) GameActivity.this.aa);
                    GameActivity.this.fk = (GameActivity.this.ballGoY - GameActivity.this.ballStartY) / ((float) GameActivity.this.aa);
                    GameActivity.this.ab = 0;
                    do {
                        gameActivity = GameActivity.this;
                        gameActivity.ab++;
                        GameActivity.this.fb = (GameActivity.this.ballStartX - GameActivity.this.batBottomStartX) + (((float) GameActivity.this.ab) * (GameActivity.this.fj - GameActivity.this.fh));
                        GameActivity.this.fc = (GameActivity.this.ballStartY - GameActivity.this.batBottomStartY) + (((float) GameActivity.this.ab) * (GameActivity.this.fk - GameActivity.this.fi));
                        GameActivity.this.fa = (float) (Math.sqrt((GameActivity.this.fb * GameActivity.this.fb) + (GameActivity.this.fc * GameActivity.this.fc)) + 1.0E-6f);
                        if (GameActivity.this.ab >= GameActivity.this.aa) {
                            break;
                        }
                    } while (GameActivity.this.fa > GameActivity.this.ballRadScaled + GameActivity.this.malletOuterRadScaled);
                    if (GameActivity.this.fa <= GameActivity.this.ballRadScaled + GameActivity.this.malletOuterRadScaled) {
                        soundmallet();
                        GameActivity.this.ballGo2X = GameActivity.this.batBottomCenterX + ((GameActivity.this.fb * ((GameActivity.this.ballRadScaled + 1.0f) + GameActivity.this.malletOuterRadScaled)) / GameActivity.this.fa);
                        GameActivity.this.ballGo2Y = GameActivity.this.batBottomCenterY + ((GameActivity.this.fc * ((GameActivity.this.ballRadScaled + 1.0f) + GameActivity.this.malletOuterRadScaled)) / GameActivity.this.fa);
                        GameActivity.this.ballVel = (float) Math.sqrt((GameActivity.this.ballVelX * GameActivity.this.ballVelX) + (GameActivity.this.ballVelY * GameActivity.this.ballVelY));
                        GameActivity.this.fd = (float) Math.atan2((double) GameActivity.this.fb, (double) GameActivity.this.fc);
                        GameActivity.this.fe = ((float) Math.atan2((double) GameActivity.this.ballVelX, (double) GameActivity.this.ballVelY)) - 3.1415927f;
                        GameActivity.this.ff = (GameActivity.this.fd * 2.0f) - GameActivity.this.fe;
                        GameActivity.this.fg = GameActivity.this.ff - GameActivity.this.fd;
                        if (GameActivity.this.fg > 3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg -= 6.2831855f;
                        }
                        if (GameActivity.this.fg < -3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg += 6.2831855f;
                        }
                        if (GameActivity.this.fg > 1.57f) {
                            GameActivity.this.ff = GameActivity.this.fd + 1.57f;
                        }
                        if (GameActivity.this.fg < -1.57f) {
                            GameActivity.this.ff = GameActivity.this.fd - 1.57f;
                        }
                        GameActivity.this.fh = (GameActivity.this.batBottomCenterX - GameActivity.this.batBottomStartX) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                        GameActivity.this.fi = (GameActivity.this.batBottomCenterY - GameActivity.this.batBottomStartY) / ((float) (GameActivity.this.currentTime - GameActivity.this.ballTime));
                        GameActivity.this.fj = (float) Math.atan2((double) GameActivity.this.fh, (double) GameActivity.this.fi);
                        GameActivity.this.fg = GameActivity.this.fj - GameActivity.this.fd;
                        if (GameActivity.this.fg > 3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg -= 6.2831855f;
                        }
                        if (GameActivity.this.fg < -3.1415927f) {
                            gameActivity = GameActivity.this;
                            gameActivity.fg += 6.2831855f;
                        }
                        if (GameActivity.this.ballVel > GameActivity.this.velMaxScaled * GameActivity.velHitMax) {
                            GameActivity.this.ballVel = GameActivity.this.velMaxScaled * GameActivity.velHitMax;
                        }
                        GameActivity.this.fk = (float) Math.abs(Math.cos(GameActivity.this.fg));
                        GameActivity.this.ballVelX = (float) ((((Math.sin(GameActivity.this.ff) * GameActivity.this.ballVel) * GameActivity.decelHit) + (GameActivity.this.fh * GameActivity.this.fk)) - ((GameActivity.this.fi * GameActivity.this.fk) * Math.sin(GameActivity.this.fg)));
                        GameActivity.this.ballVelY = (float) ((((Math.cos(GameActivity.this.ff) * GameActivity.this.ballVel) * GameActivity.decelHit) + (GameActivity.this.fi * GameActivity.this.fk)) + ((GameActivity.this.fh * GameActivity.this.fk) * Math.sin(GameActivity.this.fg)));
                        GameActivity.this.ballGoX = GameActivity.this.ballGo2X;
                        GameActivity.this.ballGoY = GameActivity.this.ballGo2Y;
                        GameActivity.this.hitFlag = 2;
                        GameActivity.this.hitTime = GameActivity.this.currentTime;
                    }
                    GameActivity.this.ballTime = GameActivity.this.currentTime;
                }
                GameActivity.this.ballStartX = GameActivity.this.ballGoX;
                GameActivity.this.ballStartY = GameActivity.this.ballGoY;
                GameActivity.this.batTopStartX = GameActivity.this.batTopCenterX;
                GameActivity.this.batBottomStartX = GameActivity.this.batBottomCenterX;
                GameActivity.this.batTopStartY = GameActivity.this.batTopCenterY;
                GameActivity.this.batBottomStartY = GameActivity.this.batBottomCenterY;
            }
            GameActivity.this.coordX = (int) GameActivity.this.ballGoX;
            GameActivity.this.coordY = (int) GameActivity.this.ballGoY;
            getcoords();
            GameActivity.this.paint.setAntiAlias(true);
            GameActivity.this.paintBlur.setColor(GameActivity.ballBlurColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, (GameActivity.this.ballRadScaled * 7.0f) / 4.0f, GameActivity.this.paintBlur);
            canvas.drawCircle((float) GameActivity.this.coordX-100, (float) GameActivity.this.coordY-20, (GameActivity.this.ballRadScaled * 7.0f) / 4.0f, GameActivity.this.paintBlur);
            GameActivity.this.paint.setColor(GameActivity.ballColor[GameActivity.this.theme]);
            canvas.drawCircle((float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.ballRadScaled, GameActivity.this.paint);
            canvas.drawCircle((float) GameActivity.this.coordX-20, (float) GameActivity.this.coordY, GameActivity.this.ballRadScaled-20, GameActivity.this.paint);
            GameActivity.this.paint.setStyle(Style.FILL);
            GameActivity.this.paint.setAntiAlias(true);
            GameActivity.this.paint.setTextSize((float) (GameActivity.this.screenW / 10));
            GameActivity.this.paint.setTypeface(Typeface.DEFAULT_BOLD);
            GameActivity.this.paint.setTextAlign(Align.LEFT);
            GameActivity.this.paint.setColor(GameActivity.scoreColor[GameActivity.this.theme]);
            GameActivity.this.paintBlur.setColor(GameActivity.scoreBlurColor[GameActivity.this.theme]);
            GameActivity.this.paint.setTextAlign(Align.RIGHT);
            if (GameActivity.this.landscape == 1) {
                canvas.drawText(new StringBuilder(String.valueOf(Integer.toString(GameActivity.this.scoreTop))).append("      ").toString(), (float) GameActivity.this.screenH2, (float) (GameActivity.this.screenW / 8), GameActivity.this.paint);
                GameActivity.this.paint.setTextAlign(Align.LEFT);
                canvas.drawText("      " + Integer.toString(GameActivity.this.scoreBottom), (float) GameActivity.this.screenH2, (float) (GameActivity.this.screenW / 8), GameActivity.this.paint);
            } else {
                canvas.drawText(new StringBuilder(String.valueOf(Integer.toString(GameActivity.this.scoreTop))).append("  ").toString(), (float) GameActivity.this.screenW, (float) (GameActivity.this.screenH / 4), GameActivity.this.paint);
                canvas.drawText(new StringBuilder(String.valueOf(Integer.toString(GameActivity.this.scoreBottom))).append("  ").toString(), (float) GameActivity.this.screenW, (float) ((GameActivity.this.screenH * 3) / 4), GameActivity.this.paint);
            }

            //end the game if the game end time less than the current time
            if (GameActivity.this.players != 3 && GameActivity.this.currentTime > GameActivity.this.gameEndTime) {
                if (GameActivity.this.gameEnded == -1) {
                    GameActivity.this.gameEnded = 0;
                }

                GameActivity.this.paint.setColor(GameActivity.this.dataColors[(GameActivity.this.theme * GameActivity.colorsNo) + 0]);
                GameActivity.this.paint.setTextAlign(Align.CENTER);
                GameActivity.this.coordX = GameActivity.this.screenW / 2;
                GameActivity.this.coordY = GameActivity.this.screenH / 2;
                getcoords();
                canvas.drawText(getResources().getString(R.string.game_over), (float) (GameActivity.this.coordX - 3), (float) (GameActivity.this.coordY - 3), GameActivity.this.paint);
                canvas.drawText(getResources().getString(R.string.game_over), (float) (GameActivity.this.coordX - 3), (float) (GameActivity.this.coordY + 3), GameActivity.this.paint);
                canvas.drawText(getResources().getString(R.string.game_over), (float) (GameActivity.this.coordX + 3), (float) (GameActivity.this.coordY - 3), GameActivity.this.paint);
                canvas.drawText(getResources().getString(R.string.game_over), (float) (GameActivity.this.coordX + 3), (float) (GameActivity.this.coordY + 3), GameActivity.this.paint);
                GameActivity.this.paint.setColor(GameActivity.this.dataColors[(GameActivity.this.theme * GameActivity.colorsNo) + 1]);
                canvas.drawText(getResources().getString(R.string.game_over), (float) GameActivity.this.coordX, (float) GameActivity.this.coordY, GameActivity.this.paint);
            }
            if (GameActivity.this.paused == 1) {
                if (GameActivity.this.landscape == 1) {
                    GameActivity.this.drawStart = 36;
                    GameActivity.this.drawNo = 3;
                    drawquads();
                } else {
                    GameActivity.this.drawStart = 0;
                    GameActivity.this.drawNo = 3;
                    drawquads();
                }
            }
            if (GameActivity.this.gameEnded <= 0 && GameActivity.this.paused != 1) {
                invalidate();
            }
        }

        private void drawquads() {
            GameActivity.this.aa = 0;
            while (GameActivity.this.aa < GameActivity.this.drawNo) {
                GameActivity gameActivity;
                if (GameActivity.dataQuads[GameActivity.this.drawStart + 11] == 0) {
                    GameActivity.this.drawPaint = GameActivity.this.paint;
                } else {
                    GameActivity.this.drawPaint = GameActivity.this.paintBlur;
                }
                GameActivity.this.ae = GameActivity.dataQuads[GameActivity.this.drawStart + 8];
                if (GameActivity.this.ae == 0) {
                    GameActivity.this.drawPaint.setStyle(Style.STROKE);
                } else {
                    GameActivity.this.drawPaint.setStyle(Style.FILL);
                }
                GameActivity.this.drawPaint.setStrokeWidth((float) ((GameActivity.this.canvasW * GameActivity.dataQuads[GameActivity.this.drawStart + 9]) / 1000));
                GameActivity.this.drawPaint.setColor(GameActivity.this.dataColors[(GameActivity.this.theme * GameActivity.colorsNo) + GameActivity.dataQuads[GameActivity.this.drawStart + 10]]);
                if (GameActivity.this.landscape == 1) {
                    GameActivity.this.ac = (GameActivity.dataQuads[GameActivity.this.drawStart + 6] * GameActivity.this.canvasW) / 1000;
                    GameActivity.this.ab = (GameActivity.dataQuads[GameActivity.this.drawStart + 7] * GameActivity.this.canvasH) / 1000;
                } else {
                    GameActivity.this.ab = (GameActivity.dataQuads[GameActivity.this.drawStart + 6] * GameActivity.this.canvasW) / 1000;
                    GameActivity.this.ac = (GameActivity.dataQuads[GameActivity.this.drawStart + 7] * GameActivity.this.canvasH) / 1000;
                }
                GameActivity.this.path.reset();
                GameActivity.this.path.moveTo((float) GameActivity.this.ab, (float) GameActivity.this.ac);
                GameActivity.this.af = 0;
                while (GameActivity.this.af < 4) {
                    int[] iArr;
                    GameActivity gameActivity2;
                    int i;
                    if (GameActivity.this.landscape == 1) {
                        gameActivity = GameActivity.this;
                        iArr = GameActivity.dataQuads;
                        gameActivity2 = GameActivity.this;
                        i = gameActivity2.drawStart;
                        gameActivity2.drawStart = i + 1;
                        gameActivity.ae = (iArr[i] * GameActivity.this.canvasW) / 1000;
                        gameActivity = GameActivity.this;
                        iArr = GameActivity.dataQuads;
                        gameActivity2 = GameActivity.this;
                        i = gameActivity2.drawStart;
                        gameActivity2.drawStart = i + 1;
                        gameActivity.ad = (iArr[i] * GameActivity.this.canvasH) / 1000;
                    } else {
                        gameActivity = GameActivity.this;
                        iArr = GameActivity.dataQuads;
                        gameActivity2 = GameActivity.this;
                        i = gameActivity2.drawStart;
                        gameActivity2.drawStart = i + 1;
                        gameActivity.ad = (iArr[i] * GameActivity.this.canvasW) / 1000;
                        gameActivity = GameActivity.this;
                        iArr = GameActivity.dataQuads;
                        gameActivity2 = GameActivity.this;
                        i = gameActivity2.drawStart;
                        gameActivity2.drawStart = i + 1;
                        gameActivity.ae = (iArr[i] * GameActivity.this.canvasH) / 1000;
                    }
                    GameActivity.this.path.lineTo((float) GameActivity.this.ad, (float) GameActivity.this.ae);
                    gameActivity = GameActivity.this;
                    gameActivity.af++;
                }
                GameActivity.this.drawCanvas.drawPath(GameActivity.this.path, GameActivity.this.drawPaint);
                gameActivity = GameActivity.this;
                gameActivity.drawStart += 4;
                gameActivity = GameActivity.this;
                gameActivity.aa++;
            }
        }

        private void getcoords() {
            if (GameActivity.this.landscape == 1) {
                int temp = GameActivity.this.coordY;
                GameActivity.this.coordY = GameActivity.this.coordX;
                GameActivity.this.coordX = temp;
            }
        }

        private void soundwall() {
            if (GameActivity.this.soundLoaded > 0 && GameActivity.this.useSound == 0) {
                if (GameActivity.this.soundWallAct == 0) {
                    GameActivity.this.soundPool.play(GameActivity.this.soundWall, GameActivity.this.volume, GameActivity.this.volume, 1, 0, 1.0f);
                }
                GameActivity.this.soundWallAct = 2;
            }
        }

        private void soundmallet() {
            if (GameActivity.this.soundLoaded > 0 && GameActivity.this.useSound == 0) {
                if (GameActivity.this.soundMalletAct == 0) {
                    GameActivity.this.soundPool.play(GameActivity.this.soundMallet, GameActivity.this.volume, GameActivity.this.volume, 1, 0, 1.0f);
                }
                GameActivity.this.soundMalletAct = 2;
            }
        }

        private void soundgoal() {
            if (GameActivity.this.soundLoaded > 0 && GameActivity.this.useSound == 0) {
                if (GameActivity.this.soundGoalAct == 0) {
                    GameActivity.this.soundPool.play(GameActivity.this.soundGoal, GameActivity.this.volume, GameActivity.this.volume, 1, 0, 1.0f);
                }
                GameActivity.this.soundGoalAct = 2;
                GameActivity.this.soundPool.play(GameActivity.this.soundGoal, GameActivity.this.volume, GameActivity.this.volume, 1, 0, 1.0f);
            }
        }
    }

    public class ScreenReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Log.d(CommonActivity.TAG, "screen off");
                if (GameActivity.this.paused == 0) {
                    GameActivity.this.pausedTime = GameActivity.this.currentTime;
                    GameActivity.this.pausedBallTime = GameActivity.this.ballTime;
                    GameActivity.this.pausedGameEndTime = GameActivity.this.gameEndTime;
                    GameActivity.this.paused = 1;
                }
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                Log.d(CommonActivity.TAG, "screen on");
                GameActivity gameActivity = GameActivity.this;
                GameActivity gameActivity2 = GameActivity.this;
                long currentTimeMillis = System.currentTimeMillis();
                gameActivity2.currentTime = currentTimeMillis;
                gameActivity.paused2Time = currentTimeMillis;
                GameActivity.this.ballTime = (GameActivity.this.pausedBallTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
                GameActivity.this.gameEndTime = (GameActivity.this.pausedGameEndTime - GameActivity.this.pausedTime) + GameActivity.this.currentTime;
            }
        }
    }

    public GameActivity() {
        this.relVelPro = new float[]{0.6f, 0.8f, 1.0f};
        this.relBatSize = new float[]{1.0f, 0.8f, 0.6f};
        this.relBatSize2= new float[]{2.0f,1f,0.8f};
        this.relGoalSize = new float[]{1.0f, 0.9f, 1.3f};
        this.relBallSize = new float[]{1.0f, 0.9f, 0.8f};
        this.relVel = new float[]{0.6f, 0.8f, 1.0f};
        this.paused = 0;
        this.theme = 0;
        this.backEnded = 0;
        this.gameEnded = 0;
        this.bgndLoaded = 0;
        this.soundLoaded = 1;
        this.useSound = 0;
        this.dataColors = new int[]{-1, -16777216, -16777216, -1052689};

    }

    static {
        relBatSizePro = new float[]{1.0f, 0.8f, 0.6f};
        relGoalSizePro = new float[]{1.0f, 0.9f, 0.8f};
        relBallSizePro = new float[]{1.0f, 0.9f, 0.8f};
        velMax = 500.0f;
        velMaxPlayer = 200.0f;
        velMin = 20000.0f;
        velHitMax = 1.4f;
        edgeLoc = 0.03f;
        goalWidth = 0.39f;
        goalWidthPlayer = 0.39f;
        ballRad = 0.045f;
        malletMiddleRad = 0.06f;
        malletOuterRad = 0.09f;
        malletInnerRad = 0.03f;
        malletMiddleRad2 = 0.06f;
        malletOuterRad2 = 0.09f;
        malletInnerRad2 = 0.03f;
        decelHit = 0.8f;
        fieldColor = new int[]{-1, -16777216};
        lineColor = new int[]{-16744704, -8421505};
        scoreBlurColor = new int[]{8355711, -1349546097};
        scoreColor = new int[]{-16777216, -1052689};
        edgeTopColor = new int[]{-16776961, -269488145};
        edgeTopBlurColor = new int[]{MotionEventCompat.ACTION_MASK, -1358954241};
        edgeBottomColor = new int[]{-65536, -269488145};
        edgeBottomBlurColor = new int[]{16711680, -1342242816};
        ballColor = new int[]{-8421505, -269488145};
        ballBlurColor = new int[]{8355711, -1349546097};
        malletTopBlurColor = new int[]{MotionEventCompat.ACTION_MASK, -1358954241};
        malletTopOuterColor = new int[]{-16777089, -269488145};
        malletTopMiddleColor = new int[]{-16777153, -16777057};
        malletTopInnerColor = new int[]{-16776961, -16776961};
        malletBottomBlurColor = new int[]{16711680, -1342242816};
        malletBottomOuterColor = new int[]{-8454144, -269488145};
        malletBottomMiddleColor = new int[]{-12648448, -6356992};
        malletBottomInnerColor = new int[]{-65536, -65536};
        startDelay = 1000;
        doubleDelay = 2000;
        int[] iArr = new int[72];
        iArr[0] = 390;
        iArr[1] = 390;
        iArr[2] = 610;
        iArr[3] = 390;
        iArr[4] = 610;
        iArr[5] = 610;
        iArr[6] = 390;
        iArr[7] = 610;
        iArr[8] = 1;
        iArr[9] = 1;
        iArr[12] = 400;
        iArr[13] = 400;
        iArr[14] = 490;
        iArr[15] = 400;
        iArr[16] = 490;
        iArr[17] = 600;
        iArr[18] = 400;
        iArr[19] = 600;
        iArr[20] = 1;
        iArr[21] = 1;
        iArr[22] = 1;
        iArr[24] = 600;
        iArr[25] = 400;
        iArr[26] = 510;
        iArr[27] = 400;
        iArr[28] = 510;
        iArr[29] = 600;
        iArr[30] = 600;
        iArr[31] = 600;
        iArr[32] = 1;
        iArr[33] = 1;
        iArr[34] = 1;
        iArr[36] = 390;
        iArr[37] = 390;
        iArr[38] = 390;
        iArr[39] = 610;
        iArr[40] = 610;
        iArr[41] = 610;
        iArr[42] = 610;
        iArr[43] = 390;
        iArr[44] = 1;
        iArr[45] = 1;
        iArr[48] = 400;
        iArr[49] = 400;
        iArr[50] = 400;
        iArr[51] = 490;
        iArr[52] = 600;
        iArr[53] = 490;
        iArr[54] = 600;
        iArr[55] = 400;
        iArr[56] = 1;
        iArr[57] = 1;
        iArr[58] = 1;
        iArr[60] = 400;
        iArr[61] = 600;
        iArr[62] = 400;
        iArr[63] = 510;
        iArr[64] = 600;
        iArr[65] = 510;
        iArr[66] = 600;
        iArr[67] = 600;
        iArr[68] = 1;
        iArr[69] = 1;
        iArr[70] = 1;
        dataQuads = iArr;
        colorsNo = 2;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(CommonActivity.TAG, "oncreate for Playgame");
        requestWindowFeature(1);

        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(R.layout.activity_game);
        this.gGameSettings = getSharedPreferences(CommonActivity.GAME_PREFERENCES, 0);
        this.difficulty = this.gGameSettings.getInt(CommonActivity.GAME_PREFERENCES_DIFFICULTY, 0);
        this.players = this.gGameSettings.getInt(CommonActivity.GAME_PREFERENCES_PLAYERS, 0);
        this.theme = this.gGameSettings.getInt(CommonActivity.GAME_PREFERENCES_THEME, 0);
        this.soundSet = this.gGameSettings.getInt(CommonActivity.GAME_PREFERENCES_VOLUME, 0);
        Editor editor = this.gGameSettings.edit();
        editor.putString(CommonActivity.GAME_PREFERENCES_FEEDBACK, "");


        editor.commit();
        switch (this.soundSet) {
            case DialogFragment.STYLE_NORMAL /*0*/:
                this.volume = 0.99f;
                break;
            case CursorAdapter.FLAG_AUTO_REQUERY /*1*/:
                this.volume = 0.5f;
                break;
            case CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER /*2*/:
                this.volume = 0.25f;
                break;
//            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
//                this.volume = 0.125f;
//                break;
//            case FragmentManagerImpl.ANIM_STYLE_CLOSE_EXIT /*4*/:
//                this.volume = 0.0f;
//                break;
            default:
                this.volume = 0.0f;
                break;
        }
        this.aa = this.gGameSettings.getInt(CommonActivity.GAME_PREFERENCES_DURATION, 0);
        switch (this.aa) {
            case DialogFragment.STYLE_NORMAL /*0*/:
                this.gameDuration = 6000000000000L;
                break;
            case CursorAdapter.FLAG_AUTO_REQUERY /*1*/:
                this.gameDuration = 12000000000000L;
                break;
            case CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER /*2*/:
                this.gameDuration = 60000;
                break;
            //case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
              //  this.gameDuration = 120000;
                //break;
           // case FragmentManagerImpl.ANIM_STYLE_CLOSE_EXIT /*4*/:
             //   this.gameDuration = 300000;
               // break;
//            case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
//                this.gameDuration = 600000;
//                break;
//            case FragmentManagerImpl.ANIM_STYLE_FADE_EXIT /*6*/:
//                this.gameDuration = 1200000;
//                break;
//            default:
//                this.gameDuration = 60000;
//                break;
        }
        if (this.players == 3) {
            this.gameDuration = 5000000000000L;
        }
        this.gameType = getResources().getString(R.string.game_type1);
        this.paint = new Paint();
        this.paintBlur = new Paint();
        this.path = new Path();
        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
        if (this.gameType.equals("pro")) {
            //layout.getLayoutParams().height = 0;
            this.aa = 0;
            while (this.aa < 3) {
                this.relBatSize[this.aa] = relBatSizePro[this.aa];
                this.relGoalSize[this.aa] = relGoalSizePro[this.aa];
                this.relBatSize[this.aa] = relBatSizePro[this.aa];
                this.aa++;
            }
        }
        //else {
          //  this.textTop = getResources().getString(C0033R.string.admob_id);
            //this.adView = new AdView((Activity) this, AdSize.BANNER, this.textTop);
            //layout.addView(this.adView);
            //this.adView.loadAd(new AdRequest());
            //new AdRequest().addTestDevice(AdRequest.TEST_EMULATOR);
        //}
        this.gameLayout = (RelativeLayout) findViewById(R.id.layoutGame);
        View viewBackground = new Background(this);
        viewBackground.setLayoutParams(new LayoutParams(-1, -1));
        this.gameLayout.addView(viewBackground);
        View viewGame = new PlayGame(this);
        viewGame.setLayoutParams(new LayoutParams(-1, -1));
        this.gameLayout.addView(viewGame);
        this.soundGoalAct = 0;
        this.soundWallAct = 0;
        this.soundMalletAct = 0;
        this.soundPool = new SoundPool(10, 3, 0);
        this.soundWall = this.soundPool.load(this, R.raw.snd_wall, 1);
        this.soundMallet = this.soundPool.load(this, R.raw.snd_mallet, 1);
        this.soundGoal = this.soundPool.load(this, R.raw.snd_goal, 1);
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(new ScreenReceiver(), filter);

        Button bt =(Button) findViewById(R.id.changeMalletSize);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Background bck = new Background(GameActivity.this);
                trackMalletTime = System.currentTimeMillis();
                bck.setPlayerMalletSize();
            }
        });

        Button btGoal =(Button) findViewById(R.id.changeGoalSize);
        btGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Background bck2 = new Background(GameActivity.this);
                trackGoalTime= System.currentTimeMillis();
                bck2.setGoalSize();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(CommonActivity.TAG, "ondestroy for Playgame");
       // if (!(this.gameType.equals("pro") || this.adView == null)) {
         //   this.adView.destroy();
        //}
        if (this.bgndBitmap != null) {
            this.bgndBitmap.recycle();
        }
        if (this.soundPool != null) {
            this.soundPool.release();
        }
        System.gc();
        sendBroadcast(new Intent(CommonActivity.CUSTOM_INTENT));
    }

    public void onPause() {
        super.onPause();
        Log.d(CommonActivity.TAG, "onPause for Playgame");
        if (this.paused == 0) {
            this.pausedTime = this.currentTime;
            this.pausedBallTime = this.ballTime;
            this.pausedGameEndTime = this.gameEndTime;
            this.paused = 1;
        }
    }

    public void onResume() {
        super.onResume();
        Log.d(CommonActivity.TAG, "onresume for Playgame");
        long currentTimeMillis = System.currentTimeMillis();
        this.currentTime = currentTimeMillis;
        this.paused2Time = currentTimeMillis;
        this.ballTime = (this.pausedBallTime - this.pausedTime) + this.currentTime;
        this.gameEndTime = (this.pausedGameEndTime - this.pausedTime) + this.currentTime;
        ((RelativeLayout) findViewById(R.id.layoutGame)).invalidate();
    }


}
