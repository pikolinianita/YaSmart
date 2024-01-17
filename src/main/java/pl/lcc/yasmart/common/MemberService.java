package pl.lcc.yasmart.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
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
        System.out.println("Here Principal: " + (auth==null? null : auth.getName()));
        this.memberRepository = memberRepository;
        memberDetails = memberRepository.findByName(auth.getName());
    }

    Member getDetails(){
        return memberDetails;
    }
}
