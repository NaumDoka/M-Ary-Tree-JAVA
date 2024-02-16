
import java.util.*;

/**
 * @author Naum Doka (7011512)
 *
 */

public class Nodo_m_ario<String> {

//		Si mantiene un puntatore a ciascun figlio e al padre.
		private String info;
		
		private Nodo_m_ario<String> padre;
		private ArrayList<Nodo_m_ario<String>> children;
		
		//costruttore	
		public Nodo_m_ario(String x){
			info=x;
		}
		
//   getter
	 public String getInfo(){
             return info;
     }
	
	
	public Nodo_m_ario<String> getPadre(){
		return padre;
	}
	
//	setters
	
	public void setInfo(String x){
                info=x;
        }

	
	public void setPadre(Nodo_m_ario<String> v){
		padre=v;
	}
	
	
	

	
	public java.lang.String toString(){
		return info.toString();
	}

	public int livello(){
		int livello=0;
		Nodo_m_ario<String> temp=this.getPadre();
		while(temp!=null){
			livello++;
			temp=temp.getPadre();
		}
		return livello;
	
	}

	
	/**
	 * @return the children
	 */
	public ArrayList<Nodo_m_ario<String>> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<Nodo_m_ario<String>> children) {
		this.children = children;
	}
	
}
