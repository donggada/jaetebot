package comr.dongs.jaetebot.presentation.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    
    @GetMapping("/")
    fun home(): String {
        return "index"
    }
    
    @GetMapping("/dashboard")
    fun dashboard(): String {
        return "dashboard"
    }
}
