package com.gasis.thegame.logic;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;
import com.gasis.thegame.logic.things.Thing;
import com.gasis.thegame.logic.things.ThingUtils;
import java.util.Iterator;

public class MainGame implements ContactListener {
   private final int POSITION_ITERATIONS = 3;
   private final int VELOCITY_ITERATIONS = 6;
   private boolean aChecked = false;
   private boolean bChecked = false;
   private Background background;
   private Array bodiesToChange = new Array();
   private OrthographicCamera boxcam;
   private int coins;
   private DeathAnimation deathAnimation;
   private boolean debug = false;
   private boolean gameOver = false;
   private boolean gameStarted = false;
   private RayHandler handler;
   private Level level;
   private PointLight light;
   private GameListener listener;
   private Main main;
   private boolean nightMode = false;
   private boolean paused = false;
   private Thing player;
   private Texture playerTexture;
   private Box2DDebugRenderer renderer;
   private int score;
   private float time;
   private World world;

   public MainGame(Main var1, GameListener var2, boolean var3) {
      this.main = var1;
      this.listener = var2;
      this.nightMode = var3;
      this.createWorld();
      this.createDebugStuff();
      this.createPlayer();
      this.createLevel();
      this.createBackground();
      this.createLight();
   }

   static Thing access$000(MainGame var0) {
      return var0.player;
   }

   static void access$100(MainGame var0) {
      var0.gameOver();
   }

   private void checkPlayerPosition() {
      float var1 = this.player.body.getPosition().y * Utils.PPM;
      if ((var1 >= Utils.HEIGHT + Utils.P * 10.0F || var1 <= -Utils.P * 10.0F) && this.deathAnimation == null && !this.gameOver) {
         this.deathAnimation = new DeathAnimation(this);
         this.main.resources.playDeathSound();
      }

   }

   private void createBackground() {
      this.background = new Background(this.main, this.nightMode);
   }

   private void createDebugStuff() {
      this.boxcam = new OrthographicCamera();
      this.boxcam.setToOrtho(false, Utils.WIDTH / Utils.PPM, Utils.HEIGHT / Utils.PPM);
      if (this.debug) {
         this.renderer = new Box2DDebugRenderer();
      }

   }

   private void createLevel() {
      this.level = new Level(this.main, this.world);
   }

   private void createLight() {
      if (this.nightMode) {
         this.handler = new RayHandler(this.world);
         this.handler.setAmbientLight(0.0F);
         this.light = new PointLight(this.handler, 200, Color.WHITE, Utils.P * 100.0F / Utils.PPM, 0.0F, 0.0F);
         this.light.attachToBody(this.player.body);
         this.light.setIgnoreAttachedBody(true);
      }

   }

   private void createPlayer() {
      String var1 = this.main.data.getString("ball_texture");
      this.playerTexture = new Texture(Gdx.files.internal(var1));
      this.player = ThingUtils.createCircle(this.playerTexture, BodyDef.BodyType.DynamicBody, Utils.P * 25.0F, Utils.HEIGHT / 2.0F, Utils.P * 2.0F, 1.0F, "player", (Thing.Updater)null, this.world, false);
      this.player.body.setAngularVelocity(1.0F);
   }

   private void createWorld() {
      this.world = new World(new Vector2(0.0F, -15.0F), true);
      this.world.setContactListener(this);
   }

   private void gameOver() {
      if (!this.gameOver) {
         this.gameOver = true;
         this.deathAnimation = null;
         this.level.stopMoving();
         this.listener.gameEnded();
         if (this.light != null) {
            this.light.attachToBody((Body)null);
         }
      }

   }

   public void addCoins(int var1) {
      this.coins += var1;
      this.listener.coinsCollected(var1);
   }

   public void beginContact(Contact var1) {
      Fixture var2 = var1.getFixtureA();
      Fixture var3 = var1.getFixtureB();
      if (var2.getUserData() != null && var2.getUserData().equals("player")) {
         if (var3.getUserData() != null && var3.getUserData().equals("coin")) {
            this.listener.coinCollected();
            ++this.coins;
            this.bodiesToChange.add(var3.getBody());
         } else {
            if (this.deathAnimation == null && !this.gameOver) {
               this.deathAnimation = new DeathAnimation(this);
               this.main.resources.playDeathSound();
            }

            this.level.stopMoving();
         }
      } else if (var3.getUserData() != null && var3.getUserData().equals("player")) {
         if (var2.getUserData() != null && var2.getUserData().equals("coin")) {
            this.listener.coinCollected();
            ++this.coins;
            this.bodiesToChange.add(var2.getBody());
         } else {
            if (this.deathAnimation == null && !this.gameOver) {
               this.deathAnimation = new DeathAnimation(this);
               this.main.resources.playDeathSound();
            }

            this.level.stopMoving();
         }
      }

   }

