package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BladeVertices;

public class Structure14 extends Structure {
   private final float BOTTOM;
   private final float TOP;
   private float speedOne;
   private float speedTwo;

   public Structure14() {
      this.TOP = Utils.HEIGHT - Utils.P * 10.0F;
      this.BOTTOM = Utils.P * 10.0F;
      this.speedOne = -Utils.P / 3.2F;
      this.speedTwo = Utils.P / 3.2F;
   }

   static float access$000(Structure14 var0) {
      return var0.TOP;
   }

   static float access$100(Structure14 var0) {
      return var0.BOTTOM;
   }

   static float access$200(Structure14 var0) {
      return var0.speedOne;
   }

   static float access$202(Structure14 var0, float var1) {
      var0.speedOne = var1;
      return var1;
   }

   static float access$300(Structure14 var0) {
      return var0.speedTwo;
   }

   static float access$302(Structure14 var0, float var1) {
      var0.speedTwo = var1;
      return var1;
   }

   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      BladeVertices var5 = new BladeVertices();
      Thing var4 = ThingUtils.createPolygon(var5.get(), 1.5F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.KinematicBody, Utils.P * 25.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 30.0F, Utils.P * 30.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var6 = ThingUtils.createPolygon(var5.get(), 1.5F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.KinematicBody, Utils.P * 75.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 30.0F, Utils.P * 30.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var4.body.setAngularVelocity(2.0F);
      var6.body.setAngularVelocity(2.0F);
      var4.updater = new Thing.Updater(this) {
         final Structure14 this$0;

         {
            this.this$0 = var1;
         }

         public void update(Body var1) {
            float var2 = var1.getPosition().y * Utils.PPM;
            if (var2 >= this.this$0.TOP || var2 <= this.this$0.BOTTOM) {
               this.this$0.speedOne = -this.this$0.speedOne;
            }

            var1.setTransform(var1.getPosition().x, var1.getPosition().y + this.this$0.speedOne / Utils.PPM, var1.getAngle());
         }
      };
      var6.updater = new Thing.Updater(this) {
         final Structure14 this$0;

         {
            this.this$0 = var1;
         }

         public void update(Body var1) {
            float var2 = var1.getPosition().y * Utils.PPM;
            if (var2 >= this.this$0.TOP || var2 <= this.this$0.BOTTOM) {
               this.this$0.speedTwo = -this.this$0.speedTwo;
            }

            var1.setTransform(var1.getPosition().x, var1.getPosition().y + this.this$0.speedTwo / Utils.PPM, var1.getAngle());
         }
      };
      this.things = new Thing[2];
      this.things[0] = var4;
      this.things[1] = var6;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
