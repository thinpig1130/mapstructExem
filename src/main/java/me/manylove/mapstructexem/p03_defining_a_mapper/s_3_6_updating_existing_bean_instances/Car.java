package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_6_updating_existing_bean_instances;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers.CarType;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers.Person;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;
    private Person owner;
    private List<String> option;



}