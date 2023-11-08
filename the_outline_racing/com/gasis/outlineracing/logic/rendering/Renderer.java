package com.gasis.outlineracing.logic.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;
import com.gasis.outlineracing.Vars;
import com.gasis.outlineracing.logic.Utils;
import com.gasis.outlineracing.logic.world.GasisWorld;
import com.gasis.outlineracing.logic.world.InputReceiver;
import com.gasis.outlineracing.logic.world.OnGameStateChangedListener;
import com.gasis.outlineracing.logic.world.Pauser;
import com.gasis.outlineracing.screens.LevelScreen;
import com.gasis.outlineracing.screens.PlayScreen;
import com.gasis.outlineracing.storage.PrefStorage;

public class Renderer implements OnGameStateChangedListener {
   private Assets assets;
   private float bestTime;
   private OrthographicCamera cam;
   private Label centerText;
   private int currentLevel;
   private float currentTime;
   private PrefStorage data;
   private ImageButton.ImageButtonStyle exitStyle;
   private int league;
   private Texture left;
   private Texture leftDown;
   private ImageButton.ImageButtonStyle leftStyle;
   private int level;
   private Main main;
   private float maxTime;
   private ImageButton menu;
   private TextButton nextLevel;
   private ImageButton pause;
   private ImageButton.ImageButtonStyle pauseStyle;
   private boolean paused = false;
   private Pauser pauser;
   private Viewport port;
   private InputReceiver receiver;
   private ImageButton restart;
   private ImageButton.ImageButtonStyle restartStyle;
   private ImageButton.ImageButtonStyle resumeStyle;
   private Texture right;
   private Texture rightDown;
   private ImageButton.ImageButtonStyle rightStyle;
   private Skin skin;
   private Stage stage;
   private Label time;
   private boolean timer = false;
   private GasisWorld world;

   public Renderer(Main var1, Assets var2, int var3, int var4, PrefStorage var5, GasisWorld var6, int var7) {
      this.main = var1;
      this.assets = var2;
      this.level = var3;
      this.league = var4;
      this.data = var5;
      this.world = var6;
      this.currentLevel = var7;
      this.receiver = var6;
      this.pauser = var6;
      var6.setGameStateListener(this);
      this.bestTime = this.data.getFloat("best_time_" + var3);
      this.initStyles();
      this.setup();
   }

   static InputReceiver access$000(Renderer var0) {
      return var0.receiver;
   }

   static Assets access$100(Renderer var0) {
      return var0.assets;
   }

   static float access$1000(Renderer var0) {
      return var0.bestTime;
   }

   static float access$1002(Renderer var0, float var1) {
      var0.bestTime = var1;
      return var1;
   }

   static int access$1100(Renderer var0) {
      return var0.currentLevel;
   }

   static TextButton access$1200(Renderer var0) {
      return var0.nextLevel;
   }

   static Stage access$1300(Renderer var0) {
      return var0.stage;
   }

   static Main access$200(Renderer var0) {
      return var0.main;
   }

   static int access$300(Renderer var0) {
      return var0.league;
   }

   static int access$308(Renderer var0) {
      int var1 = var0.league++;
      return var1;
   }

   static boolean access$400(Renderer var0) {
      return var0.paused;
   }

   static int access$500(Renderer var0) {
      return var0.level;
   }

   static int access$508(Renderer var0) {
      int var1 = var0.level++;
      return var1;
   }

   static PrefStorage access$600(Renderer var0) {
      return var0.data;
   }

   static Label access$700(Renderer var0) {
      return var0.centerText;
   }

   static float access$800(Renderer var0) {
      return var0.currentTime;
   }

   static float access$900(Renderer var0) {
      return var0.maxTime;
   }

   private void initStyles() {
      this.restartStyle = new ImageButton.ImageButtonStyle();
      this.restartStyle.up = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_restart_up.png")));
      this.restartStyle.down = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_restart_down.png")));
      this.pauseStyle = new ImageButton.ImageButtonStyle();
      this.pauseStyle.up = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_pause.png")));
      this.pauseStyle.down = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_pause.png")));
      this.resumeStyle = new ImageButton.ImageButtonStyle();
      this.resumeStyle.up = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_resume.png")));
      this.resumeStyle.down = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_resume.png")));
      this.exitStyle = new ImageButton.ImageButtonStyle();
      this.exitStyle.up = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_menu_up.png")));
      this.exitStyle.down = new TextureRegionDrawable(new TextureRegion(this.assets.getTex("ic_menu_down.png")));
   }

   private void setLevelData() {
      this.maxTime = Vars.maxLevelTime;
   }

   private void setSkin() {
      if (this.league == 1) {
         this.skin = this.assets.greenSkin;
      } else if (this.league == 2) {
         this.skin = this.assets.yellowSkin;
      } else if (this.league == 3) {
         this.skin = this.assets.redSkin;
      } else if (this.league == 4) {
         this.skin = this.assets.blueSkin;
      }

   }

