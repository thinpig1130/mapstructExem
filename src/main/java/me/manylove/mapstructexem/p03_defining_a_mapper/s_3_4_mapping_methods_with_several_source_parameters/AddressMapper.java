package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_4_mapping_methods_with_several_source_parameters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * 소스객체가 여러개 일때 매핑 방법을 알아본다.
 *
 */

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );

    /**
     * 단일 매개변수 매핑 방법과 마찬가지로 속성은 이름으로 매핑된다.
     * 소스가 되는 객체에 동일한 이름을 가진 속성이 존재하는 경우,
     * @Mapping 애노테이션을 이용해 어떤 객체의 속성을 사용할 것인지 반드시 명시해 주어야 한다.
     * 만약, 명시해 주지 않으면 오류가 발생한다.
     * (error: Several possible source properties for target property 속성명 )
     */
    @Mapping(source = "person.description", target = "description") // description 속성이 둘다 존재 함으로 명시함
    @Mapping(source = "address.houseNo", target = "houseNumber") // 속성명이 달라서 명시함
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Address address);
}

/**
 * [ 맵스트럭트 지식 + ]
 * 여러 소스 매개변수가 있는 매핑 메서드는 모든 소스 매개변수가 null인 경우는 null을 반환된다.
 * 그렇지 않으면 반환될 개체가 인스턴스화되고, null이 아닌 매개변수의 속성이 반환객체에 매핑된다.
 */