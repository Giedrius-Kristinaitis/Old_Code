package com.gasis.outlineracing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
import com.gasis.outlineracing.logic.Utils;
import com.gasis.outlineracing.logic.world.vechile.Upgrades;
import com.gasis.outlineracing.storage.PrefStorage;

public class ShopScreen implements Screen {
   private Assets assets;
   private PrefStorage data;
   private Texture ic_accel;
   private Texture ic_coin;
   private Texture ic_lb;
   private Texture ic_speed;
   private Texture ic_sus;
   private Texture ic_tires;
   private int league;
   private Main main;
   private Viewport port;
   private Skin skin;
   private Stage stage;

   public ShopScreen(Main var1, Assets var2, int var3, PrefStorage var4) {
      this.main = var1;
      this.assets = var2;
      this.league = var3;
      this.data = var4;
      this.setup();
   }

   static Assets access$000(ShopScreen var0) {
      return var0.assets;
   }

   static void access$100(ShopScreen var0, int var1, float var2) {
      var0.purchaseSpeed(var1, var2);
   }

   static void access$200(ShopScreen var0, int var1, float var2) {
      var0.purchaseAccel(var1, var2);
   }

   static void access$300(ShopScreen var0, int var1, float var2) {
      var0.purchaseSus(var1, var2);
   }

   static void access$400(ShopScreen var0, int var1, float var2) {
      var0.purchaseLB(var1, var2);
   }

   static void access$500(ShopScreen var0, int var1, float var2) {
      var0.purchaseTires(var1, var2);
   }

   static Main access$600(ShopScreen var0) {
      return var0.main;
   }

   static int access$700(ShopScreen var0) {
      return var0.league;
   }

   private long loadMoney() {
      return this.data.getLong("money");
   }

   private void loadSkinAndTextures() {
      if (this.league == 1) {
         this.skin = this.assets.greenSkin;
      } else if (this.league == 2) {
         this.skin = this.assets.yellowSkin;
      } else if (this.league == 3) {
         this.skin = this.assets.redSkin;
      } else if (this.league == 4) {
         this.skin = this.assets.blueSkin;
      }

      if (this.league == 1) {
         this.ic_speed = this.assets.getTex("ic_top_speed_green.png");
         this.ic_accel = this.assets.getTex("ic_accel_green.png");
         this.ic_sus = this.assets.getTex("ic_suspension_green.png");
         this.ic_lb = this.assets.getTex("ic_body_green.png");
         this.ic_tires = this.assets.getTex("ic_tire_green.png");
      } else if (this.league == 2) {
         this.ic_speed = this.assets.getTex("ic_top_speed_yellow.png");
         this.ic_accel = this.assets.getTex("ic_accel_yellow.png");
         this.ic_sus = this.assets.getTex("ic_suspension_yellow.png");
         this.ic_lb = this.assets.getTex("ic_body_yellow.png");
         this.ic_tires = this.assets.getTex("ic_tire_yellow.png");
      } else if (this.league == 3) {
         this.ic_speed = this.assets.getTex("ic_top_speed_red.png");
         this.ic_accel = this.assets.getTex("ic_accel_red.png");
         this.ic_sus = this.assets.getTex("ic_suspension_red.png");
         this.ic_lb = this.assets.getTex("ic_body_red.png");
         this.ic_tires = this.assets.getTex("ic_tire_red.png");
      } else if (this.league == 4) {
         this.ic_speed = this.assets.getTex("ic_top_speed_blue.png");
         this.ic_accel = this.assets.getTex("ic_accel_blue.png");
         this.ic_sus = this.assets.getTex("ic_suspension_blue.png");
         this.ic_lb = this.assets.getTex("ic_body_blue.png");
         this.ic_tires = this.assets.getTex("ic_tire_blue.png");
      }

      this.ic_coin = this.assets.getTex("ic_coin.png");
   }

   private void purchaseAccel(int var1, float var2) {
      this.saveMoney(this.loadMoney() - (long)((int)var2));
      this.data.saveInt("acceleration", var1);
      this.main.setCurrentScreen(new ShopScreen(this.main, this.assets, this.league, this.data));
   }

