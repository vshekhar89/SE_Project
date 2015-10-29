package com.example.shardendu.airhockey1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shardendu on 10/27/15.
 */
public class SplashActivity extends CommonActivity
{
    ImageView gameLogo;
    SharedPreferences mGameSettings;

    private void startAnimation()
    {
        Animation localAnimation = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        this.gameLogo.startAnimation(localAnimation);
        localAnimation.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation paramAnimation)
            {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MenuActivity.class));
                SplashActivity.this.finish();
            }

            public void onAnimationRepeat(Animation paramAnimation)
            {
            }

            public void onAnimationStart(Animation paramAnimation)
            {
            }
        });
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_splash);
        Log.d("chilon", "Splash activity");
        this.mGameSettings = getSharedPreferences("GamePrefs", 0);
        SharedPreferences.Editor localEditor = this.mGameSettings.edit();
        localEditor.putInt("GameOver", 0);
        localEditor.commit();
        String str1 = getResources().getString(R.string.app_version_info1);
        PackageManager localPackageManager = getPackageManager();
        try
        {
            PackageInfo localPackageInfo = localPackageManager.getPackageInfo(getPackageName(), 0);
            str1 = str1 + localPackageInfo.versionName;
            Log.d("chilon", "PackageName = " + localPackageInfo.packageName + "\nVersionCode = " + localPackageInfo.versionCode + "\nVersionName = " + localPackageInfo.versionName + "\nPermissions = " + localPackageInfo.permissions);
            String str2 = str1 + getResources().getString(R.string.app_version_info2);
            ((TextView)findViewById(R.id.TextViewVersion)).setText(str2);
            Log.d("chilon", str2);
            String str3 = getResources().getString(R.string.game_type1);
            this.gameLogo = ((ImageView)findViewById(R.id.ImageViewLogo512));
            if (str3.equals("pro"))
                this.gameLogo.setImageResource(R.drawable.logo512pro);
            startAnimation();
            return;
        }
        catch (Exception localException)
        {
            while (true)
                Log.d("chilon", "error reading package info");
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        //((ImageView)findViewById(R.id.ImageViewLogo512)).setImageResource(2130837508);
        System.gc();
    }

    protected void onPause()
    {
        super.onPause();
        this.gameLogo.clearAnimation();
    }

    protected void onResume()
    {
        super.onResume();
        startAnimation();
    }
}
