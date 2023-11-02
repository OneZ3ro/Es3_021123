package angelomoreno.Es3_021123;

import angelomoreno.Es3_021123.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
    static Menu menu;
    private static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void beforeAll() {
        log.info("Before all");
        ctx = new AnnotationConfigApplicationContext(Es3021123Application.class);
        pizza = (Pizza) ctx.getBean("margherita");
        drink = (Drink) ctx.getBean("limonata");
        topping = (Topping) ctx.getBean("formaggio");
        productList = (List<Product>) ctx.getBean("getElementiOrdine");
        menu = (Menu) ctx.getBean("menu");
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

    @ParameterizedTest
    @ValueSource(strings = {"margherita", "odiolitalia", "salume"})
    void testConParametri(String str) {
        List<Pizza> pizze = menu.getPizze().stream().filter(pizza1 -> pizza1.getNome().equals(str)).toList();
        assertEquals(str, pizze.get(0).getNome());
    }
}
