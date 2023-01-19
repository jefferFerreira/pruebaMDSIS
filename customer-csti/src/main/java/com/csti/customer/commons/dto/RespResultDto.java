package com.csti.customer.commons.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespResultDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 5075998329539043324L;
    private List<Result> resultado;

    @Data
    public static class Result {
        private String codigo;
        private String descripcion;
        private String tipo;
    }
}