package com.example.dan_m_technosotlen.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dan_m_technosotlen.Database.Entities.El_Country;
import com.example.dan_m_technosotlen.Database.Entities.El_Type;
import com.example.dan_m_technosotlen.Database.Entities.TechnoStolen;

import java.util.List;

@Dao
public interface TechnoStolenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TechnoStolen technoStolen);
    @Update
    void update(TechnoStolen technoStolen);
    @Delete
    void delete(TechnoStolen technoStolen);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(El_Type el_type);
    @Update
    void update(El_Type el_type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(El_Country el_country);
    @Update
    void update(El_Country el_country);

    @Query("SELECT * FROM techno_stolen")
    List<TechnoStolen> getAllStolen();

}
