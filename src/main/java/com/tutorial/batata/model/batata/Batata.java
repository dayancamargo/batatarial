package com.tutorial.batata.model.batata;

import com.tutorial.batata.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
            this.name = dto.getName();
            this.type = dto.getType();
            this.dtUpdate = new Date();
        }
    }
}
