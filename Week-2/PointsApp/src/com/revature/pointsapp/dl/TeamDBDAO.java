package com.revature.pointsapp.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.pointsapp.models.Team;
import com.revature.pointsapp.storage.TeamList;
import com.revature.pointsapp.util.ConnectionFactory;

public class TeamDBDAO implements DAO<Team>{

	@Override
	public void addInstance(Team newInstance) {
		// TODO Auto-generated method stub
		// 'Drop table teams'
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "Insert into teams (team_name, points) values (?,?)";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setString(1, newInstance.getTeamName());
			pstmt.setInt(2, newInstance.getTotalPoints());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public Team getByName(String name) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from teams where team_name = ?";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Team(rs.getString("team_name"), rs.getInt("points"), rs.getInt("team_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Team[] getAll() {
		// TODO Auto-generated method stub
		TeamList teams = new TeamList();
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from teams";
			Statement stmt = connie.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				teams.add(new Team(rs.getString("team_name"), rs.getInt("points"), rs.getInt("team_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams.getAllElements();
	}

	@Override
	public void updateInstance(Team updatedInstance) {
		// TODO Auto-generated method stub
		try(Connection connie = ConnectionFactory.getInstance().getConnection()){
			String query = "update teams set points = ? where team_id = ?";
			PreparedStatement pstmt = connie.prepareStatement(query);
			pstmt.setInt(1, updatedInstance.getTotalPoints());
			pstmt.setInt(2, updatedInstance.getTeamId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
