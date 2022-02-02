package me.manylove.mapstructexem.p03_defining_a_mapper.s_3_3_adding_custom_methods_to_mappers;

import me.manylove.mapstructexem.p03_defining_a_mapper.s_3_1_basic_mappings.SampleMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("3.3 특정 매핑을 수동으로 구현해야 하는 경우")
class CarMapperTest {

    @Test
    @DisplayName("default 메소드로 구현")
    void carMapper1(){
        //given
        Car car = new Car("Hyundai", 4, CarType.SEDAN,
                new Person("권 다애 ", 36));
        //when
        CarDto carDto = CarMapper1.INSTANCE.carToCarDto(car);

        //then
        assertThat(carDto.getMake()).isEqualTo(car.getMake());
        assertThat(carDto.getOwner().getAge()).isEqualTo(car.getOwner().getAge());
        assertThat(carDto.getOwner().getFirstName()).isEqualTo("권");
        assertThat(carDto.getOwner().getLastName()).isEqualTo("다애");


    }

    @Test
    @DisplayName("추상 클래스로 구현")
    void carMapper2(){
        //given
        Car car = new Car("Hyundai", 4, CarType.SEDAN,
                new Person("권 다 애", 36));

        //when
        CarDto carDto = CarMapper2.INSTANCE.carToCarDto(car);

        //then
        assertThat(carDto.getMake()).isEqualTo(car.getMake());
        assertThat(carDto.getOwner().getAge()).isEqualTo(car.getOwner().getAge());
        assertThat(carDto.getOwner().getFirstName()).isEqualTo("권");
        assertThat(carDto.getOwner().getLastName()).isEqualTo("다애");

    }
}