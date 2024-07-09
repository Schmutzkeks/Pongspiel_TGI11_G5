package de.gruppe5.actions;

import java.awt.Color;

public class Utils {

	public static float lerp(float a, float b, float f)
	{
		if(f <= 0) return a;
		if(f >= 1) return b;
	    return a + f * (b - a);
	}
	
	public static Color lerpColor(Color a, Color b, float f) {
		return new Color(
					lerp((float)a.getRed() / 255, (float)b.getRed() / 255, f),
					lerp((float)a.getGreen() / 255, (float)b.getGreen() / 255, f),
					lerp((float)a.getBlue() / 255, (float)b.getBlue() / 255, f),
					lerp((float)a.getAlpha() / 255, (float)b.getAlpha() / 255, f)
			);
	}
	
	
}
