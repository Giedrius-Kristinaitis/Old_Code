package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;

public abstract class Structure {
   public Thing[] coins;
   public Thing[] dynamicThings;
   private int index;
   public float position;
   public Thing sensor;
   public Thing[] things;
   public Thing[] transformThings;
   public float width;

   public abstract void create(Main var1, World var2, float var3);

   protected void createCoin(Main var1, World var2, float var3, float var4) {
      Thing var7 = ThingUtils.createCircle(var1.resources.getTexture("ic_coin.png"), BodyDef.BodyType.KinematicBody, var3, var4, Utils.P * 2.0F, 0.5F, "coin", (Thing.Updater)null, var2, true);
      Thing[] var6 = this.coins;
      int var5 = this.index++;
      var6[var5] = var7;
   }

   protected void createSensor(World var1, float var2) {
      this.sensor = ThingUtils.createCircle((Texture)null, BodyDef.BodyType.KinematicBody, var2, -Utils.HEIGHT, 0.1F, 1.0F, (String)null, (Thing.Updater)null, var1, false);
   }

   public final void destroy(World var1) {
      byte var3 = 0;
      int var2;
      int var4;
      Thing[] var5;
      if (this.things != null) {
         var5 = this.things;
         var4 = var5.length;

         for(var2 = 0; var2 < var4; ++var2) {
            var1.destroyBody(var5[var2].body);
         }
      }

      if (this.transformThings != null) {
         var5 = this.transformThings;
         var4 = var5.length;

         for(var2 = 0; var2 < var4; ++var2) {
            var1.destroyBody(var5[var2].body);
         }
      }

      if (this.dynamicThings != null) {
         var5 = this.dynamicThings;
         var4 = var5.length;

         for(var2 = 0; var2 < var4; ++var2) {
            var1.destroyBody(var5[var2].body);
         }
      }

      if (this.coins != null) {
         var5 = this.coins;
         var4 = var5.length;

         for(var2 = var3; var2 < var4; ++var2) {
            var1.destroyBody(var5[var2].body);
         }
      }

   }

   public final void draw(SpriteBatch var1) {
      byte var3 = 0;
      int var2;
      int var4;
      Thing[] var5;
      if (this.things != null) {
         var5 = this.things;
         var4 = var5.length;

         for(var2 = 0; var2 < var4; ++var2) {
            var5[var2].draw(var1);
         }
      }

      if (this.transformThings != null) {
         var5 = this.transformThings;
         var4 = var5.length;

         for(var2 = 0; var2 < var4; ++var2) {
            var5[var2].draw(var1);
         }
      }

      if (this.dynamicThings != null) {
         var5 = this.dynamicThings;
         var4 = var5.length;

         for(var2 = 0; var2 < var4; ++var2) {
            var5[var2].draw(var1);
         }
      }

      if (this.coins != null) {
         var5 = this.coins;
         var4 = var5.length;

         for(var2 = var3; var2 < var4; ++var2) {
            var5[var2].draw(var1);
         }
      }

   }

   public final void update() {
      byte var2 = 0;
      int var1;
      int var3;
      Thing[] var4;
      if (this.things != null) {
         var4 = this.things;
         var3 = var4.length;

         for(var1 = 0; var1 < var3; ++var1) {
            var4[var1].update();
         }
      }

      if (this.transformThings != null) {
         var4 = this.transformThings;
         var3 = var4.length;

         for(var1 = 0; var1 < var3; ++var1) {
            var4[var1].update();
         }
      }

      if (this.dynamicThings != null) {
         var4 = this.dynamicThings;
         var3 = var4.length;

         for(var1 = 0; var1 < var3; ++var1) {
            var4[var1].update();
         }
      }

      if (this.coins != null) {
         var4 = this.coins;
         var3 = var4.length;

         for(var1 = var2; var1 < var3; ++var1) {
            var4[var1].update();
         }
      }

   }
}
