package com.acuity.guftgu.repositories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.acuity.guftgu.entities.Person;

public class RepositoryUtil {

    @SuppressWarnings("unchecked")
    public static Map<String, Person> loadPersonRepository() {
        FileInputStream fis = null ;
        ObjectInputStream ois = null ;
        Map<String, Person> persons = new HashMap<String, Person>();
        try {
            fis = new FileInputStream("datafile");
            ois = new ObjectInputStream(fis);
            persons = (Map<String, Person>) ois.readObject();
        } catch(Exception e) {
//            e.printStackTrace();
//            System.out.println("Could not initialise repo.");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return persons;
    }

    public static void savePersonRepository(Map<String, Person> persons) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream("datafile");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(persons);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not save repo.");
        } finally {
            try {
                oos.flush();
                oos.close();
                //fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
