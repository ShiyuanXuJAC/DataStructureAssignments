package day01teammembers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day01TeamMembers {

  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> playersByTeams = new HashMap<>();

    try (Scanner scanner = new Scanner(new File("teams.txt"))) {
      while (scanner.hasNextLine()) {
        String[] team = scanner.nextLine().split(":");
        if (team.length == 2) {
          String teamName = team[0].trim();
          String[] players = team[1].split(",");

          for (String player : players) {
            String playerName = player.trim();
            //if exist player,add team else create empty list and add team
            playersByTeams.computeIfAbsent(playerName, k -> new ArrayList<>()).add(teamName);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    for (String playerName : playersByTeams.keySet()) {
      //output
      System.out.println(playerName + " plays in: " + String.join(", ", playersByTeams.get(playerName)));
    }
  }
}
