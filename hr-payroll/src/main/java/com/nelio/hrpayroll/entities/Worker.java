package com.nelio.hrpayroll.entities;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Worker implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;

}
