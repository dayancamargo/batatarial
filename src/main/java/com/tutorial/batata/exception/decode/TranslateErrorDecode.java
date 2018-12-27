package com.tutorial.batata.exception.decode;

import com.tutorial.batata.exception.BaseException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.util.Objects;

public class TranslateErrorDecode implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() >= 400 && response.status() <= 499) {
            return new BaseException(Objects.toString(response.status()),
                    response.body().toString(),
                    response.reason()
            );
        }

        return new BaseException(methodKey, response.reason());
    }
}
