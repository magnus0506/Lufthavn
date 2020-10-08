package com.example.lufthavn.service;

import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.repository.ArrDepRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ArrDepServiceTest {

    @InjectMocks
    ArrDepService arrDepService;

    @MockBean
    ArrDepRepository mockedArrDepRepository;

    @BeforeEach
    void setUp(){
        ArrDep arrDep = new ArrDep();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void savePass() {
        ArrDep arrDep = new ArrDep();
        arrDep.setId(1L);
        Mockito.when(mockedArrDepRepository.save(arrDep)).thenReturn(arrDep);
        arrDepService.save(arrDep);
        assertEquals(1,arrDep.getId());
        Mockito.verify(mockedArrDepRepository).save(arrDep);
    }

    @Test
    void saveFail() {
        ArrDep arrDep = new ArrDep();
        arrDep.setId(1L);
        Mockito.when(mockedArrDepRepository.save(arrDep)).thenReturn(arrDep);
        arrDepService.save(arrDep);
        assertNotEquals(5,arrDep.getId());
        Mockito.verify(mockedArrDepRepository).save(arrDep);
    }
    @Test
    void get() {
        long ID = 2L;
        ArrDep arrDep = new ArrDep();
        arrDep.setId(ID);
        Mockito.when(arrDepService.findById(ID)).thenReturn(arrDep);
        assertEquals(2, arrDep.getId());
        Mockito.verify(mockedArrDepRepository).findById(ID);
    }
}

