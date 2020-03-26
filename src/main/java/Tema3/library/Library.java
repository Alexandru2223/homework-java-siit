package Tema3.library;

import java.io.*;
import java.util.ArrayList;

public class Library {
    int k1 = 0;
    int k2 = 0;
    private ArrayList<Novels> nov = new ArrayList<>();
    private ArrayList<Albums> alb = new ArrayList<>();

    public void importBooks(String fileName) {
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(", ");
                if (str[0].equals("novel")) {
                    nov.add(new Novels());
                    nov.get(k1).setName(str[1]);
                    nov.get(k1).setNumberOfPages(Integer.valueOf(str[2]));
                    nov.get(k1).setType(str[3]);
                    k1++;
                } else if (str[0].equals("album")) {
                    alb.add(new Albums());
                    alb.get(k2).setName(str[1]);
                    alb.get(k2).setNumberOfPages(Integer.valueOf(str[2]));
                    alb.get(k2).setPaperQuality(str[3]);
                    k2++;
                }

            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public void displayAllBooks() {
        for (Novels novels : nov) {
            System.out.println("Novel: " + "Name: " + novels.getName() + ", pages: " + novels.getNumberOfPages() + ", type: " + novels.getType());
        }
        for (Albums albums : alb) {
            System.out.println("Album: " + "Name: " + albums.getName() + ", pages: " + albums.getNumberOfPages() + ", paper quality: " + albums.getPaperQuality());
        }
    }
    public void displayNovel(String name){
        for(Novels novels : nov){
            if(novels.getName().equals(name)){
                System.out.println("Novel: " + "Name: " + novels.getName() + ", pages: " + novels.getNumberOfPages() + ", type: " + novels.getType());
            }
        }
    }
    public void displayAlbum(String name){
        for(Albums albums : alb){
            if(albums.getName().equals(name)){
                System.out.println("Album: " + "Name: " + albums.getName() + ", pages: " + albums.getNumberOfPages() + ", paper quality: " + albums.getPaperQuality());
            }
        }
    }

    public void addBooks(String typeOfBook, String name, int numberOfPages, String q) {
        if (typeOfBook.equals("novel")) {
            System.out.println("Book added to novels: " + name);
            nov.add(new Novels());
            nov.get(k1).setName(name);
            nov.get(k1).setNumberOfPages(numberOfPages);
            nov.get(k1).setType(q);
            writeTo("Books.txt", nov.get(k1).toStringList());
            k1++;
        } else if (typeOfBook.equals("album")) {
            System.out.println("Book added to novels: " + name);
            alb.add(new Albums());
            alb.get(k2).setName(name);
            alb.get(k2).setNumberOfPages(numberOfPages);
            alb.get(k2).setPaperQuality(q);
            writeTo("Books.txt", alb.get(k2).toStringList());
            k2++;
        }
    }

    public void deleteBooks(String name) {
        System.out.println("Book deleted: " + name);
        if (nov.contains(name)) {
            nov.removeIf(bookName -> bookName.getName().equals(name));
            k1 = nov.size();
        } else if (alb.contains(name)) {
            alb.removeIf(bookName -> bookName.getName().equals(name));
            k2 = alb.size();
        } else {
            System.out.println("Book doesn't exist");
        }

    }
    public static void writeTo(String fileName, String content){
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter fw = new PrintWriter(new FileWriter(file, true));
            BufferedWriter writer = new BufferedWriter(fw);
            writer.newLine();
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