   public void dispose() {
      this.world.dispose();
      this.playerTexture.dispose();
      this.background.dispose();
      if (this.debug) {
         this.renderer.dispose();
      }

      if (this.nightMode) {
         this.handler.dispose();
      }

   }

   public void draw(SpriteBatch var1, float var2) {
      this.background.render(var1);
      this.level.draw(var1);
      if (this.nightMode) {
         var1.end();
         this.handler.setCombinedMatrix(this.boxcam);
         this.handler.render();
         var1.begin();
      }

      this.player.draw(var1);
      if (this.debug) {
         this.renderer.render(this.world, this.boxcam.combined);
      }

   }

   public void endContact(Contact var1) {
   }

   public int getCoinsCollected() {
      return this.coins;
   }

   public Texture getPlayerTexture() {
      return this.playerTexture;
   }

   public int getScore() {
      return this.score;
   }

   public float getTime() {
      return this.time;
   }

   public void pause() {
      this.paused = true;
   }

   public void postSolve(Contact var1, ContactImpulse var2) {
   }

   public void preSolve(Contact var1, Manifold var2) {
   }

   public void resume() {
      this.paused = false;
   }

   public void touched() {
      this.player.body.setLinearVelocity(0.0F, 0.0F);
      this.player.body.applyLinearImpulse(0.0F, 0.4F, this.player.body.getPosition().x, this.player.body.getPosition().y, true);
      if (!this.gameStarted) {
         this.listener.gameStarted();
         this.gameStarted = true;
      }

      if (!this.gameOver && this.deathAnimation == null) {
         this.level.startMoving();
      }

   }

   public void update(float var1) {
      if (this.nightMode) {
         this.handler.update();
      }

      if (!this.paused && this.gameStarted) {
         this.level.update(var1);
         this.checkPlayerPosition();
         if (this.level.isMoving()) {
            this.background.update(this.level.speed);
         }

         if (this.deathAnimation != null) {
            this.deathAnimation.update();
         }

         if (!this.gameOver && !this.aChecked && this.player.body.getPosition().x * Utils.PPM > this.level.a.position + this.level.a.width + this.level.gap / 2.0F) {
            ++this.score;
            this.listener.scoreChanged(this.score);
            this.aChecked = true;
            this.bChecked = false;
         } else if (!this.gameOver && !this.bChecked && this.player.body.getPosition().x * Utils.PPM > this.level.b.position + this.level.b.width + this.level.gap / 2.0F) {
            ++this.score;
            this.listener.scoreChanged(this.score);
            this.bChecked = true;
            this.aChecked = false;
         }

         if (!this.gameOver) {
            this.time += var1;
         }

         Iterator var3 = this.bodiesToChange.iterator();

         while(var3.hasNext()) {
            Body var2 = (Body)var3.next();
            var2.setTransform(var2.getPosition().x, 20.0F, 0.0F);
         }

         this.bodiesToChange.clear();
         this.world.step(var1, 6, 3);
      }

   }

   private class DeathAnimation {
      private float alpha;
      private boolean changeVelocity;
      private float scale;
      final MainGame this$0;

      public DeathAnimation(MainGame var1) {
         this.this$0 = var1;
         this.scale = 1.0F;
         this.alpha = 1.0F;
         this.changeVelocity = false;
         this.changeVelocity = true;
      }

      public void update() {
         if (this.changeVelocity) {
            this.this$0.player.body.setLinearVelocity(0.0F, 0.0F);
         }

         if (this.alpha <= 0.0F) {
            this.this$0.gameOver();
         }

         this.this$0.player.sprite.setScale(this.scale);
         this.this$0.player.sprite.setAlpha(this.alpha);
         this.alpha -= 0.05F;
         this.scale += 0.05F;
         if (this.alpha < 0.0F) {
            this.alpha = 0.0F;
         }

      }
   }
}
