package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BladeVertices;
import com.gasis.thegame.logic.vertices.LongBoxVertices;

public class Structure20 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      LongBoxVertices var6 = new LongBoxVertices();
      Thing var5 = ThingUtils.createPolygon((new BladeVertices()).get(), 1.0F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.KinematicBody, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 20.0F, Utils.P * 20.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var4 = ThingUtils.createPolygon(var6.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.DynamicBody, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F + Utils.P * 30.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var7 = ThingUtils.createPolygon(var6.get(), 1.0F, var1.resources.getTexture("box_long.png"), BodyDef.BodyType.DynamicBody, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT / 2.0F - Utils.P * 30.0F, Utils.P * 40.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      ThingUtils.createRevoluteJoint(var2, var5.body, var4.body, new Vector2(0.0F, 0.0F), new Vector2(0.0F, Utils.P * 30.0F), 1000.0F, 1.0F);
      ThingUtils.createRevoluteJoint(var2, var5.body, var7.body, new Vector2(0.0F, 0.0F), new Vector2(0.0F, -Utils.P * 30.0F), 1000.0F, 1.0F);
      this.transformThings = new Thing[1];
      this.dynamicThings = new Thing[2];
      this.transformThings[0] = var5;
      this.dynamicThings[0] = var4;
      this.dynamicThings[1] = var7;
      this.coins = new Thing[2];
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT - Utils.P * 15.0F);
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.P * 15.0F);
      this.width = Utils.WIDTH;
   }
}
