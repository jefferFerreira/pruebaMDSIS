package com.csti.customer.commons.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CustomerDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3011892245447609637L;

    private String firstName;
    private String middleName;
    private String firstSurName;
    private String secondLastName;
    private String phone;
    private String address;
    private String cityOfResidence;
}
