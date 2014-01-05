/**
 * 
 */
package com.acuity.guftgu.processor;

import com.acuity.guftgu.response.CommandResponse;

/**
 * @author amit.verma
 *
 */
public interface CommandProcessor {

    CommandResponse processCommand(String inputs);

}
