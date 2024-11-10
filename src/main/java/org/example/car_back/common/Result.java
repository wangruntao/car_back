package org.example.car_back.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 5547831456391117748L;
    private ResultCode resultCode;
    private String memo;
    private T target;

    private Result(ResultCode resultCode, String memo, T target) {
        this.resultCode = resultCode;
        this.memo = memo;
        this.target = target;
    }

    public boolean isSuccess(){
        return resultCode.isSuccess();
    }

    public static <T> Result<T> buildResult(ResultCode resultCode, String memo, T target){
        return new Result<>(resultCode, memo, target);
    }
    public static <T> Result<T> buildResult(ResultCode resultCode, T target){
        return new Result<>(resultCode, null, target);
    }
    public static <T> Result<T> buildResult(ResultCode resultCode, String memo){
        return new Result<>(resultCode, memo, null);
    }
    public static <T> Result<T> buildResult(ResultCode resultCode){
        return new Result<>(resultCode, null, null);
    }

    public static <T> Result<T> buildSuccessResult(T target){
        return new Result<>(ResultCode.success,null, target);
    }
}
