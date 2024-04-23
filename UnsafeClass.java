import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class UnsafeClass {
    private void staticTest() throws Exception {
        // 通过反射获取Unsafe类
        Unsafe unsafe = GetUnsafe.reflectGetUnsafe();
        
        
        // 可以用下面的语句触发类初始化
        // 1.
        // unsafe.ensureClassInitialized(User.class);
        // 2.
        // System.out.println(User.name);
        // 3.
        User user = new User();

        System.out.println(unsafe.shouldBeInitialized(User.class));
        Field sexField = User.class.getDeclaredField("name");
        long fieldOffset = unsafe.staticFieldOffset(sexField);
        Object fieldBase = unsafe.staticFieldBase(sexField);
        Object object = unsafe.getObject(fieldBase, fieldOffset);
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        UnsafeClass unsafeClass = new UnsafeClass();
        unsafeClass.staticTest();
    }
}


