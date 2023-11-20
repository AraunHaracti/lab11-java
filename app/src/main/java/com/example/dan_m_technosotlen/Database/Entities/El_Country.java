package com.example.dan_m_technosotlen.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "El_Country")
public class El_Country {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "ec_name")
    private String ec_name;

    public El_Country (String ec_name) {this.ec_name = ec_name;}
    public long getId(){return id;}
    public void setId(long id){this.id=id;}
    public String getEc_name(){return ec_name;}

    public void setEc_name(String ec_name) {this.ec_name = ec_name;}
}
