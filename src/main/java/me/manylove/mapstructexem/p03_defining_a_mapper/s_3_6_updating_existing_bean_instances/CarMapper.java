package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_6_updating_existing_bean_instances;

import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_4_mapping_methods_with_several_source_parameters.AddressMapper;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 새 인스턴스를 생성하지 않고, 대신 해당 유형의 기존 인스턴스를 업데이트하는 매핑.
 *
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

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
     * TODO 이걸 왜 여기다 써 놓았을까?
     *
     * For CollectionMappingStrategy.ACCESSOR_ONLY Collection- or map-typed properties of the target bean to be updated will be cleared
     * and then populated with the values from the corresponding source collection or map.
     * Otherwise, For CollectionMappingStrategy.ADDER_PREFERRED or CollectionMappingStrategy.TARGET_IMMUTABLE the target will not be cleared
     * and the values will be populated immediately.
     *
     * CollectionMappingStrategy.ACCESSOR_ONLY의 경우 업데이트할 대상 빈의 컬렉션 또는 맵 유형 속성이 지워지고
     * 해당 소스 컬렉션 또는 맵의 값으로 채워집니다.
     * 그렇지 않으면 CollectionMappingStrategy.ADDER_PREFERRED 또는 CollectionMappingStrategy.TARGET_IMMUTABLE의 경우
     * 대상이 지워지지 않고 값이 즉시 채워집니다.
     *
     */



}