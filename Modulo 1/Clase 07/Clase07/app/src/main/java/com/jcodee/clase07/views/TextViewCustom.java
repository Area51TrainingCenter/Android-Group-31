package com.jcodee.clase07.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by johannfjs on 1/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class TextViewCustom extends TextView {
    public TextViewCustom(Context context) {
        super(context);
        init(context);
    }

    public TextViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typeface = Typeface
                .createFromAsset(context.getAssets(),
                        "fonts/Aller_Rg.ttf");
        setTypeface(typeface);
    }
}
