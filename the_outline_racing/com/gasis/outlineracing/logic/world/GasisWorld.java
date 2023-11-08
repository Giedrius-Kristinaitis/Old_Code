package com.gasis.outlineracing.logic.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.logic.world.level.Level;
import com.gasis.outlineracing.logic.world.level.LevelLoader;
import com.gasis.outlineracing.logic.world.vechile.Vechile;
import com.gasis.outlineracing.storage.PrefStorage;

public class GasisWorld implements InputReceiver, Pauser {
   private final float BACKGROUND_HEIGHT = 720.0F;
   private final float BACKGROUND_WIDTH = 1706.6666F;
   private final float GRAVITY = -9.8F;
   private final int POS_ITERS = 3;
   private final int VELOCITY_ITERS = 8;
   private Assets assets;
   private Sprite back1;
   private Sprite back2;
   private OrthographicCamera backCam;
   private SpriteBatch batch;
   private OrthographicCamera cam;
   private boolean gameEnded = false;
   private boolean gameStarted = false;
   private int league;
   private Level level;
   private OnGameStateChangedListener listener;
   private boolean paused = false;
   private Vechile vechile;
   private World world;

   public GasisWorld(Assets var1, int var2, int var3, PrefStorage var4) {
      this.assets = var1;
      this.league = var3;
      this.level = (new LevelLoader()).loadLevel(var2);
      this.setup(var4);
   }

   private void initBackground() {
      Texture var1 = null;
      if (this.league == 1) {
         var1 = this.assets.getTex("background_green.png");
      } else if (this.league == 2) {
         var1 = this.assets.getTex("background_yellow.png");
      } else if (this.league == 3) {
         var1 = this.assets.getTex("background_red.png");
      } else if (this.league == 4) {
         var1 = this.assets.getTex("background_blue.png");
      }

      this.back1 = new Sprite(var1);
      this.back2 = new Sprite(var1);
      this.back2.flip(true, false);
      this.back1.setSize(1706.6666F, 720.0F);
      this.back1.setX(-1706.6666F);
      this.back2.setSize(1706.6666F, 720.0F);
   }

   private void setup(PrefStorage var1) {
      this.cam = new OrthographicCamera();
      this.cam.setToOrtho(false, 1280.0F, 720.0F);
      this.backCam = new OrthographicCamera();
      this.backCam.setToOrtho(false, 1280.0F, 720.0F);
      this.batch = new SpriteBatch();
      this.world = new World(new Vector2(0.0F, -9.8F), true);
      this.level.initialize(this.world);
      this.level.loadTexture(this.league, this.assets);
      this.vechile = new Vechile(this.world, this.assets, this.league, var1);
      this.initBackground();
   }

   public void dispose() {
      this.batch.dispose();
      this.world.dispose();
   }

   public void leftDown() {
      this.vechile.enableMotor(true);
      if (!this.gameStarted) {
         this.gameStarted = true;
         this.listener.onGameStarted();
      }

   }

   public void leftUp() {
      this.vechile.disableMotor(true);
   }

   public void onGamePaused() {
      this.paused = true;
   }

   public void onGameResumed() {
      this.paused = false;
   }

   public void render(float var1) {
      this.cam.update();
      this.backCam.update();
      this.batch.begin();
      this.batch.setProjectionMatrix(this.backCam.combined);
      this.back1.draw(this.batch);
      this.back2.draw(this.batch);
      this.batch.setProjectionMatrix(this.cam.combined);
      this.level.render(var1, this.batch, this.cam.position.x, this.cam.position.y);
      this.vechile.render(this.batch, var1);
      this.batch.end();
   }

   public void rightDown() {
      this.vechile.enableMotor(false);
      if (!this.gameStarted) {
         this.gameStarted = true;
         this.listener.onGameStarted();
      }

   }

   public void rightUp() {
      this.vechile.disableMotor(false);
   }

   public void setGameStateListener(OnGameStateChangedListener var1) {
      this.listener = var1;
   }

   public void update(float var1) {
      if (!this.paused) {
         this.world.step(var1, 8, 3);
         this.cam.position.set(this.vechile.getX(), this.vechile.getY(), 0.0F);
         var1 = this.vechile.getBody().getLinearVelocity().x / 4.0F;
         this.back1.setX(this.back1.getX() - var1);
         this.back2.setX(this.back2.getX() - var1);
         if (this.vechile.getBody().getLinearVelocity().x > 0.0F) {
            if (this.back2.getX() < 0.0F) {
               this.back1.setX(this.back2.getX() + this.back2.getWidth() - 5.0F);
            }

            if (this.back1.getX() < 0.0F) {
               this.back2.setX(this.back1.getX() + this.back1.getWidth() - 5.0F);
            }
         } else {
            if (this.back2.getX() > 1280.0F) {
               this.back2.setX(this.back1.getX() - this.back2.getWidth() + 5.0F);
            }

            if (this.back1.getX() > 1280.0F) {
               this.back1.setX(this.back2.getX() - this.back1.getWidth() + 5.0F);
            }
         }

         if (this.vechile.getBody().getPosition().x * 100.0F > this.level.getFinish() && !this.gameEnded) {
            this.gameEnded = true;
            this.listener.onGameEnded();
         }
      }

   }
}
