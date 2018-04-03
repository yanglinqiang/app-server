package com.cake.server.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ({"/spring/*.xml"}) //加载配置文件
public class BaseJunit4Test extends AbstractTransactionalJUnit4SpringContextTests {

//    /**
//     * <b>Summary: </b> 复写方法 setDataSource
//     *
//     * @param dataSource
//     * @see org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests#setDataSource(javax.sql.DataSource)
//     */
//    @Override
//    @Resource(name = "myDataSource")
//    public void setDataSource(DataSource dataSource) {
//        // TODO Auto-generated method stub
//        super.setDataSource(dataSource);
//    }
}
