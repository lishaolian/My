package com.sms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sms.model.StudentInfo;

public class StudentInfoDao extends BaseDao {
	
	public StudentInfoDao(HttpServletRequest request){
		super(request);
	}
	
	public void add(StudentInfo model) throws Exception{
		DbHelper db = this.createDbHelper();

		Map<String,Object> param = new LinkedHashMap<String,Object>();
		param.put("Name",model.getName());
		param.put("ClassName",model.getClassName());
		db.createConnection();
		
		db.execute("insert into StudentInfo(Name,ClassName) values(?,?)", param);
		
		db.closeConnection();
	}
	public void update(StudentInfo model) throws Exception{
		DbHelper db = this.createDbHelper();
		
		Map<String,Object> param = new LinkedHashMap<String,Object>();
		param.put("Name",model.getName());
		param.put("ClassName",model.getClassName());
		param.put("Id",model.getId());
		
		db.createConnection();
		
		db.execute("update StudentInfo set Name=?,ClassName=? where Id=?", param);
		
		db.closeConnection();
	}
	public StudentInfo get(long id) throws Exception{
		DbHelper db = this.createDbHelper();
		
		Map<String,Object> param = new LinkedHashMap<String,Object>();
		param.put("Id",id);
		
		db.createConnection();
		
		ResultSet rs = db.query("select * from StudentInfo where Id=?", param);
		
		StudentInfo model = null;
		
		if(rs.next()){
			model = new StudentInfo();
			model.setId(rs.getLong(1));
			model.setName(rs.getString(2));
			model.setClassName(rs.getString(3));
		}
		
		db.closeConnection();
		
		return model;
	}
	public void delete(long id) throws Exception{
		String sql = "delete from StudentInfo where Id=?";
		Map<String,Object> param = new LinkedHashMap<String,Object>();
		param.put("Id",id);
		
		DbHelper db = this.createDbHelper();
		db.createConnection();
		db.execute(sql, param);
		db.closeConnection();
	}
	public List<StudentInfo> query(String name) throws Exception{
		String sql = "select * from StudentInfo";
		if(name!=null && name.length()>0){
			sql += " where Name like '%"+name+"%'";
		}
		
		DbHelper db = this.createDbHelper();
		
		db.createConnection();
		
		ResultSet rs = db.query(sql, null);
		
		List<StudentInfo> list = new ArrayList<StudentInfo>();

		while(rs.next()){
			StudentInfo model = new StudentInfo();
			model.setId(rs.getLong(1));
			model.setName(rs.getString(2));
			model.setClassName(rs.getString(3));

			list.add(model);
		}
		
		db.closeConnection();
		
		return list;
	}

}
