package Practica1;

import java.util.Scanner;

import Practica1.Command.ENUM_COMMAND;

public class Engine
{
	private boolean end;
	private ByteCodeProgram bcProgram;
	private static Scanner in = new Scanner(System.in);
	
	public Engine()
	{
		this.bcProgram = new ByteCodeProgram();
		this.end = false;
	}
	public void start()
	{
		String line = "";
		Command command = new Command();
		
		while (!this.end)
		{
			line = in.nextLine();
			command = CommandParser.parse(line);
			
			if (command.getCommand() == null)
			{
				System.out.println("Error: Ejecucion del comando");
			}
			else 
			{
				System.out.println("Comienza la ejecucion de " + command.getCommand());
				if (!command.execute(this))
				{
					System.out.println("Error: Ejecucion del comando");
				}
				if(this.bcProgram != null)
				{
					System.out.println("Programa almacenado: ");
					System.out.println(this.bcProgram.toString());
				}
				if(command.getCommand().equals(ENUM_COMMAND.QUIT))
				{
					System.out.println("Fin de la ejecucion....");
					this.end = true;
				}
			}
			
		}
	}
	public boolean executeCommandRun()
	{
		CPU cpu = new CPU();
		int i = 0;
		boolean check = true;
		while (i<this.bcProgram.getNumberOfByteCodes())
		{
			ByteCode instr = this.bcProgram.getByteCode(i);
			if (cpu.execute(instr)) 
			{
				System.out.println(cpu.toString());
				i++;
			}
			else
			{
				check = false;
			}
		}
		return check;
	}
	public static void showHelp() 
	{
		System.out.println("HELP: Muestra esta ayuda ");
		System.out.println("QUIT: Cierra la app");
		System.out.println("RUN: Ejecuta el programa");
		System.out.println("NEWINST BYTECODE: Introduce una nueva instruccion al programa");
		System.out.println("RESET: Vacia el programa actual");
		System.out.println("REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
	}
	public boolean endExecution()
	{ 
		return this.end = true; 
	}
	public boolean addByteCodeInstruction(ByteCode bc) 
	{
		return this.bcProgram.addBCInstruction(bc);
	}
	public boolean resetProgram() 
	{
		boolean ok = false;
		if(!this.end)
		{
			this.bcProgram.reset();
			ok = true;
		}
		return ok;
	}
	public boolean replaceByteCode(int replace) 
	{
		boolean ok = false;
		
		String line = "";
		line = in.nextLine();
		ByteCode bc = ByteCodeParser.parse(line);
		if(bc.getOpcode() != null)
		{
			this.bcProgram.replace(replace, bc);
			ok = true;
		}
		return ok;
	}
}