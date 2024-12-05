/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author ferna
 */
public class ListaCircularSimple {
    //  Atributos

    Nodo primero;//L;
    int cant;

    //constructor
    public ListaCircularSimple() {
        primero = null;
        cant = 0;
    }

    public boolean vacia() {
        return primero == null;
    }

    public void insertar(Object elemento){//
        Nodo nuevo=new Nodo();
        nuevo.setElem(elemento);
        if (primero==null) {
            primero=nuevo;
            //primero.setEnlace(primero); 
             primero.setEnlace(nuevo);
        }else{
            Nodo aux=primero;
            while (aux.getEnlace()!=primero) { //usar compareto               
                aux=aux.getEnlace();
            }
            aux.setEnlace(nuevo);
            nuevo.setEnlace(primero);
        }
        cant++;
    }
    
    
    public void insertarInicio(Object elemento) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elemento);
        if (vacia()) {
            primero = nuevo;
            nuevo.setEnlace(primero);
        } else {
            Nodo aux = primero;
            while (aux.getEnlace() != primero) {
                aux = aux.getEnlace();
            }

            nuevo.setEnlace(primero);
            primero = nuevo;
            aux.setEnlace(primero);
        }
        cant++;
    }

    public void insertarUltimo(Object elemento) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elemento);
        if (vacia()) {
            primero = nuevo;
            nuevo.setEnlace(primero);
        } else {
            Nodo aux = primero;
            while (aux.getEnlace() != primero) {
                aux = aux.getEnlace();
            }
            aux.setEnlace(nuevo);
            nuevo.setEnlace(primero);

        }
        cant++;
    }

    public void insertar(Object elemento, int posicion) {
        Nodo nuevo = new Nodo();
        nuevo.setElem(elemento);
        if (vacia() || posicion == 0) {
            insertarInicio(elemento);
        } else {
            if (posicion >= cant) {
                insertarUltimo(elemento);
            } else {
                Nodo aux = primero;
                posicion--;
                while (posicion>0) {
                    aux = aux.getEnlace();
                    posicion--;
                }
                nuevo.setEnlace(aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            

        }
        cant++;
    }
    
    
    public String toString2() {
        String S = "L -> ";
        Nodo aux = primero;
        while (aux != null) {
            S = S + "[" + aux.getElem()+ " | ]->";
            aux = aux.getEnlace();
            if (aux==primero) {
                break;
            }
        }
        S=S.substring(0, S.length()-2);
        return S ;
    }
    
    @Override
    public String toString(){
        if (primero==null) {
            System.out.println("La lista Vacia");
        }else{
            String S="C->";
            Nodo p=primero;
            do {                
                S=S+p.getElem()+" ->";
                p=p.getEnlace();
            } while (p!=primero);
            return S;
        }
        return null;
        
    }
    
    public static void main(String[] args) {
      
        ListaCircularSimple L=new ListaCircularSimple();
        L.insertarInicio(4);
        L.insertarUltimo(5);
        L.insertarUltimo(6);
          L.insertarUltimo(8);
          L.insertar(2);
          
     //     L -> [4 | ]->[5 | ]->[6 | ]->[8 | ]->null
      //           0       1       2       3
        System.out.println(L);
        
        L.insertar(23, 3);
                System.out.println(L);
        
    }
}
