package pl.lcc.yasmart.dev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CountingTestTest {

    @Autowired
    CountingRepo repo;

  //  @Test
    void countingTest(){

     //Given
     var values = List.<Ct>of(
             new Ct(1L,1L),
             new Ct(2L,2L),
             new Ct(3L,3L),
             new Ct(4L,4L) ) ;
     repo.saveAll(values);
     //When

     //Then

    }
}