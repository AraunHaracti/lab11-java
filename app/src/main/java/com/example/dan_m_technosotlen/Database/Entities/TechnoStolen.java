package com.example.dan_m_technosotlen.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "techno_stolen")
public class TechnoStolen {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "ts_name")
    private String ts_name;
    @ColumnInfo(name = "ts_type")
    private int ts_type;
    @ColumnInfo(name = "ts_country")
    private int ts_country;


    public TechnoStolen (String ts_name) {this.ts_name = ts_name;}

    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public String getTs_name(){return ts_name;}
    public void setTs_name(String ts_name) {this.ts_name = ts_name;}


    public int getTs_type() {
        return ts_type;
    }

    public void setTs_type(int ts_type) {
        this.ts_type = ts_type;
    }

    public int getTs_country() {
        return ts_country;
    }

    public void setTs_country(int ts_country) {
        this.ts_country = ts_country;
    }
}
