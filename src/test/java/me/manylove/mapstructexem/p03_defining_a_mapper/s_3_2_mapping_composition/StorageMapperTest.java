package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_2_mapping_composition;

import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings.SampleDto;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings.SampleEntity;
import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings.SampleMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3.2 매핑 구성 (experimental)")
class StorageMapperTest {

    /**
     * 나의 코드 작성 순서
     * 1. 공통 매핑 규칙을 가지고 있는 ShelveEntity와 BoxEntity를 만든다.
     * 2. 공통 매핑 규칙을 가지고 있는 ShelveDto와 BoxDto를 만든다.
     * 3. 공통 매핑 규칙을 정의한 @ToEntity 애노테이션을 만든다.
     * 4. StorageMapper 인터페이스를 정의한다. 이때 @ToEntity를 사용한다.
     * 5. build 해준다.
     * 6. 자동으로 StorageMapperImpl이 만들어 졌는지 확인한다.
     * 7. 테스트 케이스를 만들어 mapper가 정상 작동되는지 확인 한다.
     */

    @Test
    @DisplayName("01. 공통 매핑 애노테이션 사용")
    void toEntityIsWorking(){
        //given
        ShelveDto shelveDto = new ShelveDto();
        shelveDto.setGroupName("그룹이름");
        shelveDto.setMaxWeight(1.1);
        shelveDto.setStandNumber(22);
        shelveDto.setPath("경로");

        BoxDto boxDto = new BoxDto();
        boxDto.setGroupName("그룹이름2");
        boxDto.setId(100L);
        boxDto.setShelve(shelveDto);
        boxDto.setDesignation("지정_라벨");

        //when
        BoxEntity boxEntity = StorageMapper.INSTANCE.map(boxDto);
        ShelveEntity shelveEntity = boxEntity.getShelve();

        //then
        // 공통 매핑 적용 여부 확인
        // target, source
        assertThat(boxEntity.getName()).isEqualTo(boxDto.getGroupName());
        assertThat(shelveEntity.getName()).isEqualTo(shelveDto.getGroupName());
        // target, expression
        assertThat(boxEntity.getCreationDate()).isNotNull();
        assertThat(shelveEntity.getCreationDate()).isNotNull();

        // target, ignore
        assertThat(boxEntity.getId()).isNotEqualTo(boxDto.getId());
        assertThat(shelveEntity.getId()).isNull();

        // 공통 매핑 적용 외 속성 확인
        assertThat(boxEntity.getLabel()).isEqualTo(boxDto.getDesignation());

        assertThat(shelveEntity.getWeightLimit()).isEqualTo(shelveDto.getMaxWeight());
        assertThat(shelveEntity.getStandNumber()).isEqualTo(shelveDto.getStandNumber());
        assertThat(shelveEntity.getPath()).isEqualTo(shelveDto.getPath());

        // 눈으로 확인
//        System.out.println(boxEntity.getCreationDate());
//        System.out.println(shelveEntity.getCreationDate());
    }


}