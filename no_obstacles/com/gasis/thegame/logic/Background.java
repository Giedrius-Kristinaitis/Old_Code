package com.gasis.thegame.logic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;

public class Background {
   private Sprite first;
   private Sprite second;

   public Background(Main var1, boolean var2) {
      this.initialize(var1, var2);
   }

   private void initialize(Main var1, boolean var2) {
      String var3 = var1.data.getString("background_texture");
      if (var2) {
         var3 = "background_space.png";
      }

      this.first = new Sprite(new Texture(var3));
      this.second = new Sprite(new Texture(var3));
      this.second.setFlip(true, false);
      this.first.setBounds(0.0F, 0.0F, Utils.WIDTH, Utils.HEIGHT);
      this.second.setBounds(Utils.WIDTH - 1.0F, 0.0F, Utils.WIDTH, Utils.HEIGHT);
   }

   public void dispose() {
      this.first.getTexture().dispose();
      this.second.getTexture().dispose();
   }

   public void render(SpriteBatch var1) {
      this.first.draw(var1);
      this.second.draw(var1);
   }

   public void update(float var1) {
      var1 /= 4.0F;
      this.first.setX(this.first.getX() + var1);
      this.second.setX(this.second.getX() + var1);
      if (this.first.getX() < -this.first.getWidth()) {
         this.first.setX(this.second.getX() + this.second.getWidth() - 1.0F);
      } else if (this.second.getX() < -this.second.getWidth()) {
         this.second.setX(this.first.getX() + this.first.getWidth() - 1.0F);
      }

   }
}
