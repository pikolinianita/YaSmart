package pl.lcc.yasmart.common.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lcc.yasmart.common.tag.TagService;

@SpringBootTest
class TagServiceTest {

    @Autowired
    private TagService tagService;

//    @Test
//    void tesingService(){
//     //Given
//     var tag = new Tag(null, "first","user");
//     //When
//     var result = tagService.createTag(tag);
//     //Then
//
//     System.out.println(result);
//    }

}