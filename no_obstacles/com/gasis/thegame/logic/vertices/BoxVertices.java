package com.gasis.thegame.logic.vertices;

import com.gasis.thegame.Utils;

public class BoxVertices extends Vertices {
   public BoxVertices() {
      this.vertices = new float[]{Utils.P * 5.0F, Utils.P * 5.0F, -Utils.P * 5.0F, Utils.P * 5.0F, -Utils.P * 5.0F, -Utils.P * 5.0F, Utils.P * 5.0F, -Utils.P * 5.0F};
   }
}
