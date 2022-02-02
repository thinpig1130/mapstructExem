package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * use @Mapper
 * 인터페이스에 @Mapper 애노테이션을 붙이면,
 * 인자로 주입되는 source 엔티티의 속성과 반환되는 target의 엔티티의 속성을 식별하여,
 * build 될때 자동으로 매핑 Class를 만들어 준다.
 */
@Mapper
public interface SampleMapper {

    /**
     * source 엔티티와 target 엔티티의 속성 이름이 동일한 경우, 별도의 설정없이 자동으로 매핑된다.
     */
    SampleEntity dtoToEntity(SampleDto source);


    /**
     * use @Mapping
     * source - 매핑에 사용할 소스의 속성 이름
     * target - 반환 할 객체의 매핑될 속성 이름
     *
     * source 엔티티의 속성의 이름이 target 엔터티의 속성 이름과 다른 경우 @Mapping 주석을 통해 짝이 될 속성 이름을 매핑할 수 있다.
     */
    @Mapping(source = "make", target = "manufacturer")
    SampleDto entityToDto(SampleEntity source);

    /**
     * use @BeanMapping
     * 만약 이름을 통한 암묵적 자동 매핑을 사용하지 않으려면
     * @BeanMapping(ignoreByDefault = true)로 설정하면 된다.
     * 이렇게 하면 @Mapping을 통해 명시된 속성 외에는 매핑코드가 만들어지지 않는다.
    */
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "make", target = "manufacturer")
    SampleDto entityToDtoV2(SampleEntity source);
}

/**
 * [ 맵스트럭트 지식 + ]
 * 기본적으로 getter와 setter를 이용해 코드를 매핑한다.
 * 기본적으로 public으로 공개된 모든 속성이 매핑의 대상이 된다.
 *
 * 컬렉션의 매핑 :
 *      같은 타입의 요소를 가진 컬렉션의 매핑은 새 인스턴스를 생성하면서 target에 바로 매핑된다.
 *      하지만, 서로 다른 타입을 가진 컬렉션을 매핑할 때는 컬렉션 생성 한 후,
 *          각 요소를 매핑한 결과를 컬렉션에 넣어주고,
 *          요소매핑이 끝난 최종 결과 컬렉션이 target 엔티티에 매핑된다.
 */

/**
 * [ 예제 코드 부가 설명 ]
 * build를 실행 한 후, SampleMapperImpl 코드를 열어 위의 내용을 확인 할 수 있다.
 *
 * 생성 클래스의 위치 :
 *      build -> generated -> sources -> annotationProcessor -> java -> main ->
 *          매퍼코드가 작성된 패키지 ->  매퍼코드이름 + Impl
 */


