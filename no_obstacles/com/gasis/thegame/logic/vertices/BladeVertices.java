package com.gasis.thegame.logic.vertices;

import com.gasis.thegame.Utils;

public class BladeVertices extends Vertices {
   public BladeVertices() {
      this.vertices = new float[]{Utils.P * 2.0F, Utils.P * 2.0F, 0.0F, Utils.P * 10.0F, -Utils.P * 2.0F, Utils.P * 2.0F, -Utils.P * 10.0F, 0.0F, -Utils.P * 2.0F, -Utils.P * 2.0F, 0.0F, -Utils.P * 10.0F, Utils.P * 2.0F, -Utils.P * 2.0F, Utils.P * 10.0F, 0.0F};
   }
}
