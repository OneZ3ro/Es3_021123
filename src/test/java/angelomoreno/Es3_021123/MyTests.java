package angelomoreno.Es3_021123;

import angelomoreno.Es3_021123.entities.Drink;
import angelomoreno.Es3_021123.entities.Pizza;
import angelomoreno.Es3_021123.entities.Product;
import angelomoreno.Es3_021123.entities.Topping;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class MyTests {
    static Pizza pizza;
    static Drink drink;
    static Topping topping;
    static List<Product> productList;
    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void beforeAll() {
        log.info("Before all");
        ctx = new AnnotationConfigApplicationContext(Es3021123Application.class);
        pizza = (Pizza) ctx.getBean("margherita");
        drink = (Drink) ctx.getBean("limonata");
        topping = (Topping) ctx.getBean("formaggio");
        productList = (List<Product>) ctx.getBean("getElementiOrdine");
    }

    @AfterAll
    static void afterAll() {
        log.info("After all");
        ctx.close();
    }

    @Test
    void testNotNull() {
        assertNotNull(pizza);
    }

    @Test
    void testMargherita() {
        Pizza margherita = (Pizza) ctx.getBean("margherita");
        System.out.println("Pizza aspettata" + pizza);
        System.out.println("Pizza arrivata" + margherita);
        assertSame(pizza, margherita);
    }

    @Test
    void testLimonata() {
        Drink limonata = (Drink) ctx.getBean("limonata");
        System.out.println("Drink aspettato" + drink);
        System.out.println("Drink arrivato" + limonata);
        assertSame(drink, limonata);
    }

    @Test
    void testFormaggio() {
        Topping formaggio = (Topping) ctx.getBean("formaggio");
        System.out.println("Topping aspettato" + topping);
        System.out.println("Topping arrivato" + formaggio);
        assertSame(topping, formaggio);
    }

    @Test
    void testListaOrdine() {
        List<Integer> app = Stream.of(1, 2, 3, 4, 5, 6, 7).toList();
        System.out.println("Lunghezza aspettata" + productList.size());
        System.out.println("Lunghezza arrivata" + app.size());
        assertEquals(productList.size(), app.size());
    }
}
