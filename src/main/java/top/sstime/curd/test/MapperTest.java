package top.sstime.curd.test;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.sstime.curd.bean.Department;
import top.sstime.curd.bean.Employee;
import top.sstime.curd.dao.DepartmentMapper;
import top.sstime.curd.dao.EmployeeMapper;

/** 
 * @author chenwei
 * @version 创建时间：May 19, 2019 9:35:18 PM 
 * 类说明 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml"})
public class MapperTest {
	
	@Autowired
	private DepartmentMapper dMapper;
	
	@Autowired
	private EmployeeMapper empMapper;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testCURD() {
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//		dMapper = (DepartmentMapper) ioc.getBean(DepartmentMapper.class);
//		System.out.println(dMapper);
//		dMapper.insertSelective(new Department(null, "开发部"));
//		dMapper.insertSelective(new Department(null, "财务部"));
//		dMapper.insertSelective(new Department(null, "销售部"));
//		dMapper.insertSelective(new Department(null, "工程部"));
//		dMapper.insertSelective(new Department(null, "生产部"));
//		dMapper.insertSelective(new Department(null, "测试部"));
//		dMapper.insertSelective(new Department(null, "测试部"));
//		empMapper.insert(new Employee(null, "Jerry", "M", "Jerry@sstime.top", 1));
		// 批量插入，使用可以批量操作的sqlsession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 5);
			mapper.insert(new Employee(null, uuid, "M", uuid + "@sstime.top", 1));
		}
		System.out.println("批量完成");
	}

}
