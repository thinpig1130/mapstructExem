/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_2_mapping_composition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShelveDto {

    private String groupName;

    private String path;
    private int standNumber;
    private double maxWeight;
}
