/**
 * 
 */
package com.acuity.guftgu.processor;

/**
 * @author amit.verma
 *
 */
public class DefaultCommandProcessor implements CommandProcessor {

    /* (non-Javadoc)
     * @see com.acuity.guftgu.processor.CommandProcessor#processCommand(java.lang.String)
     */
    @Override
    public void processCommand(String inputs) {
        System.out
                .println("Little help; please use one of the following commands !!");
        for (Command command : Command.values()) {
            System.out.println(command.getUsage());
        }
    }

}
