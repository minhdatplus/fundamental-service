package com.bkhn.master.model.request.variable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class VariablesRequest implements Serializable {
    private static final long serialVersionUID = -341032624000574025L;

    public String symbol;
}
