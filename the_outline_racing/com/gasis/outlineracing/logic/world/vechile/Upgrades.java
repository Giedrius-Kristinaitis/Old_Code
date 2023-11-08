package com.gasis.outlineracing.logic.world.vechile;

public class Upgrades {
   public static final float ACCELERATION_PRICE_INDICATOR = 1.75F;
   public static final float ACCELERATION_STOCK_PRICE = 2000.0F;
   public static final float LB_PRICE_INDICATOR = 1.625F;
   public static final float LB_STOCK_PRICE = 2000.0F;
   public static final float SPEED_PRICE_INDICATOR = 1.775F;
   public static final float SPEED_STOCK_PRICE = 2000.0F;
   public static final float SUSPENSION_PRICE_INDICATOR = 1.725F;
   public static final float SUSPENSION_STOCK_PRICE = 2000.0F;
   public static final float TIRES_PRICE_INDICATOR = 1.65F;
   public static final float TIRES_STOCK_PRICE = 2000.0F;
   public final float ACC_1 = 0.5F;
   public final float ACC_10 = 1.0F;
   public final float ACC_11 = 1.1F;
   public final float ACC_12 = 1.2F;
   public final float ACC_13 = 1.3F;
   public final float ACC_14 = 1.4F;
   public final float ACC_15 = 1.5F;
   public final float ACC_16 = 1.6F;
   public final float ACC_17 = 1.7F;
   public final float ACC_18 = 1.8F;
   public final float ACC_19 = 1.9F;
   public final float ACC_2 = 0.55F;
   public final float ACC_20 = 2.0F;
   public final float ACC_3 = 0.6F;
   public final float ACC_4 = 0.65F;
   public final float ACC_5 = 0.7F;
   public final float ACC_6 = 0.75F;
   public final float ACC_7 = 0.8F;
   public final float ACC_8 = 0.85F;
   public final float ACC_9 = 0.9F;
   public final float LB_1 = 0.9F;
   public final float LB_10 = 0.63F;
   public final float LB_11 = 0.6F;
   public final float LB_12 = 0.57F;
   public final float LB_13 = 0.54F;
   public final float LB_14 = 0.51F;
   public final float LB_15 = 0.48F;
   public final float LB_16 = 0.45F;
   public final float LB_17 = 0.42F;
   public final float LB_18 = 0.39F;
   public final float LB_19 = 0.36F;
   public final float LB_2 = 0.87F;
   public final float LB_20 = 0.33F;
   public final float LB_3 = 0.84F;
   public final float LB_4 = 0.81F;
   public final float LB_5 = 0.78F;
   public final float LB_6 = 0.75F;
   public final float LB_7 = 0.72F;
   public final float LB_8 = 0.69F;
   public final float LB_9 = 0.66F;
   public final float SPEED_1 = 10.0F;
   public final float SPEED_10 = 32.5F;
   public final float SPEED_11 = 35.0F;
   public final float SPEED_12 = 37.5F;
   public final float SPEED_13 = 40.0F;
   public final float SPEED_14 = 42.5F;
   public final float SPEED_15 = 45.0F;
   public final float SPEED_16 = 47.5F;
   public final float SPEED_17 = 50.0F;
   public final float SPEED_18 = 52.5F;
   public final float SPEED_19 = 55.0F;
   public final float SPEED_2 = 12.5F;
   public final float SPEED_20 = 60.0F;
   public final float SPEED_3 = 15.0F;
   public final float SPEED_4 = 17.5F;
   public final float SPEED_5 = 20.0F;
   public final float SPEED_6 = 22.5F;
   public final float SPEED_7 = 25.0F;
   public final float SPEED_8 = 27.5F;
   public final float SPEED_9 = 30.0F;
   public final float SUS_1 = 10.0F;
   public final float SUS_10 = 6.9625F;
   public final float SUS_11 = 6.625F;
   public final float SUS_12 = 6.2875F;
   public final float SUS_13 = 5.95F;
   public final float SUS_14 = 5.6125F;
   public final float SUS_15 = 5.275F;
   public final float SUS_16 = 4.9375F;
   public final float SUS_17 = 4.6F;
   public final float SUS_18 = 4.2625F;
   public final float SUS_19 = 3.925F;
   public final float SUS_2 = 9.6625F;
   public final float SUS_20 = 3.5F;
   public final float SUS_3 = 9.325F;
   public final float SUS_4 = 8.9875F;
   public final float SUS_5 = 8.65F;
   public final float SUS_6 = 8.3125F;
   public final float SUS_7 = 7.975F;
   public final float SUS_8 = 7.6375F;
   public final float SUS_9 = 7.3F;
   public final float TIRES_1 = 0.1F;
   public final float TIRES_10 = 0.505F;
   public final float TIRES_11 = 0.55F;
   public final float TIRES_12 = 0.595F;
   public final float TIRES_13 = 0.64F;
   public final float TIRES_14 = 0.685F;
   public final float TIRES_15 = 0.73F;
   public final float TIRES_16 = 0.775F;
   public final float TIRES_17 = 0.82F;
   public final float TIRES_18 = 0.865F;
   public final float TIRES_19 = 0.9F;
   public final float TIRES_2 = 0.145F;
   public final float TIRES_20 = 1.0F;
   public final float TIRES_3 = 0.19F;
   public final float TIRES_4 = 0.235F;
   public final float TIRES_5 = 0.28F;
   public final float TIRES_6 = 0.325F;
   public final float TIRES_7 = 0.37F;
   public final float TIRES_8 = 0.415F;
   public final float TIRES_9 = 0.46F;

