package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BoxVertices;

public class Structure19 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      BoxVertices var9 = new BoxVertices();
      Thing var4 = ThingUtils.createPolygon(var9.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 20.0F + var3, Utils.HEIGHT - Utils.P * 5.5F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var5 = ThingUtils.createPolygon(var9.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 20.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var7 = ThingUtils.createPolygon(var9.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 20.0F + var3, Utils.P * 5.5F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var6 = ThingUtils.createPolygon(var9.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 80.0F + var3, Utils.HEIGHT - Utils.P * 5.5F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var8 = ThingUtils.createPolygon(var9.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 80.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var10 = ThingUtils.createPolygon(var9.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.KinematicBody, Utils.P * 80.0F + var3, Utils.P * 5.5F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var11 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      var11.body.setAngularVelocity(4.0F);
      this.things = new Thing[7];
      this.things[0] = var4;
      this.things[1] = var5;
      this.things[2] = var7;
      this.things[3] = var6;
      this.things[4] = var8;
      this.things[5] = var10;
      this.things[6] = var11;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.P * 35.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
