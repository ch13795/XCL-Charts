package com.demo.xclcharts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

public class HLNScrollActivity extends Activity {

	HorizontalScrollView horiView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hlnscroll);
		
		//计算horizontalScrollvView需要隔左边多远距离，可能我计算式有误
				int paddingLeft = Math.round(800 / 100 * 10);
				
				/*
				horiView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
				RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) horiView.getLayoutParams();
				param.setMargins(paddingLeft, param.topMargin, param.rightMargin, param.bottomMargin);
				horiView.setLayoutParams(param);
				*/
				
				//设置horizontalScrollvView拉到头和尾的时候没有阴影颜色
				//horiView.setOverScrollMode(View.OVER_SCROLL_NEVER);
				
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hlnscroll, menu);
		return true;
	}

}
