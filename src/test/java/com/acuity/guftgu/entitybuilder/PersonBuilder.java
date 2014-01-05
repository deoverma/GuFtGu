/**
 * 
 */
package com.acuity.guftgu.entitybuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.entities.Timeline;

/**
 * @author amit.verma
 *
 */
public class PersonBuilder {

    private String name = "Amit";
    
    private Set<Person> followers = new HashSet<Person>();
    
    private List<Timeline> timelines = new ArrayList<Timeline>();
    
    private PersonBuilder() {
        
    }
    
    public static PersonBuilder build() {
        return new PersonBuilder();
    }
    
    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }
    
    public PersonBuilder withTimeLine(Timeline timeLine) {
        this.timelines.add(timeLine);
        return this;
    }
    
    public PersonBuilder withFollower(Person follower) {
        this.followers.add(follower);
        return this;
    }
    
    public Person aPerson() {
        Person person = new Person(name);
        person.setFollowings(followers);
        person.setTimelines(timelines);
        return person;
    }
}
