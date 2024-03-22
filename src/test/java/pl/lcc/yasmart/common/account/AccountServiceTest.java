package pl.lcc.yasmart.common.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import pl.lcc.yasmart.common.account.AccountService;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("prod")
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
        assertThat(result.getName()).isEqualTo("user");
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