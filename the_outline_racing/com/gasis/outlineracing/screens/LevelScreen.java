package com.gasis.outlineracing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;
import com.gasis.outlineracing.Vars;
import com.gasis.outlineracing.storage.PrefStorage;

public class LevelScreen implements Screen {
   public static final byte BLUE_LEAGUE = 4;
   public static final short FIRST_BLUE_LEVEL = 301;
   public static final short FIRST_GREEN_LEVEL = 1;
   public static final short FIRST_RED_LEVEL = 201;
   public static final short FIRST_YELLOW_LEVEL = 101;
   public static final byte GREEN_LEAGUE = 1;
   public static final short LAST_BLUE_LEVEL = 400;
   public static final short LAST_GREEN_LEVEL = 100;
   public static final short LAST_RED_LEVEL = 300;
   public static final short LAST_YELLOW_LEVEL = 200;
   public static final byte RED_LEAGUE = 3;
   public static final byte YELLOW_LEAGUE = 2;
   private Assets assets;
   private Texture background;
   private byte leagueType;
   private Main main;
   private Viewport port;
   private PrefStorage prefs;
   private Skin skin;
   private Stage stage;

   public LevelScreen(Main var1, Assets var2, byte var3) {
      this.main = var1;
      this.assets = var2;
      this.leagueType = var3;
      this.prefs = new PrefStorage();
      this.initBackground(var3);
      this.init();
   }

   static Assets access$000(LevelScreen var0) {
      return var0.assets;
   }

   static Main access$100(LevelScreen var0) {
      return var0.main;
   }

   static byte access$200(LevelScreen var0) {
      return var0.leagueType;
   }

   static PrefStorage access$300(LevelScreen var0) {
      return var0.prefs;
   }

   private void init() {
      this.stage = new Stage();
      if (this.leagueType == 1) {
         this.skin = this.assets.greenSkin;
      } else if (this.leagueType == 2) {
         this.skin = this.assets.yellowSkin;
      } else if (this.leagueType == 3) {
         this.skin = this.assets.redSkin;
      } else if (this.leagueType == 4) {
         this.skin = this.assets.blueSkin;
      }

      this.port = new StretchViewport(1280.0F, 720.0F);
      this.port.apply(true);
      this.stage.setViewport(this.port);
      this.setupUI();
      Gdx.input.setInputProcessor(this.stage);
   }

   private void initBackground(int var1) {
      switch (var1) {
         case 1:
            this.background = this.assets.getTex("background_league_green.png");
            break;
         case 2:
            this.background = this.assets.getTex("background_league_yellow.png");
            break;
         case 3:
            this.background = this.assets.getTex("background_league_red.png");
            break;
         case 4:
            this.background = this.assets.getTex("background_league_blue.png");
      }

   }

   private void populateTable(Table var1, int var2, int var3, int var4) {
      for(; var3 <= var4; ++var3) {
         boolean var5;
         if (var3 > var2) {
            var5 = true;
         } else {
            var5 = false;
         }

         String var6;
         if (var3 < 10) {
            var6 = "00" + String.valueOf(var3);
         } else if (var3 < 100) {
            var6 = "0" + String.valueOf(var3);
         } else {
            var6 = String.valueOf(var3);
         }

         Label var7 = new Label(var6, this.skin);
         Button var8 = new Button(this.skin);
         if (var5) {
            var8.add(new Image(this.assets.getTex("lock.png"))).width(36.0F).height(36.0F).pad(10.0F);
            var8.add(var7).pad(10.0F);
         } else {
            var8.add(var7).pad(10.0F).padLeft(66.0F);
         }

         var8.addListener(new ClickListener(this, var7, var5) {
            final LevelScreen this$0;
            final boolean val$locked;
            final Label val$text;

            {
               this.this$0 = var1;
               this.val$text = var2;
               this.val$locked = var3;
            }

            public void clicked(InputEvent var1, float var2, float var3) {
               if (Vars.sound) {
                  this.this$0.assets.playButtonClick();
               }

               int var4 = Integer.parseInt(this.val$text.getText().toString());
               if (!this.val$locked) {
                  this.this$0.main.setCurrentScreen(new PlayScreen(this.this$0.main, this.this$0.assets, var4, this.this$0.leagueType, this.this$0.prefs));
               }

            }
         });
         var1.add((Actor)var8).pad(10.0F).fillX();
         if (var3 % 100 % 8 == 0) {
            var1.row();
         }
      }

   }

   private void setupUI() {
      Table var3 = new Table();
      var3.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.background))));
      var3.setFillParent(true);
      var3.align(2);
      var3.add((Actor)(new Label("Select Level", this.skin))).padTop(48.0F);
      var3.row();
      this.showLevels(var3);
      TextButton var2 = new TextButton("Shop", this.skin);
      var2.pad(10.0F);
      var2.addListener(new ClickListener(this) {
         final LevelScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new ShopScreen(this.this$0.main, this.this$0.assets, this.this$0.leagueType, this.this$0.prefs));
         }
      });
      TextButton var1 = new TextButton("Back", this.skin);
      var1.pad(10.0F);
      var1.addListener(new ClickListener(this) {
         final LevelScreen this$0;

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
      var3.add((Actor)var2).width(256.0F).padTop(36.0F).padBottom(36.0F);
      var3.add((Actor)var1).width(256.0F).padTop(36.0F).padBottom(36.0F);
      this.stage.addActor(var3);
   }

   private void showLevels(Table var1) {
      int var4 = this.prefs.getInt("current_level");
      short var2 = 0;
      short var3 = 0;
      switch (this.leagueType) {
         case 1:
            var2 = 1;
            var3 = 100;
            break;
         case 2:
            var2 = 101;
            var3 = 200;
            break;
         case 3:
            var2 = 201;
            var3 = 300;
            break;
         case 4:
            var2 = 301;
            var3 = 400;
      }

      Table var5 = new Table();
      var1.add((Actor)(new ScrollPane(var5, this.skin))).fillX().padTop(36.0F).colspan(2);
      var1.row();
      this.populateTable(var5, var4, var2, var3);
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
