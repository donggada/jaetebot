package comr.dongs.jaetebot.infrastructure.config

import comr.dongs.jaetebot.domain.member.Member
import comr.dongs.jaetebot.domain.member.MemberRepository
import comr.dongs.jaetebot.domain.member.MemberRole
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

//@Configuration
class DataInitializer {
    
//    @Bean
    fun initTestData(
        memberRepository: MemberRepository,
        passwordEncoder: PasswordEncoder
    ) = CommandLineRunner {
        // 테스트 일반 사용자 계정
        if (memberRepository.findByUsername("test").isEmpty) {
            memberRepository.save(
                Member(
                    username = "test",
                    password = passwordEncoder.encode("test1234"),
                    email = "test@jaetebot.com",
                    role = MemberRole.USER
                )
            )
            println("✅ 테스트 사용자 계정 생성: test / test1234")
        }
        
        // 테스트 관리자 계정
        if (memberRepository.findByUsername("admin").isEmpty) {
            memberRepository.save(
                Member(
                    username = "admin",
                    password = passwordEncoder.encode("admin1234"),
                    email = "admin@jaetebot.com",
                    role = MemberRole.ADMIN
                )
            )
            println("✅ 관리자 계정 생성: admin / admin1234")
        }
    }
}
