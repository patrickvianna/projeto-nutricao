package Model;
public class SelecionarAlimentos {
    //private Alimento alimento;
    private long idAlimento;
    private float qtd;

    public SelecionarAlimentos() {
    }
    
    public void setAlimentoQtd(long al, float qtd)
    {
        this.idAlimento = al;
        this.qtd = qtd;
    }

    public long getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(long idAlimento) {
        this.idAlimento = idAlimento;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
    }
    
    
}
