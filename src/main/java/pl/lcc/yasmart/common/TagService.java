package pl.lcc.yasmart.common;

import org.springframework.stereotype.Service;

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
