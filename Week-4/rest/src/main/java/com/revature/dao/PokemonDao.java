package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Pokemon;
import com.revature.utils.ConnectionUtil;

public class PokemonDao implements Dao<Pokemon>{

    @Override
    public Pokemon addInstance(Pokemon instance) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Pokemon> getAllInstance() {
        //Created our String sql
        String sql = "select * from Pokemon";
        List<Pokemon> listOfPokemon = new ArrayList<>();

        try (Connection con = ConnectionUtil.getConnection()) {
            Statement stmt = con.createStatement();

            //Equivalent to executing the sql statement on dbeaver
            ResultSet rs = stmt.executeQuery(sql);

            //Going through the table row by row and selecting the columns from each row
            while (rs.next()) {

                //This saves the information from the columns into Java object
                listOfPokemon.add(new Pokemon(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("pokelevel"),
                    rs.getInt("health"),
                    rs.getInt("damage")
                ));
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return listOfPokemon;
    }

    @Override
    public Pokemon updateInstance(Pokemon instance) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pokemon deleteInstance(Pokemon instance) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
