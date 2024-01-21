package pl.lcc.yasmart.common;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.security.Principal;

@Component
@SessionScope
public class MemberService {

    private final MemberRepository memberRepository;
    Member memberDetails;

    public MemberService(MemberRepository memberRepository) {
       var auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth==null){
           throw new RuntimeException("Member service: User not Authenticated");
       }
        System.out.println("Here Principal: " + auth.getName());
        this.memberRepository = memberRepository;
        memberDetails = memberRepository.findByName(auth.getName());
    }

    Member getDetails(){
        return memberDetails;
    }
}
