
import java.util.*;

/**
 * @author Naum Doka (7011512)
 *
 */

public class AlberoMArio<String>{
	private Nodo_m_ario<String> radice;
	private int numNodi;
	private int altezza;
	private int numFigli;
	
	
//  restituisce il numero di figli
	public int numFigli() {
		return numFigli;
	}
	
//	restituisce la radice dell'albero o null se esso e' vuoto
	public Nodo_m_ario<String> radice(){
		return radice;
	}
	
//	restituisce il contenuto/info di v
	public String info(Nodo_m_ario<String> v){
		return v.getInfo();
	}	

//	restituisce il numero di nodi
	public int numNodi(){
		return numNodi;
	}
	
//	restituisce l'altezza
	public int altezza(){
		return altezza;
	}
	 
	public int grado(Nodo_m_ario<String> v){
		ArrayList<Nodo_m_ario<String>> children = v.getChildren();
		numNodi = children.size();
		numFigli= children.size();
		for(Nodo_m_ario<String> node : children) {
			if(!node.getChildren().isEmpty()) {
				altezza = altezza +1;
				ArrayList<Nodo_m_ario<String>>  childrenTemp = node.getChildren();
				numNodi = numNodi  + childrenTemp.size();
			}
		}
		return numNodi;
	}
			
	
//	restiruisce il figlio sinistro di v o null se non c'e'
	public Nodo_m_ario<String> sin(Nodo_m_ario<String> v){
		return v.getChildren().get(0);
	}
	
//	restituisce il padre del nodo v	
	public Nodo_m_ario<String> padre(Nodo_m_ario<String> v){
		return v.getPadre();
	}

//  restituisce il livello di un nodo
	public int livello(Nodo_m_ario<String> v){
		return v.livello();
	}
	

	
//	cambia il contenuto di v
	public void cambiaInfo(Nodo_m_ario<String> v, String info){
		v.setInfo(info);
	}
	
//	inserisce la radice in un albero vuoto e la restituisce
	public Nodo_m_ario<String> aggiungiRadice(String info){
		if (radice!=null){
            return null;
		}
        numNodi++;
        numFigli=1;
        radice = new Nodo_m_ario<String>(info);
        return radice;
	}
	
//	inserisce un nodo come figlio sinistro di u e lo restiruisce	
	public Nodo_m_ario<String> aggiungiFiglioSin(Nodo_m_ario<String> u, String info){
		if(u.getChildren()!=null){
			return null;
        }
	
		if(grado(u)==1) {
			numFigli ++;
		}
		
		Nodo_m_ario<String> temp =new Nodo_m_ario<String>(info);
		ArrayList<Nodo_m_ario<String>> child  = new ArrayList<Nodo_m_ario<String>>();
		child.add(temp);
		
		u.setChildren(child);
		temp.setPadre(u);
		
		//gestione altezza
		if(temp.livello()>altezza){
			altezza=temp.livello();
		}
		numNodi++;
		
	
		return u.getChildren().get(0);
	}
	
//	inserisce un nodo come figlio destro di u e lo restiruisce
	public Nodo_m_ario<String> aggiungiFiglioDes(Nodo_m_ario<String> u, String info){
		if(u.getChildren()!=null){
			return null;
		}
		
		if(grado(u)==1) {
			numFigli++;
		}
				
		Nodo_m_ario<String> temp =new Nodo_m_ario<String>(info);
		ArrayList<Nodo_m_ario<String>> child = new ArrayList<Nodo_m_ario<String>>();;
		child.add(temp);
		
		u.setChildren(child);
		temp.setPadre(u);

		
		//gestione altezza
		if(temp.livello()>altezza){
			altezza=temp.livello();
		}
		
		numNodi++;
	
		return u.getChildren().get(child.size());
	}


	//	Visita in PROFONDITA' (anticipata) alg. iterativo
	public LinkedList<String> visitaDFS(){
		Stack<Nodo_m_ario<String>> p = new Stack<Nodo_m_ario<String>>(); 	// Struttura di servizio
		LinkedList<String> nodiAlbero = new LinkedList<String>();			// Conterra' i nodi visitati
		p.push(radice);
		while (!p.isEmpty()){
			Nodo_m_ario<String> u = p.pop();
			if (u!=null){
				for(int i = 0; i < u.getChildren().size(); i++) {
					nodiAlbero.add(u.getInfo());	//	il nodo viene ''chiuso''
					p.push(u.getChildren().get(i));			//	Si inseriscono nella pila
				}
			}
		}
		return nodiAlbero;
	}
	
	
//	Visita in AMPIEZZA alg. iterativo
	public LinkedList<String> visitaBFS(){
		LinkedList<Nodo_m_ario<String>> c = new LinkedList<Nodo_m_ario<String>>(); //Coda di servizio: la simulo con una LinkedList
		LinkedList<String> listaNodi = new LinkedList<String>(); //lista nodi in uscita
		c.add(radice); //Aggiunge LinkedList in fondo
		while (!c.isEmpty()){
			Nodo_m_ario<String> u = c.remove();//remove di LinkedList toglie il primo
			if(u!=null){
				listaNodi.add(u.getInfo());	// Il nodo viene ''chiuso''.
				for(int i = 0; i < u.getChildren().size(); i++) {
				c.add(u.getChildren().get(i));			// Si inseriscono nella coda
				
			}
		}
	}return listaNodi;
}
	
	
	

// VISITE RICORSIVE anticipata, simmetrica e posticipata.
//Quest'ultime due, per farle iterative, prevedono l'uso
//di una pila che possa ospitare sia nodi che alberi
	
	public LinkedList<String> innesco_visita(String t){
		//t="simmetrica", "posticipata" o "anticipata"
		LinkedList<String> lista_nodi = new LinkedList<String>();//ospita le informazioni della visita
		visita_Ricorsiva(radice, lista_nodi, t);
		return lista_nodi;
	}
	
	private void visita_Ricorsiva(Nodo_m_ario<String> r, LinkedList<String> lista_nodi, String t){
		if(r == null)
			return;
		if(t == "anticipata"){
			lista_nodi.add(r.getInfo());
		}
		visita_Ricorsiva(r.getChildren().get(0), lista_nodi, t);
		if(t == "simmetrica"){
			lista_nodi.add(r.getInfo());
		}
		visita_Ricorsiva(r.getChildren().get(r.getChildren().size()), lista_nodi, t);
		if(t == "posticipata"){
			lista_nodi.add(r.getInfo());
		}
	}
	
}