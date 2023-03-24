
public class AppExp extends Expr{
	public final String fun_name;
	public final Expr arg1;
	AppExp(String _fun_name, Expr _arg1){
		fun_name = _fun_name;
		arg1 = _arg1;
	}
	public Value eval(Env e) throws EvalError{
		Value f = e.lookup(fun_name);//Step - 1
		if(f instanceof FunVal) { //Step - 2
			Value v = arg1.eval(e);//Step - 3
			Env new_env =((FunVal) f).env1.addBinding(((FunVal)f).id, v);//Step - 4
			return ((FunVal)f).arg1.eval(new_env);//Step-5
		}
		else
			throw new EvalError("Evaluation error: AppExp: Incompatible arg types");
	}
	public String toString() {
		return fun_name+"("+arg1.toString()+")";
	}
}
