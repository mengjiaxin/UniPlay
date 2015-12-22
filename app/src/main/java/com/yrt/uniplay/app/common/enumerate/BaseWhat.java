package com.yrt.uniplay.app.common.enumerate;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.common.enumerate
 * Author Mengjiaxin
 * Date 2015/12/21 16:49
 * Desc handler消息标识
 */
public enum BaseWhat {
    SUCCESS(0),     // 成功标识
    FAILURE(1),     // 失败标识
    ERROR(2);       // 错误标识

    private int nCode;

    BaseWhat(int nCode) {
        this.nCode = nCode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nCode);
    }
}
