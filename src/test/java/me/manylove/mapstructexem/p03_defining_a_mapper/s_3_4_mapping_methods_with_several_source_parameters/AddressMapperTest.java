package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_4_mapping_methods_with_several_source_parameters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3.4 소스가 되는 매개 변수 객체 여러 개 일 때")
class AddressMapperTest {

    @Test
    @DisplayName("01. 속성명이 동일한 경우 주의!")
    void severalSourceMapper(){
        //given
        Person person = new Person("다애", "권", 162, "다애는 프로그래머다.");
        Address address = new Address("도움3로", 15544, 160, "가재마을 4단지");

        //when
        DeliveryAddressDto deliveryAddressDto = AddressMapper.INSTANCE.personAndAddressToDeliveryAddressDto(person, address);

        //then
        assertThat(deliveryAddressDto.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(deliveryAddressDto.getLastName()).isEqualTo(person.getLastName());
        assertThat(deliveryAddressDto.getHeight()).isEqualTo(person.getHeight());

        assertThat(deliveryAddressDto.getStreet()).isEqualTo(address.getStreet());
        assertThat(deliveryAddressDto.getZipCode()).isEqualTo(address.getZipCode());
        assertThat(deliveryAddressDto.getHouseNumber()).isEqualTo(address.getHouseNo());

        // 둘다 description 속성이 있으므로 명시적 매핑 (person의 description 사용)
        assertThat(deliveryAddressDto.getDescription()).isEqualTo(person.getDescription());

    }

    @Test
    @DisplayName("02. 매개 변수가 둘다 null인 경우")
    void severalSourceAllNull(){
        //given
        //when
        DeliveryAddressDto deliveryAddressDto = AddressMapper.INSTANCE.personAndAddressToDeliveryAddressDto(null, null);

        //then
        assertThat(deliveryAddressDto).isNull();
    }

    @Test
    @DisplayName("03. 두 매개 변수 중 한 개가 null")
    void oneSourceIsNull(){
        //given
        Person person = new Person("다애", "권", 162, "다애는 프로그래머다.");

        //when
        DeliveryAddressDto deliveryAddressDto = AddressMapper.INSTANCE.personAndAddressToDeliveryAddressDto(person, null);

        //then
        assertThat(deliveryAddressDto.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(deliveryAddressDto.getLastName()).isEqualTo(person.getLastName());
        assertThat(deliveryAddressDto.getHeight()).isEqualTo(person.getHeight());

        assertThat(deliveryAddressDto.getStreet()).isNull();
        assertThat(deliveryAddressDto.getZipCode()).isEqualTo(0);
        assertThat(deliveryAddressDto.getHouseNumber()).isEqualTo(0);

        // 둘다 description 속성이 있으므로 명시적 매핑 (person의 description 사용)
        assertThat(deliveryAddressDto.getDescription()).isEqualTo(person.getDescription());

    }

    @Test
    @DisplayName("004. 매개변수 직접 참조")
    void deliveryRefer(){
        //given
        Person person = new Person("다애", "권", 162, "다애는 프로그래머다.");

        //when
        DeliveryAddressDto deliveryAddressDto = AddressDirectlyMapper.INSTANCE.personAndAddressToDeliveryAddressDto(person, 12204);

        //then
        assertThat(deliveryAddressDto.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(deliveryAddressDto.getLastName()).isEqualTo(person.getLastName());
        assertThat(deliveryAddressDto.getHeight()).isEqualTo(person.getHeight());

        assertThat(deliveryAddressDto.getHouseNumber()).isEqualTo(12204);
        assertThat(deliveryAddressDto.getStreet()).isNull();
        assertThat(deliveryAddressDto.getZipCode()).isEqualTo(0);

        // 둘다 description 속성이 있으므로 명시적 매핑 (person의 description 사용)
        assertThat(deliveryAddressDto.getDescription()).isEqualTo(person.getDescription());

    }

    @Test
    @DisplayName("004. 직접 참조하는 객체가 null 인 경우")
    void deliveryRefer2(){
        //given
        Person person = new Person("다애", "권", 162, "다애는 프로그래머다.");

        //when
        DeliveryAddressDto deliveryAddressDto = AddressDirectlyMapper.INSTANCE.personAndAddressToDeliveryAddressDto2(person, null);

        //then
        assertThat(deliveryAddressDto.getFirstName()).isEqualTo(person.getFirstName());
        assertThat(deliveryAddressDto.getLastName()).isEqualTo(person.getLastName());
        assertThat(deliveryAddressDto.getHeight()).isEqualTo(person.getHeight());

        // 직접 참조하는 객체가 null이면 해당 필드에 결과가 셋팅되지 않음
        assertThat(deliveryAddressDto.getHouseNumber()).isEqualTo(0);

        assertThat(deliveryAddressDto.getStreet()).isNull();
        assertThat(deliveryAddressDto.getZipCode()).isEqualTo(0);

        // 둘다 description 속성이 있으므로 명시적 매핑 (person의 description 사용)
        assertThat(deliveryAddressDto.getDescription()).isEqualTo(person.getDescription());

    }

}