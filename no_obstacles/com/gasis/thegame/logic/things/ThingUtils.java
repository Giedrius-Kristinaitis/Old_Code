package com.gasis.thegame.logic.things;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.RopeJointDef;
import com.badlogic.gdx.utils.ShortArray;
import com.gasis.thegame.Utils;

public class ThingUtils {
   private static Body createBodyWithMultipleFixtures(float[] var0, World var1, BodyDef.BodyType var2, float var3, float var4, float var5, String var6) {
      BodyDef var7 = new BodyDef();
      var7.position.set(var3 / Utils.PPM, var4 / Utils.PPM);
      var7.type = var2;
      Body var8 = var1.createBody(var7);
      createTriangleFixtures(var8, var5, var6, var0, (new EarClippingTriangulator()).computeTriangles(var0));
      return var8;
   }

   private static Body createBodyWithOneFixture(World var0, BodyDef.BodyType var1, Shape var2, float var3, float var4, float var5, String var6, boolean var7) {
      BodyDef var9 = new BodyDef();
      FixtureDef var8 = new FixtureDef();
      var9.position.set(var3 / Utils.PPM, var4 / Utils.PPM);
      var9.type = var1;
      var8.shape = var2;
      var8.density = var5;
      if (var7) {
         var8.isSensor = true;
      }

      Body var10 = var0.createBody(var9);
      var10.createFixture(var8).setUserData(var6);
      return var10;
   }

   public static Thing createCircle(Texture var0, BodyDef.BodyType var1, float var2, float var3, float var4, float var5, String var6, Thing.Updater var7, World var8, boolean var9) {
      Thing var10 = new Thing();
      var10.createSprite(var0, 2.0F * var4, 2.0F * var4);
      var10.updater = var7;
      CircleShape var11 = new CircleShape();
      var11.setRadius(var4 / Utils.PPM);
      var10.body = createBodyWithOneFixture(var8, var1, var11, var2, var3, var5, var6, var9);
      return var10;
   }

   public static Thing createPolygon(float[] var0, float var1, Texture var2, BodyDef.BodyType var3, float var4, float var5, float var6, float var7, float var8, String var9, Thing.Updater var10, World var11) {
      Thing var12 = new Thing();
      var12.createSprite(var2, var6, var7);
      var12.updater = var10;
      var12.body = createBodyWithMultipleFixtures(scaleVertices(var0, var1), var11, var3, var4, var5, var8, var9);
      return var12;
   }

   public static void createRevoluteJoint(World var0, Body var1, Body var2, Vector2 var3, Vector2 var4, float var5, float var6) {
      RevoluteJointDef var7 = new RevoluteJointDef();
      var7.bodyA = var1;
      var7.bodyB = var2;
      var3.set(var3.x / Utils.PPM, var3.y / Utils.PPM);
      var4.set(var4.x / Utils.PPM, var4.y / Utils.PPM);
      var7.localAnchorA.set(var3);
      var7.localAnchorB.set(var4);
      var7.enableMotor = true;
      var7.maxMotorTorque = var5;
      var7.motorSpeed = var6;
      var0.createJoint(var7);
   }

   public static void createRopeJoint(World var0, Body var1, Body var2, float var3) {
      RopeJointDef var4 = new RopeJointDef();
      var4.maxLength = var3 / Utils.PPM;
      var4.bodyA = var1;
      var4.bodyB = var2;
      var4.localAnchorA.set(0.0F, 0.0F);
      var4.localAnchorB.set(0.0F, 0.0F);
      var0.createJoint(var4);
   }

   private static void createTriangleFixtures(Body var0, float var1, String var2, float[] var3, ShortArray var4) {
      FixtureDef var7 = new FixtureDef();
      PolygonShape var6 = new PolygonShape();

      for(int var5 = 0; var5 < var4.size - 2; var5 += 3) {
         var6.set(new float[]{var3[var4.get(var5) * 2], var3[var4.get(var5) * 2 + 1], var3[var4.get(var5 + 1) * 2], var3[var4.get(var5 + 1) * 2 + 1], var3[var4.get(var5 + 2) * 2], var3[var4.get(var5 + 2) * 2 + 1]});
         var7.shape = var6;
         var7.density = var1;
         var0.createFixture(var7).setUserData(var2);
      }

   }

   private static float[] scaleVertices(float[] var0, float var1) {
      float[] var3 = new float[var0.length];

      for(int var2 = 0; var2 < var0.length; ++var2) {
         var3[var2] = var0[var2] * var1 / Utils.PPM;
      }

      return var3;
   }
}
