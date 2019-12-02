package com.winston.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author weigaosheng
 * @description
 * @CalssName Result
 * @date 2019/2/28
 * @params
 * @return
 */
@Data
public class Result<T> implements Serializable {

    //   自定义serialVersionUID
    private static final long serialVersionUID = 8735132092273200831L;

    private int status;
    private String msg;
    private T data;
    // 总条数
    private Long total;

    private Result(T data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result(T data, long total){
        this.status = 200;
        this.msg = "success";
        this.data = data;
        this.total = total;
    }

    private Result(CodeMsg cm) {
        if(cm == null){
            return ;
        }
        this.status = cm.getStatus();
        this.msg = cm.getMsg();
    }

    /**
     * @return a
     * @Author weigaosheng
     * @Description 返回单条数据成功时的调用
     * @Date 11:56 2019/2/28
    * @Param
     **/
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * @Author Winston
     * @Description 返回多条列表数据成功时调用
     * @Date 16:27 2019/7/5
     * @Param
     * @return
     **/
    public static <T> Result<T> success(T data, long total){
        return new Result<T>(data, total);
    }

    /**
     * @return a
     * @Author weigaosheng
     * @Description 失败时的调用
     * @Date 11:56 2019/2/28
     * @Param
     **/
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

}
