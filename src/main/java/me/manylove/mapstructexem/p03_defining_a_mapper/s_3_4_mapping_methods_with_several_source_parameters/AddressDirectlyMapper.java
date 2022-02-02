package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_4_mapping_methods_with_several_source_parameters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * 입력된 매개변수를 직접 참조할 수도 있다.
 */

@Mapper
public interface AddressDirectlyMapper {

    AddressDirectlyMapper INSTANCE = Mappers.getMapper( AddressDirectlyMapper.class );

    /**
     * hn 매개변수는 int 유형으로 houseNumber에 바로 매핑된다.
     * 매개변수가 0으로 셋팅 된 것인지 매개변수 값이 없는 것인지 구분하려면 매개변수를 Integer로 받는 것이 좋겠다.
     */
    @Mapping(source = "person.description", target = "description")
    @Mapping(source = "hn", target = "houseNumber")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, int hn);

    /**
     * hn 매개변수는 bean이 아닌 유형(이 경우 java.lang.Integer)으로 houseNumber에 바로 매핑된다.
     */
    @Mapping(source = "person.description", target = "description")
    @Mapping(source = "hn", target = "houseNumber")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto2(Person person, Integer hn);

}
