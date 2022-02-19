/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.dto;

import java.util.List;

/**
 * @author Filip Hrisafov
 */
public class CustomerDto {

    public Long id;
    public String customerName;
    public List<OrderItemDto> orders;
}


