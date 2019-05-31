package top.sstime.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.sstime.curd.bean.Employee;
import top.sstime.curd.service.EmployeeService;

/** 
 * @author chenwei
 * @version 创建时间：May 29, 2019 
 * 类说明 
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	/**
	 * 查询员工数据
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1")Integer pageNum,
			Model model) {
		// 分页查询
		// 映入pageHelper分页
		PageHelper.startPage(pageNum, 5);
		// startPage后面紧跟的查询就是分页查询
		List<Employee> employees = employeeService.getAll();
		// 使用pageInfo包装查询后的结果，只需将pageInfo交给页面
		PageInfo page = new PageInfo(employees, 5);
		model.addAttribute("pageInfo", page);
		return "list";
	}
}
