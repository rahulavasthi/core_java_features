package designPatterns;

/**
 * Use this pattern if the initialization of the class is expensive and it cannot be done safely at class-loading time and the initialization is concurrent. 
 *
 */
public class LazySingletonThreadSafeWithoutSynchronized {
	private LazySingletonThreadSafeWithoutSynchronized() {
    }
 
    private static class HoldInstance {
        private static final LazySingletonThreadSafeWithoutSynchronized INSTANCE = new LazySingletonThreadSafeWithoutSynchronized();
    }
 
    public static LazySingletonThreadSafeWithoutSynchronized getInstance() {
        return HoldInstance.INSTANCE;
    }
}
