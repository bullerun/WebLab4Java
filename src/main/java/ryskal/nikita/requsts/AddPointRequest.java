package ryskal.nikita.requsts;

import lombok.Data;

@Data
public class AddPointRequest {
    private int x;
    private int y;
    private int r;
    private boolean result;
}
