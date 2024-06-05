package com.learning.system_design.adapater;

public class MediaAdapter implements MediaPlayer{
    private AdvancedPlayer advancedPlayer;
    private byte[] file=new byte[0];
    @Override
    public void play(byte[] file, String format) {
        if("mp4".equals(format)){
            advancedPlayer=new Mp4Player();
            advancedPlayer.playMp4(file);
        }
        else if("wav4".equals(format)){
            advancedPlayer=new WAV4Player();
            advancedPlayer.playWAV4(file);
        }
        else{
            System.out.println("Format not supported ...");
        }
    }
}
