package com.bkhn.master.model.request.variable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariablesSimilarRequest extends VariablesRequest {
    public String language;
    public int size;
    public int offset;
}
