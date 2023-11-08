package com.gasis.thegame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ResourceManager {
   public Sound click;
   public Sound coin;
   public Sound death;
   public BitmapFont font;
   public BitmapFont fontLarge;
   public BitmapFont fontSmall;
   public BitmapFont fontVerySmall;
   public Sound jump;
   private AssetManager manager = new AssetManager();
   public Music music;
   public Sound score;

   public void createSounds(Main var1) {
      this.music = (Music)this.manager.get("music.mp3", Music.class);
      this.click = (Sound)this.manager.get("click.ogg", Sound.class);
      this.jump = (Sound)this.manager.get("jump.wav", Sound.class);
      this.death = (Sound)this.manager.get("death.wav", Sound.class);
      this.coin = (Sound)this.manager.get("coinsfx.wav", Sound.class);
      this.startMusic();
   }

   public void dispose() {
      this.font.dispose();
      this.fontLarge.dispose();
      this.fontSmall.dispose();
      this.fontVerySmall.dispose();
      this.manager.dispose();
   }

   public AssetManager getManager() {
      return this.manager;
   }

   public Texture getTexture(String var1) {
      return (Texture)this.manager.get(var1, Texture.class);
   }

   public void load() {
      this.manager.load("saw.png", Texture.class);
      this.manager.load("box.png", Texture.class);
      this.manager.load("box_long.png", Texture.class);
      this.manager.load("blades.png", Texture.class);
      this.manager.load("ic_cup.png", Texture.class);
      this.manager.load("btn_up.png", Texture.class);
      this.manager.load("btn_down.png", Texture.class);
      this.manager.load("background_stage.png", Texture.class);
      this.manager.load("btn_pause_up.png", Texture.class);
      this.manager.load("btn_pause_down.png", Texture.class);
      this.manager.load("score_increase_indicator.png", Texture.class);
      this.manager.load("ic_coin.png", Texture.class);
      this.manager.load("logo.png", Texture.class);
      this.manager.load("btn_play_up.png", Texture.class);
      this.manager.load("btn_play_down.png", Texture.class);
      this.manager.load("btn_shop_up.png", Texture.class);
      this.manager.load("btn_shop_down.png", Texture.class);
      this.manager.load("btn_sound_off.png", Texture.class);
      this.manager.load("btn_sound_on.png", Texture.class);
      this.manager.load("background_stage_dark.png", Texture.class);
      this.manager.load("background_main_menu.png", Texture.class);
      this.manager.load("music.mp3", Music.class);
      this.manager.load("click.ogg", Sound.class);
      this.manager.load("jump.wav", Sound.class);
      this.manager.load("death.wav", Sound.class);
      this.manager.load("coinsfx.wav", Sound.class);
      this.manager.load("background_orange.png", Texture.class);
      this.manager.load("btn_classic_up.png", Texture.class);
      this.manager.load("btn_classic_down.png", Texture.class);
      this.manager.load("btn_night_up.png", Texture.class);
      this.manager.load("btn_night_down.png", Texture.class);
      this.manager.load("btn_stats_up.png", Texture.class);
      this.manager.load("btn_stats_down.png", Texture.class);
      this.manager.load("background_ac.png", Texture.class);
      this.manager.load("ic_ball_red.png", Texture.class);
      this.manager.load("ic_background_green.png", Texture.class);
      this.manager.load("ic_background_city.png", Texture.class);
      this.manager.load("ic_ball_black_white.png", Texture.class);
      this.manager.load("ic_background_blue.png", Texture.class);
      this.manager.load("ic_background_orange.png", Texture.class);
      this.manager.load("ic_ball_blue.png", Texture.class);
      this.manager.load("ic_ball_green.png", Texture.class);
      this.manager.load("ic_background_city_two.png", Texture.class);
      this.manager.load("ic_background_space.png", Texture.class);
      this.manager.load("ic_background_pyramids.png", Texture.class);
      this.manager.load("ic_background_red.png", Texture.class);
      this.manager.load("ic_ball_blue_lines.png", Texture.class);
      this.manager.load("ic_background_by.png", Texture.class);
      this.manager.load("ic_ball_heart.png", Texture.class);
      this.manager.load("ic_ball_gear.png", Texture.class);
      this.manager.load("ic_background_purple.png", Texture.class);
      this.manager.load("ic_ball_dots.png", Texture.class);
      this.manager.load("ic_background_grey.png", Texture.class);
      this.manager.load("ic_background_yellow.png", Texture.class);
      this.manager.load("ic_ball_white.png", Texture.class);
      this.manager.load("ic_background_wood.png", Texture.class);
      this.manager.load("ic_ball_black.png", Texture.class);
   }

   public void loadFonts() {
      this.font = Utils.generateFont((int)(Utils.P * 7.0F));
      this.fontLarge = Utils.generateFont((int)(Utils.P * 9.0F));
      this.fontSmall = Utils.generateFont((int)(Utils.P * 5.5F));
      this.fontVerySmall = Utils.generateFont((int)(Utils.P * 3.5F));
   }

   public void playButtonClick() {
      if (Utils.soundOn) {
         this.click.play();
      }

   }

   public void playCoinSound() {
      if (Utils.soundOn) {
         this.coin.play(0.2F);
      }

   }

   public void playDeathSound() {
      if (Utils.soundOn) {
         this.death.play();
      }

   }

   public void playJumpSound() {
      if (Utils.soundOn) {
         this.jump.play(0.2F);
      }

   }

   public void startMusic() {
      if (Utils.soundOn && !this.music.isPlaying()) {
         this.music.setLooping(true);
         this.music.setVolume(0.1F);
         this.music.play();
      }

   }

   public void stopMusic() {
      if (this.music.isPlaying()) {
         this.music.stop();
      }

   }
}
