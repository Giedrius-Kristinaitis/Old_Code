package com.gasis.outlineracing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;
import com.gasis.outlineracing.logic.MainGame;
import com.gasis.outlineracing.storage.PrefStorage;

public class PlayScreen implements Screen {
   private MainGame game;

   public PlayScreen(Main var1, Assets var2, int var3, int var4, PrefStorage var5) {
      this.game = new MainGame(var1, var2, var3, var4, var5);
   }

   public void dispose() {
      this.game.dispose();
   }

   public void hide() {
   }

   public void pause() {
      this.game.pause();
   }

   public void render(float var1) {
      Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      Gdx.gl.glClear(16384);
      this.game.update(var1);
      this.game.draw(var1);
   }

   public void resize(int var1, int var2) {
      this.game.resize(var1, var2);
   }

   public void resume() {
      this.game.resume();
   }

   public void show() {
   }
}
