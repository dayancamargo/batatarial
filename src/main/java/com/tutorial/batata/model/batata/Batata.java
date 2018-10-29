package com.tutorial.batata.model.batata;

import com.tutorial.batata.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
