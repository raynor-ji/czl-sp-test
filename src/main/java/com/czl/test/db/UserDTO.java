package com.czl.test.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {


    private Long id;
    private String name;
    private Integer age;
    private Instant idt;
    private LocalDateTime ildt;
    private LocalDateTime ldt;
    private Instant lidt;


}
