package com.bkhn.master.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsRequest extends CompanyProfileRequest {
    public int size;
    public int offset;
    public String fromDate;
    public String toDate;
}
