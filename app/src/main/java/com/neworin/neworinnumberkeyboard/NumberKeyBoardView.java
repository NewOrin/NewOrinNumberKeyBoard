package com.neworin.neworinnumberkeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by neworin on 16-9-29.
 * Email: NewOrin@163.com
 */

public class NumberKeyBoardView extends RelativeLayout {

    private int textColor;
    private float textSize;
    private Drawable textBackground;

    private TextView numText;

    public NumberKeyBoardView(Context context) {
        this(context, null);
    }

    public NumberKeyBoardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberKeyBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * @param context
     */
    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyKeyBoardView);
        textColor = ta.getColor(R.styleable.MyKeyBoardView_textColor, 0);
        textSize = ta.getDimension(R.styleable.MyKeyBoardView_textSize, 10);
        textBackground = ta.getDrawable(R.styleable.MyKeyBoardView_textBackground);
        ta.recycle();
        numText = new TextView(context);
        numText.setTextSize(textSize);
        numText.setTextColor(textColor);
        numText.setBackground(textBackground);

    }
}
