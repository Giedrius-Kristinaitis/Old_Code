package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BoxVertices;

public class Structure2 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      this.things = new Thing[2];
      this.transformThings = new Thing[2];
      this.dynamicThings = new Thing[2];
      BoxVertices var7 = new BoxVertices();
      Thing var4 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 20.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var5 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var6 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 80.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var10 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.P * 10.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var8 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.DynamicBody, Utils.P * 40.0F + var3, Utils.HEIGHT - Utils.P * 30.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var9 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.DynamicBody, Utils.P * 60.0F + var3, Utils.HEIGHT - Utils.P * 30.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      ThingUtils.createRopeJoint(var2, var4.body, var8.body, Utils.P * 32.5F);
      ThingUtils.createRopeJoint(var2, var6.body, var9.body, Utils.P * 32.5F);
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F);
      this.transformThings[0] = var4;
      this.things[0] = var5;
      this.transformThings[1] = var6;
      this.things[1] = var10;
      this.dynamicThings[0] = var8;
      this.dynamicThings[1] = var9;
      this.width = Utils.WIDTH;
   }
}
