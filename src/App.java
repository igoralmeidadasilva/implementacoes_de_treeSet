import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        Set<Integer> minhaArvoreInteger = new TreeSet<>();
        minhaArvoreInteger.add(1);
        minhaArvoreInteger.add(42);
        minhaArvoreInteger.add(55);
        minhaArvoreInteger.add(4);
        minhaArvoreInteger.add(87);
        System.out.println(minhaArvoreInteger);
        
        Set<Carro> minhaArvoreCarro = new TreeSet<>(new ComparatorCarroModelo());
        minhaArvoreCarro.add(new Carro("Fiat", "Uno", 2010));
        minhaArvoreCarro.add(new Carro ("Peugeot", "208", 2012));
        minhaArvoreCarro.add(new Carro ("Toyota", "Corolla", 2023));
        minhaArvoreCarro.add(new Carro ("Toyota", "Supra", 1998));

        System.out.println("Padrão");
        for (Carro carro : minhaArvoreCarro) {
            System.out.println(carro);
        }

        Set<Carro> minhaArvoreCarro2 = new TreeSet<>(new Comparator<Carro>(){
            @Override
            public int compare(Carro carro01, Carro carro02) {
                int marca = carro01.getMarca().compareToIgnoreCase(carro02.getMarca());
                if (marca != 0){
                return marca;
                } 
                return carro01.getAno().compareTo(carro02.getAno());
            }
        });
        minhaArvoreCarro2.add(new Carro("Fiat", "Uno", 2010));
        minhaArvoreCarro2.add(new Carro ("Peugeot", "208", 2012));
        minhaArvoreCarro2.add(new Carro ("Toyota", "Corolla", 2023));
        minhaArvoreCarro2.add(new Carro ("Toyota", "Supra", 1998));

        System.out.println("\n\nImplementação anônima da interface");
        for (Carro carro : minhaArvoreCarro2) {
            System.out.println(carro);
        }

        Set<Carro> minhaArvoreCarro3 = new TreeSet<>((Carro carro01, Carro carro02) -> carro01.getAno().compareTo(carro02.getAno()));
        minhaArvoreCarro3.add(new Carro("Fiat", "Uno", 2010));
        minhaArvoreCarro3.add(new Carro ("Peugeot", "208", 2012));
        minhaArvoreCarro3.add(new Carro ("Toyota", "Corolla", 2023));
        minhaArvoreCarro3.add(new Carro ("Toyota", "Supra", 1998));

        System.out.println("\n\nLambda Expression");
        for (Carro carro : minhaArvoreCarro3) {
            System.out.println(carro);
        }
    }
}

class Carro{
    String marca;
    String modelo;
    Integer ano;
    
    public Carro(String marca, String modelo, Integer ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "[" + "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + "]";
    }
}

class ComparatorCarroModelo implements Comparator<Carro>{
    @Override
    public int compare(Carro carro01, Carro carro02) {
        int modelo = carro01.getModelo().compareToIgnoreCase(carro02.getModelo());
        if (modelo != 0){
            return modelo;
        } 
        return carro01.getAno().compareTo(carro02.getAno());
    }
}
