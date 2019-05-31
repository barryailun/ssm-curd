package top.sstime.curd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.sstime.curd.bean.Employee;
import top.sstime.curd.dao.EmployeeMapper;
import top.sstime.curd.service.EmployeeService;

/** 
 * @author chenwei
 * @version 创建时间：May 29, 2019 
 * 类说明 
 */
@Service
public class IEmployeeService implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * 查出所有员工
	 */
	public List<Employee> getAll() {
		
		List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
		
		return employees;
	}

}
