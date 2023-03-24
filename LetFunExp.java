
public class LetFunExp extends Expr{
	public final String fun_name;
	public final String param;
	public final Expr arg1;
	public final Expr arg2;
	public LetFunExp(String _fun_name, String _param, Expr _arg1, Expr _arg2) {
		fun_name = _fun_name;
		param = _param;
		arg1 = _arg1;
		arg2 = _arg2;
	}
	public Value eval(Env e) throws EvalError{
		//Revised LetFunExp Slide 40 to handle recursion
		/*FunVal v = new FunVal(param, arg1, e);
		Env env2 = e.addBinding(fun_name, v);
		return arg2.eval(env2);*/
		Value dummy_val = new IntVal(5);
		Env new_env = e.addBinding(fun_name, dummy_val);
		FunVal val = new FunVal(param, arg1, new_env);
		Env new_env2 = new_env.updateBinding(fun_name, val);
		return arg2.eval(new_env2);
	}
	public String toString() {
		return "let fun "+fun_name+"("+param+") = "+arg1+" in "+arg2+" end";
	}
}
