package comr.dongs.jaetebot.application.member

import comr.dongs.jaetebot.domain.member.Member
import comr.dongs.jaetebot.domain.member.MemberRepository
import jakarta.annotation.PostConstruct
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberApplicationService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun login(username: String, password: String) {
        val member = memberRepository.findByUsername(username)
            .orElseThrow { throw UsernameNotFoundException("사용자를 찾을 수 없습니다: $username") }

        if (!passwordEncoder.matches(password, member.password)) {
            throw BadCredentialsException("비밀번호가 일치하지 않습니다")
        }
    }
}