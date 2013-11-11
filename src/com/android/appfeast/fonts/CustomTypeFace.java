package com.android.appfeast.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

public class CustomTypeFace {
	
	public Typeface bold;
	public Typeface thin;
	public Typeface normal;
	public Typeface medium;
	public Typeface italic;

	public static CustomTypeFace customTypeFace;
	
	public CustomTypeFace(Context context, String name)
	{
		if (name == null)
		{
			name = "roboto";
		}
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		Log.e("INITIALISING", "CONTEXT: " + context +" "+context.getAssets() + "name " + name);
		bold = Typeface.createFromAsset(context.getAssets(), "fonts/" + name + "-Bold.ttf");
		thin = Typeface.createFromAsset(context.getAssets(), "fonts/" + name + "-Light.ttf");
		normal = Typeface.createFromAsset(context.getAssets(), "fonts/" + name + "-Regular.ttf");
		medium = Typeface.createFromAsset(context.getAssets(), "fonts/" + name + "-Medium.ttf");
		italic = Typeface.createFromAsset(context.getAssets(), "fonts/" + name + "-Italic.ttf");
	}
}