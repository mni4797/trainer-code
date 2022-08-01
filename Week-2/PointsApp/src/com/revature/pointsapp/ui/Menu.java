package com.revature.pointsapp.ui;

import java.util.Scanner;

import com.revature.pointsapp.dl.DAO;
import com.revature.pointsapp.dl.TeamDAO;
import com.revature.pointsapp.models.Team;

public class Menu {
	private static DAO<Team> teamDao = new TeamDAO();
	public static void open() {
		// for getting our user input
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		do {
			System.out.println("Welcome to the points app, not at all related to the points guy");
			System.out.println("Where you can earn revapoints for your team to accomplish infinite glory for a week");
			System.out.println("[1] Create a team");
			System.out.println("[2] Add points to a team");
			System.out.println("[x] Exit");
			
			userInput = scanner.nextLine();
			switch(userInput)
			{
			case "1":
				//create team
				System.out.println("Enter team name: ");
				String teamName = scanner.nextLine();
				Team newTeam = new Team(teamName);
				System.out.println(newTeam);
				teamDao.addInstance(newTeam);
				break;
			case "2":
				//get all teams
				for(Team team: teamDao.getAll()) {
					System.out.println(team);
				}
				break;
			case "x":
				System.out.println("happy point tracking!");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
			
		} while (!userInput.equals("x")); // ! means not, .equals returns a boolean, negates boolean
	}

}
