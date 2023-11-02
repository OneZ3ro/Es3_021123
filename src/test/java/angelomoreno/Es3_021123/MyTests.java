package angelomoreno.Es3_021123;

import angelomoreno.Es3_021123.entities.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertSame;

@Slf4j
public class MyTests {
    static Pizza pizza;
    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void beforeAll() {
        log.info("Before all");
        ctx = new AnnotationConfigApplicationContext(Es3021123Application.class);
        pizza = (Pizza) ctx.getBean("margherita");
    }

    @AfterAll
    static void afterAll() {
        log.info("After all");
        ctx.close();
    }

    @Test
    void testMargherita() {
        Pizza margherita = (Pizza) ctx.getBean("margherita");
        System.out.println("Pizza aspettata" + pizza);
        System.out.println("Pizza arrivata" + margherita);
        assertSame(pizza, margherita);
    }
}
