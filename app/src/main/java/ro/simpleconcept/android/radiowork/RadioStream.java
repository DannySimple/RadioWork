package ro.simpleconcept.android.radiowork;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import java.io.IOException;

/**
 * Created by Danny Simple on 2/15/2015.
 */

public class RadioStream {

    private static RadioStream radioStreamInstance = null;
    private static MediaPlayer radioPlayer = new MediaPlayer();

    private RadioStream() {
    }

    public static /*synchronized*/ RadioStream getInstance() {
        if (radioStreamInstance == null) {
            radioStreamInstance = new RadioStream();
        }
        return radioStreamInstance;
    }

    public static void playRadioStream(String radioUrl) {
        try {
            radioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            radioPlayer.setDataSource(radioUrl);
            radioPlayer.prepareAsync();
            radioPlayer.start();
        } catch (IllegalArgumentException e) {
            Log.e("RadioError", "Source not valid");
        } catch (IOException e) {
            Log.e("RadioError", "Source not playable");
        } catch (Exception e) {
            Log.e("RadioError", "Other Error");
        }
    }

    public static void stopRadioStream() {
        //TODO code to stop and release resources
    }

    public static void pauseRadioStream() {
        //TODO code to pause and keep conection
    }

    public static void resumeRadioStream() {
        //TODO code  - not sure i need this method
    }

}//end class
