package com.gasis.outlineracing;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.gasis.outlineracing.screens.LoadingScreen;

public class Main extends Game {
   private Assets assets;
   private Screen currentScreen;
   private ShowAdListener listener;
   private Music music;

   public Main(ShowAdListener var1) {
      this.listener = var1;
   }

   public void adClosed() {
   }

   public void create() {
      this.setCurrentScreen(new LoadingScreen(this));
   }

   public void dispose() {
      this.currentScreen.dispose();
      this.assets.getManager().dispose();
      this.assets.dispose();
   }

   public Assets getAssets() {
      return this.assets;
   }

   public ShowAdListener getListener() {
      return this.listener;
   }

   public void pause() {
      this.currentScreen.pause();
   }

   public void render() {
      super.render();
   }

   public void resize(int var1, int var2) {
      this.currentScreen.resize(var1, var2);
   }

   public void resume() {
      this.currentScreen.resume();
   }

   public void setAssets(Assets var1) {
      this.assets = var1;
   }

   public void setCurrentScreen(Screen var1) {
      if (this.currentScreen != null) {
         this.currentScreen.dispose();
      }

      this.currentScreen = var1;
      this.setScreen(var1);
   }

   public void setMusic(Music var1) {
      if (var1 == null) {
         if (this.music != null) {
            this.music.stop();
            this.music = null;
         }
      } else {
         this.music = var1;
         var1.setVolume(0.4F);
         var1.setLooping(true);
         var1.play();
      }

   }
}
