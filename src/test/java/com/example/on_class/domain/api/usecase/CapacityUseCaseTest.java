package com.example.on_class.domain.api.usecase;

import com.example.on_class.domain.api.ICapacityServicePort;
import com.example.on_class.domain.exception.RepeatCapacitiesInListException;
import com.example.on_class.domain.exception.RepeatTechnologiesInListException;
import com.example.on_class.domain.model.Capacity;
import com.example.on_class.domain.model.Technology;
import com.example.on_class.domain.spi.ICapacityPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CapacityUseCaseTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();
    @Mock
    private ICapacityPersistencePort capacityPersistencePort;
    private ICapacityServicePort capacityServicePort;
    private CapacityUseCase capacityUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        capacityServicePort = new CapacityUseCase(capacityPersistencePort);
        capacityUseCase = new CapacityUseCase(capacityPersistencePort);
    }

    @Test
    void testSaveCapacity() {
        List<Technology> technologies = new ArrayList<>();
        technologies.add(new Technology(1L, "Java", "Programming Language" ));

        Capacity capacity = new Capacity(1L, "Proof1", "Fronted", technologies);

        capacityServicePort.saveCapacity(capacity);

        verify(capacityPersistencePort, times(1)).saveCapacity(capacity);
    }

    @Test
    void testValidationRepeatTechnology() {
        List<Technology> technologies = new ArrayList<>();
        technologies.add(new Technology(1L, "Java", "Programming Language"));
        technologies.add(new Technology(1L, "Java", "Programming Language"));

        Capacity capacity = new Capacity(1L, "Proof1", "Proof description", technologies);

        assertThrows(RepeatTechnologiesInListException.class, () -> capacityUseCase.saveCapacity(capacity));
        verify(capacityPersistencePort, times(0)).saveCapacity(capacity);
    }

    @Test
    void testGetAllCapacities(){
        List<Technology> technologies = new ArrayList<>();
        technologies.add(new Technology(2L,"Java","Programing Language"));
        technologies.add(new Technology(3L,"Python","Programming Language"));

        List<Capacity> expectedCapacityList = new ArrayList<>();
        expectedCapacityList.add(new Capacity(1L,"Proof1","Proof description", technologies));
        expectedCapacityList.add(new Capacity(2L,"Proof2","Proof description", technologies));

        when(capacityPersistencePort.getAllCapacities(1,10,true,true)).thenReturn(expectedCapacityList);

        List<Capacity> actualCapacityList = capacityServicePort.getAllCapacities(1,10,true,true);

        assertEquals(expectedCapacityList, actualCapacityList);
    }
}