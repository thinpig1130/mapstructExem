package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_5_mapping_nested_bean_properties_to_current_target;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 CustomerDto를 Customer에 매핑 하려고 한다.
 CustomerDto내부에는 Bean속성 record와 account가 있다.
 하지만 Customer의 속성들은 Bean이 아니다.
 CustomerDto 내부에 있는 Bean 속성들을 Customer에 플랫하게 매핑하려고 한다.
 */
@Mapper
public interface CustomerMapper {

    /**
     * @Mapping( target = ".", source = "플랫하게 매핑하고자하는 Bean속성의 이름" )
     * 이렇게 명시해 준다면 Bean속성의 속성이름을 토대로 target에 있는 속성들이 자동 매핑된다.
     */
    @Mapping( target = "name", source = "record.name" )
    @Mapping( target = ".", source = "record" )
    @Mapping( target = ".", source = "account" )
    /**
     * 만약, 플랫하게 매핑하고자 하는 Bean 속성이 여러개라면 여러개의 소스를 명시해 준다.
     * 매핑하려는 속성 이름이 여러개라면 어떻게 될까?
     * 소스들 중 어떤 속성을 매핑할지 몰라 맵스트럭트가 매핑코드를 생성할때 에러를 발생시킨다.
     * 그러므로 동일한 속성의 이름이 두 소스코드에 존재하고 이를 매핑해야 한다면
     * 아래와 같이 소스가 될 속성의 이름을 반드시 명시해 주어야 한다.
     */
    Customer customerDtoToCustomer(CustomerDto customerDto);

    /**
     * 소스가 되는 Bean들의 속성이 중복되더라도 Customer에 해당 속성의 이름이 없으면 에러가 발생되지 않으며,
     * 잘 빌드되어 매퍼코드가 작성된다.
     * (너무 당연한 이야기 인가?)
     */

    /**
     * TODO 아래 내용이 뭔말인지 왜 이부분에 포함되어 있는지 연구가 필요.!
     * This "target this" notation can be very useful when mapping hierarchical objects to flat objects and vice versa (@InheritInverseConfiguration).
     *
     * @InheritInverseConfiguration 를 이용할때는 모두 명시해 주지 않으면
     * @Mapping( target = "name", source = "record.name" ) 때문에
     * @Mapping( target = ".", source = "record" ) 는 적용이 되지 않네... 왜그런 걸까?
     *
     */

    @InheritInverseConfiguration
    CustomerDto customerToCustomerDto(Customer customer);

}