package com.bkhn.master.model.request.variable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariablesCorporateActionRequest extends VariablesRequest {
    public String language;
    public int size;
    public int offset;
    public String fromDate;
    public String toDate;
    public String eventcode;
    public String datetype;
}
