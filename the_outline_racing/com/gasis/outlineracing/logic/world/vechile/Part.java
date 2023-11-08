package com.gasis.outlineracing.logic.world.vechile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.gasis.outlineracing.Assets;

public abstract class Part {
   private Body body;
   private Sprite sprite;

   public Body getBody() {
      return this.body;
   }

   public Sprite getSprite() {
      return this.sprite;
   }

   public abstract void render(SpriteBatch var1, float var2);

   public void setBody(Body var1) {
      this.body = var1;
   }

   public void setSprite(Sprite var1) {
      this.sprite = var1;
   }

   public abstract void setup(int var1, Assets var2);
}
