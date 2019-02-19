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
@Table(name = "Engine")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Capacity")
    private double capacity;

    @Column(name = "Power")
    private int power;

    @Column(name = "Torque")
    private int torque;
}
