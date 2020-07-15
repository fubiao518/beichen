package com.beichen.scent.common.exception;

import com.beichen.scent.common.ExceptionResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @ClassName ControllerAdviceProcessor
 * @Description 全局controller异常处理  @ControllerAdvice会应用到所有的 Controller 中的@RequestMapping 注解的方法中
 * @Author fubiao
 * @Date 2020/1/9 15:05
 */
@ControllerAdvice
public class ControllerAdviceProcessor {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResponse handleExeption(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        //开发人员手动抛的异常
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            return new ExceptionResponse(commonException.getCode(),commonException.getMsg(),request.getRequestURI());
        }
        //参数校验异常返回
        if (e instanceof MethodArgumentNotValidException){
            //获取异常信息
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            FieldError fieldError = validException.getBindingResult().getFieldError();
            return new ExceptionResponse(-1,fieldError.getDefaultMessage(),request.getRequestURI());
        }
        e.printStackTrace();
        return new ExceptionResponse(500,exceptionToString(e),request.getRequestURI());
    }

    /**
     * @Author fubiao
     * @Description 获取异常信息
     * @Date 16:15 2020/1/9
     * @Param [ex]
     * @return java.lang.String
     **/

    public  String exceptionToString(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }
}
