package com.tinker.shades365;

import android.content.res.ColorStateList;
import android.graphics.Color;

public class ColorStateListCreator {

    private static int defaultColor = Color.WHITE;

    public static ColorStateList create(int colorStateEnabled, int colorStateUnchecked) {
        int[][] states = new int[][] {
                new int[] {-android.R.attr.state_checked},
                new int[]{android.R.attr.state_enabled},
                new int[]{} // this should be empty to make default color as we want
        };

        int[] colors = new int[] {
                colorStateUnchecked,
                colorStateEnabled,
                defaultColor
        };

        return new ColorStateList(states, colors);
    }
}
