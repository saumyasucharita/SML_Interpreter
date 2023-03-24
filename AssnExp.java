
public class AssnExp extends Expr{
	public final String left_id;
	public final Expr arg;
	public AssnExp(String _id, Expr _arg) {
		left_id = _id;
		arg = _arg;
	}
	public Value eval(Env e) throws EvalError{
		Value assign_val = arg.eval(e);
		if(e.lookup(left_id)!=null) {// For assignment the variable should be present in current environment
			if(e.lookup(left_id).getClass().getSimpleName().equalsIgnoreCase(assign_val.getClass().getSimpleName()) )//Type checking of both e.lookup(left_id) and arg 
			{
				e.updateBinding(left_id, assign_val);
				return assign_val;
			}
			else 
				throw new EvalError("Evaluation error: Incompatible arg types: Assignment Expression");
		}
		else 
			throw new EvalError("Evaluation error: Variable not present in current envt: Assignment Expression");
	}
	public String toString() {
		return left_id + ":=" + arg.toString();
	}

}
