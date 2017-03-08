package com.jcodee.clase07.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.EditText;

import com.jcodee.clase07.R;

/**
 * Created by johannfjs on 3/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class EditTextCustom extends EditText {
    public EditTextCustom(Context context) {
        super(context);
        init(context);
    }

    public EditTextCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EditTextCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typeface = Typeface.createFromAsset(
                context.getAssets(), "fonts/Aller_Bd.ttf");
        setTypeface(typeface);

        setTextSize(14);

        setTextColor(Color.BLUE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextColor(getResources().getColor(R.color.colorAccent, context.getTheme()));
        } else {
            setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
}
