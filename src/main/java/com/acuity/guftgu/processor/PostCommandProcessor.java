/**
 * 
 */
package com.acuity.guftgu.processor;

/**
 * @author amit.verma
 *
 */
public class PostCommandProcessor implements CommandProcessor {

    /* (non-Javadoc)
     * @see com.acuity.guftgu.processor.CommandProcessor#processCommand()
     */
    @Override
    public void processCommand(String inputs) {
        System.out.println("Command sent is " + Command.POST.getCommand());

    }

}
