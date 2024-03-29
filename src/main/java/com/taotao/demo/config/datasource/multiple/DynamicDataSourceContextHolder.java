package com.taotao.demo.config.datasource.multiple;

public class DynamicDataSourceContextHolder {

    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源变量
     *
     * @param dataSourceName
     */
    public static void setDataSourceName(String dataSourceName) {
        CONTEXT_HOLDER.set(dataSourceName);
    }

    /**
     * 获取数据源变量
     *
     * @return
     */
    public static String getDataSourceName() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSourceName() {
        CONTEXT_HOLDER.remove();
    }

}
