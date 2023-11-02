package angelomoreno.Es3_021123.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Pizza extends Product {
    private List<String> ingredienti;

    public Pizza(String name, int calorie, double prezzo, List<String> ingredienti) {
        super(name, calorie, prezzo);
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return "Pizza= " +
                super.toString() +
                ", ingredienti: " + ingredienti;
    }
}
