package com.spring.course.api.core;

@Configuration
public class ModelMapperConfig {

    @Bean // indica que esse metodo vai ser usado para injecao de dependencia em outras classes
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}