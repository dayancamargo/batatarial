package com.tutorial.batata.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Class to make a http body response
 * @param <B> Body object,  it will be a 'data' element with some fields (B) or a list of errors;
 * @param <M> Meta object, it will contain a 'meta" element with some information (M);
 *
 */
@Getter
public class Response <B, M> extends BaseModel {
    private final List<B> data;
    private final List<Error> errors;
    private final M meta;

    public static ContentStep build(){
        return new ContentBuilder();
    }

    private Response(ContentBuilder builder){
        this.data   = builder.data;
        this.errors = builder.errors;
        this.meta   = (Objects.nonNull(builder.meta) ?  (M) builder.meta : null);
    }

    public interface ContentStep<B> {
        Build withoutContent();
        MetaStep withBody(B body);
        MetaStep withErrors(Error... errors);
    }

    public interface MetaStep<M> {
        Build withMeta(@NotNull M meta);
        Response create();
    }

    public interface Build  {
        Response create();
    }

    private static class ContentBuilder<B, M> implements ContentStep<B>, MetaStep<M>, Build {
        private List<B> data;
        private List<Error> errors;
        private M meta;

        public Build withoutContent() {
            this.data   = null;
            this.errors = null;
            this.meta   = null;
            return  this;
        }

        public MetaStep withBody(@NotNull B body){
            data =  new ArrayList<>();

            if(body instanceof List) {
                data.addAll((List)body);
            } else {
                data.add(body);
            }

            return this;
        }

        public MetaStep withErrors(@NotNull Error... errors){
            data = null;
            this.errors = Arrays.asList(errors);
            return this;
        }

        public Build withMeta(@NotNull M meta) {
            this.meta = meta;
            return this;
        }

        public Response create() {
            return new Response(this);
        }
    }
}