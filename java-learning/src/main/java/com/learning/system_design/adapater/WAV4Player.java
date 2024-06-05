package com.learning.system_design.adapater;

public class WAV4Player implements AdvancedPlayer{
    @Override
    public void playMp4(byte[] file) {
        // do nothing
    }

    @Override
    public void playWAV4(byte[] file) {
        System.out.println("Playing WAV4 ...");
    }
}
