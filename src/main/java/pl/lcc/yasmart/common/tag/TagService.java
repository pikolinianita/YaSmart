package pl.lcc.yasmart.common.tag;

import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.tag.Tag;
import pl.lcc.yasmart.common.tag.TagRepository;

@Service
public class TagService {


    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    Tag createTag(Tag tag){
            tagRepository.save(tag);
            return tag;
    }

}
