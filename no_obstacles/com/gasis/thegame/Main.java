package com.gasis.thegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gasis.thegame.screen.BaseScreen;
import com.gasis.thegame.screen.LoadingScreen;
import com.gasis.thegame.screen.PlayScreen;

public class Main extends Game {
   private AdShowListener adListener;
   private BaseScreen currentScreen;
   public Data data;
   private ShareListener listener;
   public ResourceManager resources;

   public Main(AdShowListener var1) {
      this.adListener = var1;
   }

   private void initializeGlobalVariables() {
      this.data = new Data();
      Utils.soundOn = this.data.getBoolean("sound_status");
      this.resources = new ResourceManager();
   }

   private void initializeMetrics() {
      int var1 = Gdx.graphics.getWidth();
      if (var1 >= 1366) {
         this.initializeScreenMetrics(1.8F);
      } else if (var1 >= 960) {
         this.initializeScreenMetrics(1.2F);
      } else if (var1 >= 720) {
         this.initializeScreenMetrics(0.9F);
      } else if (var1 >= 480) {
         this.initializeScreenMetrics(0.6F);
      } else if (var1 >= 320) {
         this.initializeScreenMetrics(0.4F);
      } else {
         this.initializeScreenMetrics(0.4F);
      }

   }

   private void initializeScreen() {
      this.changeScreen(new LoadingScreen(this));
   }

   private void initializeScreenMetrics(float var1) {
      Utils.WIDTH = 800.0F * var1;
      Utils.HEIGHT = 480.0F * var1;
      Utils.P = Utils.WIDTH / 100.0F;
      Utils.PPM = Utils.WIDTH / 8.0F;
   }

   public boolean backPressed() {
      boolean var1;
      if (this.currentScreen instanceof PlayScreen) {
         var1 = ((PlayScreen)this.currentScreen).backPressed();
      } else {
         var1 = false;
      }

      return var1;
   }

   public void changeScreen(BaseScreen var1) {
      if (this.currentScreen != null) {
         this.currentScreen.dispose();
      }

      this.currentScreen = var1;
      this.setScreen(this.currentScreen);
   }

   public void create() {
      this.initializeMetrics();
      this.initializeGlobalVariables();
      this.initializeScreen();
   }

   public void dispose() {
      this.currentScreen.dispose();
      this.resources.dispose();
   }

   public AdShowListener getAdListener() {
      return this.adListener;
   }

   public ShareListener getShareListener() {
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

   public void setShareListener(ShareListener var1) {
      this.listener = var1;
   }
}
