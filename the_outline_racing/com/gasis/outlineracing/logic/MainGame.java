package com.gasis.outlineracing.logic;

import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;
import com.gasis.outlineracing.logic.rendering.Renderer;
import com.gasis.outlineracing.logic.world.GasisWorld;
import com.gasis.outlineracing.storage.PrefStorage;

public class MainGame {
   private Renderer renderer;
   private GasisWorld world;

   public MainGame(Main var1, Assets var2, int var3, int var4, PrefStorage var5) {
      this.world = new GasisWorld(var2, var3, var4, var5);
      this.renderer = new Renderer(var1, var2, var3, var4, var5, this.world, var5.getInt("current_level"));
   }

   public void dispose() {
      this.renderer.dispose();
      this.world.dispose();
   }

   public void draw(float var1) {
      this.renderer.draw(var1);
   }

   public void pause() {
      this.renderer.pause();
   }

   public void resize(int var1, int var2) {
      this.renderer.resize(var1, var2);
   }

   public void resume() {
   }

   public void update(float var1) {
      this.world.update(var1);
   }
}
