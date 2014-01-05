/**
 * 
 */
package com.acuity.guftgu.main;

import static com.acuity.guftgu.processor.CommandFactory.getInstance;

import java.util.Map;

import com.acuity.guftgu.entities.Person;
import com.acuity.guftgu.processor.CommandProcessor;
import com.acuity.guftgu.repositories.PersonRepository;
import com.acuity.guftgu.repositories.RepositoryUtil;
import com.acuity.guftgu.response.CommandResponse;
import com.acuity.guftgu.response.DefaultCommandResponse;


/**
 * @author amit.verma
 *
 */
public class Chat {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if(args == null) {
            return;
        }
        
        int indexOf = args[0].indexOf(":");
        String command = "";

        if (indexOf > 1) {
            command = args[0].substring(0, indexOf);
        }

        Map<String, Person> persons = RepositoryUtil.loadPersonRepository();
        
        PersonRepository.setPersons(persons);
        CommandProcessor processor = getInstance()
                .getCommandProcessor(command);
        CommandResponse response = new DefaultCommandResponse();
        try {
            response = processor.processCommand(args[0]);
            response.printResponse();
        } catch (StringIndexOutOfBoundsException e) {
            response.printResponse();
        }
        
        RepositoryUtil.savePersonRepository(PersonRepository.getPersons());

    }

}
