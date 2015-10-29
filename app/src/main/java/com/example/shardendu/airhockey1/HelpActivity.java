package com.example.shardendu.airhockey1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TabHost;

/**
 * Created by shardendu on 10/28/15.
 */
public class HelpActivity extends Activity{

    SharedPreferences mGameSettings;

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(2130903041);
        setContentView(R.layout.activity_help);
        Log.d("chilon", "help activity");
        TabHost localTabHost = (TabHost)findViewById(R.id.TabHost1);
        localTabHost.setup();
        TabHost.TabSpec localTabSpec1 = localTabHost.newTabSpec("instructions");
        localTabSpec1.setIndicator(getResources().getString(R.string.tab_text));
        localTabSpec1.setContent(R.id.ScrollViewHelpText);
        localTabHost.addTab(localTabSpec1);
        TabHost.TabSpec localTabSpec2 = localTabHost.newTabSpec("example");
        localTabSpec2.setIndicator(getResources().getString(R.string.tab_image));
        localTabSpec2.setContent(R.id.ScrollViewHelpImage);
        localTabHost.addTab(localTabSpec2);
        localTabHost.setCurrentTabByTag("instructions");
        ImageView localImageView = (ImageView)findViewById(R.id.imageViewHelp);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = localDisplayMetrics.widthPixels;
        int j = localDisplayMetrics.heightPixels;
        Log.d("chilon", "onpost create for Help - width  " + i);
        if (i < j)
            localImageView.setImageResource(R.drawable.help);
        while (true)
        {
            localImageView.setImageResource(R.drawable.helpland);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.d("chilon", "ondestroy for Help");
        ((ImageView)findViewById(R.id.imageViewHelp)).setImageResource(R.drawable.ic_launcher);
        System.gc();
    }
}
