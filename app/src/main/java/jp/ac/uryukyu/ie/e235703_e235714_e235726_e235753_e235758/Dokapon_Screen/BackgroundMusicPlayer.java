package jp.ac.uryukyu.ie.e235703_e235714_e235726_e235753_e235758.Dokapon_Screen;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusicPlayer {
    private Clip clip;

    public BackgroundMusicPlayer(String filePath) {
        try {
            // オーディオファイルの読み込み
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            // オーディオフォーマットの取得
            AudioFormat format = audioInputStream.getFormat();

            // Clipの生成
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);

            // オーディオデータの読み込みとClipへの設定
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.start(); // BGM再生開
            System.out.println("Lets go");
            clip.loop(Clip.LOOP_CONTINUOUSLY); // ループ再生
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // BGM停止
            clip.close(); // クリップを閉じる
        }
    }

    public static void main(String[] args) {
        BackgroundMusicPlayer bgmPlayer = new BackgroundMusicPlayer("/Users/e235726/prog2/dokapon/app/src/main/java/jp/ac/uryukyu/ie/e235703_e235714_e235726_e235753_e235758/Dokapon_Screen/BGM/duel.wav");
        
        //音声再生を別スレッドで開始
        new Thread(() -> bgmPlayer.play()).start();


        //音声再生を停止
        bgmPlayer.stop();
    }
}

