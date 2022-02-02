/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_2_mapping_composition;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoxEntity {

    // Entity의 공통 속성
    private Date creationDate;
    private Long id;
    private String name;

    //BoxEntity 만의 속성.
    private String label;
    private ShelveEntity shelve;

}
