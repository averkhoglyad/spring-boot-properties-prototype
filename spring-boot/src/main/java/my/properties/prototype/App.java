package my.properties.prototype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:extra.properties")
public class App {

    public App(@Value("${foo}") String foo,
               @Value("${bar}") String bar,
               @Value("${extra:-}") String extra,
               @Value("${imported:-}") String imported,
               @Value("${my.app.custom.foo:-}") String confTreeFoo,
               @Value("${my.app.custom.bar:-}") String confTreeBar) {
        System.out.println("Foo: " + foo);
        System.out.println("Bar: " + bar);
        System.out.println("Extra: " + extra);
        System.out.println("Imported: " + imported);
        System.out.println("Config Tree Foo: " + confTreeFoo);
        System.out.println("Config Tree Bar: " + confTreeBar);
    }

    public static void main(String[] args) {
        var app = SpringApplication.run(App.class, args);
        app.getBean(Test.class).test();
    }

}
