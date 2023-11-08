package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;

public class Structure1 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.things = new Thing[8];
      this.coins = new Thing[1];
      this.things[0] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[1] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[2] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 30.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[3] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[4] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[5] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 70.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[6] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.things[7] = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F);
      this.things[0].body.setAngularVelocity(8.0F);
      this.things[1].body.setAngularVelocity(8.0F);
      this.things[2].body.setAngularVelocity(8.0F);
      this.things[3].body.setAngularVelocity(8.0F);
      this.things[4].body.setAngularVelocity(8.0F);
      this.things[5].body.setAngularVelocity(8.0F);
      this.things[6].body.setAngularVelocity(8.0F);
      this.things[7].body.setAngularVelocity(8.0F);
      this.width = Utils.WIDTH;
      this.createSensor(var2, var3);
   }
}
