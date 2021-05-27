package com.bkhn.master.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum CorporateActionsDateType {
    NGAY_GIAO_DICH_KHONG_HUONG_QUYEN("ex_date", "ExrightDate"),
    NGAY_CONG_BO("pub_date", "PublicDate");
    private final String value;

    private final String dateType;

    public static CorporateActionsDateType from(String value) {
        if (value == null) return null;
        for (CorporateActionsDateType corporateActionsType : CorporateActionsDateType.values()) {
            if (corporateActionsType.getValue().equals(value)) return corporateActionsType;
        }

        return null;
    }
}
