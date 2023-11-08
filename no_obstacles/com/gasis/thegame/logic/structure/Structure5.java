package com.gasis.thegame.logic.structure;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import com.gasis.thegame.logic.vertices.BladeVertices;
import com.gasis.thegame.logic.vertices.BoxVertices;

public class Structure5 extends Structure {
   public void create(Main var1, World var2, float var3) {
      this.createSensor(var2, var3);
      this.dynamicThings = new Thing[4];
      this.transformThings = new Thing[1];
      Thing var7 = ThingUtils.createPolygon((new BladeVertices()).get(), 1.0F, var1.resources.getTexture("blades.png"), BodyDef.BodyType.KinematicBody, Utils.P * 50.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 20.0F, Utils.P * 20.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      BoxVertices var8 = new BoxVertices();
      Thing var5 = ThingUtils.createPolygon(var8.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.DynamicBody, Utils.P * 20.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var6 = ThingUtils.createPolygon(var8.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.DynamicBody, Utils.P * 50.0F + var3, Utils.HEIGHT, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var4 = ThingUtils.createPolygon(var8.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.DynamicBody, Utils.P * 80.0F + var3, Utils.HEIGHT / 2.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      Thing var9 = ThingUtils.createPolygon(var8.get(), 1.0F, var1.resources.getTexture("box.png"), BodyDef.BodyType.DynamicBody, Utils.P * 50.0F + var3, 0.0F, Utils.P * 10.0F, Utils.P * 10.0F, 0.5F, (String)null, (Thing.Updater)null, var2);
      ThingUtils.createRevoluteJoint(var2, var7.body, var5.body, new Vector2(0.0F, 0.0F), new Vector2(Utils.P * 30.0F, 0.0F), 1000.0F, 1.0F);
      ThingUtils.createRevoluteJoint(var2, var7.body, var6.body, new Vector2(0.0F, 0.0F), new Vector2(0.0F, -(Utils.HEIGHT / 2.0F)), 1000.0F, 1.0F);
      ThingUtils.createRevoluteJoint(var2, var7.body, var4.body, new Vector2(0.0F, 0.0F), new Vector2(-Utils.P * 30.0F, 0.0F), 1000.0F, 1.0F);
      ThingUtils.createRevoluteJoint(var2, var7.body, var9.body, new Vector2(0.0F, 0.0F), new Vector2(0.0F, Utils.HEIGHT / 2.0F), 1000.0F, 1.0F);
      this.coins = new Thing[2];
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.HEIGHT - Utils.P * 10.0F);
      this.createCoin(var1, var2, Utils.WIDTH / 2.0F + var3, Utils.P * 10.0F);
      this.transformThings[0] = var7;
      this.dynamicThings[0] = var5;
      this.dynamicThings[1] = var6;
      this.dynamicThings[2] = var4;
      this.dynamicThings[3] = var9;
      this.width = Utils.WIDTH;
   }
}
