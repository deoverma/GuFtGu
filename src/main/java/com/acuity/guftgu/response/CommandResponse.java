package com.acuity.guftgu.response;

import java.io.Serializable;

public interface CommandResponse extends Serializable {

    static final String SEPARATOR = " -> ";

    static final String PROMPT = "> ";

    void printResponse();
}
