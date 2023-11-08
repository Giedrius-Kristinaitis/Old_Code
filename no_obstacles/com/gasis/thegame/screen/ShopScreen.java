package com.gasis.thegame.screen;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.gasis.thegame.Main;

public class ShopScreen extends BaseScreen {
   private TextButton back;
   private TextButton.TextButtonStyle buttonStyle;
   private Image coin;
   private Label coins;
   private Image imageLeft;
   private Image imageRight;
   private Label.LabelStyle largeText;
   private ScrollPane scroll;
   private float scrollPos;
   private Label.LabelStyle smallText;

   public ShopScreen(Main param1, float param2) {
      // $FF: Couldn't be decompiled
   }

   static TextButton.TextButtonStyle access$000(ShopScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static Label.LabelStyle access$200(ShopScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static Label access$300(ShopScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static void access$400(ShopScreen param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   static ScrollPane access$500(ShopScreen param0) {
      // $FF: Couldn't be decompiled
   }

   private void createBottom(Table param1) {
      // $FF: Couldn't be decompiled
   }

   private void createStyles() {
      // $FF: Couldn't be decompiled
   }

   private void createTop(Table param1) {
      // $FF: Couldn't be decompiled
   }

   private void showInfoDialog(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void initialize(Stage param1) {
      // $FF: Couldn't be decompiled
   }

   private class ShopItem {
      public TextButton buy;
      private Table content;
      private String data;
      public Image icon;
      private String key;
      private Label lblPrice;
      private String name;
      private boolean owned;
      private int price;
      final ShopScreen this$0;

      public ShopItem(ShopScreen param1, String param2, String param3, String param4, int param5) {
         // $FF: Couldn't be decompiled
      }

      static boolean access$100(ShopItem param0) {
         // $FF: Couldn't be decompiled
      }

      public void buy(Main param1) {
         // $FF: Couldn't be decompiled
      }

      public void create(Table param1, Main param2, String param3) {
         // $FF: Couldn't be decompiled
      }

      public void use(Main param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
