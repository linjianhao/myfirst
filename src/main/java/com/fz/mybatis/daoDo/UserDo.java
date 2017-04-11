package com.fz.mybatis.daoDo;

import lombok.Data;

/**继承Base序列化接口
 * Created by Administrator on 2017/4/9.
 */
@Data
public class UserDo extends BaseDo {
    private int id;
    private String name;// 用户姓名
    private String password;// 密码
    private String phone;// 电话
    private String sex;// 性别
    private String address;// 地址
    private String realname;//真实名字
    private String email;//邮箱
    private String status;//状态
    private String pic;//图片


}
