package com.csti.customer.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EResponse {
    SUCCESS("RP_200","Transacción Exitosa","INFO"),
    ERROR("RP_400","No se pudo completar la transaccion","ERROR");

    private String code;
    private String message;
    private String type;
}