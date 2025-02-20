package com.jyhmw.util;

public class RestResponseUtils {
    // 成功响应
    public static <T> RestResponse<T> success(T data, String message) {
        return new RestResponse<>(true, 200, message, data);
    }

    public static <T> RestResponse<T> success(T data) {
        return success(data, "操作成功");
    }

    // 失败响应
    public static <T> RestResponse<T> fail(String message) {
        return new RestResponse<>(false, 400, message, null);
    }

    public static <T> RestResponse<T> fail(int code, String message) {
        return new RestResponse<>(false, code, message, null);
    }
}
