package com.gasis.outlineracing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;
import com.gasis.outlineracing.Vars;
import com.gasis.outlineracing.storage.PrefStorage;

public class MainMenuScreen implements Screen {
   private Assets assets;
   private Image backgroundBlue;
   private Image backgroundGreen;
   private Image backgroundRed;
   private Image backgroundYellow;
   private Image currentBackground;
   private PrefStorage data;
   private Image image;
   private Main main;
   private Viewport port;
   private Skin skin;
   private boolean soundOn;
   private Stage stage;
   private float timeElapsed;

   public MainMenuScreen(Main var1) {
      this.assets = var1.getAssets();
      this.main = var1;
      this.data = new PrefStorage();
      this.backgroundGreen = new Image(this.assets.getTex("background_league_green.png"));
      this.backgroundYellow = new Image(this.assets.getTex("background_league_yellow.png"));
      this.backgroundRed = new Image(this.assets.getTex("background_league_red.png"));
      this.backgroundBlue = new Image(this.assets.getTex("background_league_blue.png"));
      this.backgroundYellow.addAction(Actions.alpha(0.0F));
      this.backgroundRed.addAction(Actions.alpha(0.0F));
      this.backgroundBlue.addAction(Actions.alpha(0.0F));
      this.currentBackground = this.backgroundGreen;
      this.stage = new Stage();
      this.skin = this.assets.blueSkin;
      this.port = new StretchViewport(1280.0F, 720.0F);
      this.port.apply(true);
      this.stage.setViewport(this.port);
      this.soundOn = this.data.getBoolean("sound_status");
      var1.setMusic(this.assets.getMusic("sound/music.mp3"));
      if (!this.soundOn) {
         var1.setMusic((Music)null);
      }

      this.setupUI();
      Gdx.input.setInputProcessor(this.stage);
   }

   static Assets access$000(MainMenuScreen var0) {
      return var0.assets;
   }

   static Main access$100(MainMenuScreen var0) {
      return var0.main;
   }

   static void access$200(MainMenuScreen var0) {
      var0.showCreditsDialog();
   }

   static boolean access$300(MainMenuScreen var0) {
      return var0.soundOn;
   }

   static boolean access$302(MainMenuScreen var0, boolean var1) {
      var0.soundOn = var1;
      return var1;
   }

   static PrefStorage access$400(MainMenuScreen var0) {
      return var0.data;
   }

   private void changeBackground() {
      this.currentBackground.addAction(Actions.fadeOut(1.0F));
      int var1 = (int)(Math.random() * 4.0);
      if (var1 == 0) {
         this.currentBackground = this.backgroundGreen;
      } else if (var1 == 1) {
         this.currentBackground = this.backgroundYellow;
      } else if (var1 == 2) {
         this.currentBackground = this.backgroundRed;
      } else if (var1 == 3) {
         this.currentBackground = this.backgroundBlue;
      } else {
         this.currentBackground = this.backgroundBlue;
      }

      this.currentBackground.addAction(Actions.fadeIn(1.0F));
   }

   private void setupUI() {
      Stack var3 = new Stack();
      var3.setFillParent(true);
      Table var2 = new Table();
      var2.setFillParent(true);
      var2.align(2);
      this.image = new Image(this.assets.getTex("logo.png"));
      var2.add((Actor)this.image).pad(72.0F);
      TextButton var1 = new TextButton("Start", this.skin);
      var1.pad(10.0F);
      var1.addListener(new ClickListener(this) {
         final MainMenuScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new LeagueScreen(this.this$0.main, this.this$0.assets));
         }
      });
      var2.row();
      var2.add((Actor)var1).width(320.0F).padTop(36.0F);
      var1 = new TextButton("Credits", this.skin);
      var1.pad(10.0F);
      var1.addListener(new ClickListener(this) {
         final MainMenuScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.showCreditsDialog();
         }
      });
      var2.row();
      var2.add((Actor)var1).width(320.0F).padTop(36.0F);
      var1 = new TextButton("Exit", this.skin);
      var1.pad(10.0F);
      var1.addListener(new ClickListener(this) {
         final MainMenuScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            Gdx.app.exit();
         }
      });
      var2.row();
      var2.add((Actor)var1).width(320.0F).padTop(36.0F);
      Vars.sound = this.soundOn;
      Texture var4;
      if (this.soundOn) {
         var4 = this.assets.getTex("ic_sound_on.png");
      } else {
         var4 = this.assets.getTex("ic_sound_off.png");
      }

      Image var5 = new Image(var4);
      var5.setBounds(32.0F, 32.0F, 64.0F, 64.0F);
      var5.addListener(new InputListener(this, var5) {
         final MainMenuScreen this$0;
         final Image val$button;

         {
            this.this$0 = var1;
            this.val$button = var2;
         }

         public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            if (this.this$0.soundOn) {
               this.this$0.soundOn = false;
               Vars.sound = this.this$0.soundOn;
               this.this$0.data.saveBoolean("sound_status", this.this$0.soundOn);
               this.this$0.main.setMusic((Music)null);
               this.val$button.setDrawable(new TextureRegionDrawable(new TextureRegion(this.this$0.assets.getTex("ic_sound_off.png"))));
            } else {
               this.this$0.soundOn = true;
               Vars.sound = this.this$0.soundOn;
               this.this$0.data.saveBoolean("sound_status", this.this$0.soundOn);
               this.this$0.main.setMusic(this.this$0.assets.getMusic("sound/music.mp3"));
               this.val$button.setDrawable(new TextureRegionDrawable(new TextureRegion(this.this$0.assets.getTex("ic_sound_on.png"))));
            }

            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            return true;
         }
      });
      var3.addActor(this.backgroundGreen);
      var3.addActor(this.backgroundYellow);
      var3.addActor(this.backgroundRed);
      var3.addActor(this.backgroundBlue);
      this.stage.addActor(var3);
      this.stage.addActor(var2);
      this.stage.addActor(var5);
   }

   private void showCreditsDialog() {
      Dialog var2 = new Dialog("", this.skin);
      TextButton var1 = new TextButton("OK", this.skin);
      var1.addListener(new ClickListener(this, var2) {
         final MainMenuScreen this$0;
         final Dialog val$dialog;

         {
            this.this$0 = var1;
            this.val$dialog = var2;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.val$dialog.hide();
         }
      });
      var2.button((Button)var1);
      var2.text("Developed by:\nGasis\nPublished by:\nGasis\n\nMusic:\nEDM Detection Mode Kevin MacLeod (incompetech.com)\nLicensed under Creative Commons: By Attribution 3.0 License\nhttp://creativecommons.org/licenses/by/3.0/");
      var2.show(this.stage);
   }

   private void update(float var1) {
      this.timeElapsed += var1;
      if (this.timeElapsed >= 2.5F) {
         this.timeElapsed = 0.0F;
         this.changeBackground();
      }

   }

   public void dispose() {
      this.stage.dispose();
   }

   public void hide() {
   }

   public void pause() {
   }

   public void render(float var1) {
      Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      Gdx.gl.glClear(16384);
      this.update(var1);
      this.stage.act(var1);
      this.stage.draw();
   }

   public void resize(int var1, int var2) {
      this.port.update(var1, var2);
   }

   public void resume() {
   }

   public void show() {
      this.stage.addAction(Actions.alpha(0.0F));
      this.stage.addAction(Actions.fadeIn(1.0F));
   }
}
