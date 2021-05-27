package com.bkhn.master.model.request.variable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariablesStockPriceRequest extends VariablesRequest {
    public String symbol;
    public int size;
    public int offset;
    public String fromDate;
    public String toDate;

}
