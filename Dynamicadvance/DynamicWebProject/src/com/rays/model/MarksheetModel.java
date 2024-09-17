package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.MarksheetBean;
import com.rays.util.JDBCDataSource;

public class MarksheetModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select max(id) from Marksheet");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("max id = " + pk);

		}
		return pk + 1;

	}

	public void add(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("insert into Marksheet values(?,?,?,?,?,?,?,?,?)");

			MarksheetBean existBean = findById(bean.getId());

			conn.setAutoCommit(false);

			if (existBean == null) {

				pstmt.setInt(1, nextPk());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getRollNo());
				pstmt.setInt(4, bean.getPhysics());
				pstmt.setInt(4, bean.getChemistry());
				pstmt.setInt(5, bean.getMaths());

				int i = pstmt.executeUpdate();

				conn.commit();

				System.out.println("data inserted successfully.. " + i);
			} else {
				System.out.println("loginId already exist");
			}

		} catch (Exception e) {

			conn.rollback();
			e.printStackTrace();

		}

	}

	public void delete(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from Marksheet where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data deleted successfully.. " + i);

	}

	public void update(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set name = ?, rollNo = ?, physics = ?, chemistry = ?, maths = ?, where id = ?");
        pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getRollNo() );
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());
		

		int i = pstmt.executeUpdate();

		System.out.println("data update successfully... " + i);

	}

	public MarksheetBean searchAll() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from Marksheet");

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			

		}

		return bean;

	}

	public MarksheetBean authenticate(String loginId, String password) throws Exception {

		System.out.println("data = " + loginId + " " + password);

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from Marksheet where loginId = ? and password = ?");

		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		
		}

		return bean;

	}

	/*
	 * public MarksheetBean findByLoginId(String loginId) throws Exception {
	 * 
	 * System.out.println("data = " + loginId);
	 * 
	 * Connection conn = JDBCDataSource.getConnection();
	 * 
	 * PreparedStatement pstmt =
	 * conn.prepareStatement("select * from marksheet where loginId = ?");
	 * 
	 * pstmt.setString(2, "name");
	 * 
	 * ResultSet rs = pstmt.executeQuery();
	 * 
	 * MarksheetBean bean = null;
	 * 
	 * while (rs.next()) {
	 * 
	 * bean = new MarksheetBean();
	 * 
	 * bean.setId(rs.getInt(1)); bean.setId(rs.getInt(1));
	 * bean.setName(rs.getString(2)); bean.setRollNo(rs.getInt(3));
	 * bean.setPhysics(rs.getInt(4)); bean.setChemistry(rs.getInt(5));
	 * bean.setMaths(rs.getInt(6));
	 * 
	 * }
	 * 
	 * return bean;
	 * 
	 * }
	 */

	public MarksheetBean findById(int Id) throws Exception {

		System.out.println("data = " + Id);

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from Marksheet where id = ?");

		pstmt.setInt(1, Id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
		}

		return bean;

	}

	public List search(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from Marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "'");
			}

			
			}

		
		System.out.println(sql.toString());

		PreparedStatement ptmt = conn.prepareStatement(sql.toString());
		ResultSet rs = ptmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		return list;

	}

}