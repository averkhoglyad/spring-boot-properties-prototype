package my.properties.prototype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class App {

    public App(@Value("${foo}") String foo,
               @Value("${bar}") String bar) {
        System.out.println("Foo: " + foo);
        System.out.println("Bar: " + bar);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
