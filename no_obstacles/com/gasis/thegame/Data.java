package com.gasis.thegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Data {
   public static final String KEY_BACKGROUND_TEXTURE = "background_texture";
   public static final String KEY_BALL_TEXTURE = "ball_texture";
   public static final String KEY_COINS = "coins";
   public static final String KEY_HIGH_SCORE = "high_score";
   public static final String KEY_HIGH_SCORE_NIGHT = "high_score_night";
   public static final String KEY_SOUND = "sound_status";
   private final String PREFERENCE_NAME = "the_game_data";
   private Preferences prefs;

   public Data() {
      this.prefs = Gdx.app.getPreferences("the_game_data");
   }

   public boolean getBoolean(String var1) {
      boolean var2 = true;
      if (!var1.equals("green_ball") && !var1.equals("orange_background")) {
         if (var1.equals("sound_status")) {
            var2 = this.prefs.getBoolean("sound_status", true);
         } else {
            var2 = this.prefs.getBoolean(var1);
         }
      }

      return var2;
   }

   public float getFloat(String var1) {
      return this.prefs.getFloat(var1);
   }

   public int getInteger(String var1) {
      return this.prefs.getInteger(var1);
   }

   public String getString(String var1) {
      if (var1.equals("background_texture")) {
         var1 = this.prefs.getString(var1, "background_orange.png");
      } else if (var1.equals("ball_texture")) {
         var1 = this.prefs.getString(var1, "ball_green.png");
      } else {
         var1 = this.prefs.getString(var1);
      }

      return var1;
   }

   public void putBoolean(String var1, boolean var2) {
      this.prefs.putBoolean(var1, var2);
      this.prefs.flush();
   }

   public void putFloat(String var1, float var2) {
      this.prefs.putFloat(var1, var2);
      this.prefs.flush();
   }

   public void putInteger(String var1, int var2) {
      this.prefs.putInteger(var1, var2);
      this.prefs.flush();
   }

   public void putString(String var1, String var2) {
      this.prefs.putString(var1, var2);
      this.prefs.flush();
   }
}
