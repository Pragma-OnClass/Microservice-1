package com.example.On_class.domain.api.usecase;

import com.example.On_class.domain.api.ITechnologyServicePort;
import com.example.On_class.domain.model.Technology;
import com.example.On_class.domain.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TechnologyUseCaseTest {
    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;

    private ITechnologyServicePort technologyServicePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        technologyServicePort = new TechnologyUseCase(technologyPersistencePort);
    }

    @Test
    void testSaveTechnology() {

        Technology technology = new Technology(2L,"Java","Programing Language");

        technologyServicePort.saveTechnology(technology);

        verify(technologyPersistencePort, times(1)).saveTechnology(technology);
    }
}