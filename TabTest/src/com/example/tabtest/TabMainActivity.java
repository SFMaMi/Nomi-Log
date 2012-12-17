package com.example.tabtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.TabActivity;
import android.widget.TabHost;

@SuppressWarnings({ "deprecation", "unused" })
public class TabMainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
        
        TabHost tabhost = getTabHost();
        
        tabhost.addTab(tabhost.newTabSpec("first_tab")
        		.setIndicator("情報")
        		.setContent(R.id.first));
        
        tabhost.addTab(tabhost.newTabSpec("second_tab")
        		.setIndicator("評価")
        		.setContent(R.id.second));
        
        tabhost.addTab(tabhost.newTabSpec("third_tab")
        		.setIndicator("メモ")
        		.setContent(R.id.third));
        
        tabhost.addTab(tabhost.newTabSpec("fourth_tab")
        		.setIndicator("タグ")
        		.setContent(R.id.fourth));
        
        tabhost.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_main, menu);
        return true;
    }
}
