package impl;

import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class GrafoMA implements GrafoTDA {
	
	static int n = 100; 
	int [][] mAdy;
	int [] etiqs;
	int cantNodos;
	
	@Override
	public void inicializarGrafo() { 
		mAdy = new int[n][n];
		etiqs = new int[n]; cantNodos = 0;
		cantNodos = 0;
	}
	
	@Override
	public void agregarVertice(int v) { 
		etiqs[cantNodos] = v;
		for(int i=0; i<=cantNodos; i++) {
			mAdy[cantNodos][i] = 0;
			mAdy[i][cantNodos] = 0; 
		}
		cantNodos++; 
	}
	
	@Override
	public void eliminarVertice(int v) { 
		int ind = vert2Indice(v);
		for(int k=0; k<cantNodos; k++) 
			mAdy[k][ind] = mAdy[k][cantNodos-1];
		for(int k=0; k<cantNodos; k++) 
			mAdy[ind][k] = mAdy[cantNodos-1][k];
		
		etiqs[ind] = etiqs[cantNodos-1];
		cantNodos--; 
	}
	
	
	private int vert2Indice(int v ) { 
		int i=cantNodos-1; 
		while(i>=0 && etiqs[i]!=v)
			i--; 
		return i;
	}
	
	@Override
	public ConjuntoTDA vertices() { 
		ConjuntoTDA vert = new ConjuntoSt(); 
		vert.inicializarConjunto();
		for (int i = 0; i < cantNodos; i++)
			vert.agregar(etiqs[i]);
		return vert; 
	}
	
	@Override
	public void agregarArista(int v1, int v2, int peso) { 
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		mAdy[o][d] = peso;
	}
	
	@Override
	public void eliminarArista(int v1, int v2) { 
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		mAdy[o][d]=0;
	}
	
	@Override
	public boolean existeArista(int v1, int v2) { 
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		return mAdy[o][d]!=0;
	}
	
	@Override
	public int pesoArista(int v1, int v2) {
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		return mAdy[o][d];
	}
	
}

