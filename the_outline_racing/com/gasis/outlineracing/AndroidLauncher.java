package com.gasis.outlineracing;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AndroidLauncher extends AndroidApplication implements ShowAdListener {
   private InterstitialAd ad;
   private Main main;

   static void access$000(AndroidLauncher var0) {
      var0.requestNewAd();
   }

   static Main access$100(AndroidLauncher var0) {
      return var0.main;
   }

   static InterstitialAd access$200(AndroidLauncher var0) {
      return var0.ad;
   }

   private void requestNewAd() {
      AdRequest var1 = (new AdRequest.Builder()).build();
      this.ad.loadAd(var1);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      AndroidApplicationConfiguration var2 = new AndroidApplicationConfiguration();
      var2.useAccelerometer = false;
      var2.useCompass = false;
      this.main = new Main(this);
      this.ad = new InterstitialAd(this);
      this.ad.setAdUnitId(this.getResources().getString(2130903077));
      this.ad.setAdListener(new AdListener(this) {
         final AndroidLauncher this$0;

         {
            this.this$0 = var1;
         }

         public void onAdClosed() {
            this.this$0.requestNewAd();
            this.this$0.main.adClosed();
         }
      });
      this.requestNewAd();
      this.initialize(this.main, var2);
   }

   public void showAd() {
      this.runOnUiThread(new Runnable(this) {
         final AndroidLauncher this$0;

         {
            this.this$0 = var1;
         }

         public void run() {
            if (this.this$0.ad.isLoaded()) {
               this.this$0.ad.show();
            } else {
               this.this$0.requestNewAd();
            }

         }
      });
   }
}
