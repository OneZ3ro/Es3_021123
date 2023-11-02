package angelomoreno.Es3_021123.entities;

import angelomoreno.Es3_021123.enums.StatoTavolo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component("tavolo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tavolo {
    private int id;
    private int numCopertiMax;
    private StatoTavolo statoTavolo;
}
