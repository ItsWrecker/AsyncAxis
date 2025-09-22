package com.asyncaxis.app

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ConcatenatingMediaSource2
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.exoplayer.source.MediaSource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class PlayerViewModel @Inject constructor(
    val player: ExoPlayer,
    @param:ApplicationContext private val context: Context
) : ViewModel() {

    private val videoUrls = listOf(
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",

    )

    init {
        initializePlayer()
    }

    private fun initializePlayer() {
        val mediaSource = buildMediaSource()
        player.setMediaSource(mediaSource)
        player.playWhenReady = true
        player.preloadConfiguration = ExoPlayer.PreloadConfiguration(5000)
        player.prepare()
    }

    private fun buildMediaSource(): MediaSource {
        val mediaSourceFactory = DefaultMediaSourceFactory(context)
        val concatenatingMediaSource = ConcatenatingMediaSource2.Builder()
        concatenatingMediaSource.setMediaSourceFactory(mediaSourceFactory)
        videoUrls.forEach {
            val mediaItem = MediaItem.Builder()
                .setUri(it)
                .setClippingConfiguration(
                    MediaItem.ClippingConfiguration.Builder()
                        .setStartsAtKeyFrame(true)
                        .setStartPositionMs(1000)
                        .setEndPositionMs(11000)
                    .build()
                ).build()
            concatenatingMediaSource.add(mediaItem,0)
        }
        return concatenatingMediaSource.build()

    }
    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}