   private void setTextures() {
      if (this.league == 1) {
         this.left = this.assets.getTex("arrow_green_left.png");
         this.leftDown = this.assets.getTex("arrow_green_left_down.png");
         this.right = this.assets.getTex("arrow_green_right.png");
         this.rightDown = this.assets.getTex("arrow_green_right_down.png");
      } else if (this.league == 2) {
         this.left = this.assets.getTex("arrow_yellow_left.png");
         this.leftDown = this.assets.getTex("arrow_yellow_left_down.png");
         this.right = this.assets.getTex("arrow_yellow_right.png");
         this.rightDown = this.assets.getTex("arrow_yellow_right_down.png");
      } else if (this.league == 3) {
         this.left = this.assets.getTex("arrow_red_left.png");
         this.leftDown = this.assets.getTex("arrow_red_left_down.png");
         this.right = this.assets.getTex("arrow_red_right.png");
         this.rightDown = this.assets.getTex("arrow_red_right_down.png");
      } else if (this.league == 4) {
         this.left = this.assets.getTex("arrow_blue_left.png");
         this.leftDown = this.assets.getTex("arrow_blue_left_down.png");
         this.right = this.assets.getTex("arrow_blue_right.png");
         this.rightDown = this.assets.getTex("arrow_blue_right_down.png");
      }

   }

