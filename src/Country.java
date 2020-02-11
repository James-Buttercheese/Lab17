import java.util.List;

public class Country {
	private String name;
	private int population;
	private String primaryLanguage;

	public Country() {
		super();
		this.name = "Some random boat in the Pacific";
		this.population = 1;
		this.setPrimaryLanguage("pigLatin");
	}

	public Country(String name, int population, String primaryLanguage) {
		super();
		this.name = name;
		this.population = population;
		this.setPrimaryLanguage(primaryLanguage);
	}

	
	public String getPrimaryLanguage() {
		return primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		return String.format("%s Population of %d speaks %s", name, population, primaryLanguage);
	}
	
	

}
