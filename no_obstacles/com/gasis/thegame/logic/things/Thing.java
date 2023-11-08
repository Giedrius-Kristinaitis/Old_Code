package com.gasis.thegame.logic.things;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.gasis.thegame.Utils;

public class Thing {
   public Body body;
   protected float height;
   public Sprite sprite;
   public Updater updater;
   protected float width;

   public void createSprite(Texture var1, float var2, float var3) {
      if (var1 != null) {
         this.sprite = new Sprite(var1);
         this.sprite.setSize(var2, var3);
         this.width = var2;
         this.height = var3;
      }

   }

   public void draw(SpriteBatch var1) {
      this.sprite.setPosition(this.body.getPosition().x * Utils.PPM - this.width / 2.0F, this.body.getPosition().y * Utils.PPM - this.height / 2.0F);
      this.sprite.setOriginCenter();
      this.sprite.setRotation(this.body.getAngle() * 57.295776F);
      this.sprite.draw(var1);
   }

   public final void update() {
      if (this.updater != null) {
         this.updater.update(this.body);
      }

   }

   public interface Updater {
      void update(Body var1);
   }
}
