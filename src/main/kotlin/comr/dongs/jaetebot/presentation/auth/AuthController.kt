package comr.dongs.jaetebot.presentation.auth

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/auth")
class AuthController {
    
    /**
     * GET /auth/login - 로그인 페이지 표시
     * POST /auth/login은 Spring Security가 자동으로 처리
     */
    @GetMapping("/login")
    fun loginPage(
        @RequestParam(required = false) error: String?,
        @RequestParam(required = false) logout: String?,
        model: Model
    ): String {
        if (error != null) {
            model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.")
        }
        
        if (logout != null) {
            model.addAttribute("message", "로그아웃되었습니다.")
        }
        
        return "login"
    }
}
