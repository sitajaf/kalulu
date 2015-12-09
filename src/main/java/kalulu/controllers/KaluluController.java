package kalulu.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class KaluluController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, Kalulu!";
    }


}
