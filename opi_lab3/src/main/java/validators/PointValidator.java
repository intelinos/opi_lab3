package validators;

public class PointValidator {
    public static Boolean isHit(Float x, Float y, Float r){
        if (x <= 0 && y >= 0 && x >= -r / 2 && y <= r) return true;
        if (x <= 0 && y <= 0 && y >= - x / 2 - r / 2) return true;
        if (x >= 0 && y <= 0 && x * x + y * y <= (r / 2) * (r / 2)) return true;
        return false;
    }
}
