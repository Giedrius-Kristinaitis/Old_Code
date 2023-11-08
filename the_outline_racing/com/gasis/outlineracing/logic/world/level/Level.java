package com.gasis.outlineracing.logic.world.level;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gasis.outlineracing.Assets;
import java.util.Iterator;

public class Level {
   private final float LINE_HEIGHT = 12.5F;
   private Sprite finish;
   private float finishX;
   private Array polys = new Array();
   private Sprite sprite;

   public Level(Array var1, float var2) {
      this.polys = var1;
      this.finishX = var2;
   }

   private float[] convertVertices(float[] var1) {
      float[] var5 = new float[var1.length];
      int var4 = var1.length;
      int var2 = 0;

      for(int var3 = 0; var2 < var4; ++var3) {
         var5[var3] = var1[var2] / 100.0F;
         ++var2;
      }

      return var5;
   }

   private void createBody(World var1, float[] var2, float var3, float var4) {
      BodyDef var5 = new BodyDef();
      FixtureDef var7 = new FixtureDef();
      ChainShape var6 = new ChainShape();
      var5.position.set(0.0F, 0.0F);
      var5.type = BodyDef.BodyType.StaticBody;
      var6.createChain(this.convertVertices(var2));
      var7.shape = var6;
      var7.friction = 0.8F;
      var1.createBody(var5).createFixture(var7);
   }

   private Array extractPoints(float[] var1) {
      Array var8 = new Array();
      Vector2 var6 = new Vector2();
      int var5 = 0;

      Vector2 var7;
      for(int var4 = 0; var4 < var1.length; var6 = var7) {
         float var2 = var1[var4];
         int var3;
         if (var5 == 0) {
            var6.x = var2;
            var3 = var5 + 1;
            var7 = var6;
         } else {
            var3 = var5;
            var7 = var6;
            if (var5 == 1) {
               var6.y = var2;
               var3 = 0;
               var8.add(var6);
               var7 = new Vector2();
            }
         }

         ++var4;
         var5 = var3;
      }

      return var8;
   }

   public float getFinish() {
      return this.finishX;
   }

   public void initialize(World var1) {
      Iterator var3 = this.polys.iterator();

      while(var3.hasNext()) {
         Polyline var2 = (Polyline)var3.next();
         this.createBody(var1, var2.getVertices(), var2.getX(), var2.getY());
      }

   }

   public void loadTexture(int var1, Assets var2) {
      Texture var3 = null;
      if (var1 == 1) {
         var3 = var2.getTex("line_green.png");
      } else if (var1 == 2) {
         var3 = var2.getTex("line_yellow.png");
      } else if (var1 == 3) {
         var3 = var2.getTex("line_red.png");
      } else if (var1 == 4) {
         var3 = var2.getTex("line_blue.png");
      }

      this.sprite = new Sprite(var3);
      this.finish = new Sprite(var2.getTex("finish_line.png"));
      this.finish.setSize(50.0F, 2160.0F);
      this.finish.setCenter(this.finishX, 360.0F);
   }

   public void render(float var1, SpriteBatch var2, float var3, float var4) {
      this.finish.draw(var2);
      Iterator var18 = this.polys.iterator();

      while(var18.hasNext()) {
         Array var16 = this.extractPoints(((Polyline)var18.next()).getVertices());

         for(int var9 = 0; var9 < var16.size - 1; ++var9) {
            Vector2 var19 = (Vector2)var16.get(var9);
            Vector2 var17 = (Vector2)var16.get(var9 + 1);
            float var7 = var3 - 640.0F;
            float var5 = var3 + 640.0F;
            var1 = var4 - 360.0F;
            float var6 = var4 + 360.0F;
            boolean var10;
            if (var19.x >= var7 - 128.0F && var19.x <= 128.0F + var5) {
               var10 = true;
            } else {
               var10 = false;
            }

            boolean var11;
            if (var17.x >= var7 - 128.0F && var17.x <= 128.0F + var5) {
               var11 = true;
            } else {
               var11 = false;
            }

            boolean var12;
            if (var19.y >= var1 - 72.0F && var19.y <= 72.0F + var6) {
               var12 = true;
            } else {
               var12 = false;
            }

            boolean var13;
            if (var17.y >= var1 - 72.0F && var17.y <= 72.0F + var6) {
               var13 = true;
            } else {
               var13 = false;
            }

            boolean var14;
            if (var19.x < var17.x) {
               var14 = true;
            } else {
               var14 = false;
            }

            boolean var15;
            if (var19.y > var17.y) {
               var15 = true;
            } else {
               var15 = false;
            }

            if (var14) {
               var1 = var17.x - var19.x;
            } else {
               var1 = var19.x - var17.x;
            }

            if (var15) {
               var5 = var19.y - var17.y;
            } else {
               var5 = var17.y - var19.y;
            }

            float var8 = (float)Math.sqrt((double)(var1 * var1 + var5 * var5));
            if ((var10 || var11 || var8 >= 720.0F) && (var12 || var13 || var8 >= 720.0F)) {
               var7 = (var19.x + var17.x) / 2.0F;
               var6 = (var19.y + var17.y) / 2.0F;
               var1 = (float)Math.atan((double)(var5 / 2.0F / (var1 / 2.0F))) * 57.295776F;
               this.sprite.setSize(var8, 12.5F);
               this.sprite.setCenter(var7, var6);
               this.sprite.setOriginCenter();
               if (var14) {
                  if (var15) {
                     var1 = -var1;
                  }
               } else if (!var15) {
                  var1 = -var1;
               }

               this.sprite.setRotation(var1);
               this.sprite.draw(var2);
            }
         }
      }

   }
}
