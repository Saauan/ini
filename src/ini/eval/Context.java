package ini.eval;

import ini.ast.Function;
import ini.eval.data.Data;
import ini.eval.data.DataReference;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Context {

	Function function;

	public boolean noRulesApplied = false;
	
	public Context(Function function) {
		this.function = function;
	}

	public Context(Context context) {
		this.function = context.function;
		this.variables.putAll(context.variables);
		//this.threadAt.putAll(context.threadAt);
	}
	
	private Map<String, Data> variables = new HashMap<String, Data>();

	//private Map<String, Thread> threadAt = new HashMap<String, Thread>();
	
	public void bind(String name, Data data) {
		variables.put(name, data);
	}
	
	/*public void bindAt(String atName, Thread t) {
		threadAt.put(atName, t);
	}*/

	public void unbind(String name) {
		variables.remove(name);
	}

	public Data get(String name) {
		return variables.get(name);
	}

	public Data getOrCreate(String name) {
		if (!variables.containsKey(name)) {
			bind(name, new DataReference(null));
		}
		return variables.get(name);
	}

	@Override
	public String toString() {
		return variables.toString();
	}

	public void prettyPrint(PrintStream out) {
		for (String v : variables.keySet()) {
			out.print("   ");
			prettyPrintVariable(out, v);
			out.println();
		}
	}

	public void prettyPrintVariable(PrintStream out, String variableName) {
		out.print(variableName + " = ");
		Data d = variables.get(variableName);
		if (d == null) {
			out.print("<undefined>");
		} else {
			d.prettyPrint(out);
		}
	}

}