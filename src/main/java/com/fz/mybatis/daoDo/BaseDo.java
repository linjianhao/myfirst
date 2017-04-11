package com.fz.mybatis.daoDo;

import java.io.Serializable;

/**序列化接口(然后对应的实体类继承这个序列化接口，目的是为了将对象进行持久化保存)，将对象保存
 * 到外部储存设备中
 * Created by Administrator on 2017/4/10.
 */
public class BaseDo implements Serializable {
    private String state;//是否可用状态

    private String createBy;//创建人

    private String createDate;//创建日期

    private String updateBy;//更新人

    private String updateDate;//更新时间
}
