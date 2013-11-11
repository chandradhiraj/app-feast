/**
 *
 */
package com.android.appfeast.fonts;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Class which will keep track of all the fonts used for the application
 */
public class Fonts {


    private static HashMap<String, Typeface> fonts = new HashMap<String, Typeface>();

    /**
     * @param singleTon SingleTonEnforcer
     */
    public Fonts(SingleTonEnforcer singleTon) {
    }

    /**
     * @param path    of type String
     * @param context of type Context
     * @return font of type Typeface
     *         function which will create the font from path
     */
    public static Typeface getFont(String path, Context context) {
        Typeface font = fonts.get(path);
        if (font == null) {
            font = Typeface.createFromAsset(context.getAssets(), path);
            fonts.put(path, font);
        }
        return font;
    }


    private static class SingleTonEnforcer {

    }


}