   public float getAcceleration(int var1) {
      float var2 = 0.5F;
      if (var1 != 1) {
         if (var1 == 2) {
            var2 = 0.55F;
         } else if (var1 == 3) {
            var2 = 0.6F;
         } else if (var1 == 4) {
            var2 = 0.65F;
         } else if (var1 == 5) {
            var2 = 0.7F;
         } else if (var1 == 6) {
            var2 = 0.75F;
         } else if (var1 == 7) {
            var2 = 0.8F;
         } else if (var1 == 8) {
            var2 = 0.85F;
         } else if (var1 == 9) {
            var2 = 0.9F;
         } else if (var1 == 10) {
            var2 = 1.0F;
         } else if (var1 == 11) {
            var2 = 1.1F;
         } else if (var1 == 12) {
            var2 = 1.2F;
         } else if (var1 == 13) {
            var2 = 1.3F;
         } else if (var1 == 14) {
            var2 = 1.4F;
         } else if (var1 == 15) {
            var2 = 1.5F;
         } else if (var1 == 16) {
            var2 = 1.6F;
         } else if (var1 == 17) {
            var2 = 1.7F;
         } else if (var1 == 18) {
            var2 = 1.8F;
         } else if (var1 == 19) {
            var2 = 1.9F;
         } else if (var1 == 20) {
            var2 = 2.0F;
         }
      }

      return var2;
   }

   public float getLB(int var1) {
      float var2 = 0.9F;
      if (var1 != 1) {
         if (var1 == 2) {
            var2 = 0.87F;
         } else if (var1 == 3) {
            var2 = 0.84F;
         } else if (var1 == 4) {
            var2 = 0.81F;
         } else if (var1 == 5) {
            var2 = 0.78F;
         } else if (var1 == 6) {
            var2 = 0.75F;
         } else if (var1 == 7) {
            var2 = 0.72F;
         } else if (var1 == 8) {
            var2 = 0.69F;
         } else if (var1 == 9) {
            var2 = 0.66F;
         } else if (var1 == 10) {
            var2 = 0.63F;
         } else if (var1 == 11) {
            var2 = 0.6F;
         } else if (var1 == 12) {
            var2 = 0.57F;
         } else if (var1 == 13) {
            var2 = 0.54F;
         } else if (var1 == 14) {
            var2 = 0.51F;
         } else if (var1 == 15) {
            var2 = 0.48F;
         } else if (var1 == 16) {
            var2 = 0.45F;
         } else if (var1 == 17) {
            var2 = 0.42F;
         } else if (var1 == 18) {
            var2 = 0.39F;
         } else if (var1 == 19) {
            var2 = 0.36F;
         } else if (var1 == 20) {
            var2 = 0.33F;
         }
      }

      return var2;
   }

