package com.gasis.outlineracing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.outlineracing.Assets;
import com.gasis.outlineracing.Main;

public class LoadingScreen implements Screen {
   private Assets assets;
   private Sprite back;
   private SpriteBatch batch;
   private OrthographicCamera cam;
   private BitmapFont font;
   private Sprite logo;
   private Main main;
   private ShapeRenderer renderer;
   private Viewport viewport;

   public LoadingScreen(Main var1) {
      this.main = var1;
      this.assets = new Assets();
      this.font = new BitmapFont(Gdx.files.internal("arial32.fnt"));
      this.batch = new SpriteBatch();
      this.renderer = new ShapeRenderer();
      this.renderer.setAutoShapeType(true);
      this.cam = new OrthographicCamera();
      this.viewport = new StretchViewport(1280.0F, 720.0F, this.cam);
      this.viewport.apply(true);
      this.assets.load();
      this.logo = new Sprite(new Texture("logo.png"));
      this.logo.setBounds(192.0F, 400.0F, 896.0F, 144.0F);
      this.back = new Sprite(new Texture("background_menu.png"));
      this.back.setBounds(0.0F, 0.0F, 1280.0F, 720.0F);
   }

   private void draw() {
      this.batch.begin();
      this.back.draw(this.batch);
      this.logo.draw(this.batch);
      this.font.draw(this.batch, (CharSequence)"Loading...", 128.0F, 72.0F);
      this.batch.end();
      this.renderer.begin();
      this.renderer.set(ShapeRenderer.ShapeType.Filled);
      this.renderer.setColor(Color.WHITE);
      this.renderer.rect(128.0F, 104.0F, 1024.0F, 32.0F);
      this.renderer.setColor(Color.BLUE);
      this.renderer.rect(128.0F, 104.0F, this.assets.getManager().getProgress() * 1024.0F, 32.0F);
      this.renderer.end();
   }

   private boolean update() {
      this.cam.update();
      this.renderer.setProjectionMatrix(this.cam.combined);
      this.batch.setProjectionMatrix(this.cam.combined);
      boolean var1;
      if (this.assets.getManager().update()) {
         this.main.setAssets(this.assets);
         this.main.setCurrentScreen(new MainMenuScreen(this.main));
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void dispose() {
      this.font.dispose();
      this.logo.getTexture().dispose();
      this.back.getTexture().dispose();
      this.renderer.dispose();
      this.batch.dispose();
   }

   public void hide() {
   }

   public void pause() {
   }

   public void render(float var1) {
      Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      Gdx.gl.glClear(16384);
      if (!this.update()) {
         this.draw();
      }

   }

   public void resize(int var1, int var2) {
      this.viewport.update(var1, var2);
   }

   public void resume() {
   }

   public void show() {
   }
}
