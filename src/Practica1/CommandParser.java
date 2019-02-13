package Practica1;

public class CommandParser {

	public static Command parse(String line)
	{
		String[] aux;
		line = line.trim();
		aux = line.split(" +");
		
		if(aux.length == 1)
		{
			if(aux[0].equalsIgnoreCase("RUN"))
			{
				return new Command(Command.ENUM_COMMAND.RUN);
			}
			else if(aux[0].equalsIgnoreCase("HELP"))
			{
				return new Command(Command.ENUM_COMMAND.HELP);
			}
			else if(aux[0].equalsIgnoreCase("QUIT"))
			{
				return new Command(Command.ENUM_COMMAND.QUIT);
			}
			else if(aux[0].equalsIgnoreCase("RESET"))
			{
				return new Command(Command.ENUM_COMMAND.RESET);
			}
			else
			{
				return new Command(null);
			}
			
		}
		else if(aux.length == 2)
		{
			if(aux[0].equalsIgnoreCase("NEWINST"))
				{
					return new Command(Command.ENUM_COMMAND.NEWINST, ByteCodeParser.parse(aux[1]));
				}
			else if(aux[0].equalsIgnoreCase("REPLACE"))
				{
					return new Command(Command.ENUM_COMMAND.REPLACE, Integer.parseInt(aux[1]));
				}
			else
			{
				return new Command(null);
			}
		}
		else if(aux.length == 3)
		{
			if(aux[0].equalsIgnoreCase("NEWINST"))
			{
				String bytecode = aux[1] + " " + aux[2];
				ByteCode bc = ByteCodeParser.parse(bytecode);
				return new Command(Command.ENUM_COMMAND.NEWINST,bc);
				//return new Command(Command.ENUM_COMMAND.NEWINST, ByteCodeParser.parse(aux[1] +System.getProperty("line.separator") + aux[2]));
			}
			else
			{
				return new Command(null);
			}
		}
		else 
		{
			return new Command(null);
		}
	}
}
