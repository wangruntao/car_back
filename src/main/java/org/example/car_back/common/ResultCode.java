package org.example.car_back.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using = ResultCode.ResultCodeSerializer.class)
public enum ResultCode {
    success(0),
    system_error(-1),
    network_failed(-2);
    private final int code;

    ResultCode(int code){
        this.code = code;
    }

    public boolean isSuccess(){
        return this.code >= 0;
    }

    public static class ResultCodeSerializer extends JsonSerializer<ResultCode> {
        @Override
        public void serialize(ResultCode resultCode, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeNumberField("code", resultCode.code);
            gen.writeStringField("message", resultCode.name());
            gen.writeEndObject();
        }
    }
}
