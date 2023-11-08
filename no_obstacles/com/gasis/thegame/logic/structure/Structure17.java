package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure17 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      Thing var5 = ThingUtils.createCircle(var1.resources.getTexture("saw.png"), BodyDef.BodyType.KinematicBody, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT - Utils.P * 10.0F, Utils.P * 5.0F, 0.5F, (String)null, (Thing.Updater)null, var2, false);
      Thing var4 = ThingUtils.createPolygon((new LongBoxVertices()).get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.DynamicBody, Utils.P * 85.0F + var3, Utils.HEIGHT / 2.0F + Utils.P * 20.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.25F, (String)null, (Thing.Updater)null, var2);
      var5.body.setAngularVelocity(8.0F);
      ThingUtils.createRopeJoint(var2, var5.body, var4.body, Utils.P * 35.0F);
      this.things = new Thing[1];
      this.things[0] = var5;
      this.dynamicThings = new Thing[1];
      this.dynamicThings[0] = var4;
      this.coins = new Thing[1];
      this.createCoin(var1, var2, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F);
      this.width = Utils.WIDTH;
   }
}
