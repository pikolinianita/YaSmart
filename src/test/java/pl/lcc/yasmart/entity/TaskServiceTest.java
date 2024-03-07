package pl.lcc.yasmart.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lcc.yasmart.common.account.AccountRepository;
import pl.lcc.yasmart.common.loader.DataPreLoader;
import pl.lcc.yasmart.common.tag.TagRepository;

import java.util.List;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    DataPreLoader dataLoader;

    @Autowired
    TaskService taskService;

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void resetDb() throws Exception {
        dataLoader
                .clean()
                .run();

    }

    @Test
    void getTask(){
     //Given
        List<Task> target = taskRepository.findListAll();
        System.out.println(target.toString());
        var ch01 = target.stream().filter(t -> t.getName().equals("Ch01")).findFirst().get();
     //When
        var response = taskService.getTask( accountRepository.findByName("user"),ch01.getId());
     //Then
        System.out.println("out");
        System.out.println(response.toString());
    }

    @Test
    void createTask(){
     //Given

     //When

     //Then

    }

}