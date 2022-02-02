/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_2_mapping_composition;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StorageMapper {

    StorageMapper INSTANCE = Mappers.getMapper( StorageMapper.class );

    @ToEntity
    @Mapping( target = "weightLimit", source = "maxWeight")
    ShelveEntity map(ShelveDto source);

    @ToEntity
    @Mapping( target = "label", source = "designation")
    BoxEntity map(BoxDto source);
}

/**
 * [ 예제 코드 부가 설명 ]
 * 예제 코드를 보면,
 * BoxDto 안에 ShelveDto가 있으며, BoxEntity안에 ShelveEntity가 있다.
 * BoxDto를 BoxEntity로 매핑하려면 ShelveDto를 ShelveEntity로도 매핑해야 한다.
 * 이때 위와 같이 인터페이스에 ShelveEntity map(ShelveDto source)정의하면,
 * 맵스트럭트에 의해 작성된 StorageMapperImpl은 map(ShelveDto source) 메소드를 이용하여 BoxEntity 내부의 ShelveEntity를 매핑한다.
 *
 * 만약, ShelveEntity map(ShelveDto source)를 정의하지 않는다면,
 * protected ShelveEntity shelveDtoToShelveEntity(ShelveDto source) 메서드가 맵스트럭트에 의해 생성되며,
 * 기본 매핑을 이용하여 생성된 shelveDtoToShelveEntity 메서드를 통해 ShelveEntity를 매핑한다.
 */