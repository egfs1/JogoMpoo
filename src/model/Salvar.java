package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

import view.TelaGame;

public class Salvar {
	
	public static void salvarDados(TelaGame telagame) throws FileNotFoundException, IOException
	{
		Dados dados = new Dados(telagame.getPlayers(), telagame.isMapa1passou(), telagame.isMapa2passou(), telagame.getN_mapas_passados());
		
		File file = new File("dados.xml");
		OutputStream stream = null;
		XStream xstream = new XStream(new Dom4JDriver());
		xstream.alias("dados", Dados.class);
			
			if(!file.exists())
			{
				file.createNewFile();
			}
			else
			{
				file.delete();
				file.createNewFile();
			}
			
			stream = new FileOutputStream(file);
			xstream.toXML(dados, stream);
	}
	
	public static Dados ler()
	{
		Dados dados=null;
		File file = new File("dados.xml");
		XStream xstream = new XStream(new Dom4JDriver());
		
		try {
			
			if(file.exists())
			{	
				xstream.alias("dados", Dados.class);
				dados = (Dados) xstream.fromXML(file);
			}
			
		} catch (Exception e) {
			
			System.err.println("Erro ao ler");
			
		}
		return dados;
	}
	
	
}
