package exercisee;

public class exp14c {
  void main(String[] args) {
	System.out.println("without public modifier");
	System.out.println("without static modifier");
	noparamater np=new noparamater();
	np.param();
	
}
}
class noparamater{
	void param(){
		System.out.println("without functional paramater");
		
	}
}