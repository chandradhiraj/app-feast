package com.android.appfeast.fonts;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.appfeast.utils.Util;

public class CustomFontTextView extends TextView {

	private String fontName;

	private void setFont(AttributeSet attrs)
	{
		fontName = "Roboto";
	}

	public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setFont(attrs);
	}

    public void setTextColor(int color) {
        try {
        super.setTextColor(getResources().getColor(color));
        }catch(Exception ex) {
            super.setTextColor(color);
        }
    }
	public CustomFontTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFont(attrs);
	}

	public CustomFontTextView(Context context) {
		super(context);
        fontName="Roboto";
    }

	@Override
	public void setTypeface(Typeface tf, int style) {
		if (!isInEditMode()) {
			/*
			 *  If we are dealing with LDPI phones, we use the default font,
			 *  They have a rendering issue with the font that we're using
			 */
			if (Util.getDensityMultiplier() <= 0.75f)
			{
				if (style == Typeface.ITALIC || style == Typeface.BOLD_ITALIC) 
				{
					style = Typeface.NORMAL;
				}
				super.setTypeface(tf, style);
				return;
			}
			if (CustomTypeFace.customTypeFace == null) {
				CustomTypeFace.customTypeFace = new CustomTypeFace(getContext(), fontName);
			}

			if (style == Typeface.BOLD) {
				super.setTypeface(CustomTypeFace.customTypeFace.bold);
			} else if (style == Typeface.ITALIC) {
				super.setTypeface(CustomTypeFace.customTypeFace.thin);
			} else if (style == Typeface.BOLD_ITALIC) {
				super.setTypeface(CustomTypeFace.customTypeFace.medium);
			} else {
				super.setTypeface(CustomTypeFace.customTypeFace.normal);
			}
		}
	}
}
