package com.wyg.webmvc.bean;

import com.wyg.webmvc.bean.myEnum.ExceptionCommonEnum;
import com.wyg.webmvc.config.myException.BaseErrorInfoInterface;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultBody<T> {
    /**
     * 响应代码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应结果
     */
    private T data;

    public ResultBody(BaseErrorInfoInterface error){
        this.code = error.getResultCode();
        this.message = error.getResultMsg();
    }

    /**
     * 成功
     *
     * @return ResultBody
     */
    public static ResultBody<Object> success(){
        return success(null);
    }

    /**
     * 成功
     *
     * @param data data
     * @return ResultBody
     */
    public static ResultBody<Object> success(Object data) {
        ResultBody<Object> rb = new ResultBody<>();
        rb.setCode(ExceptionCommonEnum.SUCCESS.getResultCode());
        rb.setMessage(ExceptionCommonEnum.SUCCESS.getResultMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     *
     * @param exception exception
     * @return ResultBody
     */
    public static ResultBody<Object> fail(BaseErrorInfoInterface exception){
        ResultBody<Object> rb = new ResultBody<>();
        rb.setCode(exception.getResultCode());
        rb.setMessage(exception.getResultMsg());
        return rb;
    }

    /**
     * 失败
     *
     * @param code code
     * @param message message
     * @return ResultBody
     */
    public static ResultBody<Object> fail(int code, String message){
        ResultBody<Object> rb = new ResultBody<>();
        rb.setCode(code);
        rb.setMessage(message);
        return rb;
    }

    /**
     * 失败
     *
     * @param message message
     * @return ResultBody
     */
    public static ResultBody<Object> fail(String message){
        ResultBody<Object> rb = new ResultBody<>();
        rb.setCode(-1);
        rb.setMessage(message);
        return rb;
    }
}
