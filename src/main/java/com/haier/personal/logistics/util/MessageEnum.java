package com.haier.personal.logistics.util;

public enum MessageEnum {
    C0000("0000","成功"),
    C1001("1001","错误的加密"),
    C1002("1002","时间戳异常"),
    C1003("1003","公钥不一致"),
    C1004("1004","字段缺失"),
    C1005("1005","链接超时，请重新登录"),
    C1006("1006","签名不清晰，请重新上传"),
    C1007("1007","等待时间超时，请刷新页面重新扫描二维码"),
    C2001("2001","签名未找到"),
    C2002("2002","签名已存在"),
    C2003("2003","存储失败"),
    C2004("2004","签名已作废"),
    C2005("2005","未找到该临时用户"),
    C0001("0001","用户名或密码不能为空"),
    C0002("0002","用户名密码错误"),
    C0003("0003","系统名称已存在，请勿重复申请"),
    C0004("0004","拒绝申请"),
    C0005("0005","时间格式错误"),
    C0006("0006","无增量数据"),
    C0007("0007","图片尺寸不符"),
    C9999("9999","未知异常");

    MessageEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
