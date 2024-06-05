package com.learning.system_design.adapater;

public class Mp4Player implements AdvancedPlayer {

    @Override
    public void playMp4(byte[] file) {
        System.out.println("Playing MP4 ...");
    }

    @Override
    public void playWAV4(byte[] file) {
        // do nothing
    }
}
