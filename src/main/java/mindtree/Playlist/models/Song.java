package mindtree.Playlist.models;

import java.util.List;

public class Song {
	
	private long songId;
	private String title;
	private int  length;
	private List<Singer> singersList;
	
	public Song(long songId, String title, int length, List<Singer> singersList) {
		super();
		this.songId = songId;
		this.title = title;
		this.length = length;
		this.singersList = singersList;
	}
	
	public Song()
	{
		super();
	}

	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<Singer> getSingersList() {
		return singersList;
	}

	public void setSingersList(List<Singer> singersList) {
		this.singersList = singersList;
	}
	
	

}
