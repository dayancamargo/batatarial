package com.tutorial.batata.model.translate;

import com.tutorial.batata.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TranslateResponse {

    @Getter @Setter @NoArgsConstructor
    class Content extends BaseModel {
        private String translated;
        private String text;
        private String translation;
    }

    private Content contents;
}
