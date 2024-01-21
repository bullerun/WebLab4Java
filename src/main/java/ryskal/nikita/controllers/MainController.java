package ryskal.nikita.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ryskal.nikita.models.Point;
import ryskal.nikita.requsts.AddPointRequest;
import ryskal.nikita.services.PointService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {
    private final PointService pointService;

    @PostMapping("/addpoint")
    public ResponseEntity<List<Point>> addpoint(@RequestBody AddPointRequest addPointRequest) {
        System.out.println(addPointRequest);
        return ResponseEntity.ok(pointService.addPointToDB(addPointRequest));
    }
}
