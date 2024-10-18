public class Conjunto <X>
{
    private Object[] elem; // private X[] elem;
    private int      qtd=0;
    private int      capacidadeInicial;
        
    public /*void*/ Conjunto (int capInicial) throws Exception
    {
        if (capInicial<=0)
            throw new Exception ("Capacidade invalida");
            
      //this.elem = new X      [capInicial];
        this.elem = new Object [capInicial];
        
        this.capacidadeInicial = capInicial;
    }    

    public Conjunto () // construtor padrão (construtor sem parâmetros)
    {
      //this.elem = new X      [10];
        this.elem = new Object [10];
        
        this.capacidadeInicial = 10;
    }

    private void redimensioneSe (int novaCap)
    {
      //X     [] novo = new X      [novaCap];
        Object[] novo = new Object [novaCap];

        for (int i=0; i<this.qtd; i++)
            novo[i] = this.elem[i];

        this.elem = novo;
    }

    // retorna true, indicando que achou o que era procurado e,
    // junto com o true, a posição onde foi encontrado o que era procurado; ou
    // retorna false, indicando que NÃO achou o que era procurado e,
    // junto com o false, a posição onde é possível incluir aquilo que era procurado
    // e NÃO foi encontrado, caso seja do nosso desejo incluir
    private Object[] ondeEsta (X x)
    {
        for (int i=0; i<this.qtd; i++)
            if (x.equals(this.elem[i]))
            {
                Object[] ret = {true,i};
                return ret;
            }

        Object[] ret = {false,this.qtd};
        return ret;
    }

    // este método funciona mais ou menos; não está lá essas coisas
    public void inclua (X x) throws Exception
    {
        if (x==null)
            throw new Exception ("Elemento ausente");
            
        Object[] onde    = this.ondeEsta(x);
        boolean  achou   = (Boolean)onde[0];
        int      posicao = (Integer)onde[1];

        if (achou)
            throw new Exception ("Elemento repetido");
            
        if (this.qtd==this.elem.length)
            this.redimensioneSe (2*this.elem.length);

        for (int i=this.qtd-1; i>=posicao; i--)
            this.elem[i+1] = this.elem[i];

        if (x isinstance Cloneable)
            // this.elem[posicao] = x.clone(); // isso da pau
            this.elem[posicao] = new Clonador <X>.clone(x);
        else        
            this.elem[posicao] = x;
            
        this.qtd++;
    } 
     
    public X getElemento (int posicao) throws Exception
    {
	if (posicao<0 || posicao>=this.qtd) throw new Exception ("Posicao invalida");
        
        if (this.elem[posicao] isinstance Cloneable)
            // return this.elem[posicao].clone(); // isso da pau
            return new Clonador<X>.clone((X)this.elem[posicao]);
        else        
            this.elem[posicao] = x;
    }
}
