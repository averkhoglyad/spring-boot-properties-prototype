package my.properties.prototype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@Configuration
@ComponentScan("my.properties.prototype")
@PropertySource("classpath:app.properties")
@PropertySource("file:cfg/app.properties")
@PropertySource(value = "file:~/my-app/cfg/fake.properties", ignoreResourceNotFound = true)
public class App {

    public App(@Value("${foo}") String foo,
               @Value("${bar}") String bar) {
        System.out.println("Foo: " + foo);
        System.out.println("Bar: " + bar);
    }

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "foo");
        var app = new AnnotationConfigApplicationContext(App.class);
        app.getBean(Test.class).test();

        System.out.println(
                "Line separator: " +
                Arrays.toString(app.getEnvironment().getRequiredProperty("line.separator").getBytes())
        );
    }

}

