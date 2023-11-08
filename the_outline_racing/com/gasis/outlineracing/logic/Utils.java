package com.gasis.outlineracing.logic;

import java.text.DecimalFormat;

public class Utils {
   public static String format(float var0) {
      String var2 = (new DecimalFormat("#.#")).format((double)var0);
      String var1 = var2;
      if (!var2.contains(".")) {
         var1 = var2;
         if (!var2.contains(",")) {
            var1 = var2 + ".0";
         }
      }

      return var1;
   }

   public static float toMeters(float var0) {
      return var0 / 100.0F;
   }

   public static float toScreenCoords(float var0) {
      return 100.0F * var0;
   }
}
