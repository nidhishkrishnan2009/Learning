package com.learning.system_design.adapater;

public class Mp3Player implements MediaPlayer{

    private MediaAdapter mediaAdapter;
    private byte[] file=new byte[0];
    @Override
    public void play(byte[] file, String format) {
        if("mp3".equals(format)){
            System.out.println("Playing Mp3 ...");
        }
        else{
            mediaAdapter=new MediaAdapter();
            mediaAdapter.play(file,format);
        }
    }
}
