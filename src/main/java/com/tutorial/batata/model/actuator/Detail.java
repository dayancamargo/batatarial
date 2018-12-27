package com.tutorial.batata.model.actuator;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Detail extends BaseModel {

    private DiskSpace diskSpace;
}
