package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_5_mapping_nested_bean_properties_to_current_target;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String id;
    private Record record;
    private Account account;
}
