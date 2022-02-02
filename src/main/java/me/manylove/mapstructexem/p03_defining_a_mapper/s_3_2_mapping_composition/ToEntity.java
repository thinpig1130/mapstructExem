/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_2_mapping_composition;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * (experimental) Mapping 규칙 재사용을 목적으로 공통 매핑 규칙을 담은 애노테이션을 생성.
 *
 * [ 공통이 되는 매핑 규칙 ]
 * target빈인 ShelveEntity와 BoxEntity에 "id", "creationDate" 및 "name" 속성이 공통으로 있다고 있다고 가정한다.
 * 또한 source 빈 ShelveDto와 BoxDto에는 항상 "groupName" 속성이 있다고 가정한다.
 *
 */

/**
 * @Retention(RetentionPolicy.XXX) : 애노테이션의 라이프 사이클을 정한다. 애노테이션이 언제까지 살아 남아 있을지를 정하는 정책이다.
 *      RetentionPolicy.SOURCE : 소스코드까지만 유지 ( 컴파일 과정에서 어노테이션 정보는 사라진다. )
 *      RetentionPolicy.CLASS : 클래스파일 까지만 유지 ( 런타임시 유지되지 않는다. )
 *      RetentionPolicy.RUNTIME : 런타임 시점까지 유지 (=사실상 안 사라진다. 따라서, Reflection API로 애노테이션 정보 조회가 가능하다.)
 */
@Retention(RetentionPolicy.CLASS)
/**
 * use @Mapping
 * ignore - target으로 지정된 속성을 매핑 하지 않으려면 ignore을 true로 설정한다. (기본 값 : false)
 *          특정 속성이 target에 전파 되어서는 안 되는 경우 나, 특정 속성이 데코레이터를 사용하여 채워져 기본적으로 매핑되지 말아야하는 속성 일 경우 유용하게 사용된다.
 * expression - target 속성이 설정될 기반이 되는 표현식 문자열.
 *          source(), defaultValue(), defaultExpression(),qualifiedBy(),qualifiedByName() 또는 constant()와 함께 사용할 수 없다.
 */
@Mapping(target = "id", ignore = true)
@Mapping(target = "creationDate", expression = "java(new java.util.Date())")
@Mapping(target = "name", source = "groupName")
public @interface ToEntity { }


/**
 * [ 맵스트럭트 지식 + ]
 * 아직 실험중인 방법이며, 오류 메시지가 온전하지 않기 떄문에, 속성이 항상 존재하는지 불확실한 경우에는 주의해서 사용해야 한다.
 * 좀 복잡 하지만 @InheritConfiguration을 사용하여 동일한 결과를 얻는 방법도 있다. s_11_1
 */
