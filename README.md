**Android Challenge Task: A thought exercise**

Objective:

Implement an Android video player that plays multiple video URLs as if they are a single continuous video, by playing short segments from each video sequentially.

Requirements:

Video Sources:

Use 5 different video URLs (e.g., 30 seconds each).
Videos can be hosted online or locally in the app.


**Segmented Playback:**

For each video, play a random 10 second segment.
After finishing the segment, move to the next video and play another 10 second segment.
Continue cycling through all videos until each video’s 10 second segments until all videos are done
Collective length of the final video being played will be 50 seconds (10s each from 5 videos)


**Seamless Experience:**

The user should perceive the playback as a single continuous video, not five separate videos.
There should be no noticeable buffering, black screens, or delays between segments.


**Implementation:** 

I have implemented the solution with online hosted video, this implementation should work with locally stored videos as well, just need to Parse the correct Uri from local video file.
Media3 Exoplayer itself is enough for this implementation, which provides out of the box tools to achieve any customization and custom implementation with top-notch performance.



Video Urls:

https://gist.github.com/SeunghoonBaek/f35e0fd3db80bf55c2707cae5d0f7184

References:

https://developer.android.com/media/media3/exoplayer

https://dagger.dev/hilt/

https://developer.android.com/media/implement/playback-app

