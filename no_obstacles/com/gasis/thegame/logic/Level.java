package com.gasis.thegame.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.structure.Structure;
import com.gasis.thegame.logic.things.Thing;

public class Level {
   public Structure a;
   public Structure b;
   public float gap;
   private final float gapDecreaseSpeed;
   private Sprite indicatorA;
   private Sprite indicatorB;
   private Main main;
   private boolean move;
   private final int numStructures = 20;
   public float speed = -2.5F;
   private World world;

   public Level(Main var1, World var2) {
      this.gapDecreaseSpeed = Utils.P / 4.0F;
      this.gap = Utils.P * 25.0F;
      this.move = false;
      this.main = var1;
      this.world = var2;
      this.a = this.createStructure(Utils.WIDTH / 2.0F);
      this.b = this.createStructure(this.a.position + this.a.width + Utils.P * 25.0F);
      this.indicatorA = new Sprite(var1.resources.getTexture("score_increase_indicator.png"));
      this.indicatorB = new Sprite(var1.resources.getTexture("score_increase_indicator.png"));
      this.indicatorA.setSize(Utils.P * 6.0F, Utils.HEIGHT);
      this.indicatorB.setSize(Utils.P * 6.0F, Utils.HEIGHT);
      this.createIndicator();
   }

   private void changeStructureVelocity(Structure var1, float var2) {
      if (var1.things != null) {
         Thing[] var5 = var1.things;
         int var4 = var5.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            Thing var6 = var5[var3];
            if (var6.body.getType().equals(BodyDef.BodyType.KinematicBody)) {
               var6.body.setLinearVelocity(var2, var6.body.getLinearVelocity().y);
            }
         }
      }

      var1.sensor.body.setLinearVelocity(var2, 0.0F);
   }

   private void createIndicator() {
      float var4 = this.a.position + this.a.width + this.gap / 2.0F - Utils.P * 3.0F;
      float var3 = this.b.position + this.b.width + this.gap / 2.0F - Utils.P * 3.0F;
      float var1;
      float var2;
      if (var4 < Utils.P * 25.0F) {
         var2 = -64.0F;
         var1 = var3;
      } else {
         var2 = var4;
         var1 = var3;
         if (var3 < Utils.P * 25.0F) {
            var1 = -64.0F;
            var2 = var4;
         }
      }

      this.indicatorA.setPosition(var2, 0.0F);
      this.indicatorB.setPosition(var1, 0.0F);
   }

   private Structure createStructure(float var1) {
      Object var4 = null;
      int var2 = MathUtils.random(19);
      Class var3 = null;

      label18: {
         Class var8;
         try {
            StringBuilder var5 = new StringBuilder();
            var8 = Class.forName(var5.append("com.gasis.thegame.logic.structure.Structure").append(String.valueOf(var2 + 1)).toString());
         } catch (ClassNotFoundException var7) {
            var7.printStackTrace();
            break label18;
         }

         var3 = var8;
      }

      Structure var9;
      try {
         var9 = (Structure)var3.newInstance();
      } catch (Exception var6) {
         var6.printStackTrace();
         var9 = (Structure)var4;
      }

      var9.create(this.main, this.world, var1);
      var9.position = var1;
      return var9;
   }

   private void updateGap() {
      if (this.gap > Utils.P * 10.0F) {
         this.gap -= this.gapDecreaseSpeed;
      }

   }

   private void updateSpeed() {
      this.speed -= 0.05F;
      this.changeStructureVelocity(this.a, this.speed);
      this.changeStructureVelocity(this.b, this.speed);
   }

   private void updateThings(Structure var1, float var2, float var3) {
      byte var5 = 0;
      int var4;
      int var6;
      if (var1.dynamicThings != null) {
         Thing[] var8 = var1.dynamicThings;
         var6 = var8.length;

         for(var4 = 0; var4 < var6; ++var4) {
            Thing var7 = var8[var4];
            var7.body.setTransform(var7.body.getPosition().x + var2 * var3, var7.body.getPosition().y, var7.body.getAngle());
         }
      }

      Thing[] var10;
      if (var1.transformThings != null) {
         var10 = var1.transformThings;
         var6 = var10.length;

         for(var4 = 0; var4 < var6; ++var4) {
            Thing var11 = var10[var4];
            var11.body.setTransform(var11.body.getPosition().x + var2 * var3, var11.body.getPosition().y, var11.body.getAngle());
         }
      }

      if (var1.coins != null) {
         var10 = var1.coins;
         var6 = var10.length;

         for(var4 = var5; var4 < var6; ++var4) {
            Thing var9 = var10[var4];
            var9.body.setTransform(var9.body.getPosition().x + var2 * var3, var9.body.getPosition().y, var9.body.getAngle());
         }
      }

   }

   public final void draw(SpriteBatch var1) {
      this.a.draw(var1);
      this.b.draw(var1);
      this.indicatorA.draw(var1);
      this.indicatorB.draw(var1);
   }

   public boolean isMoving() {
      return this.move;
   }

   public void startMoving() {
      this.move = true;
      this.changeStructureVelocity(this.a, this.speed);
      this.changeStructureVelocity(this.b, this.speed);
   }

   public void stopMoving() {
      this.move = false;
      this.changeStructureVelocity(this.a, 0.0F);
      this.changeStructureVelocity(this.b, 0.0F);
   }

   public final void update(float var1) {
      this.a.update();
      this.b.update();
      if (this.move) {
         this.a.position = this.a.sensor.body.getPosition().x * Utils.PPM;
         this.b.position = this.b.sensor.body.getPosition().x * Utils.PPM;
         this.createIndicator();
         this.updateThings(this.a, this.speed, var1);
         this.updateThings(this.b, this.speed, var1);
      }

      if (this.a.position < -this.a.width) {
         this.a.destroy(this.world);
         this.a = null;
         this.a = this.createStructure(this.b.position + this.b.width + this.gap);
         this.updateGap();
         this.updateSpeed();
      }

      if (this.b.position < -this.b.width) {
         this.b.destroy(this.world);
         this.b = null;
         this.b = this.createStructure(this.a.position + this.a.width + this.gap);
         this.updateGap();
         this.updateSpeed();
      }

   }
}
