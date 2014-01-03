package com.acuity.guftgu;

import com.acuity.guftgu.entities.Person;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
}
