

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// Image_Loader deals with reading in the image???
public class Image_Loader
{
	
	// Load_Image gets the image???
	public static BufferedImage Load_Image(String Path)
	{
		
		// If image not found end program.
		try
		{
			
			return ImageIO.read(Image_Loader.class.getResource(Path));
			
		}
		catch (IOException e)
		{

			e.printStackTrace();
			System.exit(1);
			
		}
		
		
		return null;
		
	}

}
