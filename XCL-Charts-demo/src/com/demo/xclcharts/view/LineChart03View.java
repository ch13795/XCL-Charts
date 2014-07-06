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

public class LineChart03View  extends GraphicalView {
	
	private String TAG = "LineChart01View";
	private LineChart chart = new LineChart();
	
	//标签集合
	private LinkedList<String> labels = new LinkedList<String>();
	private LinkedList<LineData> chartData = new LinkedList<LineData>();

	public LineChart03View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		chartLabels();
		chartDataSet();	
		chartRender();
	}
	
	 public LineChart03View(Context context, AttributeSet attrs){   
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

			
			chart.setChartRange(0.0f, 0.0f,800f,600f);
			
			
			chart.setPadding(20, 20, 10, 5);
			
			//设定数据源
			chart.setCategories(labels);								
			chart.setDataSource(chartData);
			
			//数据轴最大值
			chart.getDataAxis().setAxisMax(100);
			//数据轴刻度间隔
			chart.getDataAxis().setAxisSteps(10);
			
			//chart.getDataAxis().setAxisLineVisible(false);
			chart.getDataAxis().setVisible(false);
			
			
			//背景网格
			chart.getPlotGrid().showHorizontalLines();
			//chart.getPlotGrid().showVerticalLines();
			chart.getPlotGrid().showEvenRowBgColor();
			chart.getPlotGrid().showOddRowBgColor();
			
			chart.getPlotGrid().getHorizontalLinePaint().setStrokeWidth(2);
			chart.getPlotGrid().setHorizontalLineStyle(XEnum.LineStyle.DASH);
			chart.getPlotGrid().setVerticalLineStyle(XEnum.LineStyle.DOT);
			
			chart.getPlotGrid().getHorizontalLinePaint().setColor(Color.RED);
			chart.getPlotGrid().getVerticalLinePaint().setColor(Color.BLUE);
			
			chart.setTitle("折线图 (scroll view)");
			chart.addSubtitle("(XCL-Charts Demo)");
			
			chart.getLegend().setLowerLegend("(年份)");			
		
			
			/*
			//想隐藏轴线的可以下面的四个函数来隐藏
			chart.getDataAxis().setVisible(false);
			chart.getCategoryAxis().setVisible(false);
			chart.setTopAxisVisible(false);
			chart.setRightAxisVisible(false);
			//想设置刻度线属性的可用下面函数
			chart.getDataAxis().getTickMarksPaint()
			chart.getCategoryAxis().getTickMarksPaint()
			//想设置刻度线标签属性的可用下面函数 
			chart.getDataAxis().getAxisTickLabelPaint()	
			chart.getCategoryAxis().getAxisTickLabelPaint()
			*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString());
		}
	}
	private void chartDataSet()
	{
		//Line 1
		LinkedList<Double> dataSeries1= new LinkedList<Double>();	
		dataSeries1.add(20d); 
		dataSeries1.add(10d); 
		dataSeries1.add(31d); 
		dataSeries1.add(40d);
		dataSeries1.add(0d);
		LineData lineData1 = new LineData("方块",dataSeries1,(int)Color.rgb(234, 83, 71));
		lineData1.setLabelVisible(true);		
		lineData1.setDotStyle(XEnum.DotStyle.RECT);				
		lineData1.getDotLabelPaint().setColor(Color.BLUE);
		lineData1.getDotLabelPaint().setTextSize(22);
		lineData1.getDotLabelPaint().setTextAlign(Align.LEFT);		
		//Line 2
		LinkedList<Double> dataSeries2= new LinkedList<Double>();	
		dataSeries2.add((double)30); 
		dataSeries2.add((double)42); 
		dataSeries2.add((double)50); 	
		dataSeries2.add((double)60); 
		dataSeries2.add((double)40); 
		LineData lineData2 = new LineData("圆环",dataSeries2,(int)Color.rgb(75, 166, 51));
		lineData2.setDotStyle(XEnum.DotStyle.RING);				
		lineData2.getPlotLine().getDotPaint().setColor(Color.BLACK);
		lineData2.setLabelVisible(true);		
		//Line 3
		LinkedList<Double> dataSeries3= new LinkedList<Double>();	
		dataSeries3.add(65d);
		dataSeries3.add(75d);
		dataSeries3.add(55d);
		dataSeries3.add(65d);
		dataSeries3.add(95d);
		LineData lineData3 = new LineData("圆点",dataSeries3,(int)Color.rgb(123, 89, 168));
		lineData3.setDotStyle(XEnum.DotStyle.DOT);
		//Line 4
		LinkedList<Double> dataSeries4= new LinkedList<Double>();	
		dataSeries4.add(50d);
		dataSeries4.add(60d);
		dataSeries4.add(80d);
		dataSeries4.add(84d);
		dataSeries4.add(90d);
		LineData lineData4 = new LineData("棱形",dataSeries4,(int)Color.rgb(84, 206, 231));		
		lineData4.setDotStyle(XEnum.DotStyle.PRISMATIC);
		//Line 5
		LinkedList<Double> valuesE= new LinkedList<Double>();	
		valuesE.add(0d);
		valuesE.add(80d);
		valuesE.add(85d);
		valuesE.add(90d);
		LineData lineData5 = new LineData("定制",valuesE,(int)Color.rgb(234, 142, 43));
		lineData5.setDotRadius(15);
		
		chartData.add(lineData1);
		chartData.add(lineData2);
		chartData.add(lineData3);
		chartData.add(lineData4);
		chartData.add(lineData5);
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
		
		 canvas.drawColor(Color.GREEN);
	        super.onDraw(canvas);  
	        
	 }
	
	
	//自定义view的宽高
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	
		 int measuredHeight = measureHeight(heightMeasureSpec);		 
		 int measuredWidth = measureWidth(widthMeasureSpec);		 
		// setMeasuredDimension(measuredHeight, measuredWidth);		    
		 
		// setMeasuredDimension(measuredWidth,measuredHeight );	
		 
		 setMeasuredDimension(800,600 );
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
