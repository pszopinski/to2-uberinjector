package singleton_test;

import org.junit.Test;
import uberinjector.InjectorException;
import uberinjector.Singleton;
import uberinjector.UberInjector;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void testUnboundSingleton() throws InjectorException {
        UberInjector injector = new UberInjector();
        SingletonClass a = injector.getInstance(SingletonClass.class);
        SingletonClass b = injector.getInstance(SingletonClass.class);
        assertEquals(a, b);
    }

    @Test
    public void testBoundSingleton() throws InjectorException {
        UberInjector injector = new UberInjector();
        injector.bind(SomeInterface.class, SingletonClass.class);
        SomeInterface a = injector.getInstance(SomeInterface.class);
        SomeInterface b = injector.getInstance(SomeInterface.class);
        assertEquals(a, b);
    }

    @Test
    public void testBoundEagerSingleton() throws InjectorException {
        UberInjector injector = new UberInjector();
        injector.bind(SomeInterface.class, EagerSingletonClass.class);
        SomeInterface a = injector.getInstance(SomeInterface.class);
        SomeInterface b = injector.getInstance(SomeInterface.class);
        assertEquals(a, b);
    }

    @Test
    public void testSingletonInjection() throws InjectorException {
        UberInjector injector = new UberInjector();
        SingletonUser u1 = injector.getInstance(SingletonUser.class);
        SingletonUser u2 = injector.getInstance(SingletonUser.class);
        assertEquals(u1.singleton, u2.singleton);
    }
}
