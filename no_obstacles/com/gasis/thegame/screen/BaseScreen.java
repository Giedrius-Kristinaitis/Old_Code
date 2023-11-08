package com.gasis.thegame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.thegame.Main;
import com.gasis.thegame.Utils;

public abstract class BaseScreen extends ScreenAdapter {
   private final float POPUP_HEIGHT;
   private final float POPUP_WIDTH;
   private SpriteBatch batch;
   public Main main;
   private OrthographicCamera mainCam;
   private Viewport mainPort;
   protected Stage stage;
   private boolean stylesCreated;
   private Label.LabelStyle text;
   private OrthographicCamera uiCam;
   private Viewport uiPort;

   public BaseScreen(Main var1) {
      this.POPUP_WIDTH = Utils.P * 50.0F;
      this.POPUP_HEIGHT = Utils.P * 10.0F;
      this.stylesCreated = false;
      this.main = var1;
      this.createUserInterfaceStuff();
      this.createGameLogicStuff();
   }

   private void createGameLogicStuff() {
      this.mainCam = new OrthographicCamera();
      this.mainPort = new StretchViewport(Utils.WIDTH, Utils.HEIGHT, this.mainCam);
      this.batch = new SpriteBatch();
   }

   private void createStyles() {
      this.text = new Label.LabelStyle();
      this.text.font = this.main.resources.fontVerySmall;
      this.stylesCreated = true;
   }

   private void createUserInterfaceStuff() {
      this.uiCam = new OrthographicCamera();
      this.uiPort = new ScreenViewport(this.uiCam);
      this.stage = new Stage(this.uiPort);
      Gdx.input.setInputProcessor(this.stage);
   }

   public void createPopup(Texture var1, Texture var2, String var3, String var4) {
      if (!this.stylesCreated) {
         this.createStyles();
      }

      Table var5 = new Table();
      var5.background((Drawable)Utils.drawable(var1));
      var5.align(8);
      Image var6 = new Image(Utils.drawable(var2));
      Label var7 = new Label(var3, this.text);
      Label var8 = new Label(var4, this.text);
      Table var9 = new Table();
      var9.add((Actor)var7).left().pad(Utils.P * 1.0F).padBottom(0.0F).row();
      var9.add((Actor)var8).left().pad(Utils.P * 1.0F).padTop(0.0F);
      var5.add((Actor)var6).size(Utils.P * 8.0F).center().pad(Utils.P * 1.0F);
      var5.add((Actor)var9).left();
      var5.setBounds((float)Gdx.graphics.getWidth() / 2.0F - this.POPUP_WIDTH / 2.0F, (float)Gdx.graphics.getHeight() - this.POPUP_HEIGHT - Utils.P * 5.0F, this.POPUP_WIDTH, this.POPUP_HEIGHT);
      this.stage.addActor(var5);
      Utils.createSlideInAnimation(var5, 0.5F, (byte)0, Interpolation.pow2In, new Runnable(this, var5) {
         final BaseScreen this$0;
         final Table val$table;

         {
            this.this$0 = var1;
            this.val$table = var2;
         }

         public void run() {
            (new Thread(new Runnable(this) {
               final <undefinedtype> this$1;

               {
                  this.this$1 = var1;
               }

               public void run() {
                  try {
                     Thread.sleep(2500L);
                  } catch (InterruptedException var4) {
                     var4.printStackTrace();
                  } finally {
                     Gdx.app.postRunnable(new Runnable(this) {
                        final <undefinedtype> this$2;

                        {
                           this.this$2 = var1;
                        }

                        public void run() {
                           Utils.createSlideOutAnimation(this.this$2.this$1.val$table, 0.5F, (byte)0, Interpolation.pow2, new Runnable(this) {
                              final <undefinedtype> this$3;

                              {
                                 this.this$3 = var1;
                              }

                              public void run() {
                                 this.this$3.this$2.this$1.val$table.addAction(Actions.removeActor());
                              }
                           });
                        }
                     });
                  }

               }
            })).start();
         }
      });
   }

   public void dispose() {
      this.batch.dispose();
      this.stage.dispose();
   }

   protected void drawMainGame(SpriteBatch var1, float var2) {
   }

   protected void initialize(Stage var1) {
   }

   public void render(float var1) {
      Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      Gdx.gl.glClear(16384);
      this.update(var1);
      this.stage.act(var1);
      this.mainPort.apply(true);
      this.batch.setProjectionMatrix(this.mainCam.combined);
      this.batch.begin();
      this.drawMainGame(this.batch, var1);
      this.batch.end();
      this.uiPort.apply(true);
      this.stage.draw();
   }

   public void resize(int var1, int var2) {
      this.uiPort.update(var1, var2, true);
      this.mainPort.update(var1, var2, true);
   }

   public void setInputProcessor(InputProcessor var1) {
      InputMultiplexer var2 = new InputMultiplexer();
      var2.addProcessor(this.stage);
      var2.addProcessor(var1);
      Gdx.input.setInputProcessor(var2);
   }

   public final void show() {
      this.initialize(this.stage);
   }

   protected void update(float var1) {
   }
}
