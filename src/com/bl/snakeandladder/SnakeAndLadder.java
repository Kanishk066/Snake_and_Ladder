package com.bl.snakeandladder;
public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to the Snake and Ladder Game");
        int PlayerPosition1 = 0;
        int PlayerPosition2 = 0;
        int WinningPosition = 100;
        int DiceRollCount1 = 0;
        int DiceRollCount2 = 0;
        int CurrentPlayer = 1;
        while (PlayerPosition1 < WinningPosition && PlayerPosition2 < WinningPosition) {
            int dieroll = (int) ((Math.random() * 6) + 1);
            if (CurrentPlayer == 1) {
                DiceRollCount1++;
            } else {
                DiceRollCount2++;
            }
            int options = (int) (Math.random() * 3);
            switch (options) {
                case 1: // Case for Ladder
                    int newposition = (CurrentPlayer == 1) ? PlayerPosition1 + dieroll : PlayerPosition2 + dieroll;
                    if (CurrentPlayer == 1) {
                        PlayerPosition1 = newposition;
                        System.out.println("Player 1 got a Ladder! Moved ahead by: " + dieroll + ", new position: " + PlayerPosition1);
                    } else {
                        PlayerPosition2 = newposition;
                        System.out.println("Player 2 got a Ladder! Moved ahead by: " + dieroll + ", new position: " + PlayerPosition2);
                    }
                    if (dieroll != 6) {
                        CurrentPlayer = (CurrentPlayer == 1) ? 2 : 1;
                    } else {
                        System.out.println("Player " + CurrentPlayer + " got a Ladder but cannot move beyond the Winning Position. Current Position: " + newposition);
                    }
                    break;
                case 2: // Case for Snake
                    int oldPosition = (CurrentPlayer == 1) ? PlayerPosition1 : PlayerPosition2;
                    int newPosition = oldPosition - dieroll;
                    if (newPosition < 0) {
                        newPosition = 0;
                    }
                    if (CurrentPlayer == 1) {
                        PlayerPosition1 = newPosition;
                        System.out.println("Player 1 got a Snake! Moved back by: " + dieroll + ", new position: " + PlayerPosition1);
                    } else {
                        PlayerPosition2 = newPosition;
                        System.out.println("Player 2 got a Snake! Moved back by: " + dieroll + ", new position: " + PlayerPosition2);
                    }
                    CurrentPlayer = (CurrentPlayer == 1) ? 2 : 1;
                    break;
                default: // Case of No Play
                    if (CurrentPlayer == 1) {
                        System.out.println("Player 1 got No Play, stay at the same position: " + PlayerPosition1);
                    } else {
                        System.out.println("Player 2 got No Play, stay at the same position: " + PlayerPosition2);
                    }
                    CurrentPlayer = (CurrentPlayer == 1) ? 2 : 1;
                    break;
            }
        }
        if (PlayerPosition1 >= WinningPosition && PlayerPosition2 >= WinningPosition) {
            System.out.println("Game is a tie!");
        } else if (PlayerPosition1 >= WinningPosition) {
            System.out.println("Congratulations! Player 1 won the game in " + DiceRollCount1 + " dice rolls!");
        } else {
            System.out.println("Congratulations! Player 2 won the game in " + DiceRollCount2 + " dice rolls!");
        }
    }
}