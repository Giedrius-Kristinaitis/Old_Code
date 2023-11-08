package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BladeVertices;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure18 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      LongBoxVertices var5 = new LongBoxVertices();
      BladeVertices var6 = new BladeVertices();
      Thing var4 = ThingUtils.createPolygon(var5.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 25.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var8 = ThingUtils.createPolygon(var5.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 75.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var7 = ThingUtils.createPolygon(var6.get(), 1.0F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.DynamicBody, Utils.P * 10.0F + var3, Utils.HEIGHT - Utils.P * 37.5F, Utils.P * 20.0F, Utils.P * 20.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var9 = ThingUtils.createPolygon(var6.get(), 1.0F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.DynamicBody, Utils.P * 90.0F + var3, Utils.HEIGHT - Utils.P * 37.5F, Utils.P * 20.0F, Utils.P * 20.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var7.body.setAngularVelocity(1.0F);
      var9.body.setAngularVelocity(-1.0F);
      ThingUtils.createRopeJoint(var2, var4.body, var7.body, Utils.P * 35.0F);
      ThingUtils.createRopeJoint(var2, var8.body, var9.body, Utils.P * 35.0F);
      this.things = new Thing[2];
      this.dynamicThings = new Thing[2];
      this.things[0] = var4;
      this.things[1] = var8;
      this.dynamicThings[0] = var7;
      this.dynamicThings[1] = var9;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
