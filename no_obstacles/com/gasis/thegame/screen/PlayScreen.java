package com.gasis.thegame.screen;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.gasis.thegame.Main;
import com.gasis.thegame.logic.GameListener;
import com.gasis.thegame.logic.MainGame;

public class PlayScreen extends BaseScreen implements GameListener {
   private TextButton.TextButtonStyle buttonStyle;
   private boolean canAddCoins;
   private Image coin;
   private int coins;
   private Image cup;
   private MainGame game;
   private boolean gameOver;
   private int highScore;
   private Label lblCoins;
   private Main main;
   private boolean nightMode;
   private int oldHighScore;
   private Button pause;
   private boolean pauseDialogVisible;
   private Button.ButtonStyle pauseStyle;
   private Label score;
   private String scoreKey;
   private boolean showAd;
   private Label.LabelStyle smallText;
   private Label.LabelStyle textStyle;
   private Window.WindowStyle windowStyle;

   public PlayScreen(Main param1) {
      // $FF: Couldn't be decompiled
   }

   public PlayScreen(Main param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public PlayScreen(Main param1, boolean param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   static MainGame access$100(PlayScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static boolean access$200(PlayScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static Main access$300(PlayScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static void access$400(PlayScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static boolean access$500(PlayScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static boolean access$600(PlayScreen param0) {
      // $FF: Couldn't be decompiled
   }

   static boolean access$702(PlayScreen param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   private void changeScoreText(int param1) {
      // $FF: Couldn't be decompiled
   }

   private void createGame() {
      // $FF: Couldn't be decompiled
   }

   private void createStyles() {
      // $FF: Couldn't be decompiled
   }

   private void createUserInterface(Stage param1) {
      // $FF: Couldn't be decompiled
   }

   private void initialize() {
      // $FF: Couldn't be decompiled
   }

   private void loadHighScoreAndCoins() {
      // $FF: Couldn't be decompiled
   }

   private void showGameOverDialog() {
      // $FF: Couldn't be decompiled
   }

   private void showPauseDialog() {
      // $FF: Couldn't be decompiled
   }

   public boolean backPressed() {
      // $FF: Couldn't be decompiled
   }

   public void coinCollected() {
      // $FF: Couldn't be decompiled
   }

   public void coinsCollected(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void dispose() {
      // $FF: Couldn't be decompiled
   }

   public void drawMainGame(SpriteBatch param1, float param2) {
      // $FF: Couldn't be decompiled
   }

   public void gameEnded() {
      // $FF: Couldn't be decompiled
   }

   public void gameStarted() {
      // $FF: Couldn't be decompiled
   }

   public void initialize(Stage param1) {
      // $FF: Couldn't be decompiled
   }

   public void pause() {
      // $FF: Couldn't be decompiled
   }

   public void scoreChanged(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void update(float param1) {
      // $FF: Couldn't be decompiled
   }

   private class MyInput extends InputAdapter {
      final PlayScreen this$0;

      private MyInput(PlayScreen param1) {
         // $FF: Couldn't be decompiled
      }

      MyInput(PlayScreen param1, Object param2) {
         // $FF: Couldn't be decompiled
      }

      public boolean keyDown(int param1) {
         // $FF: Couldn't be decompiled
      }

      public boolean touchDown(int param1, int param2, int param3, int param4) {
         // $FF: Couldn't be decompiled
      }
   }
}
