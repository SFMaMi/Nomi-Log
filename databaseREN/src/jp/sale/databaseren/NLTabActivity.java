package jp.sale.databaseren;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class NLTabActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tab, menu);
		return true;
	}

}