   private void purchaseLB(int var1, float var2) {
      this.saveMoney(this.loadMoney() - (long)((int)var2));
      this.data.saveInt("lighter_body", var1);
      this.main.setCurrentScreen(new ShopScreen(this.main, this.assets, this.league, this.data));
   }

   private void purchaseSpeed(int var1, float var2) {
      this.saveMoney(this.loadMoney() - (long)((int)var2));
      this.data.saveInt("top_speed", var1);
      this.main.setCurrentScreen(new ShopScreen(this.main, this.assets, this.league, this.data));
   }

   private void purchaseSus(int var1, float var2) {
      this.saveMoney(this.loadMoney() - (long)((int)var2));
      this.data.saveInt("suspension", var1);
      this.main.setCurrentScreen(new ShopScreen(this.main, this.assets, this.league, this.data));
   }

   private void purchaseTires(int var1, float var2) {
      this.saveMoney(this.loadMoney() - (long)((int)var2));
      this.data.saveInt("tires", var1);
      this.main.setCurrentScreen(new ShopScreen(this.main, this.assets, this.league, this.data));
   }

   private void saveMoney(long var1) {
      this.data.saveLong("money", var1);
   }

   private void setup() {
      this.port = new StretchViewport(1280.0F, 720.0F);
      this.port.apply(true);
      this.stage = new Stage();
      this.stage.setViewport(this.port);
      this.loadSkinAndTextures();
      this.setupUI();
      Gdx.input.setInputProcessor(this.stage);
   }

