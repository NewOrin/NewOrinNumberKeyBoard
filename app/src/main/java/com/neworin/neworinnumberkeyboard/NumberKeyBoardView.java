package com.neworin.neworinnumberkeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by neworin on 16-9-29.
 * Email: NewOrin@163.com
 */

public class NumberKeyBoardView extends LinearLayout {

    private int numColor;//数字颜色
    private float numSize;//文字大小

    private TextView numText;

    private Context mContext;
    private LayoutParams lineartParams;
    private LayoutParams textParams;
    private LinearLayout mViewLayout;

    private static final int LAYOUT_PADDING = 80;
    private static final int TEXT_SIZE_DEFUALT = 5;

    private ITextClickListener iTextClickListener;

    public void setiTextClickListener(ITextClickListener iTextClickListener) {
        this.iTextClickListener = iTextClickListener;
    }

    public interface ITextClickListener {
        void onTextClick(String text);
    }

    public NumberKeyBoardView(Context context) {
        this(context, null);
    }

    public NumberKeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context, attrs);
    }

    /**
     * @param context
     */
    private void init(Context context, AttributeSet attrs) {

        //设置控件属性
        this.setOrientation(VERTICAL);
        this.setPadding(0, LAYOUT_PADDING, 0, LAYOUT_PADDING);

        /**
         * 获取属性
         */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyKeyBoardView);
        numColor = ta.getColor(R.styleable.MyKeyBoardView_numColor, getResources().getColor(R.color.colorNumber));
        numSize = ta.getDimension(R.styleable.MyKeyBoardView_numSize, TEXT_SIZE_DEFUALT);
        ta.recycle();

        /**
         * 横向LineaLayout布局1
         */
        mViewLayout = getParentLayout();
        //添加1
        mViewLayout.addView(getNumText("1"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("1");
            }
        });
        //添加2
        mViewLayout.addView(getNumText("2"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("2");
            }
        });
        //添加3
        mViewLayout.addView(getNumText("3"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("3");
            }
        });
        //添加第一行
        addView(mViewLayout, getParentParams());

        /**
         * 横向LineaLayout布局2
         */
        mViewLayout = getParentLayout();
        //添加4
        mViewLayout.addView(getNumText("4"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("4");
            }
        });
        //添加5
        mViewLayout.addView(getNumText("5"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("5");
            }
        });
        //添加6
        mViewLayout.addView(getNumText("6"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("6");
            }
        });
        //添加第二行
        addView(mViewLayout, getParentParams());

        /**
         * 横向LineaLayout布局3
         */
        mViewLayout = getParentLayout();
        //添加7
        mViewLayout.addView(getNumText("7"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("7");
            }
        });
        //添加8
        mViewLayout.addView(getNumText("8"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("8");
            }
        });
        //添加9
        mViewLayout.addView(getNumText("9"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("9");
            }
        });
        //添加第三行
        addView(mViewLayout, getParentParams());
        /**
         * 横向LineaLayout布局3
         */
        mViewLayout = getParentLayout();
        //添加清空
        mViewLayout.addView(getNumText("清空"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("清空");
            }
        });
        //添加0
        mViewLayout.addView(getNumText("0"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("0");
            }
        });
        //添加删除
        mViewLayout.addView(getNumText("删除"), getTextParams());
        numText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iTextClickListener.onTextClick("删除");
            }
        });
        //添加第四行
        addView(mViewLayout, getParentParams());

    }

    /**
     * 获取文字属性
     *
     * @param text
     */
    private TextView getNumText(String text) {
        numText = new TextView(mContext);
        numText.setText(text);
        numText.setTextSize(numSize);
        numText.setTextColor(numColor);
        numText.setGravity(Gravity.CENTER);
        return numText;
    }

    /**
     * 文字控件属性设置
     *
     * @return
     */
    private LayoutParams getTextParams() {
        textParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);//定义宽，高属性
        textParams.weight = 1;
        return textParams;
    }

    /**
     * 设置 parent layout
     *
     * @return
     */
    private LinearLayout getParentLayout() {
        mViewLayout = new LinearLayout(mContext);
        mViewLayout.setHorizontalGravity(HORIZONTAL);
        mViewLayout.setBackgroundColor(Color.BLUE);
        mViewLayout.setShowDividers(SHOW_DIVIDER_MIDDLE);
        mViewLayout.setBackgroundResource(R.drawable.linearlayout_bg);
        mViewLayout.setWeightSum(3);
        mViewLayout.setDividerDrawable(getResources().getDrawable(R.drawable.linearlayout_divider));
        return mViewLayout;
    }

    /**
     * 获得 parent layout 属性
     *
     * @return
     */
    private LayoutParams getParentParams() {
        lineartParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lineartParams.weight = 1;
        lineartParams.topMargin = 50;
        return lineartParams;
    }

}
