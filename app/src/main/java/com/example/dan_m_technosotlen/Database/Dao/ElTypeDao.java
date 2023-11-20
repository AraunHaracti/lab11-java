package com.example.dan_m_technosotlen.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dan_m_technosotlen.Database.Entities.El_Type;

import java.util.List;

@Dao
public interface ElTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(El_Type el_type);
    @Update
    void update(El_Type el_type);
    @Delete
    void delete(El_Type el_type);
    @Query ("SELECT * FROM El_Type")
    List<El_Type> getAllTypes();
}
