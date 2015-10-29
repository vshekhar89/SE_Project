package com.example.shardendu.airhockey1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shardendu on 10/27/15.
 */
public class MenuActivity extends CommonActivity
{
    int diff;
    TextView gameMessage;
    SharedPreferences mGameSettings;

    private void initHelp()
    {
        ((Button)findViewById(R.id.Button_Help)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                Log.d("chilon", "help button pressed");
                MenuActivity.this.startActivity(new Intent(MenuActivity.this, HelpActivity.class));
            }
        });
    }

    private void initPlay()
    {
        ((Button)findViewById(R.id.Button_Play)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                Log.d("chilon", "play button pressed");
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("GameOver", 0);
                localEditor.commit();
                MenuActivity.this.startActivity(new Intent(MenuActivity.this, GameActivity.class));
            }
        });
    }

    private void initSpinner()
    {
        Spinner localSpinner = (Spinner)findViewById(R.id.Spinner_Difficulty);
        ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, R.array.difficulties, android.R.layout.simple_spinner_item);
        localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localArrayAdapter);
        if (this.mGameSettings.contains("Difficulty"))
            localSpinner.setSelection(this.mGameSettings.getInt("Difficulty", 0));
        localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
            {
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("Difficulty", paramInt);
                localEditor.commit();
                Log.d("chilon", "Spinner set difficulty to: " + paramInt);
                if (paramInt != MenuActivity.this.diff)
                    MenuActivity.this.runOnUiThread(new Runnable()
                    {
                        public void run()
                        {
                            SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                            localEditor.putString("Feedback", "");
                            localEditor.commit();
                            MenuActivity.this.gameMessage.setText("");
                        }
                    });
            }

            public void onNothingSelected(AdapterView<?> paramAdapterView)
            {
            }
        });
    }

    private void initSpinnerD()
    {
        Spinner localSpinner = (Spinner)findViewById(R.id.Spinner_duration);
        ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, R.array.duration, android.R.layout.simple_spinner_item);
        localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localArrayAdapter);
        if (this.mGameSettings.contains("Duration"))
            localSpinner.setSelection(this.mGameSettings.getInt("Duration", 0));
        localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
            {
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("Duration", paramInt);
                localEditor.commit();
                Log.d("chilon", "Spinner set duration to: " + paramInt);
            }

            public void onNothingSelected(AdapterView<?> paramAdapterView)
            {
            }
        });
    }

    private void initSpinnerP()
    {
        Spinner localSpinner = (Spinner)findViewById(R.id.Spinner_Players);
        ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, R.array.players, android.R.layout.simple_spinner_item);
        localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localArrayAdapter);
        if (this.mGameSettings.contains("Players"))
            localSpinner.setSelection(this.mGameSettings.getInt("Players", 0));
        localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
            {
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("Players", paramInt);
                localEditor.commit();
                Log.d("chilon", "Spinner set players to: " + paramInt);
            }

            public void onNothingSelected(AdapterView<?> paramAdapterView)
            {
            }
        });
    }

    private void initSpinnerT()
    {
        Spinner localSpinner = (Spinner)findViewById(R.id.Spinner_Theme);
        ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_item);
        localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localArrayAdapter);
        if (this.mGameSettings.contains("Theme"))
            localSpinner.setSelection(this.mGameSettings.getInt("Theme", 0));
        localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
            {
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("Theme", paramInt);
                localEditor.commit();
                Log.d("chilon", "Spinner set Theme to: " + paramInt);
            }

            public void onNothingSelected(AdapterView<?> paramAdapterView)
            {
            }
        });
    }

    private void initSpinnerV()
    {
        Spinner localSpinner = (Spinner)findViewById(R.id.Spinner_Volume);
        ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, R.array.volume, android.R.layout.simple_spinner_item);
        localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localArrayAdapter);
        if (this.mGameSettings.contains("Volume"))
            localSpinner.setSelection(this.mGameSettings.getInt("Volume", 0));
        localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
            {
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("Volume", paramInt);
                localEditor.commit();
                Log.d("chilon", "Spinner set volume to: " + paramInt);
            }

            public void onNothingSelected(AdapterView<?> paramAdapterView)
            {
            }
        });
    }

    private void initStore()
    {
        ((Button)findViewById(R.id.Button_Store)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                try
                {
                    Log.d("chilon", "store button pressedh");
                    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=Chilon+Consulting+Ltd"));
                    MenuActivity.this.startActivity(localIntent);
                    return;
                }
                catch (Exception localException)
                {
                    while (true)
                        Toast.makeText(MenuActivity.this, MenuActivity.this.getResources().getString(R.string.play_store_exception), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void reset()
    {
        ((Button)findViewById(R.id.Button_Reset)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramView)
            {
                Log.d("chilon", "reset button pressed");
                SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                localEditor.putInt("AWinEasy", 0);
                localEditor.putInt("YWinEasy", 0);
                localEditor.putInt("AWinMedium", 0);
                localEditor.putInt("YWinMedium", 0);
                localEditor.putInt("AWinHard", 0);
                localEditor.putInt("YWinHard", 0);
                localEditor.commit();
                MenuActivity.this.runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        String str = MenuActivity.this.getResources().getString(R.string.stats_reset);
                        SharedPreferences.Editor localEditor = MenuActivity.this.mGameSettings.edit();
                        localEditor.putString("Feedback", str);
                        localEditor.commit();
                        MenuActivity.this.gameMessage.setText(str);
                    }
                });
            }
        });
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_menu);
        Log.d("chilon", "menu activity");
        if (getResources().getString(R.string.game_type2).equals("am"))
            ((Button)findViewById(R.id.Button_Store)).setVisibility(View.GONE);
        this.mGameSettings = getSharedPreferences("GamePrefs", 0);
        this.gameMessage = ((TextView)findViewById(R.id.textView_Feedback));
        this.gameMessage.setText(this.mGameSettings.getString("Feedback", ""));
        initSpinnerD();
        initSpinnerT();
        initSpinnerP();
        initSpinner();
        initSpinnerV();
        initPlay();
        reset();
        initHelp();
        initStore();
        IntentFilter localIntentFilter = new IntentFilter("chilon.consult.hockey.intent.action.ENDED");
        registerReceiver(new ScreenReceiver(), localIntentFilter);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        SharedPreferences.Editor localEditor = this.mGameSettings.edit();
        localEditor.putString("Feedback", "");
        localEditor.commit();
    }

    public class ScreenReceiver extends BroadcastReceiver
    {
        public ScreenReceiver()
        {
        }

        public void onReceive(Context paramContext, Intent paramIntent)
        {
            if (paramIntent.getAction().equals("chilon.consult.hockey.intent.action.ENDED"))
            {
                Log.d("chilon", "broadcast receiver feedback");
                MenuActivity.this.runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        MenuActivity.this.mGameSettings = MenuActivity.this.getSharedPreferences("GamePrefs", 0);
                        int i = MenuActivity.this.mGameSettings.getInt("GameOver", 0);
                        MenuActivity.this.diff = MenuActivity.this.mGameSettings.getInt("Difficulty", 0);
                        int j = MenuActivity.this.mGameSettings.getInt("Players", 0);
                        int k = 0;
                        int m = 0;
                        Log.d("chilon", "result = " + i);
                        String str1;
                        String str2 = "";
                        if (i == 1)
                            if (j >= 2)
                            {
                                str1 = MenuActivity.this.getResources().getString(R.string.winner_left_top);
                                Log.d("chilon", str1);
                                if ((j < 2) && ((i == 1) || (i == 2)))
                                {
                                    str2 = str1 + MenuActivity.this.getResources().getString(R.string.you_win2);
                                    if (MenuActivity.this.diff != 0)
                                        if (MenuActivity.this.diff == 1)
                                        {
                                            m += MenuActivity.this.mGameSettings.getInt("AWinMedium", 0);
                                            k += MenuActivity.this.mGameSettings.getInt("YWinMedium", 0);
                                            SharedPreferences.Editor localEditor3 = MenuActivity.this.mGameSettings.edit();
                                            localEditor3.putInt("AWinMedium", m);
                                            localEditor3.putInt("YWinMedium", k);
                                            localEditor3.commit();
                                           // continue;
                                        }
                                        //break label575;
                                    m += MenuActivity.this.mGameSettings.getInt("AWinEasy", 0);
                                    k += MenuActivity.this.mGameSettings.getInt("YWinEasy", 0);
                                    SharedPreferences.Editor localEditor4 = MenuActivity.this.mGameSettings.edit();
                                    localEditor4.putInt("AWinEasy", m);
                                    localEditor4.putInt("YWinEasy", k);
                                    localEditor4.commit();
                                }
                            }
                        while (true)
                        {
                            str1 = str2 + " " + k * 100 / (k + m) + "%";
                            Log.d("chilon", str1);
                            SharedPreferences.Editor localEditor2 = MenuActivity.this.mGameSettings.edit();
                            localEditor2.putString("Feedback", str1);
                            localEditor2.commit();
                            MenuActivity.this.gameMessage.setText(str1);
                            //return;
                            if (j == 1)
                            {
                                str1 = MenuActivity.this.getResources().getString(R.string.you_win);
                                k = 0 + 1;
                                break;
                            }
                            str1 = MenuActivity.this.getResources().getString(R.string.i_win);
                            m = 0 + 1;
                            //break;
                            if (i == 2)
                            {
                                if (j >= 2)
                                {
                                    str1 = MenuActivity.this.getResources().getString(R.string.winner_right_bottom);
                                    break;
                                }
                                if (j == 0)
                                {
                                    str1 = MenuActivity.this.getResources().getString(R.string.you_win);
                                    k = 0 + 1;
                                    break;
                                }
                                str1 = MenuActivity.this.getResources().getString(R.string.i_win);
                                m = 0 + 1;
                                break;
                            }
                            if (i == 3)
                            {
                                str1 = MenuActivity.this.getResources().getString(R.string.draw);
                                break;
                            }
                            str1 = "";
                            //break;
                            label575: if (MenuActivity.this.diff == 1)
                            {
                                m += MenuActivity.this.mGameSettings.getInt("AWinMedium", 0);
                                k += MenuActivity.this.mGameSettings.getInt("YWinMedium", 0);
                                SharedPreferences.Editor localEditor3 = MenuActivity.this.mGameSettings.edit();
                                localEditor3.putInt("AWinMedium", m);
                                localEditor3.putInt("YWinMedium", k);
                                localEditor3.commit();
                                continue;
                            }
                            if (MenuActivity.this.diff != 2)
                                continue;
                            m += MenuActivity.this.mGameSettings.getInt("AWinHard", 0);
                            k += MenuActivity.this.mGameSettings.getInt("YWinHard", 0);
                            SharedPreferences.Editor localEditor1 = MenuActivity.this.mGameSettings.edit();
                            localEditor1.putInt("AWinHard", m);
                            localEditor1.putInt("YWinHard", k);
                            localEditor1.commit();
                        }
                    }
                });
            }
        }
    }
}
