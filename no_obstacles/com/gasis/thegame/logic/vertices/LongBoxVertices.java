package com.gasis.thegame.logic.vertices;

import com.gasis.thegame.Utils;

public class LongBoxVertices extends Vertices {
   public LongBoxVertices() {
      this.vertices = new float[]{Utils.P * 20.0F, Utils.P * 5.0F, -Utils.P * 20.0F, Utils.P * 5.0F, -Utils.P * 20.0F, -Utils.P * 5.0F, Utils.P * 20.0F, -Utils.P * 5.0F};
   }
}
