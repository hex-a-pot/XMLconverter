package mindtree.Playlist;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import mindtree.Playlist.service.PlaylistServiceImpl;

public class App 
{
	private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        boolean exit = false;
        do {
        	int option = displayMenu();
        	switch(option)
        	{
        	case 1:
        		try {
					PlaylistServiceImpl.getInstance().generateXML();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		break;
        	case 2:
        		exit = true;
        		break;
        	case 3:
        		System.out.println("Invalid Choice!!!!");
        		break;
        	}
        	
        }while(exit == false);
    }
	private static int displayMenu() {
		System.out.println("Enter options - ");
		System.out.println("1.Generate XML ");
		System.out.println("2.Exit ");
		return sc.nextInt();
		
	}
}
