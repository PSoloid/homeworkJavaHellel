package com.Hellel.PSoloid.serializationgamesaving;

import com.google.gson.Gson;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;


/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class App {
    public static void main(String[] args) throws Exception {
        CharacterType elf = new CharacterType("elf", "blue");
        CharacterType ork = new CharacterType("ork", "green");

        //save
        GameCharacter firstPlayer =
                new GameCharacter(100, "Legolas", elf, new String[]{"sword", "bow"});
        GameCharacter secondPlayer =
                new GameCharacter(85, "Ork", ork, new String[]{"hands", "axe"});

        FileOutputStream out = new FileOutputStream("resourses/save.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(firstPlayer);
        objectOutputStream.writeObject(secondPlayer);

        objectOutputStream.close();

        //restore
        GameCharacter restoredFirstPlayer = null;
        GameCharacter restoredSecondPlayer = null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("resourses/save.dat"));
        restoredFirstPlayer = (GameCharacter) objectInputStream.readObject();
        System.out.println(restoredFirstPlayer);
        restoredSecondPlayer = (GameCharacter) objectInputStream.readObject();
        System.out.println(restoredSecondPlayer);
        objectInputStream.close();


        restoredFirstPlayer = null;
        restoredSecondPlayer = null;

        inXML(firstPlayer);
        inXML(secondPlayer);


        restoredFirstPlayer = outXML();
        restoredSecondPlayer = outXML();

        System.out.println(restoredFirstPlayer.toString());
        System.out.println(restoredSecondPlayer.toString());


//        JSON
        Gson gson = new Gson();

        String json = gson.toJson(firstPlayer);

        System.out.println("JSON: " + json);

        restoredFirstPlayer = gson.fromJson(json, GameCharacter.class);

        System.out.println(restoredFirstPlayer.toString());
    }


    public static void inXML(GameCharacter o) {
        XMLEncoder xmlEncoder = null;
        try {
            FileOutputStream outXml = new FileOutputStream("resourses/saveXML.xml");
            xmlEncoder = new XMLEncoder(outXml);
            xmlEncoder.writeObject(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            xmlEncoder.flush();
            xmlEncoder.close();
        }

    }

    public static GameCharacter outXML(){
        XMLDecoder xmlDecoder = null;
        GameCharacter restored = null;
        try {
            FileInputStream inXml = new FileInputStream("resourses/saveXML.xml");
            xmlDecoder = new XMLDecoder(inXml);
            restored = (GameCharacter) xmlDecoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            xmlDecoder.close();
        }
        return restored;
    }
}
