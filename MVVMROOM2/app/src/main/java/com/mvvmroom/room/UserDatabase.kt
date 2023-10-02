package com.mvvmroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[User::class] , version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDAO: UserDAO

    //SINGLETON DESIGN PATTERN
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase ?= null
        fun getInstence(context: Context): UserDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    // CREATING DATABASE
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "users_db",
                    ).build()
                }
                return instance
            }
        }

    }
}