package com.gasis.outlineracing.storage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PrefStorage {
   private static final String NAME = "outline_racing_data";
   private Preferences prefs;

   public PrefStorage() {
      this.prefs = Gdx.app.getPreferences("outline_racing_data");
   }

   public boolean getBoolean(String var1) {
      return this.prefs.getBoolean(var1, true);
   }

   public float getFloat(String var1) {
      return this.prefs.getFloat(var1, 0.0F);
   }

   public int getInt(String var1) {
      return this.prefs.getInteger(var1, 1);
   }

   public long getLong(String var1) {
      return this.prefs.getLong(var1);
   }

   public String getString(String var1) {
      return this.prefs.getString(var1, "");
   }

   public void saveBoolean(String var1, boolean var2) {
      this.prefs.putBoolean(var1, var2);
      this.prefs.flush();
   }

   public void saveFloat(String var1, float var2) {
      this.prefs.putFloat(var1, var2);
      this.prefs.flush();
   }

   public void saveInt(String var1, int var2) {
      this.prefs.putInteger(var1, var2);
      this.prefs.flush();
   }

   public void saveLong(String var1, long var2) {
      this.prefs.putLong(var1, var2);
      this.prefs.flush();
   }

   public void saveString(String var1, String var2) {
      this.prefs.putString(var1, var2);
      this.prefs.flush();
   }
}
