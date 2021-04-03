package com.youthfireit.dora.models;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.youthfireit.dora.models.allproducts.ProductData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {ProductData.class, CategoriesData.class}, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {


    public abstract ProductDao productDao();
    public abstract CategoriesDao categoriesDao();
    public abstract CategoryWiseProductDao categoryWiseProductDao();


    private static volatile LocalDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutors = Executors.newFixedThreadPool(NUMBER_OF_THREADS);



    public static LocalDatabase getINSTANCE(Application application) {

        if (INSTANCE == null) {
            synchronized (LocalDatabase.class) {
                if (INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(application, LocalDatabase.class, "Dora.db").build();
            }
        }
        return INSTANCE;
    }




}
