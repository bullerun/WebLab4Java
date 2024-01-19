package ryskal.nikita.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ryskal.nikita.models.Point;
import ryskal.nikita.repositories.PointRepository;


@Controller
public class MainController {
    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Point> points = pointRepository.findAll();
        model.addAttribute("points", points);
        return "index";
    }
}
