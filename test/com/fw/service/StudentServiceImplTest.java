package com.fw.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fw.model.Enterprise;
import com.fw.util.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:dispatcherServlet.xml"})
public class StudentServiceImplTest {

	@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Test
	public void testFindFollowingEnterpriseList() throws Exception {
		PageBean<Enterprise> pageBean = studentService
				.findFollowingEnterpriseList(1, 1);
		System.out.println(pageBean);
        /*studentService.getStudentInfo(1);*/
	}
}
