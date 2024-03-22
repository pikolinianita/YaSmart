package pl.lcc.yasmart.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lcc.yasmart.common.account.AccountRepository;
import pl.lcc.yasmart.entity.sprint.SprintService;

@SpringBootTest
class SprintServiceTest {

    @Autowired
    SprintService service;

    @Autowired
    AccountRepository accRepo;

    @Test
    void projectSummaryDTOTest(){
     //Given

     //When
     var result = service.getAllProjectsSummary( accRepo.findByName("user"));

     //Then
        System.out.println(result);

    }

    @Test
    void projectGetAllTest(){
        //Given

        //When
        var result = service.getAllProjects( accRepo.findByName("user"));

        //Then
        System.out.println(result);

    }

}