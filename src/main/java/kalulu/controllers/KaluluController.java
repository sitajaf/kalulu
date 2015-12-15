package kalulu.controllers;

import org.joda.time.LocalTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class KaluluController {

    @RequestMapping("/")
    public String greeting(Model model) {
        model.addAttribute("time", new LocalTime());
        return "index";
    }


}
