package com.example.dan_m_technosotlen.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "El_Type")
public class El_Type {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "et_name")
    private String et_name;

    public El_Type (String et_name) {this.et_name = et_name;}
    public long getId(){return id;}
    public void setId(long id){this.id=id;}
    public String getEt_name(){return et_name;}

    public void setEt_name(String ts_name) {this.et_name = et_name;}

}
