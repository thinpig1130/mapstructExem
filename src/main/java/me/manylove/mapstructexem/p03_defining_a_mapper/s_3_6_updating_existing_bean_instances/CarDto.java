package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_6_updating_existing_bean_instances;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers.PersonDto;

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