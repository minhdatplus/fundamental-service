package com.bkhn.master.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCompanyRequest extends CompanyProfileRequest {
    public int size;
    public int offset;
}
