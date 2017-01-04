package simple_binding_test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import uberinjector.InjectorException;
import uberinjector.UberInjector;
import tests_helper_classes.*;

import static org.junit.Assert.assertEquals;

public class SimpleMultipleBindingsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private UberInjector injector = new UberInjector();

    @Test
    public void testRedSquare() throws InjectorException {
        injector.bind(Color.class, Red.class);
        injector.bind(Shape.class, Square.class);
        Figure figure = injector.getInstance(Figure.class);
        assertEquals("I'm a red square.", figure.getDescription());
    }

    @Test
    public void testGreenCircle() throws InjectorException {
        injector.bind(Color.class, Green.class);
        injector.bind(Shape.class, Circle.class);
        Figure figure = injector.getInstance(Figure.class);
        assertEquals("I'm a green circle.", figure.getDescription());
    }

    @Test
    public void testMissingBindings() throws InjectorException {
        thrown.expect(InjectorException.class);
        thrown.expectMessage("Cannot instantiate tests_helper_classes.Color");
        Figure figure = injector.getInstance(Figure.class);
    }

}
