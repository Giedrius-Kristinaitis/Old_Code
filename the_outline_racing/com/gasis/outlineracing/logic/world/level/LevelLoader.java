package com.gasis.outlineracing.logic.world.level;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.utils.Array;
import com.gasis.outlineracing.Vars;

public class LevelLoader {
   private void transformPoly(Polyline var1) {
      float var3 = var1.getX();
      float var2 = var1.getY();
      float[] var5 = new float[var1.getVertices().length];

      for(int var4 = 0; var4 < var1.getVertices().length; ++var4) {
         if (var4 % 2 == 0) {
            var5[var4] = var1.getVertices()[var4] + var3;
         } else {
            var5[var4] = var1.getVertices()[var4] + var2;
         }
      }

      var1.setVertices(var5);
   }

   public Level loadLevel(int var1) {
      TiledMap var3 = (new TmxMapLoader()).load("levels/level_" + String.valueOf(var1) + ".tmx");
      Vars.maxLevelTime = Float.parseFloat((String)var3.getProperties().get("max_time"));
      MapLayer var4 = var3.getLayers().get("point layer");
      float var2 = (Float)var3.getLayers().get("finish layer").getObjects().get("finish").getProperties().get("x", Float.class);
      Array var6 = new Array();
      MapObjects var5 = var4.getObjects();

      for(var1 = 0; var1 < var5.getCount(); ++var1) {
         Polyline var7 = ((PolylineMapObject)var5.get(var1)).getPolyline();
         this.transformPoly(var7);
         var6.add(var7);
      }

      return new Level(var6, var2);
   }
}
