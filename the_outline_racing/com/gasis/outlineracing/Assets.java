package com.gasis.outlineracing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
   public Skin blueSkin;
   public Skin greenSkin;
   private AssetManager manager = new AssetManager();
   public Skin redSkin;
   public Skin yellowSkin;

   public void dispose() {
      this.greenSkin.dispose();
      this.yellowSkin.dispose();
      this.redSkin.dispose();
      this.blueSkin.dispose();
   }

   public BitmapFont getFont(String var1) {
      return (BitmapFont)this.manager.get(var1, BitmapFont.class);
   }

   public AssetManager getManager() {
      return this.manager;
   }

   public Music getMusic(String var1) {
      return (Music)this.manager.get(var1, Music.class);
   }

   public Texture getTex(String var1) {
      return (Texture)this.manager.get(var1, Texture.class);
   }

   public void load() {
      this.manager.load("arrow_blue_left.png", Texture.class);
      this.manager.load("arrow_blue_right.png", Texture.class);
      this.manager.load("arrow_yellow_left.png", Texture.class);
      this.manager.load("arrow_yellow_right.png", Texture.class);
      this.manager.load("arrow_green_left.png", Texture.class);
      this.manager.load("arrow_green_right.png", Texture.class);
      this.manager.load("arrow_red_left.png", Texture.class);
      this.manager.load("arrow_red_right.png", Texture.class);
      this.manager.load("arrow_blue_left_down.png", Texture.class);
      this.manager.load("arrow_blue_right_down.png", Texture.class);
      this.manager.load("arrow_yellow_left_down.png", Texture.class);
      this.manager.load("arrow_yellow_right_down.png", Texture.class);
      this.manager.load("arrow_green_left_down.png", Texture.class);
      this.manager.load("arrow_green_right_down.png", Texture.class);
      this.manager.load("arrow_red_left_down.png", Texture.class);
      this.manager.load("arrow_red_right_down.png", Texture.class);
      this.manager.load("body_green.png", Texture.class);
      this.manager.load("body_yellow.png", Texture.class);
      this.manager.load("body_red.png", Texture.class);
      this.manager.load("body_blue.png", Texture.class);
      this.manager.load("wheel_green.png", Texture.class);
      this.manager.load("wheel_yellow.png", Texture.class);
      this.manager.load("wheel_red.png", Texture.class);
      this.manager.load("wheel_blue.png", Texture.class);
      this.manager.load("line_green.png", Texture.class);
      this.manager.load("line_yellow.png", Texture.class);
      this.manager.load("line_red.png", Texture.class);
      this.manager.load("line_blue.png", Texture.class);
      this.manager.load("logo.png", Texture.class);
      this.manager.load("lock.png", Texture.class);
      this.manager.load("arial15.fnt", BitmapFont.class);
      this.manager.load("arial32.fnt", BitmapFont.class);
      this.manager.load("finish_line.png", Texture.class);
      this.manager.load("background_menu.png", Texture.class);
      this.manager.load("background_green.png", Texture.class);
      this.manager.load("background_yellow.png", Texture.class);
      this.manager.load("background_red.png", Texture.class);
      this.manager.load("background_blue.png", Texture.class);
      this.manager.load("ic_suspension_green.png", Texture.class);
      this.manager.load("ic_suspension_yellow.png", Texture.class);
      this.manager.load("ic_suspension_red.png", Texture.class);
      this.manager.load("ic_suspension_blue.png", Texture.class);
      this.manager.load("ic_top_speed_green.png", Texture.class);
      this.manager.load("ic_top_speed_yellow.png", Texture.class);
      this.manager.load("ic_top_speed_red.png", Texture.class);
      this.manager.load("ic_top_speed_blue.png", Texture.class);
      this.manager.load("ic_accel_green.png", Texture.class);
      this.manager.load("ic_accel_yellow.png", Texture.class);
      this.manager.load("ic_accel_red.png", Texture.class);
      this.manager.load("ic_accel_blue.png", Texture.class);
      this.manager.load("ic_coin.png", Texture.class);
      this.manager.load("sound/music.mp3", Music.class);
      this.manager.load("sound/click1.ogg", Sound.class);
      this.manager.load("ic_sound_on.png", Texture.class);
      this.manager.load("ic_sound_off.png", Texture.class);
      this.manager.load("background_shop.png", Texture.class);
      this.manager.load("background_item.png", Texture.class);
      this.manager.load("ic_body_green.png", Texture.class);
      this.manager.load("ic_body_yellow.png", Texture.class);
      this.manager.load("ic_body_red.png", Texture.class);
      this.manager.load("ic_body_blue.png", Texture.class);
      this.manager.load("ic_tire_green.png", Texture.class);
      this.manager.load("ic_tire_yellow.png", Texture.class);
      this.manager.load("ic_tire_red.png", Texture.class);
      this.manager.load("ic_tire_blue.png", Texture.class);
      this.manager.load("ic_restart_up.png", Texture.class);
      this.manager.load("ic_restart_down.png", Texture.class);
      this.manager.load("ic_menu_up.png", Texture.class);
      this.manager.load("ic_menu_down.png", Texture.class);
      this.manager.load("ic_pause.png", Texture.class);
      this.manager.load("ic_resume.png", Texture.class);
      this.manager.load("background_league_green.png", Texture.class);
      this.manager.load("background_league_yellow.png", Texture.class);
      this.manager.load("background_league_red.png", Texture.class);
      this.manager.load("background_league_blue.png", Texture.class);
      this.greenSkin = new Skin();
      this.greenSkin.addRegions(new TextureAtlas("uiskin-green.atlas"));
      this.greenSkin.load(Gdx.files.internal("uiskin.json"));
      this.yellowSkin = new Skin();
      this.yellowSkin.addRegions(new TextureAtlas("uiskin-yellow.atlas"));
      this.yellowSkin.load(Gdx.files.internal("uiskin.json"));
      this.redSkin = new Skin();
      this.redSkin.addRegions(new TextureAtlas("uiskin-red.atlas"));
      this.redSkin.load(Gdx.files.internal("uiskin.json"));
      this.blueSkin = new Skin();
      this.blueSkin.addRegions(new TextureAtlas("uiskin-blue.atlas"));
      this.blueSkin.load(Gdx.files.internal("uiskin.json"));
   }

   public void playButtonClick() {
      ((Sound)this.manager.get("sound/click1.ogg", Sound.class)).play(1.0F);
   }
}
