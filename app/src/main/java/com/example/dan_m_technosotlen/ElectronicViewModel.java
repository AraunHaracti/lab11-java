package com.example.dan_m_technosotlen;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dan_m_technosotlen.Database.Database;
import com.example.dan_m_technosotlen.Database.Entities.El_Country;
import com.example.dan_m_technosotlen.Database.Entities.El_Type;
import com.example.dan_m_technosotlen.Database.Entities.TechnoStolen;

import java.util.List;

public class ElectronicViewModel extends AndroidViewModel {
    public ElectronicViewModel(@NonNull Application application) {
        super(application);
        database = Database.getDatabase(application);
    }

    private Database database;
    private MutableLiveData<List<TechnoStolen>> technoStolenStatusLD = new MutableLiveData<>();

    public LiveData<List<TechnoStolen>> getListValues(){
        return technoStolenStatusLD;
    }
    public void execute(){
        Runnable allStatusesRn = ()->{
            if (database.technoStolenDao().getAllStolen() == null) return;
            List<TechnoStolen> technoStolens = database.technoStolenDao().getAllStolen();
            technoStolenStatusLD.postValue(technoStolens);
        };
        Thread thread = new Thread(allStatusesRn);
        thread.start();
    }

    public void addItem(TechnoStolen item)
    {
        Runnable sm = ()->{
            database.technoStolenDao().insert(item);
        };
        Thread thread = new Thread(sm);
        thread.start();
    }

    public void deleteItem(TechnoStolen item)
    {
        Runnable sm = ()->{
            database.technoStolenDao().delete(item);
        };
        Thread thread = new Thread(sm);
        thread.start();
    }

    public void addStatuses_Tech(TechnoStolen status){
        Runnable addStatuses = ()->{
            database.technoStolenDao().insert(status);
        };
        Thread thread = new Thread(addStatuses);
        thread.start();
    }
    public void addStatuses_Country(El_Country status){
        Runnable addStatuses = ()->{
            database.elCountryDao().insert(status);
        };
        Thread thread = new Thread(addStatuses);
        thread.start();
    }
    public void addStatuses_Type(El_Type status){
        Runnable addStatuses = ()->{
            database.elTypeDao().insert(status);
        };
        Thread thread = new Thread(addStatuses);
        thread.start();
    }
}
