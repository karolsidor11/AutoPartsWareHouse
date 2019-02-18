package pl.sidor.AutoPartsWareHouse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Nadwozie")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Typ")
    private String bodyCar;

    @Column(name = "Kolor")
    private String color;

    @Column(name = "Ilość_drzwi")
    private int door;

}
