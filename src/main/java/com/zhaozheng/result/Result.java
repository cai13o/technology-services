package com.zhaozheng.result;


import com.zhaozheng.enums.ResultCodeEnum;
import com.zhaozheng.utils.AESUtil;
import com.zhaozheng.utils.FastJsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "统一返回数据格式")
public class Result<T> {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private String code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data ;

    private Result(){}


    public static Result error(){
        Result r = new Result();
        r.setCode(ResultCodeEnum.UNKNOW_REASON.getCode());
        r.setSuccess(ResultCodeEnum.UNKNOW_REASON.getStatus());
        r.setMessage(ResultCodeEnum.UNKNOW_REASON.getMessage());
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum, Object data){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        r.setData(data);
        return r;
    }

    public static Result okApp(ResultCodeEnum codeEnum, Object data) throws Exception {
        String content = FastJsonUtil.objToJSON(data);
        String Key = AESUtil.getAESKey();
        String strEncrypt = AESUtil.aesEncrypt(content, Key);
        System.out.println("*********加密后：" + strEncrypt);
        String strDncrypt = AESUtil.aesDecrypt(strEncrypt, Key);
        System.out.println("*********解密后：" + strDncrypt);

        System.out.println("Key:" + Key);
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        // r.setMessage(codeEnum.getMessage());
        r.setMessage(Key); // 密钥
        r.setData(strEncrypt);
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }


    public static Result error(ResultCodeEnum codeEnum){
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public Result data(T data){
        this.setData(data);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(String code){
        this.setCode(code);
        return this;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

}
