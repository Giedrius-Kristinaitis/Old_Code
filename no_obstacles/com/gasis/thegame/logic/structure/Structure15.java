package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;

public class Structure15 extends Structure {
   private final float BOTTOM;
   private final float TOP;
   private float speedFive;
   private float speedFour;
   private float speedOne;
   private float speedThree;
   private float speedTwo;

   public Structure15() {
      this.TOP = Utils.HEIGHT - Utils.P * 10.0F;
      this.BOTTOM = Utils.P * 10.0F;
      this.speedOne = Utils.P / 4.0F;
      this.speedTwo = -Utils.P / 4.0F;
      this.speedThree = Utils.P / 4.0F;
      this.speedFour = -Utils.P / 4.0F;
      this.speedFive = Utils.P / 4.0F;
   }

   static float access$000(Structure15 var0) {
      return var0.TOP;
   }

   static float access$100(Structure15 var0) {
      return var0.BOTTOM;
   }

   static float access$200(Structure15 var0) {
      return var0.speedOne;
   }

   static float access$202(Structure15 var0, float var1) {
      var0.speedOne = var1;
      return var1;
   }

   static float access$300(Structure15 var0) {
      return var0.speedTwo;
   }

   static float access$302(Structure15 var0, float var1) {
      var0.speedTwo = var1;
      return var1;
   }

   static float access$400(Structure15 var0) {
      return var0.speedThree;
   }

   static float access$402(Structure15 var0, float var1) {
      var0.speedThree = var1;
      return var1;
   }

   static float access$500(Structure15 var0) {
      return var0.speedFour;
   }

   static float access$502(Structure15 var0, float var1) {
      var0.speedFour = var1;
      return var1;
   }

   static float access$600(Structure15 var0) {
      return var0.speedFive;
   }

   static float access$602(Structure15 var0, float var1) {
      var0.speedFive = var1;
      return var1;
   }

   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      Thing var7 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var5 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 30.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var8 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var6 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 70.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var4 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      var7.body.setAngularVelocity(8.0F);
      var5.body.setAngularVelocity(8.0F);
      var8.body.setAngularVelocity(8.0F);
      var6.body.setAngularVelocity(8.0F);
      var4.body.setAngularVelocity(8.0F);
      var7.updater = new Thing.Updater(this) {
         final Structure15 this$0;

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
      var5.updater = new Thing.Updater(this) {
         final Structure15 this$0;

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
      var8.updater = new Thing.Updater(this) {
         final Structure15 this$0;

         {
            this.this$0 = var1;
         }

         public void update(Body var1) {
            float var2 = var1.getPosition().y * Utils.PPM;
            if (var2 >= this.this$0.TOP || var2 <= this.this$0.BOTTOM) {
               this.this$0.speedThree = -this.this$0.speedThree;
            }

            var1.setTransform(var1.getPosition().x, var1.getPosition().y + this.this$0.speedThree / Utils.PPM, var1.getAngle());
         }
      };
      var6.updater = new Thing.Updater(this) {
         final Structure15 this$0;

         {
            this.this$0 = var1;
         }

         public void update(Body var1) {
            float var2 = var1.getPosition().y * Utils.PPM;
            if (var2 >= this.this$0.TOP || var2 <= this.this$0.BOTTOM) {
               this.this$0.speedFour = -this.this$0.speedFour;
            }

            var1.setTransform(var1.getPosition().x, var1.getPosition().y + this.this$0.speedFour / Utils.PPM, var1.getAngle());
         }
      };
      var4.updater = new Thing.Updater(this) {
         final Structure15 this$0;

         {
            this.this$0 = var1;
         }

         public void update(Body var1) {
            float var2 = var1.getPosition().y * Utils.PPM;
            if (var2 >= this.this$0.TOP || var2 <= this.this$0.BOTTOM) {
               this.this$0.speedFive = -this.this$0.speedFive;
            }

            var1.setTransform(var1.getPosition().x, var1.getPosition().y + this.this$0.speedFive / Utils.PPM, var1.getAngle());
         }
      };
      this.things = new Thing[5];
      this.things[0] = var7;
      this.things[1] = var5;
      this.things[2] = var8;
      this.things[3] = var6;
      this.things[4] = var4;
      this.coins = new Thing[2];
      this.createCoin(var1, var2, Utils.P * 40.0F + var3, Utils.HEIGHT / 2.0F);
      this.createCoin(var1, var2, Utils.P * 60.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
