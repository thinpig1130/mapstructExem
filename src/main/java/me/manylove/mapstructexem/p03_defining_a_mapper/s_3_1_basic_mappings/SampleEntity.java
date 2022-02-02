package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SampleEntity {
    private String name;
    private String description;
    private String make;
    private List<String> features;
    private List<String> amount;
}
