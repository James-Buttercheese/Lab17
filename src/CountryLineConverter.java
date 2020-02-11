
public class CountryLineConverter implements LineConverter<Country> {

	@Override
	public String toLine(Country object) {
		return String.format("%s\t%s\t%s", object.getName(), object.getPopulation(), object.getPrimaryLanguage());
	}

	@Override
	public Country fromLine(String line) {
		
		line.split("\t");
		
		String[] lines = line.split("\t");
		String name = lines[0];
		int  population = Integer.parseInt(lines[1]);
		String primaryLanguage = lines[2];
				
		return new Country(name, population, primaryLanguage);
	}

	

}
