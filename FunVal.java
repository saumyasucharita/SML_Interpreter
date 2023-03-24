
public class FunVal extends Value{
	public final String id;
	public final Expr arg1;
	public final Env env1;
	FunVal(String _id, Expr _arg1, Env _env1){
		id = _id;
		arg1 = _arg1;
		env1 = _env1;
	}
	public String toString() {
		return id+arg1.toString()+env1.toString();
	}
}
