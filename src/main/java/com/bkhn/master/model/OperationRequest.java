package com.bkhn.master.model;

import com.bkhn.master.model.request.variable.VariablesRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class OperationRequest implements Serializable {
    private static final long serialVersionUID = -341072624000574025L;

    private String operationName;
    private VariablesRequest variables;
    private String query;
}