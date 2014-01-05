package com.acuity.guftgu.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author amit.verma
 *
 */
public class Person implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -1426219287002501254L;

    private final String name;

    private Set<Person> followings = new HashSet<Person>();
    
    private List<Timeline> timelines = new ArrayList<Timeline>();
    
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getFollowings() {
        return followings;
    }
    
    public void setFollowings(Set<Person> followers) {
        this.followings = followers;
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }
 
    
}
