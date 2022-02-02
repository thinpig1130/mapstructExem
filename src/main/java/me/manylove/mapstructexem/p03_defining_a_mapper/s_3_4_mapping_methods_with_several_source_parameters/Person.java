package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_4_mapping_methods_with_several_source_parameters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int height;
    private String description;
}
