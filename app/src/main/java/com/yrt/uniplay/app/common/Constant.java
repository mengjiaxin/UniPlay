package com.yrt.uniplay.app.common;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.common
 * Author Mengjiaxin
 * Date 2015/12/21 16:00
 * Desc 全局常量
 */
public interface Constant {

    /**
     * 是否为调试模式
     */
    boolean DEBUG = true;

    /**
     * 本地数据库名称
     */
    String DB_NAME = "yrt_db.db";

    /**
     * 返回结果标识
     */
    String RESULT = "result";

    /**
     * handler处理标识
     */
    interface What {
        int SUCCESS = 0x000;     // 成功标识
        int FAILURE = 0x001;     // 失败标识
        int ERROR = 0x002;       // 错误标识
        int START = 0x003;       // 开始标识
        int FINISHED = 0x004;    // 完成标识
    }
}
