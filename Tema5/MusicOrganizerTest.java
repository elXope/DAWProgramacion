package Tema5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicOrganizerTest {


    @Test
    void isValidIndex() {
        MusicOrganizer test = new MusicOrganizer();
        test.addFile("Como un vagabundo");
        test.addFile("Mi gran noche");
        test.addFile("La santa");
        assertFalse(test.isValidIndex(-1));
        assertFalse(test.isValidIndex(3));
        assertTrue(test.isValidIndex(0));
        assertTrue(test.isValidIndex(1));
        assertTrue(test.isValidIndex(2));
    }


    @Test
    void getNumberOfFiles() {
        MusicOrganizer test = new MusicOrganizer();
        assertEquals(0, test.getNumberOfFiles());
        test.addFile("Como un vagabundo");
        test.addFile("Mi gran noche");
        test.addFile("La santa");
        assertEquals(3, test.getNumberOfFiles());
    }

    @Test
    void removeFile() {
        MusicOrganizer test = new MusicOrganizer();
        test.removeFile(0);
        assertEquals(0, test.getNumberOfFiles());
        test.addFile("Como un vagabundo");
        test.addFile("Mi gran noche");
        test.addFile("La santa");
        test.removeFile(3);
        assertEquals(3, test.getNumberOfFiles());
        test.removeFile(2);
        assertEquals(2, test.getNumberOfFiles());
    }

    public static void main(String[] args) {
        MusicOrganizer test = new MusicOrganizer();
        test.listFile(0);
        test.addFile("Como un vagabundo");
        test.addFile("Mi gran noche");
        test.addFile("La santa");
        test.addFile("un bolero en Berlin");
        test.addFile("Tenemos universidad");
        test.listFile(3);
        test.listFile(0);
        test.listFile(1);
        test.listFile(2);
        test.checkIndex(-1);
        test.checkIndex(1);
        test.checkIndex(3);
        test.listMatching("un");
        test.listMatching("australopitecus");
    }

    @Test
    void findFirst() {
        MusicOrganizer test = new MusicOrganizer();
        test.addFile("Como un vagabundo");
        test.addFile("Mi gran noche");
        test.addFile("La santa");
        test.addFile("un bolero en Berlin");
        test.addFile("Tenemos universidad");
        assertEquals(0,test.findFirst("un"));
        assertEquals(2,test.findFirst("santa"));
        assertEquals(-1,test.findFirst("sabadu"));
    }
}