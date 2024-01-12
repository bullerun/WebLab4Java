package ryskal.nikita.repositories;

import org.springframework.data.repository.CrudRepository;
import ryskal.nikita.models.Point;

public interface PointRepository extends CrudRepository<Point, Long> {
}
