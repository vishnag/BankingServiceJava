package lab4;


import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This is an abstract class   
 * @author Vishwas
  */
public abstract class Client {

	abstract public void read() throws FileNotFoundException, IOException;
	abstract void print();
	abstract public void process();
}