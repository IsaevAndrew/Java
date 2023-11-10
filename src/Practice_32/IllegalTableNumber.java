package Practice_32;

import java.io.Serializable;
public class IllegalTableNumber extends RuntimeException implements Serializable {
    public IllegalTableNumber() {
        super("Неправильный номер");
    }
}
