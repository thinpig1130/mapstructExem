package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_4_mapping_methods_with_several_source_parameters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryAddressDto {
    private String firstName;
    private String lastName;
    private int height;
    private String street;
    private int zipCode;
    private int houseNumber;
    private String description;
}
