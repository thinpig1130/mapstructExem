package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_6_updating_existing_bean_instances;

import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers.CarType;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers.PersonDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    /**
     * 컬렉션 매핑전략
     * collectionMappingStrategy
     *
     * CollectionMappingStrategy.ACCESSOR_ONLY (접속자 전용)
     * setter가 있는 경우는 setter를 이용해서 target을 매핑하지만
     * setter가 없는 경우는 getter 메서드를 이용해서 초기화가 되어 있다고 가정하고
     * getter().addAll( 소스리스트 ) 형태로 코드를 작성합니다.
     *
     * target 속성의 setter는 orderDto.setOrderLines(order.getOrderLines) 값을 전파하는 데 사용됩니다.
     * setter가 없지만 getter 메서드를 사용할 수 있는 경우,
     * 초기화된 것으로 가정하고 orderDto.getOrderLines().addAll(order.getOrderLines)가 사용됩니다.
     * MappingTarget(기존 인스턴스 업데이트)을 사용할 때도 마찬가지입니다.
     *
     *
     * CollectionMappingStrategy.SETTER_PREFERRED (세터 선호)
     *
     * setter 메서드가 존재하는 경우,
     * orderDto.setOrderLines(order.getOrderLines)
     * setter가 없고 adder 메서드가 있는 경우
     * 해당 adder는 소스 컬렉션의 각 요소에 대해 호출됩니다. order.addOrderLine(orderLine()).
     * setter도 adder 메서드도 없지만 대상 속성에 대한 getter가 없으면 ???
     * 초기화된 컬렉션을 반환한다고 가정하고 해당 getter가 사용됩니다.
     *
     *
     * CollectionMappingStrategy.ADDER_PREFERRED (에더 선호 )
     *
     * SETTER_PREFERRED와 동일하며
     * 주어진 컬렉션 유형 속성에 대해 둘 다 있는 경우
     * 해당 adder 메서드만 setter 메서드보다 선호됩니다.
     *
     * CollectionMappingStrategy.TARGET_IMMUTABLE (변경할 수 없는 대상 )
     *
     * SETTER_PREFERRED와 동일하지만
     * 기존 빈 인스턴스를 업데이트하는 경우
     * 대상 컬렉션이 지워지고
     * addAll을 통해 액세스되지 않습니다
     * (참조: MappingTarget).
     * 대신 대상 접근자 (예: set)가 대상 빈에서 컬렉션을 설정하는 데 사용됩니다.
     *
     */

}