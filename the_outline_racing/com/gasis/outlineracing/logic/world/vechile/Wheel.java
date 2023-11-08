package com.gasis.outlineracing.logic.world.vechile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.outlineracing.Assets;

public class Wheel extends Part {
   private Fixture fix;
   private float radius;

   public void createBody(World var1, float var2, float var3, float var4, float var5, float var6) {
      BodyDef var8 = new BodyDef();
      FixtureDef var7 = new FixtureDef();
      CircleShape var9 = new CircleShape();
      var8.type = BodyDef.BodyType.DynamicBody;
      var8.position.set(var2, var3);
      var9.setRadius(var4);
      var7.density = 0.2F;
      var7.shape = var9;
      var7.friction = var5;
      var7.restitution = var6;
      Body var10 = var1.createBody(var8);
      this.fix = var10.createFixture(var7);
      this.setBody(var10);
      this.radius = 100.0F * var4;
   }

   public Fixture getFix() {
      return this.fix;
   }

   public void render(SpriteBatch var1, float var2) {
      Body var5 = this.getBody();
      var2 = var5.getPosition().x;
      float var4 = var5.getPosition().y;
      float var3 = var5.getAngle();
      Sprite var6 = this.getSprite();
      var6.setSize(this.radius * 2.0F, this.radius * 2.0F);
      var6.setCenter(var2 * 100.0F, var4 * 100.0F);
      var6.setOriginCenter();
      var6.setRotation(var3 * 57.295776F);
      var6.draw(var1);
   }

   public void setup(int var1, Assets var2) {
      Texture var3 = null;
      if (var1 == 1) {
         var3 = var2.getTex("wheel_green.png");
      } else if (var1 == 2) {
         var3 = var2.getTex("wheel_yellow.png");
      } else if (var1 == 3) {
         var3 = var2.getTex("wheel_red.png");
      } else if (var1 == 4) {
         var3 = var2.getTex("wheel_blue.png");
      }

      this.setSprite(new Sprite(var3));
   }
}
