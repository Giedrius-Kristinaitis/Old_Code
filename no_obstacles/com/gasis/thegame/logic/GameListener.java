package com.gasis.thegame.logic;

public interface GameListener {
   void coinCollected();

   void coinsCollected(int var1);

   void gameEnded();

   void gameStarted();

   void scoreChanged(int var1);
}
