package com.gasis.outlineracing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;
import com.gasis.outlineracing.Vars;

public class LeagueScreen implements Screen {
   private Assets assets;
   private Image backgroundBlue;
   private Image backgroundGreen;
   private Image backgroundRed;
   private Image backgroundYellow;
   private Skin blueSkin;
   private Image currentBackground;
   private Skin greenSkin;
   private Main main;
   private Viewport port;
   private Skin redSkin;
   private Stage stage;
   private float timeElapsed;
   private Skin yellowSkin;

   public LeagueScreen(Main var1, Assets var2) {
      this.assets = var2;
      this.main = var1;
      this.init();
   }

   static Assets access$000(LeagueScreen var0) {
      return var0.assets;
   }

   static Main access$100(LeagueScreen var0) {
      return var0.main;
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

   private void init() {
      this.stage = new Stage();
      this.greenSkin = this.assets.greenSkin;
      this.yellowSkin = this.assets.yellowSkin;
      this.redSkin = this.assets.redSkin;
      this.blueSkin = this.assets.blueSkin;
      this.backgroundGreen = new Image(this.assets.getTex("background_league_green.png"));
      this.backgroundYellow = new Image(this.assets.getTex("background_league_yellow.png"));
      this.backgroundRed = new Image(this.assets.getTex("background_league_red.png"));
      this.backgroundBlue = new Image(this.assets.getTex("background_league_blue.png"));
      this.backgroundYellow.addAction(Actions.alpha(0.0F));
      this.backgroundRed.addAction(Actions.alpha(0.0F));
      this.backgroundBlue.addAction(Actions.alpha(0.0F));
      this.currentBackground = this.backgroundGreen;
      this.port = new StretchViewport(1280.0F, 720.0F);
      this.port.apply(true);
      this.stage.setViewport(this.port);
      this.setupUI();
      Gdx.input.setInputProcessor(this.stage);
   }

   private void setupUI() {
      Stack var1 = new Stack();
      var1.setFillParent(true);
      Table var2 = new Table();
      var2.align(2);
      var2.add((Actor)(new Label("Select League:", this.greenSkin))).pad(36.0F);
      var2.row();
      TextButton var7 = new TextButton("Green League", this.greenSkin);
      var7.pad(10.0F);
      var7.addListener(new ClickListener(this) {
         final LeagueScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new LevelScreen(this.this$0.main, this.this$0.assets, (byte)1));
         }
      });
      TextButton var6 = new TextButton("Yellow League", this.yellowSkin);
      var6.pad(10.0F);
      var6.addListener(new ClickListener(this) {
         final LeagueScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new LevelScreen(this.this$0.main, this.this$0.assets, (byte)2));
         }
      });
      TextButton var5 = new TextButton("Red League", this.redSkin);
      var5.pad(10.0F);
      var5.addListener(new ClickListener(this) {
         final LeagueScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new LevelScreen(this.this$0.main, this.this$0.assets, (byte)3));
         }
      });
      TextButton var4 = new TextButton("Blue League", this.blueSkin);
      var4.pad(10.0F);
      var4.addListener(new ClickListener(this) {
         final LeagueScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new LevelScreen(this.this$0.main, this.this$0.assets, (byte)4));
         }
      });
      Table var3 = new Table();
      var3.add((Actor)var7).width(320.0F).pad(50.0F);
      var3.add((Actor)var6).width(320.0F).pad(50.0F);
      var3.row();
      var3.add((Actor)var5).width(320.0F).pad(50.0F);
      var3.add((Actor)var4).width(320.0F).pad(50.0F);
      var2.add((Actor)var3).expand();
      TextButton var8 = new TextButton("Back", this.blueSkin);
      var8.pad(10.0F);
      var8.addListener(new ClickListener(this) {
         final LeagueScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new MainMenuScreen(this.this$0.main));
         }
      });
      var2.row();
      var2.add((Actor)var8).width(213.33333F).pad(36.0F);
      var1.addActor(this.backgroundGreen);
      var1.addActor(this.backgroundYellow);
      var1.addActor(this.backgroundRed);
      var1.addActor(this.backgroundBlue);
      var1.addActor(var2);
      this.stage.addActor(var1);
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
