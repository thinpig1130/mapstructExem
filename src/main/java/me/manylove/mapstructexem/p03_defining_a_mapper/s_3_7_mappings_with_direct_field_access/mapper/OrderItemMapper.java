/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.mapper;


import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.dto.OrderItem;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.dto.OrderItemDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Filip Hrisafov
 */
@Mapper
public interface OrderItemMapper {

    OrderItemMapper MAPPER = Mappers.getMapper(OrderItemMapper.class);

    OrderItem toOrder(OrderItemDto orderItemDto);

    @InheritInverseConfiguration
    OrderItemDto fromOrder(OrderItem orderItem);
}
