package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;

public class Structure13 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      Thing var4 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 25.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 15.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var5 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 75.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 15.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      var4.body.setAngularVelocity(4.0F);
      var5.body.setAngularVelocity(4.0F);
      this.things = new Thing[2];
      this.things[0] = var4;
      this.things[1] = var5;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
