package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure8 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      LongBoxVertices var5 = new LongBoxVertices();
      Thing var4 = ThingUtils.createPolygon(var5.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 25.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var6 = ThingUtils.createPolygon(var5.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 75.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var4.body.setAngularVelocity(2.0F);
      var6.body.setAngularVelocity(3.5F);
      this.things = new Thing[2];
      this.coins = new Thing[2];
      this.things[0] = var4;
      this.things[1] = var6;
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT - Utils.P * 10.0F);
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.P * 10.0F);
      this.width = Utils.WIDTH;
   }
}
