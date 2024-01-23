package pl.lcc.yasmart.common.tag;

import org.springframework.stereotype.Service;

@Service
public class TagService {


    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    Tag createTag(Tag tag){
            tagRepository.save(tag);
            return tag;
    }

}
