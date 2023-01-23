package com.tutorial.batata.model.batata;

import com.tutorial.batata.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Batata extends BaseModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String type;

    @Column(name = "last_modification") @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date dtUpdate;

    public Batata(BatataDto dto) {
        if(dto != null) {
            this.name = dto.name();
            this.type = dto.type();
            this.dtUpdate = new Date();
        }
    }
}
