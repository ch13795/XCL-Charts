package com.demo.xclcharts.view;

import java.util.LinkedList;

import org.xclcharts.chart.LineChart;
import org.xclcharts.chart.LineData;
import org.xclcharts.renderer.XEnum;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.MeasureSpec;

public class LineChart03View_left extends GraphicalView {
	
	private String TAG = "LineChart01View";
	private LineChart chart = new LineChart();
	
	//标签集合
	private LinkedList<String> labels = new LinkedList<String>();
	private LinkedList<LineData> chartData = new LinkedList<LineData>();

	public LineChart03View_left(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		chartLabels();
		chartDataSet();	
		chartRender();
	}
	
	 public LineChart03View_left(Context context, AttributeSet attrs){   
	        super(context, attrs);   
	        chartLabels();
			chartDataSet();	
			chartRender();
	 }
	 

	private void chartRender()
	{
		try {				
			
			
			//图所占范围大小
			//chart.setChartRange(0.0f, 0.0f,getScreenWidth(),getScreenHeight());

			
			//方法一
			//调整x轴起始坐标位置
			//chart.setChartRange(38f, 0.0f,800f,600f); //50.0f
			//chart.setPadding(20, 20, 10, 5);
			
			//方法二
			chart.setChartRange(0.0f, 0.0f,80f,600f);
			chart.setPadding(20, 20, 12, 5); //主要是12,即左边从原点x坐标，偏移12%,让轴可以显示在屏幕中,手机屏幕不同，不一定是合适比例			
			//你可以依y轴比例( 80 * 0.12) 得到宽度。再用代码把xml中的layout_marginLeft 为这个宽度.即右边scrollview偏移这个宽度。
			
			
			
			//设定数据源
			chart.setCategories(labels);								
			chart.setDataSource(chartData);
			
			//数据轴最大值
			chart.getDataAxis().setAxisMax(100);
			//数据轴刻度间隔
			chart.getDataAxis().setAxisSteps(10);
			
		
			chart.getCategoryAxis().setVisible(false);
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString());
		}
	}
	private void chartDataSet()
	{
	
		LinkedList<Double> dataSeries1= new LinkedList<Double>();	
		dataSeries1.add(0d); 
		LineData lineData1 = new LineData("方块",dataSeries1,(int)Color.rgb(234, 83, 71));
		chartData.add(lineData1);
	}
	
	private void chartLabels()
	{
		labels.add("2010");
		labels.add("2011");
		labels.add("2012");
		labels.add("2013");
		labels.add("2014");
	}
	
	@Override
    public void render(Canvas canvas) {
        try{
            chart.render(canvas);
        } catch (Exception e){
        	Log.e(TAG, e.toString());
        }
    }

	@Override
	 public void onDraw(Canvas canvas){   
		
		 canvas.drawColor(Color.BLUE);
	        super.onDraw(canvas);  
	        
	 }
	
	
	//自定义view的宽高
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	
		 int measuredHeight = measureHeight(heightMeasureSpec);		 
		 int measuredWidth = measureWidth(widthMeasureSpec);		 
		// setMeasuredDimension(measuredHeight, measuredWidth);	
		 
		 //setMeasuredDimension(80,600 );
		 //setMeasuredDimension(measuredWidth,measuredHeight);	
		 
		 setMeasuredDimension(800,600 );
		 
		 //setMeasuredDimension(80,600 );
	}
	

	private int measureHeight(int measureSpec) {
		 
	    int specMode = MeasureSpec.getMode(measureSpec);
	    int specSize = MeasureSpec.getSize(measureSpec);
	 
	    // Default size if no limits are specified.
	 
	    int result = 500;
	    if (specMode == MeasureSpec.AT_MOST) {
	 
	        // Calculate the ideal size of your
	        // control within this maximum size.
	        // If your control fills the available
	        // space return the outer bound.
	 
	        result = specSize;
	    } else if (specMode == MeasureSpec.EXACTLY) {
	 
	        // If your control can fit within these bounds return that
	        // value.
	        result = specSize;
	    }
	 
	    return result;
	}
	 
	private int measureWidth(int measureSpec) {
	    int specMode = MeasureSpec.getMode(measureSpec);
	    int specSize = MeasureSpec.getSize(measureSpec);
	 
	    // Default size if no limits are specified.
	    int result = 500;
	    if (specMode == MeasureSpec.AT_MOST) {
	        // Calculate the ideal size of your control
	        // within this maximum size.
	        // If your control fills the available space
	        // return the outer bound.
	        result = specSize;
	    }
	 
	    else if (specMode == MeasureSpec.EXACTLY) {
	        // If your control can fit within these bounds return that
	        // value.
	 
	        result = specSize;
	    }
	 
	    return result;
	}
	
}
