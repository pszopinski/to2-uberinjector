package named_test;

import uberinjector.Named;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Named
public @interface Hanukkah {
}
