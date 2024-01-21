package ryskal.nikita.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "point")
public class Point implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_id_seq")
    @SequenceGenerator(name = "point_id_seq", sequenceName = "point_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "x", nullable = false)
    private float x;
    @Column(name = "y", nullable = false)
    private float y;
    @Column(name = "r", nullable = false)
    private int r;
    @Column(name = "result", nullable = false)
    private boolean result;

    public Point(float x, float y, int r, boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = isHit;
    }

    public Point(float x, float y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = isHit();
    }


    public boolean isHit() {
        return checkSquare() || checkCircle() || checkTriangle();
    }

    private boolean checkTriangle() {
        return 0 <= x && x <= (float) r / 2 && (float) -r / 2 <= y && y <= 0 && Math.abs(y) + x <= (float) r / 2;
    }

    private boolean checkCircle() {
        return x * x + y * y <= r * r && -r <= x && x <= 0 && 0 >= y && y >= -r;
    }

    private boolean checkSquare() {
        return -r <= x && x <= 0 && 0 <= y && y <= r;
    }

}
