package dumbguy.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class AccountHandler
{

	private static String accountFile;
	private static HashMap<String, Integer> accounts;

	public static void init(String gameFolderPath)
	{
		accountFile = gameFolderPath + "resorces\\accounts.txt";
		accounts = new HashMap<String, Integer>();
		loadAccounts();
	}

	public static void loadAccounts()
	{
		accounts.put("Guest", 1);
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(new File(accountFile)));
			while(true)
			{
				String line = reader.readLine();
				if(line == null)
					break;
				int i = Integer.parseInt(line.substring(0, line.indexOf(",")));
				String s = line.substring(line.indexOf(",") + 1);
				accounts.put(s, i);
			}
			reader.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createAccount(String username) throws Exception
	{
		if(accounts.containsKey(username)) throw new Exception("try a different name. this one is taken");
		accounts.put(username, 1);
		
		updateAccountFile();
	}

	public static void updateAccountFile()
	{
		try
		{
		File file = new File(accountFile);
		file.delete();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		for(String name : accounts.keySet())
		{
			if(name != "Guest")
			{
				writer.write(accounts.get(name) + "," + name);
				writer.write(System.lineSeparator());
			}
		}
		writer.close();
		
		loadAccounts();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
