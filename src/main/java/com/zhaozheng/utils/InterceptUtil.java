package com.zhaozheng.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InterceptUtil {
    public static void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            //由于统一拦截了异常所以不需要抛出
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
