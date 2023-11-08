package com.gasis.outlineracing.logic.world.vechile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.outlineracing.Assets;

public class Chasis extends Part {
   private Fixture fix;
   private float height;
   private float width;

   public void createBody(int var1, World var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      BodyDef var11 = new BodyDef();
      FixtureDef var10 = new FixtureDef();
      PolygonShape var12 = new PolygonShape();
      var11.type = BodyDef.BodyType.DynamicBody;
      var11.position.set(var3, var4);
      if (var1 != 1 && var1 != 3) {
         if (var1 == 2) {
            var12.set(new float[]{-var5 / 2.0F, -var6 / 2.0F, var5 / 2.0F, -var6 / 2.0F, var5 / 2.0F / 6.0F, 0.0F, -var5 / 2.0F / 3.5F, var6 / 2.0F});
         } else if (var1 == 4) {
            var12.set(new float[]{-var5 / 2.0F, -var6 / 2.0F, var5 / 2.0F, -var6 / 2.0F, var5 / 2.0F / 2.0F, var6 / 2.0F, -var5 / 2.0F / 2.0F, var6 / 2.0F});
         }
      } else {
         var12.set(new float[]{-var5 / 2.0F, -var6 / 2.0F, var5 / 2.0F, -var6 / 2.0F, 0.0F, var6 / 2.0F});
      }

      var10.density = var9;
      var10.shape = var12;
      var10.friction = var7;
      var10.restitution = var8;
      Body var13 = var2.createBody(var11);
      this.fix = var13.createFixture(var10);
      this.setBody(var13);
      this.width = 100.0F * var5;
      this.height = 100.0F * var6;
   }

   public Fixture getFix() {
      return this.fix;
   }

   public void render(SpriteBatch var1, float var2) {
      Body var5 = this.getBody();
      float var4 = var5.getPosition().x;
      var2 = var5.getPosition().y;
      float var3 = var5.getAngle();
      Sprite var6 = this.getSprite();
      var6.setSize(this.width, this.height);
      var6.setCenter(var4 * 100.0F, var2 * 100.0F);
      var6.setOriginCenter();
      var6.setRotation(var3 * 57.295776F);
      var6.draw(var1);
   }

   public void setup(int var1, Assets var2) {
      Texture var3 = null;
      if (var1 == 1) {
         var3 = var2.getTex("body_green.png");
      } else if (var1 == 2) {
         var3 = var2.getTex("body_yellow.png");
      } else if (var1 == 3) {
         var3 = var2.getTex("body_red.png");
      } else if (var1 == 4) {
         var3 = var2.getTex("body_blue.png");
      }

      this.setSprite(new Sprite(var3));
   }
}
