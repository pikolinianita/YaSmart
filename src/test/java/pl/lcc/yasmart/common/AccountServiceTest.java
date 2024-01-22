package pl.lcc.yasmart.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @WithMockUser(username="user")
    @Test
    void initTest(){
     //Given username = user

     //When
     var result = accountService.getDetails();

     //Then
        assertThat(result.name).isEqualTo("user");
    }

    @Test
    void UnauthenticatedInitTest(){
        //Given init

        //When
       assertThatThrownBy(()-> accountService.getDetails())
       //Then
               .hasMessageContaining("No Account Details available");
    }

}