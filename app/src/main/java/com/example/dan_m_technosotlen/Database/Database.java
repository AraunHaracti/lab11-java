package com.example.dan_m_technosotlen.Database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dan_m_technosotlen.Database.Dao.ElCountryDao;
import com.example.dan_m_technosotlen.Database.Dao.ElTypeDao;
import com.example.dan_m_technosotlen.Database.Dao.TechnoStolenDao;
import com.example.dan_m_technosotlen.Database.Entities.El_Country;
import com.example.dan_m_technosotlen.Database.Entities.El_Type;
import com.example.dan_m_technosotlen.Database.Entities.TechnoStolen;

@androidx.room.Database(entities = {El_Country.class, TechnoStolen.class, El_Type.class}, version = 2)
public abstract class Database extends RoomDatabase {
    public abstract TechnoStolenDao technoStolenDao();
    public abstract ElTypeDao elTypeDao();
    public abstract ElCountryDao elCountryDao();

    public static volatile Database INSTANCE;
    public static Database getDatabase (Context context)
    {
        if (INSTANCE == null) {
            synchronized (Database.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context,
                            Database.class,
                            "Techno_Utilize").build();
                }
            }
        }
        return INSTANCE;
    }
}
