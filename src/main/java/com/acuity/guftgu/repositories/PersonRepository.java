package com.acuity.guftgu.repositories;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.entities.Timeline;

/**
 * 
 * @author amit.verma
 *
 */
public final class PersonRepository implements Externalizable {

    private static Map<String, Person> persons = new ConcurrentHashMap<String, Person>();
    
    private static PersonRepository instance;
    
    private PersonRepository() {
        
    }
    
    public static PersonRepository getInstance() {
        if(instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }
    
    public void savePerson(Person person) {
        persons.put(person.getName().toUpperCase(), person);
    }
    
    public Person getPerson(String userName) {
        userName = userName != null ? userName.toUpperCase() : userName;
        return persons.get(userName);
    }

    public void addTimeline(String userName, String message) {
        Person person = getPerson(userName);
        Timeline timeline = new Timeline(message, new GregorianCalendar());
        if(person == null) {
            person = new Person(userName);
            savePerson(person);
        }
        person.getTimelines().add(timeline);
    }
    
    public void addFollowings(String userName, String followUser) {
        Person follower = getPerson(followUser);
        Person user = getPerson(userName);
        
        if(follower == null) {
            follower = new Person(followUser);
            savePerson(follower);
        }
        
        if(user == null) {
            user = new Person(userName);
            savePerson(user);
        }
        user.getFollowings().add(follower);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out = new ObjectOutputStream(new FileOutputStream("datafile"));
        out.writeObject(persons);
        out.flush();
        out.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream("datafile");
        in = new ObjectInputStream(fis);
        persons = (Map<String, Person>)in.readObject();
        in.close();
    }

    public static Map<String, Person> getPersons() {
        return persons;
    }

    public static void setPersons(Map<String, Person> persons) {
        PersonRepository.persons = persons;
    }

    
}
