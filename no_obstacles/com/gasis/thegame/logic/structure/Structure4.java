package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure4 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      this.things = new Thing[3];
      LongBoxVertices var5 = new LongBoxVertices();
      Thing var4 = ThingUtils.createPolygon(var5.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.P * 20.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var4.body.setTransform(var4.body.getPosition(), 1.5707964F);
      Thing var7 = ThingUtils.createPolygon(var5.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.HEIGHT - Utils.P * 20.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      var7.body.setTransform(var7.body.getPosition(), 1.5707964F);
      Thing var6 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 6.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      var6.body.setAngularVelocity(8.0F);
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3 + Utils.P * 20.0F, Utils.HEIGHT / 2.0F);
      this.things[0] = var4;
      this.things[1] = var7;
      this.things[2] = var6;
      this.width = Utils.WIDTH;
   }
}
