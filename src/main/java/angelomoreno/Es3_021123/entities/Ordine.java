package angelomoreno.Es3_021123.entities;

import angelomoreno.Es3_021123.enums.StatoOrdine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@PropertySource("application.properties")
public class Ordine {
    private int id;
    private Tavolo tavolo;
    private List<Product> elementi;
    private StatoOrdine statoOrdine;
    private int numCoperti;
    private LocalDate oraDiAcquisizione;
    private double costoCoperti;
    private double totale;

    public Ordine(@Value("${costo.coperti}") double costoCoperti) {
        this.costoCoperti = costoCoperti;
    }

    public Ordine(int id, Tavolo tavolo, List<Product> elementi, StatoOrdine statoOrdine, int numCoperti, LocalDate oraDiAcquisizione) {
        this.id = id;
        this.tavolo = tavolo;
        this.elementi = elementi;
        this.statoOrdine = statoOrdine;
        this.numCoperti = numCoperti;
        this.oraDiAcquisizione = oraDiAcquisizione;
    }

    public void faiOrdine() {
        double tot = 0;
        for (int i = 0; i < this.elementi.size(); i++) {
            tot += this.elementi.get(i).getPrezzo();
        }
        this.totale = tot + this.costoCoperti;
        System.out.println("Il tuo ordine è stato effettuato, ecco la ricevuta:");
        this.elementi.forEach(System.out::println);
        System.out.println("Il totale è: " + (tot + this.costoCoperti) + "$");
    }
}
