package ryskal.nikita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ryskal.nikita.models.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

}
