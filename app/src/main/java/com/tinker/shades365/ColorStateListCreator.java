package com.tinker.shades365;

import android.content.res.ColorStateList;

public class ColorStateListCreator {
    public static ColorStateList create(int colorStatePressed, int colorStateUnchecked, int colorStateEnabled, int colorStateDefault) {
        int[][] states = new int[][] {
                new int[]{android.R.attr.state_pressed},
                new int[] {-android.R.attr.state_checked},
                new int[]{android.R.attr.state_enabled},
                new int[]{} // this should be empty to make default color as we want
        };

        int[] colors = new int[] {
                colorStatePressed,
                colorStateUnchecked,
                colorStateEnabled,
                colorStateDefault
        };

        return new ColorStateList(states, colors);
    }
}
