package mindtree.Playlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mindtree.Playlist.models.Singer;
import mindtree.Playlist.utilities.JdbcConnection;

public class SingerDaoImpl implements SingerDao {
	
	Connection connection = null;
	PreparedStatement pstmnt = null;
	ResultSet resSet = null;
	Statement stmnt = null;

	private static SingerDaoImpl singerDao = null;

	public SingerDaoImpl() {
		super();
	}

	public static SingerDaoImpl getInstance()
	{
		if(singerDao == null)
			singerDao = new SingerDaoImpl();
		return singerDao;
			
	}

	private Connection getConnection() throws SQLException {
		return  JdbcConnection.getInstance().getConnection();
		
	}

	@Override
	public List<Singer> getSingerList(long songId) {
		List<Singer> singerList = new ArrayList<>();
		try
		{
			connection = getConnection();
			String query = "select * from singer where id in (select singerid from songandsinger where songId = ?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, songId);
			resSet = pstmnt.executeQuery();
			while(resSet.next())
			{
				Singer singer = new Singer();
				singer.setId(resSet.getLong("id"));
				singer.setName(resSet.getString("name"));
				singer.setGender(resSet.getString("gender"));
				singerList.add(singer);
			}
			
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally {
			try {
				if (stmnt != null)
					stmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return singerList;
	}

}
