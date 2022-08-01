package com.revature.pointsapp.dl;

import com.revature.pointsapp.models.Team;
import com.revature.pointsapp.storage.TempStorage;

public class TeamDAO implements DAO<Team> {

	@Override
	public void addInstance(Team newInstance) {
		// TODO Auto-generated method stub
		// to add a team somewhere I need a place to store it
		TempStorage.teams.add(newInstance);
	}

	@Override
	public Team getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team[] getAll() {
		// TODO Auto-generated method stub
		return TempStorage.teams.getAllElements();
	}
	

}
