package com.asyncaxis.app

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(ViewModelComponent::class)
object PlayerModule {

    @Provides
    fun provideAppContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideExoPlayer(context: Context): ExoPlayer {
        return ExoPlayer.Builder(context).build()
    }
}
