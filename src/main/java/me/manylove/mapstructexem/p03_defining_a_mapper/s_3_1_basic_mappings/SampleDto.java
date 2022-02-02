package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SampleDto {
    private String name;
    private String description;
    private String manufacturer;
    private List<String> features;
    private List<Integer> amount;
}
