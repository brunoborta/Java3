package bruno.cafeteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunobortagaray on 10/03/18.
 */

public class Categoria {
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getItensCategoria() {
        List<String> items = new ArrayList<>();
        if(descricao.equalsIgnoreCase("Bebidas")) {
            items.add("Café");
            items.add("Água");
            items.add("Refrigerante");
        } else if(descricao.equalsIgnoreCase("Lanches Salgados")) {
            items.add("Pastel");
            items.add("Empada");
            items.add("Croquete");
        } else {
            items.add("Croissant");
            items.add("Cupcake");
            items.add("Bolo");
        }
        return items;
    }
}
