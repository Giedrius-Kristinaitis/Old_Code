package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BladeVertices;

public class Structure3 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      this.things = new Thing[5];
      Thing var7 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var4 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var6 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 10.0F + var3, Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var5 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.P * 90.0F + var3, Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      var7.body.setAngularVelocity(8.0F);
      var4.body.setAngularVelocity(8.0F);
      var6.body.setAngularVelocity(8.0F);
      var5.body.setAngularVelocity(8.0F);
      Thing var8 = ThingUtils.createPolygon((new BladeVertices()).get(), 1.5F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 30.0F, Utils.P * 30.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      this.coins = new Thing[2];
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT - Utils.P * 7.5F);
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.P * 7.5F);
      var8.body.setAngularVelocity(2.5F);
      this.things[0] = var7;
      this.things[1] = var4;
      this.things[2] = var6;
      this.things[3] = var5;
      this.things[4] = var8;
      this.width = Utils.WIDTH;
   }
}
