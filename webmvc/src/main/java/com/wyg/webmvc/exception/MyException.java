package com.wyg.webmvc.exception;

import com.wyg.webmvc.bean.ResultBody;
import com.wyg.webmvc.enums.ExceptionCommonEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理BaseWygException异常
 */
@ControllerAdvice
public class MyException {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyException.class);

    /**
     * 处理自定义的业务异常
     *
     * @param e 异常
     * @param request request
     * @return ResultBody
     */
    @ExceptionHandler(BaseWygException.class)
    public ResultBody<Object> exceptionHandler(BaseWygException e, HttpServletRequest request) {
        LOGGER.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultBody.fail(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理UserNotExistException的业务异常
     *
     * @param e 异常
     * @param request request
     * @return ResultBody
     */
    @ExceptionHandler(UserNotExistException.class)
    public ResultBody<Object> exceptionHandler(UserNotExistException e, HttpServletRequest request) {
        LOGGER.error("发生用户不存在异常！原因是：", e);
        return ResultBody.fail(ExceptionCommonEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理自定义的业务异常
     *
     * @param e 异常
     * @param request request
     * @return ResultBody
     */
    @ExceptionHandler(Exception.class)
    public ResultBody<Object> exceptionHandler(Exception e, HttpServletRequest request) {
        LOGGER.error("发生未知异常！原因是：", e);
        return ResultBody.fail(ExceptionCommonEnum.INTERNAL_SERVER_ERROR);
    }
}
