package pintura_cone;

public class Cone {
    // Constantes
    public static final double PI = 3.14;
    public static final double RENDIMENTO = 3.45; // litros por m2
    public static final double LATA_CAP = 18.0; // litros por lata
    public static final double PRECO_TIPO1 = 238.90;
    public static final double PRECO_TIPO2 = 467.98;
    public static final double PRECO_TIPO3 = 758.34;

    // Atributos
    private double raio;
    private double altura;
    private int nivel; // tipo da tinta (1,2,3)

    // Construtores
    public Cone() {
        this(0,0,1);
    }

    public Cone(double raio, double altura) {
        this(raio, altura, 1);
    }

    public Cone(double raio, double altura, int nivel) {
        this.raio = raio;
        this.altura = altura;
        this.nivel = nivel;
    }

    // getters e setters
    public double getRaio() { return raio; }
    public void setRaio(double raio) { this.raio = raio; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    // Cálculos separados conforme solicitado
    public double geratriz() {
        return Math.sqrt(raio*raio + altura*altura);
    }

    public double areaFundo() {
        return PI * raio * raio;
    }

    public double areaLateral() {
        return PI * raio * geratriz();
    }

    public double areaTotal() {
        return areaFundo() + areaLateral();
    }

    // litros necessários (area * rendimento)
    public double litrosNecessarios() {
        return areaTotal() * RENDIMENTO;
    }

    // latas compradas (arredondar para cima)
    public int latasNecessarias() {
        double litros = litrosNecessarios();
        return (int) Math.ceil(litros / LATA_CAP);
    }

    // preço total conforme nível/tipo de tinta
    public double precoTotal() {
        int latas = latasNecessarias();
        double precoUnit;
        switch (nivel) {
            case 1: precoUnit = PRECO_TIPO1; break;
            case 2: precoUnit = PRECO_TIPO2; break;
            case 3: precoUnit = PRECO_TIPO3; break;
            default: precoUnit = PRECO_TIPO1; break;
        }
        return precoUnit * latas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- Cone\n");
        sb.append("Raio: ").append(raio).append("\n");
        sb.append("Altura: ").append(altura).append("\n");
        sb.append("Nível: ").append(nivel).append("\n");
        sb.append("-------------------------------\n");
        sb.append("Geratriz: ").append(geratriz()).append("\n");
        sb.append("-------------------------------\n");
        sb.append("Área do Fundo: ").append(areaFundo()).append("\n");
        sb.append("Área Lateral Cone: ").append(areaLateral()).append("\n");
        sb.append("Área Total: ").append(areaTotal()).append("\n");
        sb.append("-------------------------------\n");
        sb.append("Litros: ").append(litrosNecessarios()).append("\n");
        sb.append("Latas: ").append(latasNecessarias()).append("\n");
        sb.append("-------------------------------\n");
        sb.append("Preço Total: ").append(precoTotal()).append("\n");
        return sb.toString();
    }
}
