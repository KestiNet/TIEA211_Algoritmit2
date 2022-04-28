import java.util.Vector;
 
public class UnionFind{
	
	private Vector <Integer>p, rank, SetSize;
	private int numSets;
	
	public UnionFind(int N) {
		
		p = new Vector<Integer>(N);
		rank = new Vector<Integer>(N);
		SetSize = new Vector<Integer>(N);
		
		numSets = N;
		
		for(int i = 0; i < N; i++) {
			p.add(i);
			rank.add(0);
			SetSize.add(1);
		}

	}
	
	public int findSet(int i) {
		if(p.get(i)==i) {
			return i;
		}else {
			int ret = findSet(p.get(i));
			p.set(i, ret);
			return ret;
		}
		
	}
	
	public boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j); 
	}
	
	
	public void UnionSet(int i, int j) {
		if(!isSameSet(i, j)) {
			numSets--;
			
			int x = findSet(i);
			int y = findSet(j);
			
			if(rank.get(x) > rank.get(y)) {
				p.set(y, x);
				SetSize.set(x, SetSize.get(x) + SetSize.get(y));
				
			}else {
				p.set(x, y);
				SetSize.set(y,SetSize.get(x) + SetSize.get(y));
				if (rank.get(x) == rank.get(y)) {
					rank.set(y, rank.get(y) +1);
				}
				
			}
		}
	}
	
	public int NumberOfSubSets() {
		return numSets;
	}
	
	
	public int GetSetSize(int i) {
		return SetSize.get(p.get(i));
	}
	
	
    public static void main(String[] args){
    	//String [] uniFi = {"kiuru", "lokki", "rastas", "sorsa", "varis"};
    	try {
    	UnionFind UF = new UnionFind(10);
    	System.out.println("11 is in the UF:" + UF.findSet(11));
    	UF.UnionSet(3,4);
    	System.out.println("4 and 3 is in the UF:" + UF.isSameSet(3,4));

    	
    }catch(Exception e) {
    	System.out.println("Alkio ei ole joukossa");
    }

    
    
}
}