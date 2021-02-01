package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;

public class Dao
{
	public static Connection con = null;
	int pid;

	PreparedStatement c=null;
	ResultSet rs=null;


	Class.forName("com.mysql.cj.jdbc.Driver");

		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test306","root","0314");
		}
		catch (SQLException e)
		{
			System.out.println(e.toString());
		}
		
	
	

	
	public int addProduct(Product p) throws SQLException, ClassNotFoundException
	{
		try {

		c = con.prepareStatement("select pname from product");
		rs = c.executeQuery();
	
			p.setPid(pid);
			PreparedStatement ps = con.prepareStatement("insert into Product values(?,?,?)");
			ps.setInt(1,p.getPid() );
			ps.setString(2, p.getPname());
			ps.setFloat(3, p.getPrice());
			int res = ps.executeUpdate();
			return res;
		
		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
			return 0;
		}
		return 0;
	}
	
	public int update(Product p) throws SQLException, ClassNotFoundException
	{
	
		PreparedStatement c;
		try
		{
			c = con.prepareStatement("select pid from Product");
			rs = c.executeQuery();
			while(rs.next())
			{
				pid = rs.getInt(1);
				if(pid == p.getPid())
				{
					
				}
			}
			
	
			c = con.prepareStatement("select pname from product");
			rs = c.executeQuery();
			
				c = con.prepareStatement("update Product set price = ?,pname = ? where pid = ?");
				c.setFloat(1, p.getPrice());
				c.setString(2, p.getPname());
				c.setInt(3, p.getPid());
			
			
			
		} 
		catch (SQLException e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	public int delete(int pid) throws SQLException, ClassNotFoundException
	{
		
		try
		{
			c = con.prepareStatement("select pid from Product");
			rs = c.executeQuery();
			while(rs.next())
			{
				int piddemo = rs.getInt(1);
				
			}
		
				c = con.prepareStatement("delete from Product where pid = ?");
				c.setInt(1, pid);
				int result = c.executeUpdate();
				return result;
			
			
		} 
		catch (SQLException e)
		{
			System.out.println(e.toString());
		}
		return 0;
			
	}
	
	public ArrayList displayAll() throws SQLException, ClassNotFoundException
	{
	
		PreparedStatement c = con.prepareStatement("select * from Product");
		ResultSet rs = c.executeQuery();
		ArrayList<Product> demoProduct = new ArrayList<>();
		while(rs.next())
		{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			demoProduct.add(p);
		}
		return demoProduct;
		
	}
	
	
}
