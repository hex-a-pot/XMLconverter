package mindtree.Playlist.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import mindtree.Playlist.dao.PlaylistDaoImpl;
import mindtree.Playlist.models.Playlist;
import mindtree.Playlist.models.Song;


public class PlaylistServiceImpl implements PlaylistService {
	
	private static PlaylistServiceImpl obj = null;
	
	public static PlaylistServiceImpl getInstance()
	{
		if(obj == null)
			obj = new PlaylistServiceImpl();
		return obj;
	}

	@Override
	public void generateXML() throws JAXBException {
		
		
			
			JAXBContext contextObj = JAXBContext.newInstance(Playlist.class);  
			  
		    Marshaller marshallerObj = contextObj.createMarshaller();  
		    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		    
		    List<Song> songList = PlaylistDaoImpl.getInstance().getSongsList();
		    Playlist playlist = new Playlist("ReviewPlaylist",songList);
		   
		    try {
				marshallerObj.marshal(playlist, new FileOutputStream("playlist.xml"));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (JAXBException e) {

				e.printStackTrace();
			}  
		       
		 
		

	}

}
