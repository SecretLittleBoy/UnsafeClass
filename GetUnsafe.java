import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class GetUnsafe {
    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }   
}