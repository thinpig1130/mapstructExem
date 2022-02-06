package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("3.1 기본 매핑")
class SampleMapperTest {

    /**
     * 나의 코드 작성 순서
     * 1. SampleEndtity를 만든다.
     * 2. SampleDto를 만든다.
     * 3. SampleMapper 인터페이스를 정의하여 준다.
     * 4. SampleMapper 인터페이스에 @Mapper 어노테이션을 붙여준다.
     * 5. build 해준다.
     * 6. 자동으로 SampleMapperImpl이 만들어 졌는지 확인한다.
     * 7. 테스트 케이스를 만들어 mapper가 정상 작동되는지 확인 한다.
     */

    private SampleMapper sampleMapper = Mappers.getMapper(SampleMapper.class);

    @Test
    @DisplayName("01. 속성 이름이 같은 경우 자동 매핑")
    void dtoToEntity(){
        //given
        SampleDto sampleDto = new SampleDto();
        sampleDto.setName("KwonDarc");
        sampleDto.setDescription("설명 블라블라.");
        sampleDto.setManufacturer("속성 이름이 다른 경우");

        //when
        SampleEntity sampleEntity = sampleMapper.dtoToEntity(sampleDto);

        //then
        // 속성 이름이 같은 경우 자동으로 매핑코드가 작성된다.
        assertThat(sampleEntity.getName()).isEqualTo(sampleDto.getName());
        assertThat(sampleEntity.getDescription()).isEqualTo(sampleDto.getDescription());
        // 속성 이름이 다른경우 자동으로 매핑코드가 작성되지 않는다.
        assertThat(sampleEntity.getMake()).isNotEqualTo(sampleDto.getManufacturer());
    }

    @Test
    @DisplayName("02. 속성이름이 다른 경우 명시")
    void entityToDto(){
        //given
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName("KwonDarc");
        sampleEntity.setDescription("어쩌구 저쩌구");
        sampleEntity.setMake("속성 이름이 다른 경우");

        //when
        SampleDto sampleDto = sampleMapper.entityToDto(sampleEntity);

        //then
        assertThat(sampleDto.getName()).isEqualTo(sampleEntity.getName());
        assertThat(sampleDto.getDescription()).isEqualTo(sampleEntity.getDescription());
        assertThat(sampleDto.getManufacturer()).isEqualTo(sampleEntity.getMake());
    }

    @Test
    @DisplayName("03. 명시하지 않은 속성은 매핑 제외")
    void entityToDtoV2(){
        //given
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName("KwonDarc");
        sampleEntity.setDescription("어쩌구 저쩌구");
        sampleEntity.setMake("속성 이름이 다른 경우");

        //when
        SampleDto sampleDto = sampleMapper.entityToDtoV2(sampleEntity);

        //then

        assertThat(sampleDto.getName()).isEqualTo(sampleEntity.getName());
        assertThat(sampleDto.getManufacturer()).isEqualTo(sampleEntity.getMake());

        // 명시하지 않은 속성.
        assertThat(sampleDto.getDescription()).isNotEqualTo(sampleEntity.getDescription());


    }

    @Test
    @DisplayName("04. 같은 타입의 컬렉션 매핑")
    void sameTypeCollectionsTest(){
        //given
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName("KwonDarc");
        sampleEntity.setFeatures(new ArrayList<String>(Arrays.asList("하나","둘","셋")));


        //when
        SampleDto sampleDto = sampleMapper.entityToDto(sampleEntity);

        //then
        List<String> dtoFeatures = sampleDto.getFeatures();
        List<String> entFeatures = sampleEntity.getFeatures();
        // 같은 객체는 아님
        assertThat(dtoFeatures).isNotSameAs(entFeatures);
        // 컬렉션 길이는 같다.
        assertThat(dtoFeatures.size()).isEqualTo(entFeatures.size());
        // 복사된 내용은 같다.
        assertThat(dtoFeatures.get(1)).isEqualTo(entFeatures.get(1));

    }

    @Test
    @DisplayName("05. 다른 타입의 컬렉션 매핑")
    void differentTypeCollectionsTest(){
        //given
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName("KwonDarc");
        sampleEntity.setAmount(new ArrayList<String>(Arrays.asList("1","2","3")));

        //when
        SampleDto sampleDto = sampleMapper.entityToDto(sampleEntity);

        //then
        List<Integer> dtoFeatures = sampleDto.getAmount();
        List<String> entFeatures = sampleEntity.getAmount();
        // 같은 객체는 아님
        assertThat(dtoFeatures).isNotSameAs(entFeatures);
        // 컬렉션 길이는 같다.
        assertThat(dtoFeatures.size()).isEqualTo(entFeatures.size());
        // 복사된 내용이 같지 않다.
        assertThat(dtoFeatures.get(1)).isNotEqualTo(entFeatures.get(1));
        // 복사된 내용을 타입 변환하면 내용이 같다.
        assertThat(dtoFeatures.get(1)).isEqualTo(Integer.valueOf(entFeatures.get(1)));
    }
}