   private void setupUI() {
      Table var13 = new Table();
      var13.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.assets.getTex("background_shop.png")))));
      var13.setFillParent(true);
      var13.align(2);
      Table var19 = new Table();
      Table var15 = new Table();
      Table var21 = new Table();
      Table var22 = new Table();
      Table var20 = new Table();
      var19.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.assets.getTex("background_item.png")))));
      var15.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.assets.getTex("background_item.png")))));
      var21.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.assets.getTex("background_item.png")))));
      var22.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.assets.getTex("background_item.png")))));
      var20.setBackground((Drawable)(new TextureRegionDrawable(new TextureRegion(this.assets.getTex("background_item.png")))));
      Image var17 = new Image(this.ic_speed);
      Image var18 = new Image(this.ic_accel);
      Image var14 = new Image(this.ic_sus);
      Image var16 = new Image(this.ic_lb);
      Image var23 = new Image(this.ic_tires);
      var13.add((Actor)(new Label("Shop > Performance", this.skin))).colspan(3).pad(25.0F).align(8);
      Image var24 = new Image(this.ic_coin);
      Label var25 = new Label(String.valueOf(this.loadMoney()), this.skin);
      var13.add((Actor)var24).width(36.0F).height(36.0F).colspan(1).expandX().pad(25.0F).padRight(10.0F).align(16);
      var13.add((Actor)var25).colspan(1).expandX().align(8);
      var13.row();
      Label var36 = new Label("Speed", this.skin);
      Label var40 = new Label("Acceleration", this.skin);
      Label var26 = new Label("Suspension", this.skin);
      Label var32 = new Label("Lighter Body", this.skin);
      Label var38 = new Label("Tires", this.skin);
      new Upgrades();
      Label var27 = new Label("$" + 2000.0F, this.skin);
      Label var29 = new Label("$" + 2000.0F, this.skin);
      Label var28 = new Label("$" + 2000.0F, this.skin);
      Label var33 = new Label("$" + 2000.0F, this.skin);
      Label var37 = new Label("$" + 2000.0F, this.skin);
      var27.setFontScale(0.65F);
      var29.setFontScale(0.65F);
      var28.setFontScale(0.65F);
      var33.setFontScale(0.65F);
      var37.setFontScale(0.65F);
      var36.setFontScale(0.7F);
      var40.setFontScale(0.7F);
      var26.setFontScale(0.7F);
      var32.setFontScale(0.7F);
      var38.setFontScale(0.7F);
      TextButton var30 = new TextButton("Upgrade", this.skin);
      TextButton var41 = new TextButton("Upgrade", this.skin);
      TextButton var34 = new TextButton("Upgrade", this.skin);
      TextButton var31 = new TextButton("Upgrade", this.skin);
      TextButton var35 = new TextButton("Upgrade", this.skin);
      var30.pad(10.0F);
      var41.pad(10.0F);
      var34.pad(10.0F);
      var31.pad(10.0F);
      var35.pad(10.0F);
      int var8 = this.data.getInt("top_speed") + 1;
      float var1 = 2000.0F;

      int var7;
      for(var7 = 1; var7 < var8; ++var7) {
         var1 *= 1.775F;
      }

      if (var8 <= 20) {
         var27.setText("$" + Utils.format(var1));
      } else {
         var27.setText("No more upgrades");
         var30.setVisible(false);
      }

      int var9 = this.data.getInt("acceleration") + 1;
      float var2 = 2000.0F;

      for(var7 = 1; var7 < var9; ++var7) {
         var2 *= 1.75F;
      }

      if (var9 <= 20) {
         var29.setText("$" + Utils.format(var2));
      } else {
         var29.setText("No more upgrades");
         var41.setVisible(false);
      }

      int var10 = this.data.getInt("suspension") + 1;
      float var3 = 2000.0F;

      for(var7 = 1; var7 < var10; ++var7) {
         var3 *= 1.725F;
      }

      if (var10 <= 20) {
         var28.setText("$" + Utils.format(var3));
      } else {
         var28.setText("No more upgrades");
         var34.setVisible(false);
      }

      int var11 = this.data.getInt("lighter_body") + 1;
      float var4 = 2000.0F;

      for(var7 = 1; var7 < var11; ++var7) {
         var4 *= 1.625F;
      }

      if (var11 <= 20) {
         var33.setText("$" + Utils.format(var4));
      } else {
         var33.setText("No more upgrades");
         var31.setVisible(false);
      }

      int var12 = this.data.getInt("tires") + 1;
      float var5 = 2000.0F;

      for(var7 = 1; var7 < var12; ++var7) {
         var5 *= 1.65F;
      }

      if (var12 <= 20) {
         var37.setText("$" + Utils.format(var5));
      } else {
         var37.setText("No more upgrades");
         var35.setVisible(false);
      }

      float var6 = (float)this.loadMoney();
      var30.addListener(new ClickListener(this, var6, var1, var8) {
         final ShopScreen this$0;
         final float val$mSpeedValue;
         final float val$money;
         final int val$speedIndex;

         {
            this.this$0 = var1;
            this.val$money = var2;
            this.val$mSpeedValue = var3;
            this.val$speedIndex = var4;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (this.val$money >= this.val$mSpeedValue) {
               this.this$0.purchaseSpeed(this.val$speedIndex, this.val$mSpeedValue);
            }

         }
      });
      var41.addListener(new ClickListener(this, var6, var2, var9) {
         final ShopScreen this$0;
         final int val$accelIndex;
         final float val$mAccelValue;
         final float val$money;

         {
            this.this$0 = var1;
            this.val$money = var2;
            this.val$mAccelValue = var3;
            this.val$accelIndex = var4;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (this.val$money >= this.val$mAccelValue) {
               this.this$0.purchaseAccel(this.val$accelIndex, this.val$mAccelValue);
            }

         }
      });
      var34.addListener(new ClickListener(this, var6, var3, var10) {
         final ShopScreen this$0;
         final float val$mSusValue;
         final float val$money;
         final int val$susIndex;

         {
            this.this$0 = var1;
            this.val$money = var2;
            this.val$mSusValue = var3;
            this.val$susIndex = var4;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (this.val$money >= this.val$mSusValue) {
               this.this$0.purchaseSus(this.val$susIndex, this.val$mSusValue);
            }

         }
      });
      var31.addListener(new ClickListener(this, var6, var4, var11) {
         final ShopScreen this$0;
         final int val$lbIndex;
         final float val$mLbValue;
         final float val$money;

         {
            this.this$0 = var1;
            this.val$money = var2;
            this.val$mLbValue = var3;
            this.val$lbIndex = var4;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (this.val$money >= this.val$mLbValue) {
               this.this$0.purchaseLB(this.val$lbIndex, this.val$mLbValue);
            }

         }
      });
      var35.addListener(new ClickListener(this, var6, var5, var12) {
         final ShopScreen this$0;
         final float val$mTireValue;
         final float val$money;
         final int val$tireIndex;

         {
            this.this$0 = var1;
            this.val$money = var2;
            this.val$mTireValue = var3;
            this.val$tireIndex = var4;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (this.val$money >= this.val$mTireValue) {
               this.this$0.purchaseTires(this.val$tireIndex, this.val$mTireValue);
            }

         }
      });
      var36.setText("Speed (" + (var8 - 1) + ")");
      var40.setText("Acceleration (" + (var9 - 1) + ")");
      var26.setText("Suspension (" + (var10 - 1) + ")");
      var32.setText("Lighter Body (" + (var11 - 1) + ")");
      var38.setText("Tires (" + (var12 - 1) + ")");
      var19.add((Actor)var17).size(128.0F, 128.0F).pad(25.0F).padLeft(50.0F).padRight(50.0F).row();
      var19.add((Actor)var36).padTop(10.0F).row();
      var19.add((Actor)var27).padTop(10.0F).row();
      var19.add((Actor)var30).padTop(10.0F).padBottom(25.0F);
      var15.add((Actor)var18).size(128.0F, 128.0F).pad(25.0F).padLeft(50.0F).padRight(50.0F).row();
      var15.add((Actor)var40).padTop(10.0F).padLeft(5.0F).padRight(5.0F).row();
      var15.add((Actor)var29).padTop(10.0F).row();
      var15.add((Actor)var41).padTop(10.0F).padBottom(25.0F);
      var21.add((Actor)var14).size(128.0F, 128.0F).pad(25.0F).padLeft(50.0F).padRight(50.0F).row();
      var21.add((Actor)var26).padTop(10.0F).padLeft(5.0F).padRight(5.0F).row();
      var21.add((Actor)var28).padTop(10.0F).row();
      var21.add((Actor)var34).padTop(10.0F).padBottom(25.0F);
      var22.add((Actor)var16).size(128.0F, 64.0F).padLeft(50.0F).padRight(50.0F).padTop(57.0F).padBottom(57.0F).row();
      var22.add((Actor)var32).padTop(10.0F).padLeft(5.0F).padRight(5.0F).row();
      var22.add((Actor)var33).padTop(10.0F).row();
      var22.add((Actor)var31).padTop(10.0F).padBottom(25.0F);
      var20.add((Actor)var23).size(128.0F, 128.0F).pad(25.0F).padLeft(50.0F).padRight(50.0F).row();
      var20.add((Actor)var38).padTop(10.0F).row();
      var20.add((Actor)var37).padTop(10.0F).row();
      var20.add((Actor)var35).padTop(10.0F).padBottom(25.0F);
      var13.add((Actor)var19).pad(5.0F).padTop(72.0F).padLeft(10.0F).expandX();
      var13.add((Actor)var15).pad(5.0F).padTop(72.0F).expandX();
      var13.add((Actor)var21).pad(5.0F).padTop(72.0F).expandX();
      var13.add((Actor)var22).pad(5.0F).padTop(72.0F).expandX();
      var13.add((Actor)var20).pad(5.0F).padTop(72.0F).padRight(10.0F).expandX();
      var13.row();
      TextButton var39 = new TextButton("Back", this.skin);
      var39.pad(10.0F);
      var39.addListener(new ClickListener(this) {
         final ShopScreen this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new LevelScreen(this.this$0.main, this.this$0.assets, (byte)this.this$0.league));
         }
      });
      var13.add((Actor)var39).colspan(5).width(256.0F).expandY().padTop(90.0F);
      this.stage.addActor(var13);
   }

   public void dispose() {
      this.stage.dispose();
   }

   public void hide() {
   }

   public void pause() {
   }

   public void render(float var1) {
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
