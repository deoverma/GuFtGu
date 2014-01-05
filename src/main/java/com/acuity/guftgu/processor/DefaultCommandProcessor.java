/**
 * 
 */
package com.acuity.guftgu.processor;

import com.acuity.guftgu.response.CommandResponse;
import com.acuity.guftgu.response.DefaultCommandResponse;

/**
 * @author amit.verma
 *
 */
public class DefaultCommandProcessor implements CommandProcessor {

    /* (non-Javadoc)
     * @see com.acuity.guftgu.processor.CommandProcessor#processCommand(java.lang.String)
     */
    @Override
    public CommandResponse processCommand(String input) {
        return new DefaultCommandResponse();
    }

}
