package com.bkhn.master.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum CorporateActionsType {
    KET_QUA_KINH_DOANH("kqkd", "KQCT,KQQY,KQSB"), TRA_CO_TUC("tct", "DIV,ISS"),
    GIAO_DICH_NOI_BO("gdnb", "DDALL,DDIND,DDINS,DDRP"), DAI_HOI_CO_DONG("dhcd", "AGME,AGMR,BALLOT,BCHA,BOME,EGME"),
    NIEM_YET("ny", "AIS,NLIS,RETU,SUSP,TS"), KHAC("other", "AMEN,LIQUI,MA,MOVE,OTHE");
    private final String value;

    private final String eventCode;

    public static CorporateActionsType from(String value) {
        if (value == null) return null;
        for (CorporateActionsType corporateActionsType : CorporateActionsType.values()) {
            if (corporateActionsType.getValue().equals(value)) return corporateActionsType;
        }

        return null;
    }
}
