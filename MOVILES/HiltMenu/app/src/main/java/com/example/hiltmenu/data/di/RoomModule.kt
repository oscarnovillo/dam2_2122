package com.example.hiltmenu.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.roomviewmodel.data.PersonaRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context)
                = Room.databaseBuilder(context, PersonaRoomDatabase::class.java, "persona_database")
            .fallbackToDestructiveMigrationFrom(4)
            .createFromAsset("database/personas.db")
            .build()

        @Provides
        fun providesPersonaDao(articlesDatabase: PersonaRoomDatabase) =
            articlesDatabase.personaDao()



    }

