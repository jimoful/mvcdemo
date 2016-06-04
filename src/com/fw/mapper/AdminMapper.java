package com.fw.mapper;

import com.fw.model.Admin;

public interface AdminMapper {

	Admin selectByName(Admin adm);

	Admin selectByNameAndPassword(Admin adm);

	String selectPassword(Integer aid);

	void updatePassword(Admin admin);

}
