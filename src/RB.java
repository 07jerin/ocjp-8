
import java.util.ListResourceBundle;

class RB extends ListResourceBundle {

	public RB (){
		
	}

	@Override
	public Object[][] getContents() {
		return new Object[][] { { "locale.string", "deafult From Java" }, { "local.name", "deafult From Java Name" } };
	}

}