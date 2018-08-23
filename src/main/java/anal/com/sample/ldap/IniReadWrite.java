package anal.com.sample.ldap;

import java.io.File;
import java.io.IOException;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class IniReadWrite
{

	private String file = "src/main/resources/config.ini";
	public String get(String file, String blok, String zmienna) throws IOException, InvalidFileFormatException
	{
		Wini ini = new Wini(new File(file));
		String dir = ini.get(blok, zmienna);
		System.out.println(dir);
		return dir;
	}

	public void put(String file, String blok, String zmienna, String wartosc)
			throws IOException, InvalidFileFormatException
	{
		Wini ini = new Wini(new File(file));
		ini.put(blok, zmienna, wartosc);
		ini.store();
	}

	public String get(String blok, String zmienna) throws IOException, InvalidFileFormatException
	{
		Wini ini = new Wini(new File(file));
		String wartosc = ini.get(blok, zmienna);
		return wartosc;
	}

	public void put(String blok, String zmienna, String wartosc) throws IOException, InvalidFileFormatException
	{
		Wini ini = new Wini(new File(file));
		ini.put(blok, zmienna, wartosc);
		ini.store();
	}
}