   public float getSuspension(int var1) {
      float var2 = 10.0F;
      if (var1 != 1) {
         if (var1 == 2) {
            var2 = 9.6625F;
         } else if (var1 == 3) {
            var2 = 9.325F;
         } else if (var1 == 4) {
            var2 = 8.9875F;
         } else if (var1 == 5) {
            var2 = 8.65F;
         } else if (var1 == 6) {
            var2 = 8.3125F;
         } else if (var1 == 7) {
            var2 = 7.975F;
         } else if (var1 == 8) {
            var2 = 7.6375F;
         } else if (var1 == 9) {
            var2 = 7.3F;
         } else if (var1 == 10) {
            var2 = 6.9625F;
         } else if (var1 == 11) {
            var2 = 6.625F;
         } else if (var1 == 12) {
            var2 = 6.2875F;
         } else if (var1 == 13) {
            var2 = 5.95F;
         } else if (var1 == 14) {
            var2 = 5.6125F;
         } else if (var1 == 15) {
            var2 = 5.275F;
         } else if (var1 == 16) {
            var2 = 4.9375F;
         } else if (var1 == 17) {
            var2 = 4.6F;
         } else if (var1 == 18) {
            var2 = 4.2625F;
         } else if (var1 == 19) {
            var2 = 3.925F;
         } else if (var1 == 20) {
            var2 = 3.5F;
         }
      }

      return var2;
   }

   public float getTires(int var1) {
      float var2 = 0.1F;
      if (var1 != 1) {
         if (var1 == 2) {
            var2 = 0.145F;
         } else if (var1 == 3) {
            var2 = 0.19F;
         } else if (var1 == 4) {
            var2 = 0.235F;
         } else if (var1 == 5) {
            var2 = 0.28F;
         } else if (var1 == 6) {
            var2 = 0.325F;
         } else if (var1 == 7) {
            var2 = 0.37F;
         } else if (var1 == 8) {
            var2 = 0.415F;
         } else if (var1 == 9) {
            var2 = 0.46F;
         } else if (var1 == 10) {
            var2 = 0.505F;
         } else if (var1 == 11) {
            var2 = 0.55F;
         } else if (var1 == 12) {
            var2 = 0.595F;
         } else if (var1 == 13) {
            var2 = 0.64F;
         } else if (var1 == 14) {
            var2 = 0.685F;
         } else if (var1 == 15) {
            var2 = 0.73F;
         } else if (var1 == 16) {
            var2 = 0.775F;
         } else if (var1 == 17) {
            var2 = 0.82F;
         } else if (var1 == 18) {
            var2 = 0.865F;
         } else if (var1 == 19) {
            var2 = 0.9F;
         } else if (var1 == 20) {
            var2 = 1.0F;
         }
      }

      return var2;
   }

   public float getTopSpeed(int var1) {
      float var2 = 10.0F;
      if (var1 != 1) {
         if (var1 == 2) {
            var2 = 12.5F;
         } else if (var1 == 3) {
            var2 = 15.0F;
         } else if (var1 == 4) {
            var2 = 17.5F;
         } else if (var1 == 5) {
            var2 = 20.0F;
         } else if (var1 == 6) {
            var2 = 22.5F;
         } else if (var1 == 7) {
            var2 = 25.0F;
         } else if (var1 == 8) {
            var2 = 27.5F;
         } else if (var1 == 9) {
            var2 = 30.0F;
         } else if (var1 == 10) {
            var2 = 32.5F;
         } else if (var1 == 11) {
            var2 = 35.0F;
         } else if (var1 == 12) {
            var2 = 37.5F;
         } else if (var1 == 13) {
            var2 = 40.0F;
         } else if (var1 == 14) {
            var2 = 42.5F;
         } else if (var1 == 15) {
            var2 = 45.0F;
         } else if (var1 == 16) {
            var2 = 47.5F;
         } else if (var1 == 17) {
            var2 = 50.0F;
         } else if (var1 == 18) {
            var2 = 52.5F;
         } else if (var1 == 19) {
            var2 = 55.0F;
         } else if (var1 == 20) {
            var2 = 60.0F;
         }
      }

      return var2;
   }
}
