package angelomoreno.Es3_021123.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Menu {
    private List<Pizza> pizze;
    private List<Topping> aggiunte;
    private List<Drink> bevande;

    @Override
    public String toString() {
        System.out.println("\n---------- PIZZE ---------- PIZZE ---------- PIZZE ---------- PIZZE ---------- PIZZE ---------- PIZZE ----------");
        pizze.forEach(System.out::println);
        System.out.println();
        System.out.println("---------- AGGIUNTE ---------- AGGIUNTE ---------- AGGIUNTE ---------- AGGIUNTE ---------- AGGIUNTE ----------");
        aggiunte.forEach(System.out::println);
        System.out.println();
        System.out.println("---------- BEVANDE ---------- BEVANDE ---------- BEVANDE ---------- BEVANDE ---------- BEVANDE ----------");
        bevande.forEach(System.out::println);
        return "";
//        return "Menu{" +
//                "pizze=" + pizze +
//                ", aggiunte=" + aggiunte +
//                ", bevande=" + bevande +
//                '}';
    }
}
