package com.appleyk.DMC23_中介者模式.基础版.测试;

import com.appleyk.DMC23_中介者模式.基础版.BoyColleague;
import com.appleyk.DMC23_中介者模式.基础版.GirlColleague;
import com.appleyk.DMC23_中介者模式.基础版.HrMediator;

/**
 * <p>中介者测试</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/22:15:17
 */
public class MediatorTest {

    public static void main(String[] args) {
        HrMediator mediator = new HrMediator();
        BoyColleague boy1 = new BoyColleague("张富贵",mediator);
        BoyColleague boy2 = new BoyColleague("李奋斗",mediator);
        BoyColleague boy3 = new BoyColleague("刘无能",mediator);
        GirlColleague girl = new GirlColleague("韩美丽",mediator);
        boy1.engagement("我就是高富帅，希望结交一位温柔贤惠的女士作为另一半！");
        boy2.engagement("我很上进，工作很认真，我希望在这里找到我爱的人！");
        boy3.engagement("话不多说，我喜欢女的，活的！");
    }

    /**
     * 中介者模式很简单，就不多说了，也不在多举例子了，
     * 像服务注册与发现中心、现实中的房屋中介、婚介所等都是应用场景。
     */
}
