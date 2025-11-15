package comr.dongs.jaetebot.application.auth

import comr.dongs.jaetebot.domain.member.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val memberRepository: MemberRepository
) : UserDetailsService {
    
    /**
     * Spring Security가 POST /auth/login 요청 시 이 메서드를 자동 호출
     * 1. DB에서 사용자 조회
     * 2. UserDetails 반환 (비밀번호 검증은 Spring Security가 자동 처리)
     */
    override fun loadUserByUsername(username: String): UserDetails {
        return memberRepository.findByUsername(username)
            .orElseThrow { 
                UsernameNotFoundException("사용자를 찾을 수 없습니다: $username") 
            }
    }
}