   private void setUI() {
      this.leftStyle = new ImageButton.ImageButtonStyle();
      this.leftStyle.up = new TextureRegionDrawable(new TextureRegion(this.left));
      this.leftStyle.down = new TextureRegionDrawable(new TextureRegion(this.leftDown));
      this.rightStyle = new ImageButton.ImageButtonStyle();
      this.rightStyle.up = new TextureRegionDrawable(new TextureRegion(this.right));
      this.rightStyle.down = new TextureRegionDrawable(new TextureRegion(this.rightDown));
      ImageButton var1 = new ImageButton(this.leftStyle);
      ImageButton var2 = new ImageButton(this.rightStyle);
      var1.setBounds(32.0F, 32.0F, 182.85715F, 182.85715F);
      var1.addListener(new InputListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            this.this$0.receiver.leftDown();
            return true;
         }

         public void touchUp(InputEvent var1, float var2, float var3, int var4, int var5) {
            this.this$0.receiver.leftUp();
         }
      });
      var2.setBounds(1065.1428F, 32.0F, 182.85715F, 182.85715F);
      var2.addListener(new InputListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            this.this$0.receiver.rightDown();
            return true;
         }

         public void touchUp(InputEvent var1, float var2, float var3, int var4, int var5) {
            this.this$0.receiver.rightUp();
         }
      });
      this.stage.addActor(var1);
      this.stage.addActor(var2);
      this.time = new Label("", this.skin);
      this.time.setPosition(32.0F, 684.0F);
      this.stage.addActor(this.time);
      this.menu = new ImageButton(this.exitStyle);
      this.menu.addListener(new ClickListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setScreen(new LevelScreen(this.this$0.main, this.this$0.assets, (byte)this.this$0.league));
         }
      });
      this.menu.setBounds(1173.3334F, 621.53845F, 85.333336F, 85.333336F);
      this.pause = new ImageButton(this.pauseStyle);
      this.pause.addListener(new ClickListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (!this.this$0.paused) {
               this.this$0.pause();
            } else {
               this.this$0.resume();
            }

         }
      });
      this.pause.setBounds(1075.2001F, 626.90906F, 75.29412F, 75.29412F);
      this.stage.addActor(this.menu);
      this.stage.addActor(this.pause);
      this.stage.addListener(new InputListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public boolean keyDown(InputEvent var1, int var2) {
            boolean var3 = true;
            if (var2 == 22) {
               this.this$0.receiver.rightDown();
            } else if (var2 == 21) {
               this.this$0.receiver.leftDown();
            } else {
               var3 = false;
            }

            return var3;
         }

         public boolean keyUp(InputEvent var1, int var2) {
            boolean var3 = true;
            if (var2 == 22) {
               this.this$0.receiver.rightUp();
            } else if (var2 == 21) {
               this.this$0.receiver.leftUp();
            } else {
               var3 = false;
            }

            return var3;
         }
      });
      this.centerText = new Label("", this.skin);
      this.centerText.setX(540.0F);
      this.centerText.setY(480.0F);
      this.stage.addActor(this.centerText);
      this.restart = new ImageButton(this.restartStyle);
      this.restart.setBounds(960.0F, 621.53845F, 85.333336F, 85.333336F);
      this.restart.addListener(new ClickListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            this.this$0.main.setCurrentScreen(new PlayScreen(this.this$0.main, this.this$0.assets, this.this$0.level, this.this$0.league, this.this$0.data));
         }
      });
      this.stage.addActor(this.restart);
      this.nextLevel = new TextButton("next level", this.skin);
      this.nextLevel.setBounds(512.0F, 32.0F, 256.0F, 45.0F);
      this.nextLevel.addListener(new ClickListener(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public void clicked(InputEvent var1, float var2, float var3) {
            if (Vars.sound) {
               this.this$0.assets.playButtonClick();
            }

            if (this.this$0.level < 400) {
               if (this.this$0.level % 100 == 0) {
                  Renderer.access$308(this.this$0);
               }

               Renderer.access$508(this.this$0);
               this.this$0.main.setCurrentScreen(new PlayScreen(this.this$0.main, this.this$0.assets, this.this$0.level, this.this$0.league, this.this$0.data));
            }

         }
      });
      this.centerText.setText("Level " + this.level);
      (new Thread(new Runnable(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public void run() {
            try {
               Thread.sleep(2000L);
            } catch (InterruptedException var2) {
            }

            Gdx.app.postRunnable(new Runnable(this) {
               final <undefinedtype> this$1;

               {
                  this.this$1 = var1;
               }

               public void run() {
                  this.this$1.this$0.centerText.setText("");
               }
            });
         }
      })).start();
   }

   private void setup() {
      this.stage = new Stage();
      this.setSkin();
      this.setTextures();
      this.setLevelData();
      this.setUI();
      this.cam = new OrthographicCamera();
      this.port = new StretchViewport(1280.0F, 720.0F, this.cam);
      this.port.apply(true);
      this.stage.setViewport(this.port);
      Gdx.input.setInputProcessor(this.stage);
   }

   private void update(float var1) {
      if (!this.paused && this.timer) {
         this.currentTime += var1;
      }

   }

   public void dispose() {
      this.stage.dispose();
   }

   public void draw(float var1) {
      this.cam.update();
      this.world.render(var1);
      String var2 = Utils.format(this.currentTime) + " | " + Utils.format(this.maxTime);
      var2 = var2 + "    Best: " + Utils.format(this.bestTime);
      this.time.setText(var2);
      this.stage.act(var1);
      this.stage.draw();
      this.update(var1);
   }

   public void onGameEnded() {
      this.timer = false;
      (new Thread(new Runnable(this) {
         final Renderer this$0;

         {
            this.this$0 = var1;
         }

         public void run() {
            if (this.this$0.currentTime <= this.this$0.maxTime) {
               if (this.this$0.currentTime < this.this$0.bestTime || this.this$0.bestTime == 0.0F) {
                  this.this$0.bestTime = this.this$0.currentTime;
                  this.this$0.data.saveFloat("best_time_" + this.this$0.level, this.this$0.bestTime);
               }

               long var3 = this.this$0.data.getLong("money");
               int var1 = 1;
               if (this.this$0.league == 3) {
                  var1 = 3;
               }

               if (this.this$0.league == 4) {
                  var1 = 5;
                  if (this.this$0.level >= 350) {
                     var1 = 20;
                  }
               }

               var1 = this.this$0.level * this.this$0.league * 100 * this.this$0.league * var1;
               long var5 = (long)var1;
               this.this$0.data.saveLong("money", var3 + var5);
               if (this.this$0.level == this.this$0.currentLevel) {
                  int var2 = this.this$0.currentLevel;
                  this.this$0.data.saveInt("current_level", var2 + 1);
               }

               try {
                  Thread.sleep(1000L);
               } catch (InterruptedException var9) {
               }

               Gdx.app.postRunnable(new Runnable(this, var1) {
                  final <undefinedtype> this$1;
                  final int val$add;

                  {
                     this.this$1 = var1;
                     this.val$add = var2;
                  }

                  public void run() {
                     this.this$1.this$0.pause();
                     this.this$1.this$0.centerText.setText("Level " + this.this$1.this$0.level + " Completed!\nReward: $" + this.val$add);
                     if (this.this$1.this$0.level < 400) {
                        this.this$1.this$0.stage.addActor(this.this$1.this$0.nextLevel);
                     }

                  }
               });
            } else {
               try {
                  Thread.sleep(1000L);
               } catch (InterruptedException var8) {
               }

               Gdx.app.postRunnable(new Runnable(this) {
                  final <undefinedtype> this$1;

                  {
                     this.this$1 = var1;
                  }

                  public void run() {
                     this.this$1.this$0.pause();
                     this.this$1.this$0.centerText.setText("Level Failed, Try Again");
                  }
               });
            }

            this.this$0.main.getListener().showAd();
         }
      })).start();
   }

   public void onGameStarted() {
      this.timer = true;
   }

   public void pause() {
      this.pause.setStyle(this.resumeStyle);
      this.pauser.onGamePaused();
      this.paused = true;
      this.centerText.setText("Game Paused");
   }

   public void resize(int var1, int var2) {
      this.port.update(var1, var2);
   }

   public void resume() {
      this.pause.setStyle(this.pauseStyle);
      this.pauser.onGameResumed();
      this.paused = false;
      this.centerText.setText("");
   }
}
