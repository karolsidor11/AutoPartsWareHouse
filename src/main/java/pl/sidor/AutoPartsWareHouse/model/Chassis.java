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
@Table(name = "Chassis")
public class Chassis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Drive")
    private String drive;

    @Column(name = "Brakes")
    private String brakes;

    @Column(name = "Suspension")
    private String suspension;

    @Column(name = "Steering")
    private String steering;

}
