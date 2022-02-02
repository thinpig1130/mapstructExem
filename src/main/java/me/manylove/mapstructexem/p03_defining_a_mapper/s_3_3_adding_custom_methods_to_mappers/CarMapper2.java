package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers;

import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_2_mapping_composition.StorageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Person에서 PersonDto로의 매핑에는 MapStruct에서 생성할 수 없는 몇 가지 특수 논리가 필요하다고 가정한다.
 */
@Mapper
public abstract class CarMapper2 {

    static CarMapper2 INSTANCE = Mappers.getMapper( CarMapper2.class );

    @Mapping(target="seatCount", source = "numberOfSeats")
    public abstract CarDto carToCarDto(Car car);
    
    /**
     * 특정 매핑을 수동으로 구현해야 하는 경우 2.
     * 추상 메서드로 Mapper 클래스를 정의
     * 맵스트럭트에 의해 구현될 메서드는 public abstract 메서드로 정의
     * 수동으로 구현해야하는 메소드를 구현.
     * 매핑 할 객체의 인수와 반환 유형이 구현한 메서드와 일치하는 경우,
     * 맵스트럭트에 의해 작성된 CarMapperImpl에서는 해당 메서드 호출하여 매핑하도록 코드가 작성된다.
     */
    public PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();
        personDto.setAge( person.getAge() );

        String[] splitString = person.getName().split(" ");

        personDto.setFirstName(splitString[0]);

        String lastName = "";

        for(int i = 1; i < splitString.length; i++) lastName += splitString[i];

        if(! lastName.equals("")) personDto.setLastName(lastName);

        return personDto;
    }
}
