/**
 * 
 */
package com.acuity.guftgu.main;

import com.acuity.guftgu.processor.CommandFactory;
import com.acuity.guftgu.processor.CommandProcessor;


/**
 * @author amit.verma
 *
 */
public class Chat {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome user !! Lets Chat...");

        int indexOf = args[0].indexOf(":");
        String command = "";

        if (indexOf > 1) {
            command = args[0].substring(0, indexOf);
        }

        CommandProcessor processor = CommandFactory.getInstance()
                .getCommandProcessor(command);
        processor.processCommand(args[0]);

    }

}
