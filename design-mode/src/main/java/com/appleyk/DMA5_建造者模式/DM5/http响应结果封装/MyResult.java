package com.appleyk.DMA5_建造者模式.DM5.http响应结果封装;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * <p>封装data、status、message和时间戳timestamp</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on  下午10:17 2022/10/29
 */
@Data
public class MyResult {

    String message;
    int status = 200;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8" )
    private Date timestamp;

    public MyResult(MyResult.Builder builder){
        this.data = builder.data;
        this.message = builder.message;
        this.status = builder.status;
        this.timestamp = new Date();
    }


    public static class Builder{
        String message;
        int status = 200;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object data;
        public MyResult.Builder message(String message){
            this.message = message;
            return this;
        }
        public MyResult.Builder data(Object data){
            this.data = data;
            return this;
        }
        public MyResult.Builder status(int status){
            this.status = status;
            return this;
        }
        public MyResult build(){
            return new MyResult(this);
        }
    }
}
