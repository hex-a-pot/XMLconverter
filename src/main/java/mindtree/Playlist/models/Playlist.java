package mindtree.Playlist.models;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Playlist {
	private String name;
	private List<Song>songList;
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public List<Song> getSongList() {
		return songList;
	}
	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	public Playlist(String name, List<Song> songList) {
		super();
		this.name = name;
		this.songList = songList;
	}
	public Playlist()
	{
		super();
	}
	
	

}
