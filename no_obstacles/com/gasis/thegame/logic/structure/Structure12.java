package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;

public class Structure12 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      Thing var4 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.HEIGHT - Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var11 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 35.0F + var3, Utils.HEIGHT - Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var7 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 65.0F + var3, Utils.HEIGHT - Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var9 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.HEIGHT - Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var10 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var6 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 35.0F + var3, Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var8 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 65.0F + var3, Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var5 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.P * 17.5F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      var4.body.setAngularVelocity(8.0F);
      var11.body.setAngularVelocity(8.0F);
      var7.body.setAngularVelocity(8.0F);
      var9.body.setAngularVelocity(8.0F);
      var10.body.setAngularVelocity(8.0F);
      var6.body.setAngularVelocity(8.0F);
      var8.body.setAngularVelocity(8.0F);
      var5.body.setAngularVelocity(8.0F);
      this.things = new Thing[8];
      this.things[0] = var4;
      this.things[1] = var11;
      this.things[2] = var7;
      this.things[3] = var9;
      this.things[4] = var10;
      this.things[5] = var6;
      this.things[6] = var8;
      this.things[7] = var5;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
