//Testing interpreter without parser
public class TestAST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IntConst
		Expr intExpr = new IntConst(15);
		Env env = new EnvImp();
		//BoolConst
		Expr boolExpr = new BoolConst(true);
		//VarExp
		Expr varExpr = new VarExp("x");
		Env var_env = env.addBinding("x", new IntVal(12));
		//BinExp
		Expr binExpr_plus = new BinExp(BinOp.PLUS, new IntConst(4), new IntConst(2));
		Expr binExpr_minus = new BinExp(BinOp.MINUS, varExpr , new IntConst(2));
		Expr binExpr_times = new BinExp(BinOp.TIMES, varExpr , new IntConst(2));
		Expr binExpr_div = new BinExp(BinOp.DIV, varExpr , new IntConst(2));
		Expr binExpr_eq = new BinExp(BinOp.EQ, varExpr , new IntConst(2));
		Expr binExpr_lt = new BinExp(BinOp.LT, new IntConst(2), varExpr);
		Expr binExpr_and = new BinExp(BinOp.AND, new BoolConst(true), new BoolConst(true));
		Expr binExpr_or = new BinExp(BinOp.OR, new BoolConst(false), new BoolConst(false));
		//NotExp
		Expr notExpr = new NotExp(boolExpr);
		//AssnExp
		Expr assignExpr = new AssnExp("x", intExpr);
		//IfExp
		Expr ifExpr = new IfExp(boolExpr, binExpr_plus, intExpr );
		//WhileExp
		Expr cond  = new BinExp(BinOp.EQ, varExpr , new IntConst(15));
		Expr body  = new AssnExp("x" , new BinExp(BinOp.MINUS, varExpr , new IntConst(1)));
		Expr whileEpr = new WhileExp(cond, body);
		//LetValExp
		Expr letValExpr = new LetValExp("x", new IntConst(10), new BinExp(BinOp.TIMES, varExpr , new IntConst(2)));
		//LetFunExp
		Expr letFunExpr = new LetFunExp("f", "x", new BinExp(BinOp.PLUS, varExpr , new IntConst(1)), new AppExp("f", new IntConst(10)));
		//SeqExp
		Expr seqExpr = new SeqExp(new AssnExp("x", intExpr),
				new AssnExp("x", new BinExp(BinOp.PLUS, varExpr , new IntConst(1))));
		try {
			System.out.println(intExpr.eval(env));
			System.out.println(boolExpr.eval(env));
			System.out.println(varExpr.eval(var_env));
			System.out.println(binExpr_plus.eval(env));
			System.out.println(binExpr_minus.eval(var_env));
			System.out.println(binExpr_times.eval(var_env));
			System.out.println(binExpr_div.eval(var_env));
			System.out.println(binExpr_eq.eval(var_env));
			System.out.println(binExpr_lt.eval(var_env));
			System.out.println(binExpr_and.eval(env));
			System.out.println(binExpr_or.eval(env));
			System.out.println(notExpr.eval(env));
			System.out.println(assignExpr.eval(var_env)); // In env x = 12
			System.out.println(ifExpr.eval(env));
			System.out.println(whileEpr.eval(var_env));// while x = 15 do x := x - 1
			System.out.println(letValExpr.eval(env));// let val x = 10 in x*2 end
			System.out.println(letFunExpr.eval(env));// let fun f(x) = x + 1 in f(10) end
			System.out.println(seqExpr.eval(var_env));// x := 15; x := x + 1
			
		} catch (EvalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
