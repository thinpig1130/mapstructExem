package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_6_updating_existing_bean_instances;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * 새 인스턴스를 생성하지 않고, 대신 해당 유형의 기존 인스턴스를 업데이트하는 매핑.
 *
 */
@Mapper
public interface CarMapper {
    /**
     * 대상 개체에 대한 매개변수를 추가하고 이 매개변수를 @MappingTarget 에노테이션을 붙여주면
     * 인자로 입력된 객체에 속성을 매핑하도록 매핑코드가 작성된다.
     * 단, 매핑 대상으로 표시된 매개변수는 하나만 있을 수 있다.
     */
   public void updateCarFromDto(CarDto carDto, @MappingTarget Car car);

    /**
     * void 대신 메서드의 반환 유형을 대상 매개변수의 유형으로 설정할 수도 있습니다.
     */
    public Car updateCarFromDto2(CarDto carDto, @MappingTarget Car car);


    /**
     *
     */
    public Car updateCarFromDto3(CarDto carDto, @MappingTarget Car car);

    /**
     * 인자로 입력된 객체의 컬렉션 매핑전략
     *
     * CollectionMappingStrategy.ACCESSOR_ONLY
     *
     * CollectionMappingStrategy.ADDER_PREFERRED
     *
     * CollectionMappingStrategy.TARGET_IMMUTABLE
     *
     */




}