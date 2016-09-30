package com.neworin.neworinnumberkeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by neworin on 16-9-29.
 * Email: NewOrin@163.com
 */

public class NumberKeyBoardView extends LinearLayout {

    private int textColor;
    private float textSize;
    private Drawable textBackground;

    private TextView numText;

    private LayoutParams rightParams;
    private LayoutParams centerParams;
    private LayoutParams leftParams;

    public NumberKeyBoardView(Context context) {
        this(context, null);
    }

    public NumberKeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * @param context
     */
    private void init(Context context, AttributeSet attrs) {
        this.setHorizontalGravity(VERTICAL);
        this.setPadding(0, 10, 0, 10);
//        this.setBackgroundResource(R.drawable.linearlayout_bg);
//        this.setWeightSum(3);
        this.setBackgroundResource(R.color.colorNumKeyBoard);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyKeyBoardView);
        textColor = ta.getColor(R.styleable.MyKeyBoardView_textColor, 0);
        textSize = ta.getDimension(R.styleable.MyKeyBoardView_textSize, 10);
        textBackground = ta.getDrawable(R.styleable.MyKeyBoardView_textBackground);
        ta.recycle();
        numText = new TextView(context);
        numText.setTextSize(textSize);
        numText.setTextColor(textColor);
//        numText.setBackground(textBackground);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.weight = 1;
        numText.setGravity(Gravity.CENTER);
        numText.setText("0");
        addView(numText, leftParams);

        TextView line = new TextView(context);
        line.setTextColor(Color.BLUE);
        line.setBackgroundColor(Color.BLACK);
        LayoutParams params = new LayoutParams(1, ViewGroup.LayoutParams.MATCH_PARENT);
        params.topMargin = 10;
        params.bottomMargin = 10;
//        addView(line, params);

        centerParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);//定义宽，高属性
        numText = new TextView(context);
        numText.setTextSize(textSize);
        numText.setTextColor(textColor);
//        numText.setBackground(textBackground);
        numText.setText("1");
        numText.setGravity(Gravity.CENTER);
        centerParams.weight = 1;
        addView(numText, centerParams);

        line = new TextView(context);
        line.setTextColor(Color.BLUE);
        line.setBackgroundColor(Color.BLACK);
        params = new LayoutParams(1, ViewGroup.LayoutParams.MATCH_PARENT);
        params.topMargin = 10;
        params.bottomMargin = 10;
        //        addView(line, params);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);//定义宽，高属性
        numText = new TextView(context);
        numText.setTextSize(textSize);
        numText.setTextColor(textColor);
        numText.setGravity(Gravity.CENTER);
        rightParams.weight = 1;
//        numText.setBackground(textBackground);
        numText.setText("1");
        addView(numText, rightParams);
    }
}
