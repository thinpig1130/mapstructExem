package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String make;
    private int seatCount;
    private String type;
    private PersonDto owner;
}