package angelomoreno.Es3_021123.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Topping extends Product {
    public Topping(String name, int calorie, double prezzo) {
        super(name, calorie, prezzo);
    }

    @Override
    public String toString() {
        return "Aggiunte= " +
                super.toString();
    }
}
