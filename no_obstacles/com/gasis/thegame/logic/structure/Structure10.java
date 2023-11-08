package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BladeVertices;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure10 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      LongBoxVertices var7 = new LongBoxVertices();
      BladeVertices var8 = new BladeVertices();
      Thing var5 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 20.0F + var3, Utils.HEIGHT, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var6 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 80.0F + var3, Utils.HEIGHT, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var4 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 20.0F + var3, 0.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var9 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 80.0F + var3, 0.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var5.body.setTransform(var5.body.getPosition(), 1.5707964F);
      var6.body.setTransform(var6.body.getPosition(), 1.5707964F);
      var4.body.setTransform(var4.body.getPosition(), 1.5707964F);
      var9.body.setTransform(var9.body.getPosition(), 1.5707964F);
      Thing var10 = ThingUtils.createPolygon(var8.get(), 1.0F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 20.0F, Utils.P * 20.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var10.body.setAngularVelocity(2.5F);
      this.things = new Thing[5];
      this.things[0] = var5;
      this.things[1] = var6;
      this.things[2] = var4;
      this.things[3] = var9;
      this.things[4] = var10;
      this.coins = new Thing[2];
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT - Utils.P * 10.0F);
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.P * 10.0F);
      this.width = Utils.WIDTH;
   }
}
