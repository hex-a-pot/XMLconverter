package mindtree.Playlist.dao;

import java.util.List;

import mindtree.Playlist.models.Singer;

public interface SingerDao {

	List<Singer> getSingerList(long songId);
}
