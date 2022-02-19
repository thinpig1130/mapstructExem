/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.mapper;

import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.dto.Customer;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_7_mappings_with_direct_field_access.dto.CustomerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Filip Hrisafov
 */
@Mapper(uses = { OrderItemMapper.class })
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    @Mapping(source = "orders", target = "orderItems")
    @Mapping(source = "customerName", target = "name")
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}


/**
 * MapStruct는 getter/setter가 없는 공개 필드의 매핑도 지원합니다.
 * MapStruct는 속성에 적합한 getter/setter 메서드를 찾을 수 없는 경우 필드를 읽기/쓰기 접근자로 사용합니다.
 * public 또는 public final인 경우 필드는 읽기 접근자로 간주됩니다.
 * 필드가 static 읽기 접근자로 간주되지 않습니다.
 * 필드는 public인 경우에만 쓰기 접근자로 간주됩니다.
 * 필드가 최종 및/또는 정적이면 쓰기 접근자로 간주되지 않습니다.
 */
