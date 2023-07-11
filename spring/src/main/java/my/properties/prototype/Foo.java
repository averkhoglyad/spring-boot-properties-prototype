package my.properties.prototype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("foo")
public class Foo implements Test {

    @Value("${foo}") String value;

    @Override
    public void test() {
        System.out.println("Calling bean: " + getClass().getSimpleName());
        System.out.println("Value=" + value);
    }

}
