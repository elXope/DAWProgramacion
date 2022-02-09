package Tema5;

import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    public void checkIndex (int index) {
        if (index < 0 || index >= files.size()) {
            System.out.println("Los indices de la lista van del 0 al " + (this.files.size() - 1) + ".");
        }
    }

    public boolean isValidIndex (int index) {
        return index >= 0 && index < files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(this.isValidIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    public void listAllFiles() {
        for (String filename : this.files) {
            System.out.println(filename);
        }
    }

    public void listMatching(String match) {
        int contador = 0;
        for (String filename : this.files) {
            if (filename.contains(match)) {
                System.out.println(filename);
                contador++;
            }
        }
        if (contador == 0) System.out.println("No se ha encontrado ninguna coincidencia con " + match + ".");
    }

    public void playMatching(String match) {
        int contador = 0;
        for (String filename : this.files) {
            if (filename.contains(match)) {
                System.out.println(filename);
                player.playSample(filename);
                contador++;
            }
        }
        if (contador == 0) System.out.println("No se ha encontrado ninguna coincidencia con " + match + ".");
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(this.isValidIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
}
