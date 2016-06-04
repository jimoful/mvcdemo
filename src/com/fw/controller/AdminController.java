package com.fw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.model.Admin;
import com.fw.model.Classes;
import com.fw.model.Enterprise;
import com.fw.model.Student;
import com.fw.service.AdminService;
import com.fw.service.EnterpriseService;
import com.fw.service.StudentService;
import com.fw.util.MyUtil;
import com.fw.util.PageBean;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private StudentService studentService;

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/login.do")
	public String login(Admin admin, HttpSession session, Model model) {
		admin.setPassword(admin.getPassword());
		try {
			Admin adm = adminService.login(admin);
			session.setAttribute("admin", adm);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());

			return "/index";
		}
		return "redirect:/admin/toHomePage.do";
	}

	@RequestMapping("/toHomePage.do")
	public String toHomePage() {
		return "/admin/adminHomePage";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/toIndex.do";
	}

	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "/index";
	}

	@RequestMapping("toUpdateAdminPassword.do")
	public String toUpdateAdminPassword() {
		return "/admin/updateAdminPassword";
	}

	@RequestMapping("updateAdminPassword.do")
	public String updateAdminPassword(Admin admin, Model model) {

		admin.setPassword(MyUtil.md5(admin.getPassword()));
		admin.setNewPassword(MyUtil.md5(admin.getNewPassword()));

		try {
			adminService.updateAdminPassword(admin.getAid(),
					admin.getPassword(), admin.getNewPassword());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());

			return "/admin/updateAdminPassword";
		}

		return "redirect:/admin/logout.do";
	}

	@RequestMapping("findAllStudentList.do")
	public String findAllStudentList(int page, Model model) {
		PageBean<Student> pageBean = studentService.findAllStudentList(page);
		model.addAttribute("pageBean", pageBean);
		return "/admin/studentList";
	}

	@RequestMapping("getStudentInfo.do")
	public String getStudentInfo(int sid, Model model) throws Exception {
		Student student = studentService.getStudentInfo(sid);
		List<Classes> classesList = studentService.getAllClassesList();
		model.addAttribute("student", student);
		model.addAttribute("classesList", classesList);
		return "/admin/studentInfo";
	}

	@RequestMapping("updateStudentInfo.do")
	public String updateStudentInfo(int sid, Student student) {
		studentService.updateStudentInfoByAdmin(student);
		return "forward:/admin/getStudentInfo.do";
	}

	@RequestMapping("toAddStudent.do")
	public String toAddStudent(Model model) {
		List<Classes> classesList = studentService.getAllClassesList();
		model.addAttribute("classesList", classesList);
		return "/admin/addStudent";
	}

	@RequestMapping("addStudent.do")
	public String addStudent(Student student) {
		studentService.addStudent(student);
		return "redirect:/admin/findAllStudentList.do?page=1";
	}

	@RequestMapping("findAllEnterpriseList.do")
	public String findAllEnterpriseList(int page, Model model) {
		PageBean<Enterprise> pageBean = enterpriseService
				.findAllEnterpriseList(page);
		model.addAttribute("pageBean", pageBean);
		return "/admin/enterpriseList";
	}

	@RequestMapping("getEnterpriseInfo.do")
	public String getEnterpriseInfo(int eid, Model model) throws Exception {
		Enterprise enterprise = enterpriseService.getEnterpriseInfo(eid);

		model.addAttribute("enterprise", enterprise);

		return "/admin/enterpriseInfo";
	}

	@RequestMapping("updateEnterpriseInfo.do")
	public String updateEnterpriseInfo(int eid, Enterprise enterprise) {
		enterpriseService.updateEnterpriseInfoByAdmin(enterprise);
		return "forward:/admin/getEnterpriseInfo.do";
	}

	@RequestMapping("toVerifyEnterprise.do")
	public String toVerifyEnterprise(Model model, int page) {
		PageBean<Enterprise> pageBean = enterpriseService
				.toVerifyEnterprise(page);
		model.addAttribute("pageBean", pageBean);
		return "/admin/verifyEnterpriseList";
	}

	@RequestMapping("toAddEnterprise.do")
	public String toAddEnterprise() {
		return "/admin/addEnterprise";
	}

	@RequestMapping("addEnterprise.do")
	public String addEnterprise(Enterprise enterprise) {
		enterpriseService.addEnterprise(enterprise);
		return "redirect:/admin/findAllEnterpriseList.do?page=1";
	}

	@RequestMapping("verifyEnterprise.do")
	public String verifyEnterprise(int eid) {
		enterpriseService.verifyEnterprise(eid);
		return "redirect:/admin/findAllEnterpriseList.do?page=1";
	}

	@RequestMapping("deleteStudent.do")
	public String deleteStudent(int sid) {
		// 删除_stu_ent中的记录
		// 删除_ent_stu中的记录
		// 删除_stu_pro中的记录，和上传的项目
		// 删除_student中的记录，和上传的简历
		studentService.deleteStudent(sid);
		return "redirect:/admin/findAllStudentList.do?page=1";
	}

	@RequestMapping("deleteEnterprise.do")
	public String deleteEnterprise(int eid) {
		// 删除_ent_stu中的记录
		// 删除_stu_ent中的记录
		// 删除_stu_pro中记录，和上传的项目
		// 删除_project中的记录，和上传的项目
		// 删除_enterprise中的记录
		enterpriseService.deleteEnterprise(eid);
		return "redirect:/admin/findAllEnterpriseList.do?page=1";
	}
}
