package ryskal.nikita.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ryskal.nikita.models.Point;
import ryskal.nikita.repositories.PointRepository;
import ryskal.nikita.requsts.AddPointRequest;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PointService {
    private final PointRepository pointRepository;
    public List<Point> addPointToDB(AddPointRequest addPointRequest) {
        Point point = Point.builder()
                .x(addPointRequest.getX())
                .y(addPointRequest.getY())
                .r(addPointRequest.getR())
                .result(addPointRequest.isResult())
                .build();
        pointRepository.save(point);
        return pointRepository.findAll();
    }
}
