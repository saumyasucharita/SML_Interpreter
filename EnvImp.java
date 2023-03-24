public class EnvImp implements Env
{
    private EnvImp.EnvCell root;
    
    public EnvImp() {
        this.root = null;
    }
    
    private EnvImp(final EnvImp.EnvCell root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public Value lookup(final String s) throws UnboundVar {
        for (EnvImp.EnvCell envCell = this.root; envCell != null; envCell = envCell.next) {
            if (envCell.var.equals(s)) {
                return envCell.val;
            }
        }
        throw new UnboundVar("Unbound variable: " + s);
    }
    
    public Env addBinding(final String s, final Value value) {
        return (Env)new EnvImp(new EnvImp.EnvCell(s, value, this.root));
    }
    
    public Env updateBinding(final String s, final Value val) throws UnboundVar {
        for (EnvImp.EnvCell envCell = this.root; envCell != null; envCell = envCell.next) {
            if (envCell.var.equals(s)) {
                envCell.val = val;
                return (Env)this;
            }
        }
        throw new UnboundVar("Unbound variable: " + s);
    }
    
    @Override
    public String toString() {
        return "ENV";
    }
    private static class EnvCell
    {
        String var;
        Value val;
        EnvCell next;
        
        EnvCell(final String var, final Value val, final EnvCell next) {
            this.var = var;
            this.val = val;
            this.next = next;
        }
    }
}