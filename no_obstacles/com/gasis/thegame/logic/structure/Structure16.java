package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure16 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      LongBoxVertices var7 = new LongBoxVertices();
      Thing var6 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 25.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var4 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 75.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var5 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 25.0F + var3, Utils.P * 10.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var8 = ThingUtils.createPolygon(var7.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 75.0F + var3, Utils.P * 10.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var6.body.setTransform(var6.body.getPosition(), -0.43633232F);
      var4.body.setTransform(var4.body.getPosition(), 0.43633232F);
      var5.body.setTransform(var5.body.getPosition(), 0.43633232F);
      var8.body.setTransform(var8.body.getPosition(), -0.43633232F);
      this.things = new Thing[4];
      this.things[0] = var6;
      this.things[1] = var4;
      this.things[2] = var5;
      this.things[3] = var8;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
