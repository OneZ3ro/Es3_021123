package angelomoreno.Es3_021123.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Drink extends Product {
    private double litri;
    private int grado;

    public Drink(String name, int calorie, double prezzo, double litri) {
        super(name, calorie, prezzo);
        this.litri = litri;
    }

    public Drink(String name, int calorie, double prezzo, double litri, int grado) {
        this(name, calorie, prezzo, litri);
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Bevande= " +
                super.toString() +
                ", litri:  " + litri +
                ", grado: " + grado;
    }
}
