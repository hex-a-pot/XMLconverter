package mindtree.Playlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mindtree.Playlist.models.Singer;
import mindtree.Playlist.models.Song;
import mindtree.Playlist.utilities.JdbcConnection;



public class PlaylistDaoImpl implements PlaylistDao {
	

	Connection connection = null;
	PreparedStatement pstmnt = null;
	ResultSet resSet = null;
	Statement stmnt = null;

	private static PlaylistDaoImpl playlistDao = null;

	public PlaylistDaoImpl() {
		super();
	}

	public static PlaylistDaoImpl getInstance()
	{
		if(playlistDao == null)
			playlistDao = new PlaylistDaoImpl();
		return playlistDao;
			
	}

	private Connection getConnection() throws SQLException {
		return  JdbcConnection.getInstance().getConnection();
		
	}

	

	@Override
	public List<Song> getSongsList() {
		
		List<Song> songList = new ArrayList<>();
		try
		{
			connection = getConnection();
			String query = "select * from song";
			pstmnt = connection.prepareStatement(query);
			resSet = pstmnt.executeQuery(query);
			while(resSet.next())
			{
				Song song = new Song();
				Long songId = resSet.getLong("songId");
				song.setSongId(songId);
				song.setTitle(resSet.getString("title"));
				song.setLength(resSet.getInt("length"));
				List<Singer> singerList = SingerDaoImpl.getInstance().getSingerList(songId);
				song.setSingersList(singerList);
				songList.add(song);
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
		return songList;
	}

}
