package Practica1;

public class Command {
	public static enum ENUM_COMMAND{HELP, QUIT, NEWINST, RUN, RESET, REPLACE};
	private ENUM_COMMAND command;
	private ByteCode bytecode;
	private int replace;
	
	public Command()
	{
		this.command = null;
		this.replace = -1;
		this.bytecode = null;
	}
	public Command(ENUM_COMMAND comando, int replace)
	{
		this.command = comando;
		this.replace = replace;
	}
	
	public Command(ENUM_COMMAND comando)
	{
		this.command = comando;
		this.bytecode = null; this.replace = -1;
	}
	
	public Command(ENUM_COMMAND comando, ByteCode bc) 
	{
		this.command = comando;
		this.bytecode = bc;
		this.replace = -1;
	}
		
		public boolean execute(Engine engine)
		{
			if (this.command == ENUM_COMMAND.QUIT)
			{
				engine.endExecution();
				return true;
			}
			else if (this.command == ENUM_COMMAND.HELP)
			{
				Engine.showHelp();
				return true;
			}
			else if (this.command == ENUM_COMMAND.RUN)
			{
				return engine.executeCommandRun();
			}
			else if(this.command  == ENUM_COMMAND.NEWINST)
			{
				return engine.addByteCodeInstruction(this.bytecode);
			}
			else if(this.command == ENUM_COMMAND.REPLACE)
			{
				return engine.replaceByteCode(replace);
			}
			else if(this.command == ENUM_COMMAND.RESET)
			{
				return engine.resetProgram();
			}
		else 
			return false;
		}
		public ENUM_COMMAND getCommand()
		{
			return this.command;
		}
}
