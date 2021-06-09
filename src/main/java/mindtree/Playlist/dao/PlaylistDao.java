package mindtree.Playlist.dao;

import java.util.List;

import mindtree.Playlist.models.Singer;
import mindtree.Playlist.models.Song;

public interface PlaylistDao {
	

	List<Song> getSongsList();

}
