package com.bl.snakeandladder;
public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to the Snake and Ladder Game");
        int position = 0;
        int WinningPosition = 100;
        int DiceRollCount = 0;
        while (position < WinningPosition) {
            int dieroll = (int) ((Math.random() * 6) + 1);
            DiceRollCount++;
            int options = (int) (Math.random() * 3);
            switch (options) {
                case 1: // Case for Ladder
                    if (position + dieroll <= WinningPosition) {
                        position += dieroll;
                    }
                    System.out.println("Got a Ladder move ahead by: " + position);
                    break;
                case 2: // Case for Snake
                    position -= dieroll;
                    if (position < 0) {
                        position = 0;
                    }
                    System.out.println("Got a Snake come back by: " + position);
                    break;
                default: // Case of No Play
                    System.out.println("No Play!!!");
            }
        }
        System.out.println("Congratulations! You won the game in " + DiceRollCount + " dice rolls!");
        System.out.println("Player at Winning Position: " + position);
    }
}