package com.gasis.thegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Utils {
   public static final byte BOTTOM = 1;
   public static float HEIGHT;
   public static final byte LEFT = 2;
   public static float P;
   public static float PPM;
   public static final byte RIGHT = 3;
   public static final byte TOP = 0;
   public static float WIDTH;
   public static boolean soundOn = true;

   public static void createFadeInAnimation(Actor var0, float var1, Runnable var2) {
      Runnable var3 = var2;
      if (var2 == null) {
         var3 = new Runnable() {
            public void run() {
            }
         };
      }

      var0.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(var1), Actions.run(var3)));
   }

   public static void createFadeOutAnimation(Actor var0, float var1, Runnable var2) {
      Runnable var3 = var2;
      if (var2 == null) {
         var3 = new Runnable() {
            public void run() {
            }
         };
      }

      var0.addAction(Actions.sequence(Actions.fadeOut(var1), Actions.run(var3)));
   }

   public static void createLoopedZoomAnimation(Actor var0, float var1, float var2, float var3) {
      var0.setOrigin(var2, var3);
      var0.addAction(Actions.forever(Actions.sequence(Actions.scaleTo(var1, var1, 1.0F), Actions.scaleTo(1.0F, 1.0F, 1.0F))));
   }

   public static void createSlideInAnimation(Actor var0, float var1, byte var2, Interpolation var3, Runnable var4) {
      Runnable var5 = var4;
      if (var4 == null) {
         var5 = new Runnable() {
            public void run() {
            }
         };
      }

      switch (var2) {
         case 0:
            var0.addAction(Actions.sequence(Actions.moveBy(0.0F, WIDTH - var0.getY() + var0.getHeight()), Actions.moveBy(0.0F, -(WIDTH - var0.getY() + var0.getHeight()), var1, var3), Actions.run(var5)));
            break;
         case 1:
            var0.addAction(Actions.sequence(Actions.moveBy(0.0F, -(var0.getY() + var0.getHeight())), Actions.moveBy(0.0F, var0.getY() + var0.getHeight(), var1, var3), Actions.run(var5)));
            break;
         case 2:
            var0.addAction(Actions.sequence(Actions.moveBy(-(var0.getX() + var0.getWidth()), 0.0F), Actions.moveBy(var0.getX() + var0.getWidth(), 0.0F, var1, var3), Actions.run(var5)));
            break;
         case 3:
            var0.addAction(Actions.sequence(Actions.moveBy(WIDTH - var0.getX() + var0.getWidth(), 0.0F), Actions.moveBy(-(WIDTH - var0.getX() + var0.getWidth()), 0.0F, var1, var3), Actions.run(var5)));
      }

   }

   public static void createSlideOutAnimation(Actor var0, float var1, byte var2, Interpolation var3, Runnable var4) {
      Runnable var5 = var4;
      if (var4 == null) {
         var5 = new Runnable() {
            public void run() {
            }
         };
      }

      switch (var2) {
         case 0:
            var0.addAction(Actions.sequence(Actions.moveBy(0.0F, WIDTH - var0.getY() + var0.getHeight(), var1, var3), Actions.run(var5)));
            break;
         case 1:
            var0.addAction(Actions.sequence(Actions.moveBy(0.0F, -(var0.getY() + var0.getHeight()), var1, var3), Actions.run(var5)));
            break;
         case 2:
            var0.addAction(Actions.sequence(Actions.moveBy(-(var0.getX() + var0.getWidth()), 0.0F, var1, var3), Actions.run(var5)));
            break;
         case 3:
            var0.addAction(Actions.sequence(Actions.moveBy(WIDTH - var0.getX() + var0.getWidth(), 0.0F, var1, var3), Actions.run(var5)));
      }

   }

   public static TextureRegionDrawable drawable(Texture var0) {
      return new TextureRegionDrawable(new TextureRegion(var0));
   }

   public static BitmapFont generateFont(int var0) {
      FreeTypeFontGenerator.FreeTypeFontParameter var1 = new FreeTypeFontGenerator.FreeTypeFontParameter();
      var1.size = var0;
      return (new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"))).generateFont(var1);
   }

   public static float getStringHeight(String var0, BitmapFont var1) {
      GlyphLayout var2 = new GlyphLayout();
      var2.setText(var1, var0);
      return var2.height;
   }

   public static float getStringWidth(String var0, BitmapFont var1) {
      GlyphLayout var2 = new GlyphLayout();
      var2.setText(var1, var0);
      return var2.width;
   }
}
