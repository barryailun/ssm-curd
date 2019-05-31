package top.sstime.curd.test;

import java.util.List;

import org.apache.ibatis.mapping.ParameterMapping;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

import top.sstime.curd.bean.Employee;

/** 
 * @author chenwei
 * @version 创建时间：May 29, 2019 
 * 类说明 使用Spring测试模块提供的测试请求功能，测试curd请求的正确性
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"classpath:applicationContext-spring.xml",
		"classpath:applicationContext-mybatis.xml"})
public class MvcTest {

	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;
	
	@Before
	public 	void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	@Test
	public void testPage() throws Exception {
		// 模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1"))
			.andReturn();
		MockHttpServletRequest request = result.getRequest();
		PageInfo pInfo = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码: " + pInfo.getPageNum());
		System.out.println("总页码: " + pInfo.getPages());
		System.out.println("总记录数: " + pInfo.getTotal());
		int[] nums = pInfo.getNavigatepageNums();
		for(int num : nums) {
			System.out.println(" " + num);
		}
		List<Employee> list = pInfo.getList();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
