package com.winston.result;

import lombok.Data;

/**
 * @author weigaosheng
 * @description
 * @CalssName CodeMsg
 * @date 2019/2/28
 * @params
 * @return
 */
@Data
public class CodeMsg {
    private int status;
    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0, "success");

    // 通用异常5001XX
    public static CodeMsg USERNAME_NOT_EMPTY = new CodeMsg(500100, "用户名不能为空");
    public static CodeMsg PASSWORD_NOT_EMPTY = new CodeMsg(500101, "密码不能为空");
    public static CodeMsg ACCOUNT_NOT_EXIST = new CodeMsg(500102, "用户不存在");
    public static CodeMsg ACCOUNT_IS_LOCKED = new CodeMsg(500103, "用户被锁定");
    public static CodeMsg USERNAME_OR_PASSWORD_ERROR = new CodeMsg(500104, "用户名或密码错误");
    public static CodeMsg IS_NOT_LOGIN = new CodeMsg(500105, "未登录，请先登录");
    public static CodeMsg USER_UPDATE_FAILED = new CodeMsg(500106, "用户修改失败");
    public static CodeMsg USER_ALREADY_EXIST = new CodeMsg(500107, "用户已存在");
    public static CodeMsg USER_ADD_FAILE = new CodeMsg(500108, "用户新增失败");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500109, "服务端异常");
    public static CodeMsg SERVER_UPDATE_ERROR = new CodeMsg(500110, "系统信息修改失败");
    public static CodeMsg SERVER_UPDATE_NOT_ID = new CodeMsg(500111, "请传递资源id");
    public static CodeMsg WECHAT_GET_ACCESSTOKEN_ERROR = new CodeMsg(500112, "获取ACCESS_TOKEN失败");
    public static CodeMsg WECHAT_GET_TEMPLATEID_ERROR = new CodeMsg(500113  , "获取模板id失败");
    public static CodeMsg WECHAT_SEND_TEMPLATEID_ERROR = new CodeMsg(500114  , "模板消息发送失败");
    public static CodeMsg FILE_YASUO_ERROR = new CodeMsg(500115  , "图片压缩失败");
    public static CodeMsg FILE_TOO_BIG = new CodeMsg(500116  , "上传图片过大，请重新上传");
    public static CodeMsg USER_DEL_FAILE = new CodeMsg(500117  , "用户删除失败");

    // 登录模块5002XX
    public static CodeMsg USER_IS_NULL = new CodeMsg(500200, "操作对象不存在");
    public static CodeMsg UPDATE_IS_FAILED = new CodeMsg(500201, "修改失败");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500202, "输入密码错误");
    public static CodeMsg ACCOUNT_LOCKED = new CodeMsg(500203, "此用户已被被冻结,如有疑问请联系管理员");
    public static CodeMsg ACCOUNT_STOP = new CodeMsg(500204, "用户已停止使用");
    public static CodeMsg LOGIN_TIME_PASS = new CodeMsg(500205, "登陆过期,请重新登录");

    // 角色模块5003XX
    public static CodeMsg ROLE_USER_NO_CHOOES = new CodeMsg(500300, "请选择用户和角色");
    public static CodeMsg ROLE_USER_SAVE_ERROR = new CodeMsg(500301, "分配角色错误");
    public static CodeMsg ROLE_ADD_ERROR = new CodeMsg(500302, "角色新增失败");
    public static CodeMsg ROLE_UPDATE_ERROR = new CodeMsg(500303, "角色修改失败");
    public static CodeMsg ROLE_DEL_ERROR = new CodeMsg(500304, "角色删除失败");
    public static CodeMsg SELECT_ROLE_ERROR = new CodeMsg(500305, "请选择角色");
    public static CodeMsg SELECT_PERMOSSION_ERROR = new CodeMsg(500306, "请选择角色");
    public static CodeMsg SELECT__ERROR = new CodeMsg(500307, "分配角色出现异常");
    public static CodeMsg ROLE_HAS_USER_USE = new CodeMsg(500308, "该角色仍有用户使用,请先移除该角色用户");

    // 权限模块5004XX
    public static CodeMsg HAS_NOT_PERMISSION = new CodeMsg(500400, "您没有该权限");
    public static CodeMsg PERMISSION_ALERADY_EXIST = new CodeMsg(500401, "该权限已存在，请勿重复添加");
    public static CodeMsg PERMISSION_PARAM_NULL = new CodeMsg(500402, "请填写权限名称和路径");
    public static CodeMsg PERMISSION_ADD_ERROR = new CodeMsg(500403, "权限新增失败");
    public static CodeMsg PERMISSION_UPDATE_ERROR = new CodeMsg(500404, "权限更新失败");
    public static CodeMsg PERMISSION_DEL_ERROR = new CodeMsg(500405, "权限删除失败");
    public static CodeMsg PERMISSION_HAS_ROLE_USE = new CodeMsg(500406, "该权限正在被其他角色使用，请先移除该角色权限");

    public CodeMsg(int code, String msg) {
        this.status = code;
        this.msg = msg;
    }

    public CodeMsg(){

    }

    public CodeMsg fillArsg(Object... args){
        int code = this.status;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

}
