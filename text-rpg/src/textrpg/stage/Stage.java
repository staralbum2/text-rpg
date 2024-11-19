package textrpg.stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import textrpg.*;
abstract public class Stage {
	
	protected StringBuffer bf = new StringBuffer();
	protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	protected BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public abstract boolean update();

	public abstract void init();
}
