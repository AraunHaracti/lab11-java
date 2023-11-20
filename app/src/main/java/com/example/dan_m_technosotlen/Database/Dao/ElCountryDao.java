package com.example.dan_m_technosotlen.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dan_m_technosotlen.Database.Entities.El_Country;

import java.util.List;
@Dao
public interface ElCountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(El_Country el_country);
    @Update
    void update(El_Country el_country);
    @Delete
    void delete(El_Country el_country);
    @Query("SELECT * FROM El_Country")
    List<El_Country> getAllCountries();
}
