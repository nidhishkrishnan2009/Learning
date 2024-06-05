package com.learning.system_design.adapater;

public class Driver {
    private static byte[] file=new byte[0];
    public static void main(String[] args) {
        Mp3Player player=new Mp3Player();
        player.play(file,"mp3");
        player.play(file,"mp4");
        player.play(file,"wav4");
        player.play(file,"mp5");
    }
}
